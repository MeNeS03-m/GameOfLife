// instansvariabler, kontrukoer og metoder for klassen Rutenett.
import java.lang.Math;
class Rutenett {
    protected int antRader;
    protected int antKolonner;
    protected Celle[][] rutene;

    public Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];
    }

    public void lagCelle(int rad, int kol) {
        Celle celle = new Celle();
        if (Math.random() <= 0.3333) {
            celle.settLevende();
        }
        rutene[rad][kol] = celle;
    }

    public void fyllMedTilfeldigeCeller() {
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antKolonner; j++) {
                lagCelle(i, j);
            }
        }
    }

    public Celle hentCelle(int rad, int kol) {
        if (rad < 0 || rad >= antRader || kol < 0 || kol >= antKolonner) {
            return null;
        }
        return rutene[rad][kol];

    }

    public void tegnRutenett() {
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antKolonner; j++) {
                System.out.print(rutene[i][j].hentStatusTegn());
            }
            System.out.println();
        }
    }

    public void settNaboer(int rad, int kol) {
        Celle celle = hentCelle(rad, kol);
        if (celle == null) {
            return;
        }
        for (int i = rad - 1; i <= rad + 1; i++) {
            for (int j = kol - 1; j <= kol + 1; j++) {
                if (i == rad && j == kol) {
                    continue;
                }
                Celle nabo = hentCelle(i, j);
                if (nabo != null) {
                    celle.leggTilNabo(nabo);
                }
            }
        }
    }

    public void kobleAlleCeller() {
        for (int rad = 0; rad < rutene.length; rad++) {
            for (int kol = 0; kol < rutene[rad].length; kol++) {
                settNaboer(rad, kol);
            }
        }
    }

    public int antallLevende() {
        int teller = 0;
        for (int rad = 0; rad < rutene.length; rad++) {
            for (int kol = 0; kol < rutene[0].length; kol++) {
                if (rutene[rad][kol].erLevende()) {
                    teller++;
                }
            }
        }
        return teller;
    }
}