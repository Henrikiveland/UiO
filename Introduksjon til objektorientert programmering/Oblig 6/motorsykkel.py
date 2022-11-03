# Oppgave 1: Motorsykkel
# Lager en klasse som registrerer merke regnr og kilometerstand for
# en motorsykkel.

class Motorsykkel:
    def __init__(self, merke, reg, km):
        self._km = km
        self._merke = merke
        self._reg = reg

    def kjor(self, km):
        self._km += km

    def hentKilometerstand(self):
        return self._km

    def skrivUt(self):
        print("Merke:",str(self._merke))
        print("Registreringsnummer:",str(self._reg))
        print("Kilometer kjørt:",str(self._km))
