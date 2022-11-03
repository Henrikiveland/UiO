# Oppgave 4: Matplan
# Lager først en ordbok med navn og måltider

maaltider = {"Gjertrud": ["Yoghurt til frokost.", "Rekekabaret til lunsj.", "Kjøttkaker til middag."],
             "Rigmor": ["Brødskive med ost til frokost.", "Egg til lunsj.", "Rømmegrøt til middag."],
             "Per Kjetil": ["Nudler til frokost.", "Omelett til lunsj.", "Pølser til middag."],
             "Rolf": ["Frokostblanding til frokost.", "Grønnsakssuppe til lunsj.", "Hyrdepai til middag."]}


# Lager en prosedyre som spør bruker om et navn og gir ut riktig matplan
def matplan():

    # Printer først ut alle navnene og spør om et navn som jeg legger i en variabel
    print(maaltider.keys())
    navn = input("\nHvem vil du ha matplanen til?\n>>>")

    # Sjekker om navnet er i ordboken og printer ut riktig matplanen
    if navn in maaltider:
        print(maaltider[navn][0] + "\n" + maaltider[navn][1]+ "\n"+ maaltider[navn][2])
    else:
        # Hvis navnet ikke er i ordboken printes det ut en melding og prosedyren
        # starter på nytt, hvor det første som skjer er å printe ut alle navnene.
        print("\nDen personen bor ikke her, prøv en av disse navnene:")
        matplan()


matplan()


# 3.
# a) Her kan man godt bruke en mengde hvis man bare skal ha brukernavn,
#    men ville heller ha brukt en ordbok, sånn at man kan koble det til navn.
#
# b) Her ville jeg brukt en ordbok for å koble navn med poeng.
#
# c) Her ville jeg ha brukt en liste fordi her kan rekkefølgen være interessant
#    pluss at folk faktisk kan vinne to ganger og da funker det ikke med en mengde
#
# d) Her ville jeg brukt en ordbok for å koble navn med allergier
