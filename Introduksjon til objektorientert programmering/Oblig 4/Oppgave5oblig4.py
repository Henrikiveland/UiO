# Oppgave 5: Egen oppgave
# Lag et program som lar bruker holde styr på, legge til og skrive ut venners
# bursdager.

# Lager en tom ordbok
bursdager = {}

# Lager en prosedyre som spør om navn og dato og legger inn i ordboka.
# prosedyren gjentas helt til bruker ikke skal legge til flere bursdager.
# Hvis bruker svarer nei kaller programmet på en ny prosedyre.
def registrering():
    flere = "ja"
    while flere != "nei":
        person = input("\nHvem sin bursdag vil du legge til?\n>>>")
        dato = input("Når har personen bursdag?\n>>>")
        bursdager[person] = dato
        flere = input("vil du legge til flere?(ja/nei)\n>>>")
    brukervalg()


# Lager en prosedyre som spør bruker om et navn og skriver ut riktig bursdag.
# Etter på kaller programmet på en ny prosedyre.
def skrive_ut():
    print("\n")
    if len(bursdager) != 0:
        print(bursdager.keys())
        onsket_bursdag = input("Hvem sin bursdag vil du ha?\n>>>")
        if onsket_bursdag in bursdager:
            print(bursdager[onsket_bursdag])
        else:
            print("ugyldig input!")
        brukervalg()
    else:
        print("Ingen bursdager lagt inn!")
        brukervalg()


# Lager en prosedyre som lar brukeren velge om den skal registrere eller skrive ut bursdager.
def brukervalg():
    valg = int(input("\nHva vil du gjøre?(1 eller 2)"
                     "\nRegistrere bursdager(1)"
                     "\nSkrive ut bursdager(2)"
                     "\n>>>"))
    if valg == 1:
        registrering()
    elif valg == 2:
        skrive_ut()
    else:
        print("Ugyldig input")
        brukervalg()

# Kaller på starts prosedyren
brukervalg()
