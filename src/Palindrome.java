public class Palindrome {
    public static void isPalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        System.out.println(str.equals(reversedStr));
    }
}
