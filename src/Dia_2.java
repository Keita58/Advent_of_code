import java.util.Scanner;

public class Dia_2 {

    public static void main(String[] args) {
        //Dia2Part1();
        Dia2Part2();
    }

    public static void Dia2Part1() {
        Scanner input = new Scanner(System.in);

        int segurs = 0;
        boolean segur = true;
        boolean ascendent = false;
        boolean descendent = false;
        while(input.hasNext()) {
            String[] llistaSeparada = input.nextLine().split(" ");

            int num0 = Integer.parseInt(llistaSeparada[0]);
            int num1 = Integer.parseInt(llistaSeparada[1]);

            if((num1 - num0) > 0 && (num1 - num0) < 4) {
                ascendent = true;
            }
            else if((num0 - num1) > 0 && (num0 - num1) < 4){
                descendent = true;
            }
            
            if(ascendent || descendent) {
                for(int i = 2; i < llistaSeparada.length; i++) {
                    if(descendent && ((num1 - Integer.parseInt(llistaSeparada[i])) > 0 && (num1 - Integer.parseInt(llistaSeparada[i])) < 4)) {
                        num1 = Integer.parseInt(llistaSeparada[i]);
                    }
                    else if(ascendent && ((Integer.parseInt(llistaSeparada[i]) - num1) > 0 && (Integer.parseInt(llistaSeparada[i]) - num1) < 4)){
                        num1 = Integer.parseInt(llistaSeparada[i]);
                    }
                    else {
                        segur = false;
                        break;
                    }
                }
                if(segur)
                    segurs++;
            }
            
            segur = true;
            ascendent = false;
            descendent = false;
        }
        System.out.println(segurs);
    }

    public static void Dia2Part2() {
        Scanner input = new Scanner(System.in);

        int segurs = 0;
        while(input.hasNext()) {
            boolean segur = true;
            boolean ascendent = false;
            boolean descendent = false;
            boolean nivellTolerat = false;
            boolean sortir = true;
            String[] llistaSeparada = input.nextLine().split(" ");
            int llistaSeparadaDim = llistaSeparada.length;

            while (sortir) {
                int num0 = Integer.parseInt(llistaSeparada[0]);
                int num1 = Integer.parseInt(llistaSeparada[1]);

                if((num1 - num0) > 0 && (num1 - num0) < 4) {
                    ascendent = true;
                }
                else if((num0 - num1) > 0 && (num0 - num1) < 4){
                    descendent = true;
                }
                else if(llistaSeparada.length == llistaSeparadaDim) {
                    nivellTolerat = true;
                    int num2 = Integer.parseInt(llistaSeparada[2]);

                    if((num2 - num0) > 0 && (num2 - num0) < 4) {
                        llistaSeparada[1] = "0";
                    }
                    else if((num0 - num2) > 0 && (num2 - num0) < 4){
                        llistaSeparada[1] = "0";
                    }
                    else if((num2 - num1) > 0 && (num2 - num1) < 4) {
                        llistaSeparada[0] = "0";
                    }
                    else if((num1 - num2) > 0 && (num2 - num1) < 4){
                        llistaSeparada[0] = "0";
                    }
                    else 
                        llistaSeparada[2] = "0";

                    String[] aux = new String[llistaSeparada.length - 1];
                    int jAux = 0;
                    for(int j = 0; j < llistaSeparada.length; j++) {
                        if(!llistaSeparada[j].equals("0")) {
                            aux[jAux] = llistaSeparada[j];
                            jAux++;
                        }
                    }
                    
                    int num0_V2 = Integer.parseInt(aux[0]);
                    int num1_V2 = Integer.parseInt(aux[1]);

                    if((num1_V2 - num0_V2) > 0 && (num1_V2 - num0_V2) < 4) {
                        ascendent = true;
                    }
                    else if((num0_V2 - num1_V2) > 0 && (num0_V2 - num1_V2) < 4){
                        descendent = true;
                    }

                    for(int i = 2; i < aux.length; i++) {
                        if(descendent && ((num1_V2 - Integer.parseInt(aux[i])) > 0 && (num1_V2 - Integer.parseInt(aux[i])) < 4)) {
                            num1_V2 = Integer.parseInt(aux[i]);
                        }
                        else if(ascendent && ((Integer.parseInt(aux[i]) - num1_V2) > 0 && (Integer.parseInt(aux[i]) - num1_V2) < 4)){
                            num1_V2 = Integer.parseInt(aux[i]);
                        }
                        else {
                            segur = false;
                            sortir = false;
                            break;
                        }
                    }
                    if(segur) {
                        segurs++;
                        sortir = false;
                    }
                }
                else
                    break;
                
                if(sortir) {
                    for(int i = 2; i < llistaSeparada.length; i++) {
                        if(descendent && ((num1 - Integer.parseInt(llistaSeparada[i])) > 0 && (num1 - Integer.parseInt(llistaSeparada[i])) < 4)) {
                            num1 = Integer.parseInt(llistaSeparada[i]);
                        }
                        else if(ascendent && ((Integer.parseInt(llistaSeparada[i]) - num1) > 0 && (Integer.parseInt(llistaSeparada[i]) - num1) < 4)){
                            num1 = Integer.parseInt(llistaSeparada[i]);
                        }
                        else if(!nivellTolerat){
                            segur = false;
                            nivellTolerat = true;

                            num0 = Integer.parseInt(llistaSeparada[i-2]);
                            int num2 = Integer.parseInt(llistaSeparada[i]);

                            if((num2 - num0) > 0 && (num2 - num0) < 4) {
                                llistaSeparada[i-1] = "0";
                            }
                            else if((num0 - num2) > 0 && (num2 - num0) < 4){
                                llistaSeparada[i-1] = "0";
                            }
                            else if((num2 - num1) > 0 && (num2 - num1) < 4) {
                                llistaSeparada[i-2] = "0";
                            }
                            else if((num1 - num2) > 0 && (num2 - num1) < 4){
                                llistaSeparada[i-2] = "0";
                            }
                            else 
                                llistaSeparada[i] = "0";

                            String[] aux = new String[llistaSeparada.length - 1];
                            int jAux = 0;
                            for(int j = 0; j < llistaSeparada.length; j++) {
                                if(!llistaSeparada[j].equals("0")) {
                                    aux[jAux] = llistaSeparada[j];
                                    jAux++;
                                }
                            }
                            llistaSeparada = null;
                            llistaSeparada = aux;
                            break;
                        }
                        else {
                            segur = false;
                            sortir = false;
                            break;
                        }
                    }
                    if(segur) {
                        segurs++;
                        sortir = false;
                    }
                }
                segur = true;
                ascendent = false;
                descendent = false;
            }
        }
        System.out.println(segurs);
    }
}
