/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     public NestedInteger();
 *     public NestedInteger(int value);
 *     public boolean isInteger();
 *     public Integer getInteger();
 *     public void setInteger(int value);
 *     public void add(NestedInteger ni);
 *     public List<NestedInteger> getList();
 * }
 */

class Solution {

    public NestedInteger deserialize(String s) {

        NestedInteger ns = new NestedInteger();

        int n = s.length();
        int i = 0;

        // Whether current object represents a list
        boolean isList = false;

        // Ignore the outer closing bracket if this is a list
        int t = n;

        if (s.charAt(i) == '[') {
            isList = true;
            i++;
            t--;
        }

        StringBuilder sb = new StringBuilder();

        while (i < t) {

            char c = s.charAt(i);

            // Build the current integer
            if (Character.isDigit(c) || c == '-') {
                sb.append(c);
                i++;
            }

            // Integer completed
            else if (c == ',') {

                isList = true;

                if (sb.length() != 0) {
                    ns.add(new NestedInteger(Integer.parseInt(sb.toString())));
                }

                sb = new StringBuilder();
                i++;
            }

            // Nested list starts
            else if (c == '[') {

                isList = true;

                int count = 1;
                sb.append(c);
                i++;

                // Find the matching closing bracket
                while (count != 0 && i < t) {

                    c = s.charAt(i);
                    sb.append(c);

                    if (c == '[')
                        count++;
                    else if (c == ']')
                        count--;

                    i++;
                }

                // Recursively deserialize the nested list
                ns.add(deserialize(sb.toString()));

                sb = new StringBuilder();
            }
        }

        // Process the final number (if any)
        if (sb.length() != 0) {

            if (isList)
                ns.add(new NestedInteger(Integer.parseInt(sb.toString())));
            else
                ns.setInteger(Integer.parseInt(sb.toString()));
        }

        return ns;
    }
}