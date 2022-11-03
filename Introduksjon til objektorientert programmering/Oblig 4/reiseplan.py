# Oppgave 3: Reiseplan

steder = []

for i in range(5):
    steder.append(input("Legg til et reisemål:\n>>>"))

klesplagg = []
avreisedatoer = []

for i in range(5):
    klesplagg.append(input("Legg til et klesplagg:\n>>>"))


for i in range(5):
    avreisedatoer.append(input("Legg til en avreisedato:\n>>>"))

reiseplan = [steder, klesplagg, avreisedatoer]


for i in range(len(reiseplan)):
    print(reiseplan[i])


i1 = int(input("Hvilken av de tre listene vil du inn i? (fra 0 til 2)\n>>>"))
i2 = int(input("Hvilket objekt i denne lista vil du ha? (fra 0 til 4)\n>>>"))

if 0 <= i1 <= ((int(len(reiseplan)))-1) and 0 <= i2 <= ((int(len(reiseplan[i1]))) - 1):
    print(reiseplan[i1][i2])
else:
    print("Ugyldig input!")
