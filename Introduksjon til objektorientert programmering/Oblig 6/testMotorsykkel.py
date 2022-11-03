# Oppgave 1: Motorsykkel

# importerer klassen
from motorsykkel import Motorsykkel


# Lager en prosedyre som lager tre motorsykler og bruker
# klassen jeg har lagd til å skrive ut info.
def hovedprogram():

    motorsykkel1 = Motorsykkel("Yamaha", "CS8671", 34573)
    motorsykkel2 = Motorsykkel("Harley-Davidson", "GG4838", 10987)
    motorsykkel3 = Motorsykkel("Vespa", "NF3340", 74839)

    motorsykkel1.skrivUt()
    motorsykkel2.skrivUt()
    motorsykkel3.skrivUt()
    motorsykkel3.kjor(10)
    print(motorsykkel3.hentKilometerstand())


hovedprogram()
