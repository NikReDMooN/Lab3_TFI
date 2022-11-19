import java.util.ArrayList;
import java.util.Scanner;

public class beta_analys {
    //проверяет состоит ли строка только из скобок или нет
    static boolean check(String s){
        return s.matches("[(-)]+");
    }

    static String delete(String s, int begin, int end){
        String answer = s.substring(0,begin);
        answer += s.substring(end);
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String regex = in.nextLine();
        int max_depth = 0;
        int current_depth = 0;
        int min_depth = 0;
        boolean help = true;
        for (char c : regex.toCharArray()){
            if (c == '(' && help){
                min_depth++;
            }
            if (c != '(') {
                help = false;
            }
            if (c == '(') {
                max_depth ++;
            }
            if (c == ')'){
                current_depth --;
            }
            if (current_depth > max_depth) {
                max_depth = current_depth;
            }
        }
        String copy_regex = new String(regex);
        int current_search_depth = min_depth;
        ArrayList<String> pars_regex = new ArrayList<String>();
        while(!copy_regex.equals("")){
            current_depth = 0;
            boolean is_find = false;
            boolean find = false;
            String search = new String();
            int begin = 0;
            int end = 0;
            for (int i = 0 ; i < copy_regex.length(); i ++){
                if (current_depth == current_search_depth && !is_find && (copy_regex.toCharArray()[i] != ')'  && copy_regex.toCharArray()[i] != '(')) {
                    is_find = true;
                    find = true;
                    begin = i;
                }
                if (current_depth == current_search_depth && is_find) {
                    Character c = copy_regex.toCharArray()[i];
                    if (c != ')' && c!= '(')  search += c.toString();
                }
                if (current_depth == current_search_depth && is_find && (copy_regex.toCharArray()[i] == ')'  || copy_regex.toCharArray()[i] == '(')){
                    end = i;
                    break;
                }
                if (copy_regex.toCharArray()[i] == ')') {
                    current_depth--;
                }
                if (copy_regex.toCharArray()[i] == '(') {
                    current_depth++;
                }

            }
            if (find) {
                System.out.println("search = " + search);
                copy_regex = delete(copy_regex,begin,end);
                pars_regex.add(search);
            }
            else {
                current_search_depth++;
            }

            if(check(copy_regex)) copy_regex = "";

        }
        for(String s : pars_regex){
            System.out.println(s);
        }
    }
}


//(aaa(bbb(ccc)(ddd)bbb)aaa)
//(xy*|ab|(x|a*))(x|y*)