// instansvariabler, kontrukoer og metoder for klassen Verden.
class Verden {
    protected Rutenett rutenett;
    protected int genNr;
    protected int rader;
    protected int kolonner;

    public Verden(int rader, int kolonner) {
        rutenett = new Rutenett(rader, kolonner);
        genNr = 0;
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }

    public void tegn() {
        System.out.println("Generasjonsnummer: " + genNr);
        System.out.println("Antall levende celler:" + rutenett.antallLevende());
        rutenett.tegnRutenett();
    }

    public void oppdatering() {
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                Celle celle = rutenett.hentCelle(i, j);
                celle.tellLevendeNaboer();
                celle.oppdaterStatus();
            }
        }
        genNr++;
    }
}
