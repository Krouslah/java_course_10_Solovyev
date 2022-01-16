import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Доброго времени суток");
        getPage();
        System.out.println("В введенной строке нет цифр");
    }
    public static String scanner (){
        Scanner src = new Scanner(System.in);
        return src.nextLine();
    }
    public static void getPage() {
        System.out.print("Введите строку: ");
        String line = scanner();
        boolean flag = lookingForNumber(line);
        if (flag){
            System.out.println("Введите строку повторно, но уже без цифр");
            getPage();
        }
    }
    public static boolean lookingForNumber(String line){
        boolean flag = false;
        for (int i = 0; i < line.length(); i++) {
            Character number = line.charAt(i);
            for (int j = 0; j < 10; j++) {
                try {
                    if (line.charAt(i) == Integer.toString(j).charAt(0)) {
                        throw new NumberException("В строке обнаружена - ", number);
                    }
                }
                catch (NumberException ne){
                    System.out.println(ne.getMessage() + " " + number);
                    flag = true;
                }
            }
        }
        return flag;
    }
}
class NumberException extends RuntimeException{
    public Character k;

    public NumberException(String message, Character k) {
        super(message);
        this.k = k;
    }
}
