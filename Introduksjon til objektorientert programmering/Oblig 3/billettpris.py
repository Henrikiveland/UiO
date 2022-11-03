# Oppgave 3: Billettpris
# Lager først en prosedyre


def billett():

    # Ber bruker om en alder og legger det inn i en variabel
    alder = int(input("\nHvor gammel er du?\n>>>"))
    billettpris = 0
    # Sjekker alder og setter billetten til en passende pris
    if alder <= 17:
        billettpris = 30

    elif 17 < alder < 63:
        billettpris = 50

    else:
        billettpris = 35

    # Printer ut den riktige prisen til billetten
    print("Billetten din koster", billettpris, "kroner!")


billett()
billett()
billett()


# Det er ikke noe feil med denne prosedyren som jeg har skrevet, men hvis man følger prosedyren akkurat som
# oppgaven sier vil du få en feil hvor folk som er over 63 også er over 17 og derfor må betale feil pris.

