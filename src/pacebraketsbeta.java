import java.util.Scanner;

public class pacebraketsbeta {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        boolean is_find = true;
        int begin = 0;
        int depth = 0;
        int end = -1;
        while(is_find){
            is_find = false;
            for(int i = 0; i < s.length(); i++){
                if (s.toCharArray()[i] == '(' && !is_find) {
                    is_find = true;
                    begin = i;
                    depth++;
                }

                if (s.toCharArray()[i] == '(') {
                    depth++;
                }

                if(s.toCharArray()[i] == ')'){
                    depth--;
                }
                if (is_find && depth == 0 && (i == s.length() || (i < s.length() && nextchar(s.toCharArray()[i+1])))){
                    end = i;
                }

            }
            if (end != -1 ) {
                String ans = s.substring(begin, end);
                System.out.println(" ans = " + ans);
            } else is_find = false;
                    
        }
    }

    public static boolean nextchar(Character c){
        if (c == '*' || c =='|' || c == '?' || c == '+') {
            return false;
        }
        return true;
    }

}
