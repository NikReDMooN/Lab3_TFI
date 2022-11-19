import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String regex = in.nextLine();
        condition start = new condition(false);
        condition end = new condition(true);
        start.push(end, regex);
        autmatic aut = new autmatic(start);
    }
}
