import java.util.LinkedList;
import java.util.Scanner;

public class Dia_5 {

    public static void main(String[] args) {
        Dia5Part1();
    }

    public static void Dia5Part1() {
        Scanner input = new Scanner(System.in);

        LinkedList<String> ordreNumeros = new LinkedList<>();
        boolean comprovar = false;
        int sumaNumMig = 0;

        while(input.hasNext()) {
            String numeros = input.nextLine();

            if(!numeros.equals("") && !comprovar) {
                String[] aux = numeros.split("\\|"); //* Números separats

                if(ordreNumeros.contains(aux[0]) && ordreNumeros.contains(aux[1])) {
                    int pos0 = ordreNumeros.indexOf(aux[0]);
                    int pos1 = ordreNumeros.indexOf(aux[1]);
                    if(pos0 > pos1) {
                        ordreNumeros.remove(aux[0]);
                        ordreNumeros.add(pos1, aux[0]);
                    }
                }
                else if(ordreNumeros.contains(aux[1]) && !ordreNumeros.contains(aux[0])) {
                    int pos1 = ordreNumeros.indexOf(aux[1]);   
                    ordreNumeros.add(pos1, aux[0]);
                }
                else if(ordreNumeros.contains(aux[0]) && !ordreNumeros.contains(aux[1]))
                    ordreNumeros.addLast(aux[1]);
                else {
                    ordreNumeros.addLast(aux[0]);
                    ordreNumeros.addLast(aux[1]);
                }
            }
            else if(comprovar) {
                String[] aux = numeros.split(",");
                boolean ordreBo = true;

                for(int i = aux.length - 1; i >= 0; i--) {
                    for(int j = 0; j < i; j++) {
                        //System.out.println(ordreNumeros.indexOf(aux[i]));
                        //System.out.println(ordreNumeros.indexOf(aux[j]));
                        if(ordreNumeros.indexOf(aux[i]) < ordreNumeros.indexOf(aux[j])) {
                            ordreBo = false;
                            break;
                        }
                    }

                    if(!ordreBo)
                        break;
                }

                if(ordreBo) {
                    int meitat = aux.length/2;
                    sumaNumMig += Integer.parseInt(aux[meitat]);
                }
            }
            else {
                comprovar = true;
            }
        }
        System.out.println(sumaNumMig);
    }
}
