class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        
        int currNum = 0;
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x >= '0' && x <= '9') {
                currNum = (currNum * 10) + (x - '0');
            } else {
                if (x == '[') {
                    intStack.push(currNum);
                    currNum = 0;
                    strStack.push(String.valueOf(x));
                } else if (x == ']') {
                    String temp = "";
                    while (!strStack.isEmpty() && !strStack.peek().equals("[")) {
                        temp = strStack.pop() + temp;
                    }
                    strStack.pop(); // Remove "["
                    
                    int num = intStack.pop();
                    StringBuilder tempAns = new StringBuilder();
                    for (int i = 0; i < num; ++i) {
                        tempAns.append(temp);
                    }
                    strStack.push(tempAns.toString());
                } else {
                    strStack.push(String.valueOf(x));
                }
            }
        }
        
        String ans = "";
        while (!strStack.isEmpty()) {
            ans = strStack.pop() + ans;
        }
        return ans;
    }
}