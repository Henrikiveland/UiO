# Oppgave 5: Egen oppgave
# Lag et program som sjekker allergier til påmeldte og tilslutt printer ut
# en liste med mat som bår unngås


# Lager først en ordbod med allergier og matvarer som man da evt ikke tåler
allergi_mat_ordbok = {"nøtter": "peanøtter, mandler, hasselnøtter, valnøtter, cashewnøtter pg pistasjnøtter"
                      , "laktose": "Melk, saus, sjokolade, bakverk og leverpostei"
                      , "gluten": "Brød, boller, rundstykker og noen kaker."
                      , "egg": "Kjeks, pasta, pai, majones og gratenger"
                      , "skalldyr": "Fisk, crabsticks, kaviar, leverpostei og rekechips"}

# Lager en tom liste som jeg skal bruke til å
# hvilke allergier som er registrert

# Lager en variabel som øker med antall allergier som blir lagt til

allergier = []
antall_allergier = 1


def allergitest():

    # Henter inn variabelen og listen fra utenfor prosedyren
    global allergier
    global antall_allergier

    # Spør om allergier og legger det til i lista
    # og spør om det skal legges til flere allergier
    allergier.append(input("Hva er du allergisk mot?(nøtter, laktose, gluten, egg eller skalldyr)\n>>>"))
    flere_allergier = input("Skal det registereres flere allergier? ja/nei\n>>>")
    # Hvis det skal legges til flere allergier, starter prosedyren på nytt
    if flere_allergier == "ja":
        antall_allergier = antall_allergier + 1
        allergitest()

    # Hvis det ikke skal legges til flere allrgier, så sjekker jeg
    # hvilke og hvor mange allergier som er lagt til og skriver ut
    # hvilke mat som bør unngås
    elif flere_allergier == "nei":
        print("Mat som må unngås:")
        if antall_allergier == 1:
            print(allergi_mat_ordbok[allergier[0]])
        elif antall_allergier == 2:
            print(allergi_mat_ordbok[allergier[0]])
            print(allergi_mat_ordbok[allergier[1]])
        elif antall_allergier == 3:
            print(allergi_mat_ordbok[allergier[0]])
            print(allergi_mat_ordbok[allergier[1]])
            print(allergi_mat_ordbok[allergier[2]])
        elif antall_allergier == 4:
            print(allergi_mat_ordbok[allergier[0]])
            print(allergi_mat_ordbok[allergier[1]])
            print(allergi_mat_ordbok[allergier[2]])
            print(allergi_mat_ordbok[allergier[3]])
        elif antall_allergier == 5:
            print(allergi_mat_ordbok[allergier[0]])
            print(allergi_mat_ordbok[allergier[1]])
            print(allergi_mat_ordbok[allergier[2]])
            print(allergi_mat_ordbok[allergier[3]])
            print(allergi_mat_ordbok[allergier[4]])


# Kjører prosedyren
allergitest()
