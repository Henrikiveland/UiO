# Oppgave 3: Hund

# Importerer klassen
from hund import Hund

# lager en prosedyre som lager et hundeobjekt og kaller på spring og
# spis flere ganger og printer ut vekten etter hver gang.


def hovedprogram():
    milli = Hund(3, 7)

    milli.spring()
    print(milli.vekt())
    milli.spring()
    print(milli.vekt())
    milli.spring()
    print(milli.vekt())
    milli.spring()
    print(milli.vekt())
    milli.spring()
    print(milli.vekt())
    milli.spring()
    print(milli.vekt())
    milli.spring()
    print(milli.vekt())
    milli.spring()
    print(milli.vekt())
    milli.spis(3)
    print(milli.vekt())
    milli.spis(2)
    print(milli.vekt())
    milli.spis(2)
    print(milli.vekt())
    milli.spis(2)
    print(milli.vekt())
    milli.spis(2)
    print(milli.vekt())


# kaller på prosedyren
hovedprogram()
