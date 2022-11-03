# Oppgave 5: Egen oppgave
# Lag en qiuz med 5 spørsmål hvor du bruker if/else.

print("Quiz tid!\nNå kommer det 5 spørsmål, svar så godt du klarer :-)")

# Lager en variabel "poengsum" = 0 for så å plusse på 1 hver gang bruker svarer riktig.
poengsum = 0

# Spør et spørsmål,
q1 = input("Hva heter operativsystemet som iPhone kjører på?\n >>>")
if q1 == "iOS" or q1 == "ios" or q1 == "IOS":
    print("Riktig svar.\n")
    poengsum = poengsum + 1
else:
    print("Sorry, feil svar.\n")


q2 = input("Hvilket kjent programmeringsspråk er utviklet av danske Bjarne Stroustrup?\n >>>")
if q2 == "c++" or q2 == "C++" or q2 == "cplusplus" or q2 == "C pluss pluss" or q2 == "C Pluss Pluss":
    print("Riktig svar.\n")
    poengsum = poengsum + 1
else:
    print("Sorry, feil svar.\n")


q3 = input("Hvilken nasjonalitet hadde oppfinneren av skiftenøkkelen?\n >>>")
if q3 == "Svenk" or q3 == "svensk":
    print("Riktig svar.\n")
    poengsum = poengsum + 1
else:
    print("Sorry, feil svar.\n")


q4 = input("Hvilket operativsystem etterfulgte Windows 95?\n >>>")
if q4 == "windows 98" or q4 == "Windows 98" or q4 == "windows98" or q4 == "Windows98":
    print("Riktig svar.\n")
    poengsum = poengsum + 1
else:
    print("Sorry, feil svar.\n")


q5 = input("Hva heter den største rovfuglen i Norge?\n >>>")
if q5 == "Havørn" or q5 == "havørn":
    print("Riktig svar.\n")
    poengsum = poengsum + 1
else:
    print("Sorry, feil svar.\n")


if poengsum == 5:
    print("Du er flink, alt riktig!")
elif poengsum == 0:
    print("Beklager, du fikk ingen riktig...")
else:
    print("Du fikk", str(poengsum), "riktige av 5 mulige. ")
