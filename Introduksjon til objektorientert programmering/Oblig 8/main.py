from spillebrett import Spillebrett

# Lager en prosedyre som lager et nytt spillebrett utifra radene og kolonnene som bruker skriver inn.
# En while-løkke oppdaterer spillebrettet fram til brukeren stopper det.
def main(rad, kolonne):
    forste = Spillebrett(rad, kolonne)
    forste.tegnBrett()
    print("")
    avslutte = ""
    while avslutte != "q":
        avslutte = input("Press enter for aa fortsette, Skriv inn q og trykk enter for aa avslutte")
        forste.oppdatering()



print("Hvor mange rader og kolonner vil du ha?")
rad = int(input("Rader:"))
kolonne = int(input("Kolonner:"))

# Kaller på main med input fra brukeren som parametere
main(rad, kolonne)

