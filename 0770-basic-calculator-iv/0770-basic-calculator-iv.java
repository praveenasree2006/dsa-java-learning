import java.util.*;

class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> evalmap = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) evalmap.put(evalvars[i], evalints[i]);

        List<String> tokens = tokenize(expression);
        Map<List<String>, Integer> poly = parseExpression(tokens, evalmap);

        List<Map.Entry<List<String>, Integer>> list = new ArrayList<>(poly.entrySet());
        list.sort((a, b) -> {
            if (b.getKey().size() != a.getKey().size()) return b.getKey().size() - a.getKey().size();
            // lexicographic compare by joining with '*'
            return String.join("*", a.getKey()).compareTo(String.join("*", b.getKey()));
        });

        List<String> ans = new ArrayList<>();
        for (var e : list) {
            int coeff = e.getValue();
            if (coeff == 0) continue;
            StringBuilder sb = new StringBuilder();
            sb.append(coeff);
            for (String v : e.getKey()) sb.append("*").append(v);
            ans.add(sb.toString());
        }
        return ans;
    }

    private List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : expr.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(c);
            else {
                if (sb.length() > 0) { tokens.add(sb.toString()); sb.setLength(0); }
                if (c == '+' || c == '-' || c == '*' || c == '(' || c == ')') tokens.add(String.valueOf(c));
            }
        }
        if (sb.length() > 0) tokens.add(sb.toString());
        return tokens;
    }

    private Map<List<String>, Integer> parseExpression(List<String> tokens, Map<String, Integer> evalmap) {
        Deque<Map<List<String>, Integer>> vals = new ArrayDeque<>();
        Deque<String> ops = new ArrayDeque<>();
        Map<String, Integer> prec = Map.of("+",1, "-",1, "*",2);

        for (String tok : tokens) {
            if (tok.equals("(")) ops.push(tok);
            else if (tok.equals(")")) {
                while (!ops.peek().equals("(")) applyOp(vals, ops.pop());
                ops.pop();
            } else if (prec.containsKey(tok)) {
                while (!ops.isEmpty() && prec.containsKey(ops.peek()) && prec.get(ops.peek()) >= prec.get(tok)) {
                    applyOp(vals, ops.pop());
                }
                ops.push(tok);
            } else {
                vals.push(parseToken(tok, evalmap));
            }
        }
        while (!ops.isEmpty()) applyOp(vals, ops.pop());
        return vals.isEmpty() ? new HashMap<>() : vals.pop();
    }

    private void applyOp(Deque<Map<List<String>, Integer>> vals, String op) {
        Map<List<String>, Integer> b = vals.pop();
        Map<List<String>, Integer> a = vals.pop();
        if (op.equals("+")) vals.push(add(a, b));
        else if (op.equals("-")) vals.push(sub(a, b));
        else vals.push(mul(a, b));
    }

    private Map<List<String>, Integer> parseToken(String tok, Map<String, Integer> evalmap) {
        Map<List<String>, Integer> res = new HashMap<>();
        if (tok.matches("-?\\d+")) {
            res.put(Collections.emptyList(), Integer.parseInt(tok));
        } else if (evalmap.containsKey(tok)) {
            res.put(Collections.emptyList(), evalmap.get(tok));
        } else {
            res.put(Arrays.asList(tok), 1);
        }
        return res;
    }

    private Map<List<String>, Integer> combine(Map<List<String>, Integer> m) {
        Map<List<String>, Integer> res = new HashMap<>();
        for (var e : m.entrySet()) {
            if (e.getValue() != 0) res.put(e.getKey(), res.getOrDefault(e.getKey(), 0) + e.getValue());
        }
        res.entrySet().removeIf(kv -> kv.getValue() == 0);
        return res;
    }

    private Map<List<String>, Integer> add(Map<List<String>, Integer> a, Map<List<String>, Integer> b) {
        Map<List<String>, Integer> res = new HashMap<>(a);
        for (var e : b.entrySet()) res.put(e.getKey(), res.getOrDefault(e.getKey(), 0) + e.getValue());
        return combine(res);
    }

    private Map<List<String>, Integer> sub(Map<List<String>, Integer> a, Map<List<String>, Integer> b) {
        Map<List<String>, Integer> res = new HashMap<>(a);
        for (var e : b.entrySet()) res.put(e.getKey(), res.getOrDefault(e.getKey(), 0) - e.getValue());
        return combine(res);
    }

    private Map<List<String>, Integer> mul(Map<List<String>, Integer> a, Map<List<String>, Integer> b) {
        Map<List<String>, Integer> res = new HashMap<>();
        for (var ea : a.entrySet()) {
            for (var eb : b.entrySet()) {
                List<String> merged = new ArrayList<>(ea.getKey());
                merged.addAll(eb.getKey());
                Collections.sort(merged);
                res.put(merged, res.getOrDefault(merged, 0) + ea.getValue() * eb.getValue());
            }
        }
        return combine(res);
    }
}