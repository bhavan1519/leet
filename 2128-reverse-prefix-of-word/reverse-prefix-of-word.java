class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < word.length()) {
            st.push(word.charAt(i));
            if (word.charAt(i) == ch) {
                break;
            }
            i++;
        }
        if (i == word.length()) return word;
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        for (int j = i + 1; j < word.length(); j++) {
            sb.append(word.charAt(j));
        }
        return sb.toString();
    }
}