// instans variabler, kontruktoer og metoder for klassen Celle.
class Celle {
    protected boolean levende;
    protected Celle[] naboer;
    protected int antNaboer;
    protected int antLevendeNaboer;

    public Celle() {
        levende = false;
        naboer = new Celle[8];
        antNaboer = 0;
        antLevendeNaboer = 0;
    }

    public boolean settDoed() {
        return levende = false;
    }

    public boolean settLevende() {
        return levende = true;

    }

    public boolean erLevende() {
        if (levende) {
            return true;
        } else {
            return false;
        }
    }

    public char hentStatusTegn() {
        if (levende) {
            return 'O';
        } else {
            return '.';
        }
    }

    public void leggTilNabo(Celle nabo) {
        naboer[antNaboer++] = nabo;
    }

    public void tellLevendeNaboer() {
        antLevendeNaboer = 0;
        for (int i = 0; i < antNaboer; i++) {
            if (naboer[i].erLevende()) {
                antLevendeNaboer++;
            }

        }
    }

    public void oppdaterStatus() {
        if (levende) {
            if (antLevendeNaboer < 2 || antLevendeNaboer > 3) {
                settDoed();
            }
        } else {
            if (antLevendeNaboer == 3) {
                settLevende();
            }
        }
    }

}
