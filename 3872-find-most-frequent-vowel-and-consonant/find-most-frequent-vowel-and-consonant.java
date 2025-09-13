class Solution {
    public int maxFreqSum(String s) {
        int[] frequency = new int[27];
        int vowel = 0;
        vowel = 1 << 'a'-'a' | 1 << 'e'-'a' | 1 << 'i'-'a' | 1 << 'o'-'a' |1 << 'u'-'a';
        int vowelMaxFreq = 0;
        int consonantmaxFreq = 0;
        for(int i =0; i < s.length(); i++) {
            frequency[s.charAt(i)-'a'+1]++;
        }
        for(int i =1; i < 27; i++) {
            if((vowel & 1<<i-1) > 0) {
                if(frequency[i] > vowelMaxFreq) {
                    vowelMaxFreq = frequency[i];
                }
            } else {
                if(frequency[i] > consonantmaxFreq) {
                    consonantmaxFreq = frequency[i];
                }
            }
        }
        return consonantmaxFreq + vowelMaxFreq;
    }
}