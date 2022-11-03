# Oppgave 2 Klassen Spilleliste
# Importerer klassen Sang fra filen sang
from sang import Sang


# Lager en klasse Spilleliste
class Spilleliste:
    def __init__(self, listenavn):
        self._sanger = []
        self._navn = listenavn

    # Lager en prosedyre med et filnavn som parameter. Prosedyren åpner filen og leser linje for linje. Den splitter
    # hver linje på ";" og lager et sang-objekt og legger det til i listen "self._sanger", lukker filen til slutt.
    def lesFraFil(self, filNavn):
        fil = open(filNavn)
        for linje in fil:
            alleData = linje.strip().split(';')
            sang = Sang(alleData[1], alleData[0])
            self._sanger.append(sang)

        fil.close()


    # Lager en prosedyre med nySang som parameter som er et sang-objekt og legger nySang til i self._sanger listen.
    def leggTilSang(self, nySang):
        self._sanger.append(nySang)

    # Lager en prosedyre som har et sangobjekt som parameter og fjerner dette objektet fra listen self._sanger.
    def fjernSang(self, sang):
        self._sanger.remove(sang)

    # Lager en prosedyre med et sang-objekt som parameter. Funskjonen bruker klassen Sang.
    # som printer ut sangen som spiller
    def spillSang(self, sang):
        sang.spill()

    # Lager en prosedyre som går gjennom alle angene i self._sanger og printer ut alle sangene som spiller.
    def spillAlle(self):
        for sang in self._sanger:
            sang.spill()


    # Lager en funskjon med en parameter "tittel" som sjekker om denne tittelen er i spillelisten self._sanger
    # hvis sangen er i listen returneres sangen
    def finnSang(self, tittel):
        for sang in self._sanger:
            if sang.sjekkTittel(tittel) is True:
                return sang


    # Lager en funskjon med "artistnavn" som parameter. Lager en tom liste og går gjennom alle sangene i
    # listen self._sanger. Hvis sangen er av artisten i parameteren så legges sangen i den tomme listen
    # og listen returneres
    def hentArtistUtvalg(self, artistnavn):
        artistSanger = []
        for sang in self._sanger:
            if sang.sjekkArtist(artistnavn) is True:
                artistSanger.append(sang)

        return artistSanger


    # En __str__ funskjon som returnerer navnet på spillelisten.
    def __str__(self):
        return self._navn