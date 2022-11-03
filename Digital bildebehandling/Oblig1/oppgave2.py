from imageio import imread
import matplotlib.pyplot as plt
import numpy as np
from numba import jit # Denne er med for at man skal kunne jitte koden. 
#Må skrive "pip install numba" i terminal, før man kan kjøre koden


# Padder bildet med nærmeste nabo
def padding(fOrg, filter):
    f = fOrg
    x, y = filter.shape

    padSizeHight = int(np.floor(x / 2))
    padSizeWidth = int(np.floor(y / 2))
    fAbove = [f[0]]

    for i in range(padSizeHight-1):
        fAbove = np.append(fAbove, [f[0]], axis=0)

    f = np.append(fAbove, f, axis=0)

    for i in range(padSizeHight):
        f = np.append(f, [f[-1]], axis=0)

    f = np.matrix.transpose(f)
    fAbove = [f[0]]

    for i in range(padSizeWidth-1):
        fAbove = np.append(fAbove, [f[0]], axis=0)

    f = np.append(fAbove, f, axis=0)

    for i in range(padSizeWidth):
        f = np.append(f, [f[-1]], axis=0)

    f = np.matrix.transpose(f)
    return f


# Konvulerer og padder bilde
@jit
def Convolution(forg, filter):
    orgN, orgM = forg.shape
    f = padding(forg, filter)
    filter = np.flipud(np.fliplr(filter))

    N, M = f.shape
    x, y = filter.shape
    f_out = np.zeros((N, M))
    for i in range(N):
        for j in range(M):
            sum = 0
            for s in range(x):
                for k in range(y):
                    if i + s in range(N) and j + k in range(M):
                        sum += f[s + i, k + j] * filter[s, k]
                    else:
                        sum += 0

            f_out[i, j] = sum

    f_out = f_out[0:orgN, 0:orgM]

    return f_out


# Lager et gaussfilter
def gauss(sigma):
    size = np.ceil(1+8*sigma)/2
    x, y = np.mgrid[-size:size+1, -size:size+1]
    A = 1 / (2.0 * np.pi * sigma**2)
    gf = np.exp(-((x**2+y**2) / (2.0*sigma**2))) * A
    return gf


# Finner magnitude og gradiet
def Gradient(f):
    sobelx = np.array([[-1, 0, 1], [-2, 0, 2], [-1, 0, 1]])
    Ix = Convolution(f, sobelx)

    sobely = np.array([[1, 2, 1], [0, 0, 0], [-1, -2, -1]])
    Iy = Convolution(f, sobely)

    mag = np.hypot(Ix, Iy)
    vinkel = np.arctan2(Iy, Ix)

    return mag, vinkel


# Tynner bildet
def tynning(f, vinkel):
    vinkel = (vinkel*180)/np.pi
    vinkel[vinkel < 0] += 180

    N, M = f.shape
    f_out = np.zeros((N, M))

    for i in range(1, N-1):
        for j in range(1, M-1):
            n1 = 255
            n2 = 255
            if (0 <= vinkel[i, j] < 22.5) or (157.5 <= vinkel[i, j] < 180):
                n1 = f[i, j+1]
                n2 = f[i, j-1]

            elif (22.5 <= vinkel[i, j] < 67.5):
                n1 = f[i+1, j-1]
                n2 = f[i-1, j+1]

            elif (67.5 <= vinkel[i, j] < 112.5):
                n1 = f[i+1, j]
                n2 = f[i-1, j]

            elif (112.5 <= vinkel[i, j] < 157.5):
                n1 = f[i-1, j-1]
                n2 = f[i+1, j+1]

            if (f[i, j] >= n1) and (f[i, j] >= n2):
                f_out[i, j] = f[i, j]
            else:
                f_out[i, j] = 0

    return f_out


# Hysterese-terskling av bilde
@jit
def hysterese(f):
    Tl = 32
    Th = 65
    N, M = f.shape
    f_out = np.zeros((N, M))

    for i in range(N-1):
        for j in range(M-1):
            if (f[i, j] > Th):
                f_out[i, j] = 255
            elif (Tl < f[i, j] < Th):
                f_out[i, j] = 1

    for i in range(1, N-1):
        for j in range(1, M-1):
            if (f_out[i, j] == 1):
                f_out[i, j] = 0
                for k in range(3):
                    for s in range(3):
                        if (f_out[(i-1)+k, (j-1)+s] == 255):
                            f_out[i, j] = 255
    return f_out


# Main program som kjører alle metodene og printer det ut.
def main():
    """
    #Tester ekempelet fra forelesning
    bildetest = np.array([[1, 3, 2, 1],
                          [5, 4, 5, 3],
                          [4, 1, 1, 2],
                          [2, 3, 2, 6], ])

    filter = np.array([[1/9, 1/9, 1/9],
                       [1/9, 1/9, 1/9],
                       [1/9, 1/9, 1/9]])
    print("Før")
    print(bildetest)
    bildetest = Convolution(bildetest, filter)
    print("Etter")
    print(bildetest)
    """



    cellekjerner = imread("cellekjerner.png", as_gray=True)
    cellekjernerGauss = Convolution(cellekjerner, gauss(3.28))
    G, vinkel = Gradient(cellekjernerGauss)
    cellekjernerTynn = tynning(G, vinkel)
    cellekjernerHyst = hysterese(cellekjernerTynn)


    fig = plt.figure()
    plt.subplot(2, 3, 1)
    plt.imshow(cellekjerner, cmap="gray", vmin=0, vmax=255)
    plt.title("Orginal Bilde")

    plt.subplot(2, 3, 2)
    plt.imshow(cellekjernerGauss, cmap="gray", vmin=0, vmax=255)
    plt.title("Gauss (Sigma = 3.28)")

    plt.subplot(2, 3, 3)
    plt.imshow(G, cmap="gray", vmin=0, vmax=255)
    plt.title("Magnitude")

    plt.subplot(2, 3, 4)
    plt.imshow(vinkel, cmap="gray")
    plt.title("Vinkel")

    plt.subplot(2, 3, 5)
    plt.imshow(cellekjernerTynn, cmap="gray")
    plt.title("Tynning")

    plt.subplot(2, 3, 6)
    plt.imshow(cellekjernerHyst, cmap="gray", vmin=0, vmax=255)
    plt.title("Hysterese (TL = 32 og TH = 65)")

    fig.suptitle("Canny")

    plt.figure()
    plt.imshow(cellekjernerHyst, cmap="gray", vmin=0, vmax=255)
    plt.title("Hysterese (TL = 32 og TH = 65)")

    plt.show()


if __name__ == "__main__":
    main()
