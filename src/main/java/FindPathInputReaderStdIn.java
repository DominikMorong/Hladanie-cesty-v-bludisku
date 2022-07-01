import java.util.ArrayList;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{
    public FindPathInputReaderStdIn() {
        super(nacitajBludiskoZKonzoly());
    }
    private static char[][] nacitajBludiskoZKonzoly() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> mainList = new ArrayList<>();
        String a;
        while (!(a = sc.nextLine()).isEmpty()) {
            mainList.add(a);
        }
        char [][] bludisko = new char[mainList.size()][mainList.get(0).length()];
        for (int i = 0; i < mainList.size(); i++) {
            for (int j = 0; j < mainList.get(0).length(); j++) {
                bludisko[i][j] = mainList.get(i).charAt(j);
                System.out.print(bludisko[i][j]);
            }System.out.println();
        }System.out.println("Vypocitana cesta od bodu S k bodu X:");
        return bludisko;
    }
    public void vypisNaKonzolu(){
        System.out.println(vypis());
    }
    public String vypis(){
        if(endNode.parent != null){
            Node p = endNode;
            while (p != null && p != startNode){
                if  (p.x-1==p.parent.x)  {cesta="R,"+cesta;}
                if  (p.x+1==p.parent.x)  {cesta="L,"+cesta;}
                if  (p.y-1==p.parent.y)  {cesta="D,"+cesta;}
                if  (p.y+1==p.parent.y)  {cesta="U,"+cesta;}
                p = p.parent;
            }return cesta.substring(0,cesta.length()-1);
        }return ziskajTrasu();
    }
}

