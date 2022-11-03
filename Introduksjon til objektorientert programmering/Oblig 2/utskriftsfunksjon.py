# Oppgave 1: Utskriftsprosedyre
# Lager en prosedyre "info" som spør noen spørsmål
# for så å printe ut svarene i en setning.


def info():
    navn1 = input("Skriv inn navn: ")
    bosted1 = input("Hvor kommer du fra? ")
    print("Hei,", navn1+"! Du er fra", bosted1+".\n")


# Kaller på prosedyren 3 ganger.
info()
info()
info()
