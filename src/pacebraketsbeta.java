import java.util.Scanner;

public class pacebraketsbeta {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        parce(s);
    }

    public static boolean nextchar(Character c){
        if (c == '*' || c =='|' || c == '?' || c == '+') {
            return false;
        }
        return true;
    }

    public static void parce(String s){
        boolean is_find = true;
        int begin = 0;
        int depth = 0;
        int end = -1;
        while(is_find){
            end =-1;
            is_find = false;
            for(int i = 0; i < s.length(); i++){
                if (s.toCharArray()[i] == '(' && !is_find && ((i==0) ||
                        i!=0 &&  nextchar(s.toCharArray()[i-1]))) {
                    is_find = true;
                    begin = i;
                    depth++;
                }

                if (s.toCharArray()[i] == '(' && begin != i) {
                    depth++;
                }

                if(s.toCharArray()[i] == ')'){
                    depth--;
                }
                if (is_find && depth == 0 && (i == s.length()-1 || (i < s.length()-2 && nextchar(s.toCharArray()[i+1])))){
                    end = i;
                    break;
                }

            }
            if (end != -1 ) {
                if(end != s.length()-1 && (s.toCharArray()[end + 1] == '*' || s.toCharArray()[end + 1] == '?' || s.toCharArray()[end + 1] == '+') ) end++;
                String ans = s.substring(begin+1, end);
                System.out.println(" ans = " + ans);
                if(end != s.length()) end++;
                s = s.substring(0,begin) + s.substring(end);
                parce(ans);


            } else is_find = false;

        }
    }

}


//(xy*|ab|(x|a*))(x|y*)