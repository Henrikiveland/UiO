# Oppgave 1: Lister
# Lager en liste med tre tall, og legger til et tall i lista.
tall = [4, 5, 2]
tall.append(9)
# Printer ut det første og tredje tallet i lista
print(tall[0], tall[2])

# Lager en ny tom liste og får bruker til å legge inn 4 navn.
navn = []
navn.append(input("Skriv inn et navn!\n>>>"))
navn.append(input("Skriv inn enda et navn!\n>>>"))
navn.append(input("Skriv inn et navn til!\n>>>"))
navn.append(input("Skriv inn et siste navn!\n>>>"))

# Bruker en if-sjekk for å se om navnet mitt er i lista.
if "Henrik" in navn:
    print("Du husket meg!")
else:                       # Kunne også brukt *elif "Henrik" not in navn:*.
    print("Glemte du meg?")

# Lager en ny liste med summen og produktet av lista "tall".
tall2 = [(sum(tall)), (tall[0]*tall[1]*tall[2]*tall[3])]

# Lager enda en ny liste med de to andre listene jeg har fra før.
tall3 = tall + tall2
print(tall3)
# Fjerner de to siste tallene fra den nyeste lista.
tall3.pop(-1)
tall3.pop(-1)
print(tall3)
