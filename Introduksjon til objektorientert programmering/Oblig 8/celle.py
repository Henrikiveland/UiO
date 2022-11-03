
# Lager en klasse celle, med en konstruktør som sette status lik død
class Celle:
    # Konstruktør
    def __init__(self):
        self._status = "død"

    # Endrer status til død
    def settDoed(self):
        self._status = "død"

    # Endrer status til levende
    def settLevende(self):
        self._status = "levende"

    # Hente status, returnerer trur hvis levende og false hvis død
    def erLevende(self):
        if self._status == "levende":
            return True
        else:
            return False

    # returnerer (0) hvis levende og (.) hvis dødø
    def hentStatusTegn(self):
        if self._status == "levende":
            return " 0"
        else:
            return " ."
