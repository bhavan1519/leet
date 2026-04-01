class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0;
        int l=0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            if(i-l+1 == 3){
                if(hm.size()==3){
                    count++;
                }
                hm.put(s.charAt(l),hm.getOrDefault(s.charAt(l),0)-1);
                if(hm.get(s.charAt(l))==0){
                    hm.remove(s.charAt(l));
                }
                l++;
            }
        }
        return count;
    }
}