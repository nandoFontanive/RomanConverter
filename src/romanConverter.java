import java.util.Scanner;
import java.util.HashMap;

public class romanConverter {
    public static void main(String[] args) {
        int choice;
        String result = "";
        Scanner read = new Scanner(System.in);

        System.out.println("[ 1 ] Converter um numero arabico para romano");
        System.out.println("[ 2 ] Converter um numero romano para arabico");
        System.out.println("[ 0 ] Para sair do programa");
        System.out.print("Escolha a opcao desejada: ");
        choice = read.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Digite um numero entre 1 e 3999: ");
                int number = read.nextInt();
                if (number < 1 || number >= 4000)
                    System.out.println("Erro! Digite um numero entre 1 e 3999");
                while (number >= 1000) {
                    result = result + "M";
                    number = number - 1000;
                }
                while (number >= 900) {
                    result += "CM";
                    number -= 900;
                }
                while (number >= 500) {
                    result += "D";
                    number -= 500;
                }
                while (number >= 400) {
                    result += "CD";
                    number -= 400;
                }
                while (number >= 100) {
                    result += "C";
                    number -= 100;
                }
                while (number >= 90) {
                    result += "XC";
                    number -= 90;
                }
                while (number >= 50) {
                    result += "L";
                    number -= 50;
                }
                while (number >= 40) {
                    result += "XL";
                    number -= 40;
                }
                while (number >= 10) {
                    result += "X";
                    number -= 10;
                }
                while (number >= 9) {
                    result += "IX";
                    number -= 9;
                }
                while (number >= 5) {
                    result += "V";
                    number -= 5;
                }
                while (number >= 4) {
                    result += "IV";
                    number -= 4;
                }
                while (number >= 1) {
                    result += "I";
                    number -= 1;
                }
                System.out.println(result);
                break;

            case 2:
                read.nextLine();
                System.out.print("Digite um numero ROMANO entre 1 (I) e 3999 (MMMCMXCIX): ");
                String romanNumber = read.nextLine();

                System.out.println("Numero romano: " + romanNumber);
                HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
                romanMap.put('I', 1);
                romanMap.put('V', 5);
                romanMap.put('X', 10);
                romanMap.put('L', 50);
                romanMap.put('C', 100);
                romanMap.put('D', 500);
                romanMap.put('M', 1000);
                int len = romanNumber.length();
                int resultArabic = romanMap.get(romanNumber.charAt(len - 1));
                for (int i = len - 2; i >= 0; i--){
                    if (romanMap.get(romanNumber.charAt(i)) >= romanMap.get(romanNumber.charAt(i + 1)))
                        resultArabic = resultArabic + romanMap.get(romanNumber.charAt(i));
                    else
                        resultArabic = resultArabic - romanMap.get(romanNumber.charAt(i));
                }

                System.out.println("Numero arabico digitado: " + resultArabic);
                break;

            case 0:
                System.out.println("Saindo do programa");
                break;

            default:
                System.out.println("Opcao invalida, reiniciando o programa!");
                break;

        }
    }
}



