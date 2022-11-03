# Oppgave 4: Dato

class Dato:
    def __init__(self, nyDag, nyMaaned, nyttAar):
        self._dag = nyDag
        self._maaned = nyMaaned
        self._aar = nyttAar

    def aar(self):
        return self._aar

    def dato(self):
        return (str(self._dag)+"."+str(self._maaned)+"."+str(self._aar))

    def sjekkDag(self, dag):
        if self._dag == dag:
            return True






