# Oppgave 5: Egen oppgave
# Skriv et beregningsprogram for skreddere med en
# funksjon som leser inn fra en fil der hver linje
# beskriver et navn på et mål og selve målet i tommer.
# Bruk en funksjon til å skrive ut alle målene i cm.
maalinger = open("oppgave5oblig5.txt")


# Lager en funksjon som tar inn en fil og lager en ordbok
def lagordbok(minfil):
    ordbok = {}
    for i in minfil:
        biter = i.split(",")
        ordbok[biter[0]] = float(biter[1])

    return ordbok


# Lager en funskjon som tar inn en ordbok og gjør om alle målingene fra tommer til cm.
def tommerTilCm(ordbok):
    for i in ordbok.keys():
        ordbok[i] = ordbok[i] * 2.54
        print(i+":", ordbok[i], "cm")
    return ordbok


maalinger_ordbok = lagordbok(maalinger)
tommerTilCm(maalinger_ordbok)
