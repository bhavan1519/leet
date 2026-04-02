class Solution {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            while (i <= a.length - 1) {
                if (a[i] == 'A' || a[i] == 'E' || a[i] == 'I' || a[i] == 'O' || a[i] == 'U') {
                    break;
                }
                if (a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u') {
                    break;
                }
                i++;
            }
            while (j >= 0) {
                if (a[j] == 'A' || a[j] == 'E' || a[j] == 'I' || a[j] == 'O' || a[j] == 'U') {
                    break;
                }
                if (a[j] == 'a' || a[j] == 'e' || a[j] == 'i' || a[j] == 'o' || a[j] == 'u') {
                    break;
                }
                j--;
            }
            if (i < j) {
                char x = a[i];
                a[i] = a[j];
                a[j] = x;
                i++;
                j--;
            }
        }
        s = "";
        for (char x : a) {
            s = s + x;
        }
        return s;
    }
}