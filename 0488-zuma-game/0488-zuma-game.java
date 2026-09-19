class Solution {

    public int findMinStep(String board, String hand) {
        char[] handArr = hand.toCharArray();
        Arrays.sort(handArr);

        return dfs(board, new String(handArr), new HashMap<>());
    }

    private int dfs(String board, String remainingHand, HashMap<String, Integer> memo) {
        if (board.isEmpty()) return 0;
        if (remainingHand.isEmpty()) return -1;

        String key = board + '#' + remainingHand;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int best = Integer.MAX_VALUE;

        for (int i = 0; i < remainingHand.length(); i++) {
            if (i > 0 && remainingHand.charAt(i) == remainingHand.charAt(i-1)) {
                continue;
            }

            char ball = remainingHand.charAt(i);
            String newHand = remainingHand.substring(0, i) + remainingHand.substring(i + 1);

            for (int pos = 0; pos <= board.length(); pos++) {
                if (!isGoodPlace(board, pos, ball)) {
                    continue;
                }

                String newBoard = board.substring(0, pos) + ball + board.substring(pos);
                String collapsedBoard = collapse(newBoard);
                
                int sub = dfs(collapsedBoard, newHand, memo);
                if (sub != -1) {
                    best = Math.min(best, sub + 1);
                }
            }
        }

        int result = (best == Integer.MAX_VALUE)? -1: best;
        memo.put(key, result);
        return result;
    }

    private boolean isGoodPlace(String board, int pos, char ball) {
        if (pos > 0 && board.charAt(pos - 1) == ball) {
            return true;
        }

        if (pos > 0 && pos < board.length()
                    && board.charAt(pos - 1) == board.charAt(pos)) {
            return true;
        }

        return false;
    }

    private String collapse(String board) {
        int i = 0;
        while (i < board.length()) {
            int j = i;
            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }

            if (j - i >= 3) {
                String newBoard = board.substring(0, i) + board.substring(j);
                return collapse(newBoard);
            } else {
                i = j;
            }
        }

        return board;
    }
}