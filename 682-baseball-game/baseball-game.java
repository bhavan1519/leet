class Solution {
    public int calPoints(String[] operations) {
        int cs = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int a = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);
                stack.push(a);
                cs += a;
            } 
            else if (op.equals("C")) {
                cs -= stack.pop();
            } 
            else if (op.equals("D")) {
                int t = stack.peek() * 2;
                stack.push(t);
                cs += t;
            } 
            else {
                int val = Integer.parseInt(op);
                stack.push(val);
                cs += val;
            }
        }
        return cs;
    }
}