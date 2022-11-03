# Oppgave 3: Hund

# lager en klasse og tar inn variabler alder og vekt
class Hund:
    def __init__(self, alder, vekt):
        self._alder = alder
        self._vekt = vekt
        self._metthet = 10

    # Lager en metode som returnerer alder
    def alder(self):
        return self._alder

    # Lager en metode som returnerer vekt
    def vekt(self):
        return self._vekt

    # Lager en metode som senker mettheten med en og senker vekten med
    # en hvis mettheten er under fem
    def spring(self):
        self._metthet -= 1
        if self._metthet < 5:
            self._vekt -= 1

    # Lager en metode som tar inn en variabel mat og legger det til mettheten
    # Hvis mettheten er over sju så går vekten opp med en.
    def spis(self, mat):
        self._metthet += mat
        if self._metthet > 7:
            self._vekt += 1
