from imageio import imread
import matplotlib.pyplot as plt
import numpy as np
import time
from scipy import signal
from numba import jit


# @jit
def zeropadding(filter, img):
    # Her burker jeg en modifisert paddigmetode fra oblig 1
    N, M = img.shape

    x, y = filter.shape
    # Må løse problemet med oddetalls filter
    if x % 2 == 0:
        off = 1
    else:
        off = 0

    nullmatrix = np.zeros((x, y))

    f = filter

    padSizeHight = int(((N / 2) - (x / 2)))
    padSizeWidth = int(((M / 2) - (y / 2)))

    fAbove = [nullmatrix[0]]

    for i in range(padSizeHight - off):
        fAbove = np.append(fAbove, [nullmatrix[0]], axis=0)

    f = np.append(fAbove, f, axis=0)

    for i in range(padSizeHight):
        f = np.append(f, [nullmatrix[-1]], axis=0)

    f = np.matrix.transpose(f)

    x, y = f.shape
    nullmatrix = np.zeros((x, y))
    fAbove = [nullmatrix[0]]

    for i in range(padSizeWidth - off):
        fAbove = np.append(fAbove, [nullmatrix[0]], axis=0)

    f = np.append(fAbove, f, axis=0)

    for i in range(padSizeWidth):
        f = np.append(f, [nullmatrix[-1]], axis=0)

    f = np.matrix.transpose(f)

    return f


# En metode som kaller på fft metoden med egen padding-metode eller sender inn bildestørrelsen til np.fft.
# @jit
def fft(i, f, padding):
    img = i
    fftimg = img
    filter = f

    # Bruker egen padding metode(1.1)
    if padding == True:
        fftimg = np.fft.fft2(img)
        filter = zeropadding(filter, img)
        filter = np.fft.fftshift(filter)
        filter = np.fft.fft2(filter)
        fftimg = np.fft.ifft2((fftimg * filter))
        fftimg = np.real(fftimg)

    # Bruker innebygd padding(1.2)
    else:
        N, M = img.shape
        filter3 = np.fft.fftshift(np.fft.fft2(filter, (N, M)))
        fftimg = np.fft.fftshift(np.fft.fft2(img))
        fftimg = np.multiply(fftimg, filter3)
        fftimg = np.fft.ifft2(fftimg)
        fftimg = np.abs(fftimg)

    return fftimg


# Metode som tar inn antall/størreslen på filteret og tar tiden og plotter den i en graf.
# @jit
def timetaker(img, a):
    antall = a
    image = img

    times1 = []
    sizes1 = []
    plt.figure()
    print("Teller til ", antall)
    for i in range(1, antall):
        varFilter = (1 / (i ** 2)) * np.ones((i, i))
        fftTime = time.time()
        varFftCow = fft(image, varFilter, False)
        fftTime = time.time() - fftTime
        times1.append(fftTime)
        sizes1.append(i)
        print(i)

    times2 = []
    sizes2 = []
    print("Teller til ", antall)
    for i in range(1, antall):
        varFilter = (1 / (i ** 2)) * np.ones((i, i))
        convTime = time.time()
        varConvCow = signal.convolve2d(image, varFilter)
        convTime = time.time() - convTime
        times2.append(convTime)
        sizes2.append(i)
        print(i)

    plt.plot(sizes1, times1, color="blue")
    plt.plot(sizes2, times2, color="red")

    plt.title("Convolution(Red), FFT(Blue)")
    plt.xlabel("Filter Size")
    plt.ylabel("Time")


def main():
    start_tid = time.time()
    cow = imread("cow.png", as_gray=True)
    N, M = cow.shape
    filter = (1 / (15 ** 2)) * np.ones((15, 15))

    # 1.1
    # Konvulosjon
    conv1 = signal.convolve2d(cow, filter)

    fig = plt.figure()
    plt.subplot(1, 2, 1)
    plt.imshow(cow, cmap="gray")
    plt.title("Før")
    plt.subplot(1, 2, 2)
    plt.imshow(conv1, cmap="gray")
    plt.title("Etter")
    fig.suptitle("Konvolusjon(1.1)")

    # FFT
    fftcow1 = fft(cow, filter, True)

    fig = plt.figure()
    plt.subplot(1, 2, 1)
    plt.imshow(cow, cmap="gray")
    plt.title("Før")
    plt.subplot(1, 2, 2)
    plt.imshow(fftcow1, cmap="gray")
    plt.title("Etter")
    fig.suptitle("FFT(1.1)")

    # 1.2
    # Konvolusjon
    conv2 = signal.convolve2d(cow, filter, "same")

    fig = plt.figure()
    plt.subplot(1, 2, 1)
    plt.imshow(cow, cmap="gray")
    plt.title("Før")
    plt.subplot(1, 2, 2)
    plt.imshow(conv2, cmap="gray")
    plt.title("Etter")
    fig.suptitle("Konvolusjon 'same'(1.2)")

    # FFT med innsendt filter storrelse
    fftcow2 = fft(cow, filter, False)

    fig = plt.figure()
    plt.subplot(1, 2, 1)
    plt.imshow(cow, cmap="gray")
    plt.title("Før")
    plt.subplot(1, 2, 2)
    plt.imshow(fftcow2, cmap="gray")
    plt.title("Etter")
    fig.suptitle("FFT med innsendt storrelse(1.2)")

    # 1.3
    timetaker(cow, 30)
    timetaker(cow, 12)
    # De krysser rundt 8


    stopp_tid = round((time.time() - start_tid), 2)
    print("Hele programmet brukte", stopp_tid, "sek")
    plt.show()
    


if __name__ == "__main__":
    main()
