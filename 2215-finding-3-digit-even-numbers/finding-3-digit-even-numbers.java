class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }
        for (int num = 100; num <= 998; num += 2) {
            int a = num / 100;
            int b = (num / 10) % 10; 
            int c = num % 10;

            int[] tempFreq = new int[10];
            tempFreq[a]++;
            tempFreq[b]++;
            tempFreq[c]++;

             boolean valid = true;
            for (int i = 0; i < 10; i++) {
                if (tempFreq[i] > freq[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(num);
            } 
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}