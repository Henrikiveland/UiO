from imageio import imread, imwrite
import matplotlib.pyplot as plt
import numpy as np
from numpy import cos, pi
import time
from numba import jit


# Bruker jit for at koden skal gå fortere
# En hjelpemetode c som definert i oppgaven
@jit
def c(a):
    if a == 0:
        return 1 / (np.sqrt(2))
    else:
        return 1


# Steg 3, steg 5, impementerer 2D DCT formelen
@jit
def DCT(bilde, Q):

    # Fjerner 128 fra alle pikselverdiene
    f = bilde - 128
    N, M = bilde.shape
    F = np.zeros((N, M))

    # Seks for-løkker for å gå igjennom bilde riktig.
    # Først to løkker som henter ut en 8x8 blokk fra bildet.
    for u in range(0, N, 8):
        for v in range(0, M, 8):
            # Så 4 løkker til
            # 2 som går igjennom ut bilde(8x8)
            for ex in range(8):
                for ey in range(8):
                    temp = 0
                    # Og 2 løkker som går igjennom inn bildet(8x8)
                    for x in range(8):
                        for y in range(8):
                            # Bruker formelen fra oppgaven og regner ut for hver piksel i 8x8 blokken
                            temp += (
                                f[x + u, y + v]
                                * cos((((2 * x) + 1) * (ex) * pi) / 16)
                                * cos((((2 * y) + 1) * (ey) * pi) / 16)
                            )
                    # Legger sammen alle verdiene og lagrer det i ut bildet.
                    F[(u + ex), (v + ey)] = round(
                        ((1 / 4) * c(ex) * c(ey) * temp) / (Q[ex, ey])
                    )

    return F


# Steg 4, steg 7, rekonstruerer bildet
@jit
def iDCT(kompBilde, Q):
    F = kompBilde
    N, M = kompBilde.shape
    f = np.zeros((N, M))

    # Ganske lik DCT formelen
    for x in range(0, N, 8):
        for y in range(0, M, 8):
            for ex in range(8):
                for ey in range(8):
                    temp = 0
                    for u in range(8):
                        for v in range(8):
                            temp += (
                                c(u)
                                * c(v)
                                * F[x + u, y + v]
                                * cos((((2 * (ex)) + 1) * (u) * pi) / 16)
                                * cos((((2 * (ey)) + 1) * (v) * pi) / 16)
                                * (Q[u, v])
                            )
                    f[(x + ex), (y + ey)] = round((1 / 4) * temp)

    # Leger til 128 til hver pikselverdi før jeg returnerer
    return f + 128


# En test funskjon for å teste om to bilder er like. Denne ble brukt under testing, men blir ikke brukt når programmet leveres.
def test(bilde1, bilde2):
    N, M = bilde1.shape
    bilde1test = bilde1.astype("float64")
    bilde2test = bilde2.astype("float64")

    test = True
    for x in range(N):
        for y in range(M):
            if bilde1test[x, y] != bilde2test[x, y]:
                test = False
    if test:
        print("Bildene er like")
    else:
        print("Bildene er ikke like")


# Steg 6, metode som tregner ut entropiene til et bilde
def entropi(img):
    bilde = img
    x, y = bilde.shape
    N = x * y
    dict = {}
    for i in range(x):
        for j in range(y):
            si = bilde[i, j]
            if si in dict:
                dict[si] = dict[si] + 1
            else:
                dict[si] = 1

    for si in dict:
        dict[si] = dict[si] / N

    H = 0
    for si in dict:
        pi = dict[si]
        H += -(pi * np.log2(pi))

    # marg = np.histogramdd(np.ravel(img), bins = 256)[0]/img.size
    # marg = list(filter(lambda p: p > 0, np.ravel(marg)))
    # entropy = -np.sum(np.multiply(marg, np.log2(marg)))

    # return (H * N)/8
    # return entropy
    return H


# En metode som setter sammen alle kompresjons delene
# Tar inn et filnavn og en q som bestemmer kompresjonsraten
def kompresjon(filnavn, q):
    Q = np.array(
        [
            [16, 11, 10, 16, 24, 40, 51, 61],
            [12, 12, 14, 19, 26, 58, 60, 55],
            [14, 13, 16, 24, 40, 57, 69, 56],
            [14, 17, 22, 29, 51, 87, 80, 62],
            [18, 22, 37, 56, 68, 109, 103, 77],
            [24, 35, 55, 64, 81, 104, 113, 92],
            [49, 64, 78, 87, 103, 121, 120, 101],
            [72, 92, 95, 98, 112, 100, 103, 99],
        ]
    )
    Q = Q * q

    bilde = imread(filnavn, as_gray=True)
    DCTbilde = DCT(bilde, Q)
    iDCTbilde = iDCT(DCTbilde, Q)

    H = entropi(DCTbilde)

    # Returnerer det kompremerte bildet og entropien H
    return iDCTbilde, H


# En metode som regner ut den estimerte lagringsplassen til en bilde ved hjelp av entropien
def lagringsplass(img, entropi):
    N, M = img.shape
    return entropi * N * M


# En metode som regner ut kompresjonsraten
def kompresjonsrate(orgEntropi, kompEntropi):
    return orgEntropi / kompEntropi


def main():
    start = time.time()
    filnavn = "uio.png"
    uio = imread(filnavn, as_gray=True)
    orgEntropi = round(entropi(uio), 3)
    orgLagring = round(lagringsplass(uio, orgEntropi) / 8000, 3)
    # plt.imshow(DCT(uio, np.ones((8, 8))), cmap="gray")

    qList = [0.1, 0.5, 2, 8, 32]
    bilder = []
    entropiList = []
    CRListe = []
    lagringsListe = []
    # En løkke som kjører kompresjonen på alle de forskjellige q ene.
    for q in qList:
        ut, H = kompresjon(filnavn, q)
        bilder.append(ut)
        entropiList.append(round(H, 3))
        CRListe.append(round(kompresjonsrate(orgEntropi, H), 2))
        lagringsListe.append(round(lagringsplass(ut, H) / 8000, 3))
        name = str(q) + filnavn
        # Skriver bilde til fil. Formatet på filnavnet er quio.png hvor q er en av q-ene i qList.
        # ut = ut.astype("uint8")
        # name = str(q) + "uio.jpeg" # Kommenter ut denne linjen hvis du vil lagre det som .jpeg og ikke .png
        imwrite(name, ut)

    # Printer ut og viser alle bildene med tilhørende q og entropi H
    fig = plt.figure()
    plt.subplot(2, 3, 1)
    plt.imshow(uio, cmap="gray")
    plt.title(
        "Orginal Bilde\n H = "
        + str(orgEntropi)
        + "\n Lagring = "
        + str(orgLagring)
        + "KB"
    )
    plt.axis("off")
    plt.subplot(2, 3, 2)
    plt.imshow(bilder[0], cmap="gray")
    plt.title(
        "q = "
        + str(qList[0])
        + "\n H = "
        + str(entropiList[0])
        + "\n CR = "
        + str(CRListe[0])
        + "\n Lagring = "
        + str(lagringsListe[0])
        + "KB"
    )
    plt.axis("off")
    plt.subplot(2, 3, 3)
    plt.imshow(bilder[1], cmap="gray")
    plt.title(
        "q = "
        + str(qList[1])
        + "\n H = "
        + str(entropiList[1])
        + "\n CR = "
        + str(CRListe[1])
        + "\n Lagring = "
        + str(lagringsListe[1])
        + "KB"
    )
    plt.axis("off")
    plt.subplot(2, 3, 4)
    plt.imshow(bilder[2], cmap="gray")
    plt.title(
        "q = "
        + str(qList[2])
        + "\n H = "
        + str(entropiList[2])
        + "\n CR = "
        + str(CRListe[2])
        + "\n Lagring = "
        + str(lagringsListe[2])
        + "KB"
    )
    plt.axis("off")
    plt.subplot(2, 3, 5)
    plt.imshow(bilder[3], cmap="gray")
    plt.title(
        "q = "
        + str(qList[3])
        + "\n H = "
        + str(entropiList[3])
        + "\n CR = "
        + str(CRListe[3])
        + "\n Lagring = "
        + str(lagringsListe[3])
        + "KB"
    )
    plt.axis("off")
    plt.subplot(2, 3, 6)
    plt.imshow(bilder[4], cmap="gray")
    plt.title(
        "q = "
        + str(qList[4])
        + "\n H = "
        + str(entropiList[4])
        + "\n CR = "
        + str(CRListe[4])
        + "\n Lagring = "
        + str(lagringsListe[4])
        + "KB"
    )
    plt.axis("off")

    fig.suptitle("Ikke-tapsfri JPEG-kompresjon")

    stopp = round((time.time() - start), 3)
    print("Hele programmet tar ", stopp, "sek")
    plt.show()


if __name__ == "__main__":
    main()
