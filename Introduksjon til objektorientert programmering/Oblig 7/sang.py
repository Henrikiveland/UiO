# Oppgave 1 Klassen Sang

# lager en klasse Sang med artist og tittel som parametere.
class Sang:
    def __init__(self, artist, tittel):
        self._tittel = tittel
        self._artist = artist

    # Lager en funskjon som printer ut hvilken sang og artist som spiller.
    def spill(self):
        print("Spiller " + self._tittel + " av " + self._artist + ".")


    # Lager en funskjon med parameter "navn" som sjekker om "navn" er det samme som artisten eller en av artistene,
    # hvis det stemmer returnerer funskjonen True, hvis ikke returnerer den False.
    def sjekkArtist(self, navn):
        navnListe = navn.split()
        i = 0
        for j in navnListe:
            if j in self._artist.split():
                i += 1
            else:
                i += 0
        if i >= 1:
            i = True
        else:
            i = False
        return i

    # En funkjson med parameter "tittel" som sjekker om "tittel" er det samme som tittelen til objektet.
    # Returnerer true hvis det stemmer og False hvis det ikke stemmer.
    def sjekkTittel(self, tittel):

        if tittel.lower() == self._tittel.lower():
            return True
        else:
            return False

    # En funskjon med parametere "artist" og "tittel" som sjekker om både artist og tittel stemmer med sang-objektet.
    # Funskjonen kaller på de to andre funskejonene "sjekkArtist" og "sjekkTittel" og returnerer True hvis begger er
    # True og False hvis en av de ikke stemmer.
    def sjekkArtistOgTittel(self, artist, tittel):
        sangOgArtist = Sang(self._artist, self._tittel)
        if (sangOgArtist.sjekkArtist(artist)) and (sangOgArtist.sjekkTittel(tittel)):
            return True
        else:
            return False

    # En __str__ funskjon som returnerer sangen og tittelen.
    def __str__(self):
        return self._tittel + " av " + self._artist
