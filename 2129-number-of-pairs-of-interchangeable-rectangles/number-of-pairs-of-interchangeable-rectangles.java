class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> ratioCount = new HashMap<>();
        long count = 0;
        for (int[] rect : rectangles) {
            double ratio = (double) rect[0] / rect[1];
    count += ratioCount.getOrDefault(ratio, 0L);
            ratioCount.put(ratio, ratioCount.getOrDefault(ratio, 0L) + 1);
        }

        return count;
    }
}