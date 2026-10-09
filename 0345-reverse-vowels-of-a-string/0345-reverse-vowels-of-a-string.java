class Solution {

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            // Find vowel from the left
            while (left < right && !isVowel(chars[left])) {
                left++;
            }

            // Find vowel from the right
            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            // Swap vowels
            if (left < right) {

                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {

        return c == 'a' || c == 'e' || c == 'i'
            || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I'
            || c == 'O' || c == 'U';
    }
}