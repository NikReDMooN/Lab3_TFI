//parcer of *

import java.util.Scanner;

public class parceasteriskbeta {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while(s.contains("*")){
            int end = s.indexOf("*");
            int begin = end-1;
            if (s.charAt(end - 1) == ')' )){
                int depth = - 1;
                for (int i = end - 1; i >=0; i--){
                    if (s.charAt(i) == ')') depth--;
                    if (s.charAt(i) == '(') depth ++;
                    if (depth == 0) break;
                }
            }
            String ans =
        }
    }

}
