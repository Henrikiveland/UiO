# Oppgave 2: Konvertering
# Spør bruker om å skrive inn en temperatur i fahrenheit,
# for så å konvertere den til celsius og printe ut svaret.


Fahrenheit = float(input("Skirv inn en temperatur i fahrenheit!\n >>>"))
print(Fahrenheit, "grader fahrenheit")

# Omgjør gradene fra fahrenheit til celsius via denne formelen.
celsius = str((Fahrenheit-32)*5/9)

print("Dette er gradene i celsius:", celsius+"C")
