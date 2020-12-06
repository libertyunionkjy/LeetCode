package offer;

public class Main {
    public static void main(String[] args) {
        longestPalindrome solution = new longestPalindrome();
        String s = "ssss";
        System.out.println(solution.solution01_dp(s).toCharArray());
    }
}
