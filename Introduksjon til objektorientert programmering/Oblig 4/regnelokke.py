# Oppgave 2: Regning med løkker

# Lager en tom liste
tallliste = []
tall = int(input("Skriv inn et tall:\n>>>"))

# Lager en while-løkke som legger til alle tall som ikke er 0, inn i "tallliste".
while tall != 0:
    tallliste.append(tall)
    tall = int(input("Skriv inn et tall:(tast inn 0 når ferdig)\n>>>"))

# Printer ut alle tallene fra "tallliste".
for i in tallliste:
    print(i)

# Lager en tom variabel "minSum"
minSum = 0

# Plusser sammen et og et tall fra tallliste inn i "minSum".
for i in tallliste:
    minSum += i

print("Summen av tallene er:", minSum)


# Lager en variabel som er evig stor, sånn at alle mulige tall
# som brukeren kan legge inn er mindre
minstetall = float("inf")

# Setter "minstetall" lik det første tallet som er mindre enn uendelig(altså det første tallet)
# og sjekker vært neste tall om det er mindre enn "minstetall" og bytter det evt ut.
for i in tallliste:
    if i < minstetall:
        minstetall = i

print("Det minste tallet er:", minstetall)

# Gjør det samme med "storstetall" som med "minstetall".
storstetall = float("-inf")
for i in tallliste:
    if i > storstetall:
        storstetall = i

print("Det største tallet er:", storstetall)
