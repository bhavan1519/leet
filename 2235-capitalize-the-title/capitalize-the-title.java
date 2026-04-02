class Solution {
    public String capitalizeTitle(String title) {
        title=title.toLowerCase();
        String a="";
        String[] s=title.split("\\s+");
        for(int i=0;i<s.length;i++){
            if(s[i].length()>2)
                s[i]=Character.toUpperCase(s[i].charAt(0))+s[i].substring(1);
            a=a+s[i]+" ";
        }
        return a.trim();
    }
}