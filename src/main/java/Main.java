import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Hladanie najviac optimalnej cesty v bludisku" +
                "\nPre nacitanie zo suboru napiste: Subor" +
                "\nPre nacitanie z konzoly napiste: Konzola");
        Scanner vstup = new Scanner(System.in);
        String vyber = vstup.nextLine();

        if (vyber.equalsIgnoreCase("Subor")) {
            System.out.println("Prosim zadajte nazov suboru napr.: src/main/resources/1.txt");
            FindPathInputReaderFile findPathInputReaderFile = new FindPathInputReaderFile(vstup.nextLine());
        } else if (vyber.equalsIgnoreCase("Konzola")) {
            System.out.println("Prosim vlozte mapu bludiska a stlacte ENTER pre potvrdenie mapy");
            FindPathInputReaderStdIn findPathInputReaderStdIn = new FindPathInputReaderStdIn();
        }
    }
}
