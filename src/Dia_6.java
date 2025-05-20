import java.util.ArrayList;
import java.util.Scanner;

public class Dia_6 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ArrayList<String> aux = new ArrayList<>();

        while(scan.hasNextLine()) {
            aux.add(scan.nextLine());
        }

        char[][] mapa = new char[aux.size()][aux.get(0).length()];
        int[] pos = new int[2];
        int max_linies = aux.size();
        int max_cols = aux.get(0).length();
        boolean up = true;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        int posicions = 1;

        for (int i = 0; i < max_linies; i++) {
            for(int j = 0; j < max_cols; j++) {
                mapa[i][j] = aux.get(i).charAt(j);
    
                if(mapa[i][j] == '^') {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }

        while(true) {
            if((pos[0] > 0 && pos[0] < max_linies) && (pos[1] > 0 && pos[1] < max_cols)) {

                if(right) {
                    if(mapa[pos[0]][pos[1]+1] != '#') {
                        if(mapa[pos[0]][pos[1]+1] != 'X'){
                            posicions++;
                        }
                        mapa[pos[0]][pos[1]] = 'X';
                        pos[1]++;
                        mapa[pos[0]][pos[1]] = '>';
                    }
                    else {
                        right = false;
                        down = true;
                    }
                }
                else if(left) {
                    if(mapa[pos[0]][pos[1]-1] != '#') {
                        if(mapa[pos[0]][pos[1]-1] != 'X'){
                            posicions++;
                        }
                        mapa[pos[0]][pos[1]] = 'X';
                        pos[1]--;
                        mapa[pos[0]][pos[1]] = '<';
                    }
                    else {
                        left = false;
                        up = true;
                    }
                }
                else if(up) {
                    if(mapa[pos[0]-1][pos[1]] != '#') {
                        if(mapa[pos[0]-1][pos[1]] != 'X'){
                            posicions++;
                        }
                        mapa[pos[0]][pos[1]] = 'X';
                        pos[0]--;
                        mapa[pos[0]][pos[1]] = '^';
                    }
                    else {
                        up = false;
                        right = true;
                    }
                }
                else if(down) {
                    if(mapa[pos[0]+1][pos[1]] != '#') {
                        if(mapa[pos[0]+1][pos[1]] != 'X') {
                            posicions++;
                        }
                        mapa[pos[0]][pos[1]] = 'X';
                        pos[0]++;
                        mapa[pos[0]][pos[1]] = 'V';
                    }
                    else {
                        down = false;
                        left = true;
                    }
                }
            }
            else
                break;
        }


        System.out.println(posicions);
    }
}
