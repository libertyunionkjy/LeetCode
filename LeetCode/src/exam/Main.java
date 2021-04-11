import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character,Integer> map = new TreeMap<>();
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            char team1 = str.charAt(0);
            char team2 = str.charAt(2);
            if(!map.containsKey(team1)){
                map.put(team1,0);
            }
            if(!map.containsKey(team2)){
                map.put(team2,0);
            }
            int num1 = str.charAt(4) - '0';
            int num2 = str.charAt(6) - '0';
            if(num1 > num2){
                int value = map.get(team1);
                map.put(team1,value+3);
            }else if(num1 == num2){
                int value1 = map.get(team1);
                int value2 = map.get(team2);
                map.put(team1,value1+1);
                map.put(team2,value2+1);
            }else{
                int value = map.get(team2);
                map.put(team2,value+3);
            }
        }
        StringBuilder tmp = new StringBuilder();
        for(Character key : map.keySet()){
            tmp.append(key + " " + map.get(key) + ",");
        }
        String str1 = tmp.toString();
        System.out.print(str1.substring(0, str1.length() - 1));
    }
}