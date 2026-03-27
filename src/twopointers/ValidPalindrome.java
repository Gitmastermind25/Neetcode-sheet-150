package twopointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // main method for testing
    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        System.out.println(obj.isPalindrome(s1)); // true
        System.out.println(obj.isPalindrome(s2)); // false
    }
}
