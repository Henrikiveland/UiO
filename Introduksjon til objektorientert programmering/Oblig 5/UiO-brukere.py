# Oppgave 4: UiO-brukere

# Lager en ordbok med noen ekempel verdier
brukernavn_suffix = {"olan": "ifi.uio.no", "karin":
                     "student.matnat.uio.no"}

# lager en funksjon som tar inn et navn og splitter navnet og kombinerer det igjen med det første navnet pluss
# første bokstav i ettternavnet og returnerer dette som brukernavn
def lagBrukernavn(navn):
    splittet = navn.split(" ")
    mersplittet = list(splittet[1])
    brukernavn = (splittet[0] + mersplittet[0]).lower()
    return brukernavn


# Lager en funksjon som lager en epost av brukernavn og en epost suffix og returnerer en epost
def lagEpost(brukernavn, suffix):
    epost = (brukernavn + "@" + suffix)
    return epost


# Lager en prosedyre som lager eposter fra brukernavn og suffix fra ordboka og skriver ut alle epostene
def printEposter(ordbok):
    for i in ordbok.keys():
        print(lagEpost(i, brukernavn_suffix[i]))


# Lager en while løkke som spør brukeren om hva den vil gjøre og holder på frem til bruker vil stoppe programmet.
valg = "e"
while valg != "s":
    valg = input("\nHva vil du gjøre?\n(i for å legge til ny bruker)\n(p for å printe eposter)\n(s for å avslutte)\n>>>")
    if valg == "i":
        navn = input("Hva er ditt navn?(Et fornavn og et etternavn):\n>>>")
        suffix = input("Skriv inn en epost suffix:\n>>>")
        brukernavn = lagBrukernavn(navn)
        brukernavn_suffix[brukernavn] = suffix

    elif valg == "p":
        printEposter(brukernavn_suffix)

    elif valg == "s":
        print("Programmet avsluttes...")


