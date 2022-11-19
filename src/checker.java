import java.util.Scanner;

public class checker {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(delete(s,1,4));
    }

    static String delete(String s, int begin, int end){
        String answer = s.substring(0,begin);
        System.out.println("1 = " + answer);
        answer += s.substring(end);
        return answer;
    }
}
