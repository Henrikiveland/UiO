import random
from celle import Celle

# Lager en klasse spillebrett, som lager to instansvariabler fra de to parameterne og lager en tom rutenett liste.
# Bruker en nøsted forløkke til å lage en nøsted liste, med rad antall lister inne i lista og kolonner antall celler
# i den innertse lista. Lager og setter en generasjonsvariabel til 0 og kaller på en prosedyre genrerer.
class Spillebrett:
    def __init__(self, rader, kolonner):
        self._rader = rader
        self._kolonner = kolonner
        self._rutenett = []
        for i in range(0, self._rader):
            self._rutenett.append([])
            for l in range(0, self._kolonner):
                self._rutenett[i].append(Celle())
        self._generasjonsnummer = 0
        self._generer()

    # en prosedyre som skriver ut den nøstete lista som en firkant, og printer ut generasjonsnummer og antall
    # levende celler igjen
    def tegnBrett(self):
        print("")
        print("")
        print("")
        print("")

        for i in range(0, self._rader):
            print("")
            for l in range(0, self._kolonner):
                print((self._rutenett[i][l]).hentStatusTegn(), end="")
        print("")
        print("Generasjon:",self._generasjonsnummer, "- Antall levende celler:", self.finnAntallLevende())


    # En prosedyre med to lister med celler som skal gjenopplives og drepes. Bruker en del forløkker og if setninger
    # og følger spille-reglene for å finne ut av hvilke celler som skal gjenopplives og drepes. til slutt så
    # økes generasjonsnummeret med 1 og kaller på prosedyren tegnBrett som printer ut et spillebrett
    def oppdatering(self):
        gjenopplives = []
        drepes = []

        for i in range(0, self._rader):
            for l in range(0, self._kolonner):
                if (self._rutenett[i][l]).erLevende():
                    naboListe = (self.finnNabo(i,l))
                    levendeNaboer = 0
                    for p in naboListe:
                        if p.erLevende():
                            levendeNaboer += 1
                    if levendeNaboer < 2 or levendeNaboer > 3:
                        drepes.append(self._rutenett[i][l])

                else:
                    naboListe = (self.finnNabo(i, l))
                    levendeNaboer = 0
                    for p in naboListe:
                        if p.erLevende():
                            levendeNaboer += 1
                    if levendeNaboer == 3:
                        gjenopplives.append(self._rutenett[i][l])

        for k in gjenopplives:
            k.settLevende()
        for a in drepes:
            a.settDoed()
        self._generasjonsnummer += 1
        self.tegnBrett()


    # En funskjon som bruker en nøsted for løkke for å finne alle levende
    # celler og returnerer en liste med disse cellene.
    def finnAntallLevende(self):
        antallLevende = 0
        for i in range(0, self._rader):
            for l in range(0, self._kolonner):
                if (self._rutenett[i][l]).erLevende():
                    antallLevende += 1
        return antallLevende


    # En funskjon som lager en liste naboListe og legger til alle naboene til en celle på en spesiell rad og kolonne.
    # Bruker if setninger for å sjekke om naboene fins, hvis de finnes blir de lagt til i lista.
    # Returnerer lista til slutt.
    def finnNabo(self, rad, kolonne):
        naboListe = []
        if (rad - 1) >= 0 and (kolonne - 1) >= 0:
            naboListe.append(self._rutenett[(rad - 1)][(kolonne - 1)])
        if (rad - 1) >= 0:
            naboListe.append(self._rutenett[(rad - 1)][(kolonne)])
        if (rad - 1) >= 0 and (kolonne + 1) <= self._kolonner-1:
            naboListe.append(self._rutenett[(rad - 1)][(kolonne + 1)])
        if (kolonne - 1) >= 0:
            naboListe.append(self._rutenett[(rad)][(kolonne - 1)])
        if (kolonne + 1) <= self._kolonner-1:
            naboListe.append(self._rutenett[(rad)][(kolonne + 1)])
        if (rad + 1) <= self._rader-1 and (kolonne - 1) >= 0:
            naboListe.append(self._rutenett[(rad + 1)][(kolonne - 1)])
        if (rad + 1) <= self._rader-1:
            naboListe.append(self._rutenett[(rad + 1)][(kolonne)])
        if (rad + 1) <= self._rader-1 and (kolonne + 1) <= self._kolonner-1:
            naboListe.append(self._rutenett[(rad + 1)][(kolonne + 1)])

        return naboListe

    # Lager en prosedyre som gir hver celle 1/3 sjanse for å endre status til levende.
    def _generer(self):
        for i in range(0, self._rader):
            for l in range(0, self._kolonner):
                ranTall = random.randint(0, 2)
                if ranTall == 0:
                    (self._rutenett[i][l]).settLevende()
