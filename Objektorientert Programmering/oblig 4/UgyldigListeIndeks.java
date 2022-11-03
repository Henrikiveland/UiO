// Importert feilmelding fra oppgaven
class UgyldigListeIndeks extends RuntimeException {
    UgyldigListeIndeks(int indeks){
        super("Ugyldig indeks:" + indeks);
    }
}
