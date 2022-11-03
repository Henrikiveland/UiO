# Oppgave 1: Regnefunksjoner.

# Lager en prosedyre som adderer to parametere.
def addisjon(a, b):
    return a+b

# Bruker assert for å sjekke om svaret stemmer.
assert addisjon(1, 3) == 4
assert addisjon(10, -19) == -9
assert addisjon(-78, -2) == -80

# Lager en prosedyre som subtraerer to parametere.

def subtraksjon(c, d):
    return c-d


# Bruker assert for å sjekke om svaret stemmer.
assert subtraksjon(1, 3) == -2
assert subtraksjon(10, -19) == 29
assert subtraksjon(-78, -2) == -76

# Lager en prosedyre som dividerer to parametere.

def divisjon(e, f):
    return e/f


# Bruker assert for å sjekke om svaret stemmer.
assert divisjon(6, 3) == 2
assert divisjon(19, -19) == -1
assert divisjon(-78, -2) == 39

# Lager en prosedyre som konverterer cm til tommer..
def tommerTilCm(antallTommer):
    assert antallTommer > 0
    return antallTommer*2.54

# Lager en prosedyre som tar inn tre tall fra bruker og kaller på
# alle de andre prosedyrene og printer ut forskjellige svar.
def skrivBeregninger():
    tall1 = float(input("Skriv inn tall 1: "))
    tall2 = float(input("Skriv inn tall 2: "))
    print("\nResultat av summering:", str(addisjon(tall1, tall2)))
    print("Resultat av subtraksjon:", str(subtraksjon(tall1, tall2)))
    print("Resultat av divisjon:", str(divisjon(tall1, tall2)), "\n")
    print("Konvertering fra tommer til cm:")
    tall3 = float(input("Skirv inn et tall: "))
    print("Resultat:", str(tommerTilCm(tall3)))


skrivBeregninger()
