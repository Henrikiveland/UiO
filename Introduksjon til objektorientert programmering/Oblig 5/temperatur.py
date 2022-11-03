# Oppgave 2: Temperatur

# Lager en funksjon som tar inn en fil og lager det om til en ordbok og returnerer denne ordboken.
def lagordbok(minfil):
    ordbok = {}
    for i in minfil:
        biter = i.split(",")
        ordbok[biter[0]] = float(biter[1])
    return ordbok


# Lager en funksjon som tar inn en ordbok og en fil og sjekker om
# det er noen dager med høyere temp enn tidligere max temp.
# Skriver ut ny varmerekord og oppdaterer ordboken for så å returnere ordboken
def hoytemp(ordbok, fil):
    for i in range(365):
        splittet = (fil.readline()).split(",")
        if float(splittet[2]) > ordbok[splittet[0]]:
            print("Ny varmerekord på", splittet[1], splittet[0] + ":", float(splittet[2]),
                  "grader celsius(den gamle var på", ordbok[splittet[0]], "grader celsius).\n")
            ordbok[splittet[0]] = float(splittet[2])
    return ordbok


# Lager en prosedyre som tar inn den oppdaterte ordboken og et filnavn
# for så å lage en ny fil med filnavnet og legger til dataen fra ordboken
# i sammeformat som den orginale filen for værdataen var.
def nyfil(ordbok, filnavn):
    fil = open(filnavn, "a")
    for i in ordbok.keys():
        fil.write(i + "," + str((ordbok[i])) + "\n")


# Kjører de forskjellige funksjonene
temp_ordbok = lagordbok(open("max_temperatures_per_month.csv"))
temp_2018 = open("max_daily_temperature_2018.csv")
ny_temp_ordbok = hoytemp(temp_ordbok, temp_2018)

nyfil(ny_temp_ordbok, "new_max_temperatures_per_month.csv")
