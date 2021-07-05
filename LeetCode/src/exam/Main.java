package exam;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(input.next());
        }
        int i = 0;
        for(String s : set){
            System.out.print(s);
            if (i < n - 1) {
                System.out.print(" ");
            }
            i++;
        }
    }
}