class FoodRatings {
    private Map<String, Integer> foodRating;
    private Map<String,String> foodCuisine;
    private Map<String, TreeSet<String>> cuisineFoods;
    private Map<String, Integer> ratingLookup;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineFoods = new HashMap<>();
        ratingLookup = new HashMap<>();

        for(int i=0;i<foods.length;i++){
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];

            foodRating.put(f, r);
            foodCuisine.put(f, c);
            ratingLookup.put(f, r);

            cuisineFoods.putIfAbsent(c, new TreeSet<>((a, b) -> {
                int ra = ratingLookup.get(a);
                int rb = ratingLookup.get(b);
                if (ra != rb) return rb - ra; // higher rating first
                return a.compareTo(b);  
        }));
        cuisineFoods.get(c).add(f);
    }
    }
    public void changeRating(String food, int newRating) {
         String c = foodCuisine.get(food);
        TreeSet<String> set = cuisineFoods.get(c);

        // Remove old entry
        set.remove(food);

        // Update rating
        foodRating.put(food, newRating);
        ratingLookup.put(food, newRating);

        // Re-insert with new rating
        set.add(food);
    }
    
    public String highestRated(String cuisine) {
         return cuisineFoods.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */