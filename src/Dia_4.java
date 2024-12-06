import java.util.ArrayList;
import java.util.Scanner;

public class Dia_4 {

    public static void main(String[] args) {
        //Dia4Part1();
        Dia4Part2();
    }

    public static void Dia4Part1() {
        Scanner input = new Scanner(System.in);

        ArrayList<String> linies = new ArrayList<>();
        while(input.hasNext()) {
            linies.add(input.nextLine());
        }

        String[][] matriuXMAS = new String[linies.get(0).length()][linies.size()];

        for(int i = 0; i < linies.get(0).length(); i++) {
            String[] liniaSeparada = linies.get(i).split("");

            for(int j = 0; j < linies.size(); j++) {
                matriuXMAS[i][j] = liniaSeparada[j];
            }
        }

        int XMAS = 0;
        for(int i = 0; i < linies.get(0).length(); i++) {
            for(int j = 0; j < linies.size(); j++) {
                if(matriuXMAS[i][j].equals("X")) {
                    //? Tirem enrere
                    if(j >= 3) {
                        if(matriuXMAS[i][j-1].equals("M") && matriuXMAS[i][j-2].equals("A") && matriuXMAS[i][j-3].equals("S")) {
                            XMAS++;
                        }
                    }
                    //? Endavant
                    if(j < linies.get(0).length() - 3) {
                        if(matriuXMAS[i][j+1].equals("M") && matriuXMAS[i][j+2].equals("A") && matriuXMAS[i][j+3].equals("S")) {
                            XMAS++;
                        }
                    }
                    //? Cap a dalt
                    if(i >= 3) {
                        if(matriuXMAS[i-1][j].equals("M") && matriuXMAS[i-2][j].equals("A") && matriuXMAS[i-3][j].equals("S")) {
                            XMAS++;
                        }
                    }
                    //? Cap a baix
                    if(i < linies.size() - 3) {
                        if(matriuXMAS[i+1][j].equals("M") && matriuXMAS[i+2][j].equals("A") && matriuXMAS[i+3][j].equals("S")) {
                            XMAS++;
                        }
                    }
                    //? Diagonals

                    //? Diagonal baix a la dreta
                    if(j < linies.get(0).length() - 3 && i < linies.size() - 3) {
                        if(matriuXMAS[i+1][j+1].equals("M") && matriuXMAS[i+2][j+2].equals("A") && matriuXMAS[i+3][j+3].equals("S")) {
                            XMAS++;
                        }
                    }
                    //? Diagonal baix a l'esquerra
                    if(j >= 3 && i < linies.size() - 3) {
                        if(matriuXMAS[i+1][j-1].equals("M") && matriuXMAS[i+2][j-2].equals("A") && matriuXMAS[i+3][j-3].equals("S")) {
                            XMAS++;
                        }
                    }

                    //? Diagonal dalt a la dreta
                    if(j < linies.get(0).length() - 3 && i >= 3) {
                        if(matriuXMAS[i-1][j+1].equals("M") && matriuXMAS[i-2][j+2].equals("A") && matriuXMAS[i-3][j+3].equals("S")) {
                            XMAS++;
                        }
                    }
                    //? Diagonal dalt a l'esquerra
                    if(j >= 3 && i >= 3) {
                        if(matriuXMAS[i-1][j-1].equals("M") && matriuXMAS[i-2][j-2].equals("A") && matriuXMAS[i-3][j-3].equals("S")) {
                            XMAS++;
                        }
                    }
                }
            }
        }

        System.out.println(XMAS);
        input.close();
    }

    public static void Dia4Part2() {
        Scanner input = new Scanner(System.in);

        ArrayList<String> linies = new ArrayList<>();
        while(input.hasNext()) {
            linies.add(input.nextLine());
        }

        String[][] matriuXMAS = new String[linies.get(0).length()][linies.size()];

        for(int i = 0; i < linies.get(0).length(); i++) {
            String[] liniaSeparada = linies.get(i).split("");

            for(int j = 0; j < linies.size(); j++) {
                matriuXMAS[i][j] = liniaSeparada[j];
            }
        }

        int XMAS = 0;
        for(int i = 0; i < linies.get(0).length(); i++) {
            for(int j = 0; j < linies.size(); j++) {
                if(matriuXMAS[i][j].equals("A")) {
                    boolean X1, X2;
                    X1 = X2 = false;
                    //? Diagonals

                    //? Diagonal baix a la dreta i dalt a l'esquerra
                    if((j < linies.get(0).length() - 1 && i < linies.size() - 1) && (j >= 1 && i >= 1)) {
                        if(matriuXMAS[i+1][j+1].equals("M") && matriuXMAS[i-1][j-1].equals("S")) {
                            X1 = true;
                        }
                        else if(matriuXMAS[i+1][j+1].equals("S") && matriuXMAS[i-1][j-1].equals("M")) {
                            X1 = true;
                        }
                    }
                    //? Diagonal baix a l'esquerra i dalt a la dreta
                    if((j >= 1 && i < linies.size() - 1) && (j < linies.get(0).length() - 1 && i >= 1)) {
                        if(matriuXMAS[i+1][j-1].equals("M") && matriuXMAS[i-1][j+1].equals("S")) {
                            X2 = true;
                        }
                        else if(matriuXMAS[i+1][j-1].equals("S") && matriuXMAS[i-1][j+1].equals("M")) {
                            X2 = true;
                        }
                    }
                    if(X1 && X2)
                        XMAS++;
                }
            }
        }

        System.out.println(XMAS);
        input.close();
    }
}
