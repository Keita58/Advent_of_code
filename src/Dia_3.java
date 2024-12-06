import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dia_3 {

    public static void main(String[] args) {
        //Dia3Part1();
        Dia3Part2();
    }

    public static void Dia3Part1() {
        Scanner input = new Scanner(System.in);
        List<String> valors = new ArrayList<>();
        int resultat = 0;

        while(input.hasNext()) {
            String mults = input.nextLine();
            Pattern p = Pattern.compile("mul\\([0-9]+,[0-9]+\\)");
            Matcher m = p.matcher(mults);
            while(m.find()) {
                valors.add(m.group().toString());
            }
        }

        for(String mul : valors) {
            mul = mul.replace("mul(", "");
            mul = mul.replace(")", "");
            String[] numeros = mul.split(",");
            resultat += (Integer.parseInt(numeros[0]) * Integer.parseInt(numeros[1]));
        }
        System.out.println(resultat);
        input.close();
    }

    public static void Dia3Part2() {
        Scanner input = new Scanner(System.in);
        List<String> valors = new ArrayList<>();
        int resultat = 0;

        while(input.hasNext()) {
            String mults = input.nextLine();
            Pattern p = Pattern.compile("mul\\([0-9]+,[0-9]+\\)|do\\(\\)|don't\\(\\)");
            Matcher m = p.matcher(mults);
            while(m.find()) {
                valors.add(m.group().toString());
            }
        }

        boolean passaUn = false;
        for(String mul : valors) {
            if(mul.equals("do()")){
                passaUn = false;
                continue;
            }
            else if(mul.equals("don't()")){
                passaUn = true;
                continue;
            }
            if(!passaUn){
                mul = mul.replace("mul(", "");
                mul = mul.replace(")", "");
                String[] numeros = mul.split(",");
                resultat += (Integer.parseInt(numeros[0]) * Integer.parseInt(numeros[1]));
            }
        }
        System.out.println(resultat);
        input.close();
    }
}
