import java.util.ArrayList;

public class Arraylists {
    public static void main(String args[]){
        ArrayList<String> names = new ArrayList();

        //Adicionando String ao Array
        names.add("Vinicius");
        names.add("Sofia");
        names.add("Roberto");

        names.sort(null);

        System.out.println(names);

    }
}
