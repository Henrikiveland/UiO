# Oppgave 4: Å telle bokstaver og ord

# spør bruker om en setning og gjør det om til en liste med hvert enkelt ord. Lager en tom ordbok.
tekst = input("Skriv inn en setning!\n>>>")
tekst_ord = tekst.split()
tekst_ordbok = {}

# Lager en prosedyre som tar inn en variabel og returnerer lengden
def telleord(lengde):
    return len(lengde)


# Lager en prosedyre som tar inn setningen(som en liste)
def ordbok(tekst_ord):

    # Lager en løkke med en if setning som legger hvert ord inn i en ordbok med
    # en verdi på 1, hvis ordet allerede er der, så øker verdien med 1
    for i in range(len(tekst_ord)):
        if tekst_ord[i] in tekst_ordbok:
            tekst_ordbok[tekst_ord[i]] += 1
        else:
            tekst_ordbok[tekst_ord[i]] = 1

    return tekst_ordbok

# Kaller på prosedyren
ordbok(tekst_ord)


# printer ut hvor mange ord det er i setningen ved å kalle på den første prosedyren.
print("Det er", telleord(tekst_ord), "ord i setningen din.")

# Går gjennom alle ordene og skriver ut hvor mange ganger ordet er i setningen og hvor mange bokstaver det har
# Lager en if setning som sjekker om jeg skal skrive ganger eller gang, bokstav eller bokstaver i setningen og printer
for i in range(len(tekst_ordbok)):
    if (tekst_ordbok[tekst_ord[i]]) == 1 and telleord(tekst_ord[i]) == 1:
        print("Ordet '" + tekst_ord[i] + "' forekommer", (tekst_ordbok[tekst_ord[i]]), "gang, og har",
              telleord(tekst_ord[i]), "bokstav!")
    elif (tekst_ordbok[tekst_ord[i]]) == 1 and telleord(tekst_ord[i]) != 1:
        print("Ordet '" + tekst_ord[i] + "' forekommer", (tekst_ordbok[tekst_ord[i]]), "gang, og har",
              telleord(tekst_ord[i]), "bokstaver!")
    elif (tekst_ordbok[tekst_ord[i]]) != 1 and telleord(tekst_ord[i]) == 1:
        print("Ordet '" + tekst_ord[i] + "' forekommer", (tekst_ordbok[tekst_ord[i]]), "ganger, og har",
              telleord(tekst_ord[i]), "bokstav!")
    elif (tekst_ordbok[tekst_ord[i]]) != 1 and telleord(tekst_ord[i]) != 1:
        print("Ordet '" + tekst_ord[i] + "' forekommer", (tekst_ordbok[tekst_ord[i]]), "ganger, og har",
              telleord(tekst_ord[i]), "bokstaver!")
    else:
        print("Ordet '" + tekst_ord[i] + "' forekommer", (tekst_ordbok[tekst_ord[i]]), "gang(er), og har",
              telleord(tekst_ord[i]), "bokstav(er)!")
