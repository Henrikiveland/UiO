# Oppgave 4: Matplan
# Lager først en ordbok med navn og måltider

maaltider = {"Gjertrud": ["yoghurt til frokost", "rekekabaret til lunsj", "kjøttkaker til middag"],
             "Rigmor": ["brødskive med ost til frokost", "egg til lunsj", "rømmegrøt til middag"],
             "Per Kjetil": ["nudler til frokost", "omelett til lunsj", "pølser til middag"],
             "Rolf": ["frokostblanding til frokost", "grønnsakssuppe til lunsj", "hyrdepai til middag"]}


# Lager en prosedyre som spør burker om et navn og gir ut riktig matplan
def matplan():

    # Printer først ut alle navnene og spør om et navn som jeg leggger i en variabel
    print(maaltider.keys())
    navn = input("\nHvem vil du ha matplanen til?\n>>>")

    # Sjekker om navnet er i ordboken og printer ut riktig matplanen
    if navn in maaltider:
        print(maaltider[navn][0] + "\n" + maaltider[navn][1] + "\n" + maaltider[navn][2])
    else:
        # Hvis navnet ikke er i ordboken printes det ut en melding og prosedyren
        # starter på nytt, hvor det første som skjer er å printe ut alle navnene.
        print("\nDen personen bor ikke her, prøv en av disse navnene:")
        matplan()


matplan()
