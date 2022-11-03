from imageio import imread
import matplotlib.pyplot as plt
import numpy as np


# Gråtonetransformerer bildet
def graatonetrans(f, a, b):
    N, M = f.shape
    f_out = np.zeros((N, M))
    for i in range(N):
        for j in range(M):
            f_out[i, j] = a * f[i, j] + b

    return f_out


# En alternativ baklengstransformasjon med nærmeste nabo interpolasjon
def altnabo(f, A):
    # Denne tar lang tid å kjøre.
    N, M = 600, 512
    f_out = np.zeros((N, M))
    for i in range(N):
        for j in range(M):
            b = np.dot(np.linalg.inv(A), np.array([i, j, 1]))
            f_out[i, j] = f[int(b[0]), int(b[1])]
    return f_out


# Baklengstransformasjon med nærmeste nabo interpolasjon
def nabo(f, A):
    A = np.linalg.inv(A)
    a0 = A[0, 0]
    a1 = A[0, 1]
    a2 = A[0, 2]
    b0 = A[1, 0]
    b1 = A[1, 1]
    b2 = A[1, 2]

    N, M = 600, 512
    f_out = np.zeros((N, M))
    for i in range(N):
        for j in range(M):
            x = round((a0 * i) + (a1 * j) + (a2))
            y = round((b0 * i) + (b1 * j) + (b2))
            x = int(x)
            y = int(y)
            if x in range(N) and y in range(M):
                f_out[i, j] = f[x, y]
            else:
                f_out[i, j] = 0
    return f_out


# Baklengstransformasjon med bilineær interpolasjon
def bilinear(f, A):
    A = np.linalg.inv(A)
    a0 = A[0, 0]
    a1 = A[0, 1]
    a2 = A[0, 2]
    b0 = A[1, 0]
    b1 = A[1, 1]
    b2 = A[1, 2]

    N, M = 600, 512
    f_out = np.zeros((N, M))
    for i in range(N):
        for j in range(M):
            x = (a0 * i) + (a1 * j) + (a2)
            x0 = int(np.floor(x))
            x1 = int(np.ceil(x))
            dx = x - x0

            y = (b0 * i) + (b1 * j) + (b2)
            y0 = int(np.floor(y))
            y1 = int(np.ceil(y))
            dy = y - y0
            p = f[x0, y0] + (f[x1, y0] - f[x0, y0]) * dx
            q = f[x0, y1] + (f[x1, y1] - f[x0, y1]) * dx
            f_out[i, j] = p + (q - p) * dy

    return f_out


# Forlengstransformasjon
def forward(f, A):
    a0 = A[0, 0]
    a1 = A[0, 1]
    a2 = A[0, 2]
    b0 = A[1, 0]
    b1 = A[1, 1]
    b2 = A[1, 2]

    N, M = 600, 512
    f_out = np.zeros((N, M))
    for i in range(N):
        for j in range(M):
            x = round((a0 * i) + (a1 * j) + (a2))
            y = round((b0 * i) + (b1 * j) + (b2))
            x = int(x)
            y = int(y)
            if x in range(N) and y in range(M):
                f_out[x, y] = f[i, j]
    return f_out


# Main program som kjører alle metodene og printer det ut.
def main():

    portrett = imread("portrett.png", as_gray=True)
    geometrimaske = imread("geometrimaske.png", as_gray=True)

    my = np.mean(portrett)
    sigma = np.std(portrett)
    a = 64 / sigma
    b = 127 - my * a

    before = np.array(
        [
            [88, 84, 1, 0, 0, 0],
            [0, 0, 0, 88, 84, 1],
            [68, 119, 1, 0, 0, 0],
            [0, 0, 0, 68, 119, 1],
            [108, 129, 1, 0, 0, 0],
            [0, 0, 0, 108, 129, 1],
        ]
    )
    after = np.array([256, 168, 256, 340, 440, 256])

    ans = np.linalg.solve(before, after)
    A = np.array([[ans[0], ans[1], ans[2]], [
                 ans[3], ans[4], ans[5]], [0, 0, 1]])



    portrett_graatonetrans = graatonetrans(portrett, a, b)
    fig = plt.figure()
    plt.subplot(1, 2, 1)
    plt.imshow(portrett, cmap="gray", vmin=0, vmax=255)
    plt.title("Før")
    plt.subplot(1, 2, 2)
    plt.imshow(portrett_graatonetrans, cmap="gray", vmin=0, vmax=255)
    plt.title("Etter")
    fig.suptitle("Graatonetransformasjon")

    portrett_nabo = nabo(portrett_graatonetrans, A)
    fig = plt.figure()
    plt.subplot(1, 2, 1)
    plt.imshow(portrett_nabo, cmap="gray")
    plt.title("Resultat")
    plt.subplot(1, 2, 2)
    plt.imshow(portrett_nabo, cmap="gray")
    plt.imshow(geometrimaske, cmap="gray", alpha=0.50)
    plt.title("Med maske overlapp")
    fig.suptitle("Baklengstransformasjon med nærmeste nabo interpolasjon")

    portrett_bilinear = bilinear(portrett_graatonetrans, A)
    fig = plt.figure()
    plt.subplot(1, 2, 1)
    plt.imshow(portrett_bilinear, cmap="gray")
    plt.title("Resultat")
    plt.subplot(1, 2, 2)
    plt.imshow(portrett_bilinear, cmap="gray")
    plt.imshow(geometrimaske, cmap="gray", alpha=0.50)
    plt.title("Med maske overlapp")
    fig.suptitle("Baklengstransformasjon med bilineær interpolasjon")

    portrett_forward = forward(portrett_graatonetrans, A)
    fig = plt.figure()
    plt.subplot(1, 2, 1)
    plt.imshow(portrett_forward, cmap="gray", vmin=-20, vmax=235)
    plt.title("Resultat")
    plt.subplot(1, 2, 2)
    plt.imshow(portrett_forward, cmap="gray", vmin=-20, vmax=235)
    plt.imshow(geometrimaske, cmap="gray", vmin=0, vmax=255, alpha=0.30)
    plt.title("Med maske overlapp")
    fig.suptitle("Forlengstransformasjon")

    plt.show()


if __name__ == "__main__":
    main()
