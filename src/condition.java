import java.util.ArrayList;
import java.util.HashMap;

public class condition {
    ArrayList<condition> list_of_conditions; // куда мы можем перейти
    HashMap<condition, ArrayList<String>> keys;//как мы можем туда попасть
    HashMap<condition, Integer> position_condition;//од каким номеров в массиве состояние

    boolean is_end;

    int last_pos;

    public condition(boolean b){
        list_of_conditions = new ArrayList<condition>();
        keys = new HashMap<condition,ArrayList <String>>();
        position_condition = new HashMap<condition,Integer>();
        is_end = b;
        last_pos = 0;
    }

    public void push(condition c, String s){
        if (position_condition.get(c) == null) {
            list_of_conditions.add(c);
            position_condition.put(c,last_pos++);
        }
        if (keys.get(c) == null) {
            keys.put(c,new ArrayList<String>());
        }
        keys.get(c).add(s);
    }


    public void parcregex(){
        for(condition c : list_of_conditions){
            for (String s : keys.get(c)) {
                if (s.contains("(")){

                }

                if (s.contains("|")) {

                }

                if (s.contains("*")) {

                }

                if (s.contains("+")){

                }

                if (s.contains("?")) {

                }
            }
        }
    }


    private void parcebrackets(){

    }

}
