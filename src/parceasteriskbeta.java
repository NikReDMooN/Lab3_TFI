//parcer of *

import java.util.Scanner;

public class parceasteriskbeta {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        parceasterisk(s);
    }


    public static void parceasterisk(String s){
        while(s.contains("*")){
            int end = s.lastIndexOf("*");
            int begin = end-1;
            if (s.charAt(begin) == ')' ){
                int depth = - 1;
                for (int i = end - 2; i >=0; i--){
                    if (s.charAt(i) == ')') depth--;
                    if (s.charAt(i) == '(') depth ++;
                    if (depth == 0) {
                        begin = i;
                        break;
                    }
                }
            }
            end +=1;
            String ans = s.substring(begin, end);

            if (ans.charAt(0) == '(') {
               // System.out.println("dqwdqwdwdqdq");
                ans = ans.substring(begin+1, ans.length()-2);
            }
            System.out.println("ans = " + ans);
            parceasterisk(ans);
            s = s.substring(0, begin) + s.substring(end);
            System.out.println(" s = " + s);
        }
    }

}
