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
/* Jeg forstar ikke helt hva som er greia her... det er nemlig det at hele koden fungerer helt fin, kjorer tre ganger osv. men selve rutenettet vil ikke oppdatere 
seg i det hele tatt / samme med antall levende celler - men det er jo folgefeil siden rutenettett vil ikke oppdatere seg. Det som er litt dumt er at generasjonsnummeret oekes
saa metoden "oppdatering" fra Verden.java fungerer som den skal??? Nar man kjorer test verden med oppdatder funskjonen, sa oppdaterer den seg hver gang den blir kjort... Hvis du 
kan tipse meg paa hva som er feil, saa hadde jeg vaert veldig takknemlig. Jeg kan ogsaa nevne at alle tester i alle klassene kjorer helt fint uten noe som helst problemer...
*/