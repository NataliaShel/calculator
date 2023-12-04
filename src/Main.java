
public class Main {
    public static void main(String[] args) {

        StringCalculator calc = new StringCalculator();

        System.out.println(calc.add("//;\n1;2"));
        System.out.println(calc.add("//!\n-1!2,3\n8"));
    }
}