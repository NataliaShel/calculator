
public class Main {
    public static void main(String[] args) {
try {
    StringCalculator calc = new StringCalculator();
    System.out.println(calc.add(""));
    System.out.println(calc.add("4"));
    System.out.println(calc.add("4,7"));
    System.out.println(calc.add("//;\n1;-2"));
}
catch( Exception  e) {
    System.out.println(e.getMessage());
}
    }
}