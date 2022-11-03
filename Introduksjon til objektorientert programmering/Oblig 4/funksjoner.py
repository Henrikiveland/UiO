# Oppgave 1: Parametere og returverdier

# Lager en funksjon som har "tall1" og "tall2" som parametere
# Returnere summen av de to tallene
def adder(tall1, tall2):
    return tall1+tall2


# Spør bruker om to tall
tall1 = int(input("Skriv inn et tall.\n>>>"))
tall2 = int(input("Skriv inn et tall.\n>>>"))

# Skriver ut svaret, samtidig som jeg kaller på funksjonen med de to argumentene
sum = adder(tall1, tall2)

print("Summen av de to tallene =", sum)
def tellForekomst (minTekst, minBokstav):
    return minTekst.count(minBokstav)


minTekst = input("Skriv inn en en setning.\n>>>")
minBokstav = input("Skriv inn en bokstav.\n>>>")

antall = tellForekomst(minTekst, minBokstav)
print(minBokstav, "forekommer", antall, "ganger i setningen din!")
