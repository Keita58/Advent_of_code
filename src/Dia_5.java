import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Dia_5 {

    public static void main(String[] args) {
        //Dia5Part1();
        Dia5Part2();
    }

    public static void Dia5Part1() {
        Scanner input = new Scanner(System.in);

        HashMap<String, List<String>> ordreNumeros = new HashMap<>();
        boolean comprovar = false;
        int sumaNumMig = 0;

        while(input.hasNext()) {
            String numeros = input.nextLine();

            if(!numeros.equals("") && !comprovar) {
                String[] aux = numeros.split("\\|"); //* Números separats

                if(ordreNumeros.containsKey(aux[0])) {
                    ordreNumeros.get(aux[0]).add(aux[1]);
                }
                else {
                    List<String> num = new ArrayList<>();
                    num.add(aux[1]);
                    ordreNumeros.put(aux[0], num);
                }
            }
            else if(comprovar) {
                String[] aux = numeros.split(",");
                boolean ordreBo = true;

                for(int i = 0; i < aux.length; i++) {
                    for(Entry<String, List<String>> dic : ordreNumeros.entrySet()) {
                        if(aux[i].equals(dic.getKey())) {
                            for(int j = i + 1; j < aux.length; j++) {
                                if(!dic.getValue().contains(aux[j])) {
                                    ordreBo = false;
                                    break;
                                }
                            }
                        }

                        if(!ordreBo)
                        break;
                    }
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

    public static void Dia5Part2() {
        Scanner input = new Scanner(System.in);

        HashMap<String, List<String>> ordreNumeros = new HashMap<>();
        boolean comprovar = false;
        int sumaNumMig = 0;

        while(input.hasNext()) {
            String numeros = input.nextLine();

            if(!numeros.equals("") && !comprovar) {
                String[] aux = numeros.split("\\|"); //* Números separats

                if(ordreNumeros.containsKey(aux[0])) {
                    ordreNumeros.get(aux[0]).add(aux[1]);
                }
                else {
                    List<String> num = new ArrayList<>();
                    num.add(aux[1]);
                    ordreNumeros.put(aux[0], num);
                }
            }
            else if(comprovar) {
                List<String> resultat = Arrays.asList(numeros.split(","));
                boolean ordreBo = true;

                for(int i = 0; i < resultat.size(); i++) {
                    for(Entry<String, List<String>> dic : ordreNumeros.entrySet()) {
                        if(resultat.get(i).equals(dic.getKey())) {
                            for(int j = i + 1; j < resultat.size(); j++) {
                                if(!dic.getValue().contains(resultat.get(j))) {
                                    ordreBo = false;
                                }
                            }
                        }
                    }
                }             

                if(!ordreBo) {
                    int[] nombCorrectesPos = new int[resultat.size()];
                    int i = 0; 

                    for(String num : resultat) {
                        int nombresCorrectes = 0;
                        for(String numAltres : resultat) {
                            if(!numAltres.equals(num) && ordreNumeros.containsKey(num) && ordreNumeros.get(num).contains(numAltres))
                                nombresCorrectes++;
                        }
                        nombCorrectesPos[i] = nombresCorrectes;
                        i++;
                    }

                    int meitat = resultat.size()/2;
                    sumaNumMig += Integer.parseInt(resultat.get(meitat));
                }
            }
            else {
                comprovar = true;
            }
            
        }
        System.out.println(sumaNumMig);
    }
}
