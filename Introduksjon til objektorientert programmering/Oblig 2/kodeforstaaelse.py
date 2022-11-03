#Oppgave 4: Kodeforståelse og feilsøking
# 1: Dette er ikke lovlig kode, fordi "b" er et heltall og kan ikke printes
#    ut sammen med en tekststring.

# 2: Når man kjører koden vil man få problemer dersom b < 10, fordi da prøver
#    programmet å printe ut noe ulovlig. For å løse dette problemet må man
#    omgjøre "b" til en string ved å skirve "print (str(b) + "Hei!") "

a = input("Tast inn et heltall! ")
b = int(a)
if b < 10:
    print(b + "Hei!")
