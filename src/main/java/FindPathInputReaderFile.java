import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindPathInputReaderFile extends AbstractFindPathInputReader{
    protected static char bludisko[][];
    public FindPathInputReaderFile(String cestaKSuboru) {

        super(nacitajBludiskoZoSuboru(cestaKSuboru)); //
    }
    private static char[][] nacitajBludiskoZoSuboru(String nazov_suboru) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(nazov_suboru));
            String pom="";
            int sirka=0;
            int vyska=0;
            while((pom=bufferedReader.readLine())!=null){
                sirka=pom.length();
                vyska++;
            }
            bludisko = new char[sirka][vyska];
            bufferedReader.close();
            bufferedReader = new BufferedReader(new FileReader(nazov_suboru));
            int riadok=0;
            while ((pom=bufferedReader.readLine())!=null){
                if(pom != null){
                    for(int i=0;i<pom.length();i++){
                        bludisko[i][riadok] = pom.charAt(i);
                        System.out.print(bludisko[i][riadok]);
                    }System.out.println();
                }riadok++;
            }bufferedReader.close();
            System.out.println("Vypocitana cesta od bodu S k bodu X:");
        }catch (IOException e){
            e.printStackTrace();
        }
        return bludisko;
    }
    public void vypisNaKonzolu(){
        System.out.println(vypis());
    }

    public String vypis(){
        if(endNode.parent != null){
            Node p = endNode;
            while (p != null && p != startNode){
                if  (p.x-1==p.parent.x)  {cesta="D,"+cesta;}
                if  (p.x+1==p.parent.x)  {cesta="U,"+cesta;}
                if  (p.y-1==p.parent.y)  {cesta="R,"+cesta;}
                if  (p.y+1==p.parent.y)  {cesta="L,"+cesta;}
                p = p.parent;
            }
            return cesta.substring(0,cesta.length()-1);
        }
        return ziskajTrasu();
    }
}
