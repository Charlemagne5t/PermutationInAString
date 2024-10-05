class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] mask = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            mask[s1.charAt(i) -'a']++;
        }
        int[] m2 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            m2[s2.charAt(i) -'a']++;
        }
        if(compare(mask, m2)){
            return true;
        }

        for(int i = s1.length(); i < s2.length(); i++) {
            m2[s2.charAt(i - s1.length()) - 'a']--;
            m2[s2.charAt(i) - 'a']++;
            if(compare(mask, m2)){
                return true;
            }   
        }

        return false;
    }
    boolean compare(int[] m1, int[] m2) {
        for(int i = 0; i < 26; i++) {
            if(m1[i] != m2[i]) {
                return false;
            }
        }

        return true;
    }
}