import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dia_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String llistaSencera = "";
        List<Integer> llista1 = new ArrayList<>();
        List<Integer> llista2 = new ArrayList<>();

        while(input.hasNext()){
            llistaSencera = input.nextLine();
            String[] aux = llistaSencera.split("   ");

            llista1.add(Integer.parseInt(aux[0]));
            llista2.add(Integer.parseInt(aux[1]));
        }
        Collections.sort(llista1);
        Collections.sort(llista2);

        int distancia = 0;
        for(int i = 0; i < llista1.size(); i++) {
            int numLlista1 = llista1.get(i);
            int numLlista2 = llista2.get(i);
            distancia += Math.abs(numLlista1 - numLlista2);
        }
        System.out.print(distancia);
    }
}
