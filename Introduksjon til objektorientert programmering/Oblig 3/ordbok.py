# Oppgave 2: Ordbok
# Lager en ordbok med matvarer og priser

butikkvarer = {"melk": 14.90, "brød": 24.90, "yoghurt": 12.90, "pizza": 39.90}

print(butikkvarer)

# Ber bruker om å legge til to varer og pris, og legger det inn i ordboka
vare1 = input("Legg til en vare.\n>>>")
pris1 = float(input("Hva skal den koste?\n>>>"))

vare2 = input("Legg til en vare til.\n>>>")
pris2 = float(input("Hva skal denne koste?\n>>>"))

butikkvarer[vare1] = pris1
butikkvarer[vare2] = pris2

print(butikkvarer)
