class Solution {
    public String reverseOnlyLetters(String s) {

        List<Character> letters = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.add(ch);
            }
        }

        Collections.reverse(letters);

        char[] arr = s.toCharArray();
        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            if (Character.isLetter(arr[i])) {
                arr[i] = letters.get(index++);
            }
        }

        return new String(arr);
    }
}