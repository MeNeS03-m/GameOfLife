import java.util.Scanner;
class GameOfLife {
    public static void main(String[] args) {
        Scanner skriv = new Scanner(System.in);

        System.out.println("Skriv inn antall rader: ");
        int rader = skriv.nextInt();

        System.out.println("Skriv inn antall kolonner: ");
        int kolonner = skriv.nextInt();

        Verden verden = new Verden(rader, kolonner);
        verden.tegn();

        for (int i = 0; i < 2; i++) {
            verden.oppdatering();
            verden.tegn();
        }

    }
}
