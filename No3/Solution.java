package No3;
import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int L = 0;
        int num = s.length();
        int ans = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < num; i++){
            if (L == num){
                break;
            }
            if (i != 0){
                set.remove(s.charAt(i - 1));
            }

            while (L < num && !(set.contains(s.charAt(L)))){
                //移动窗口指针
                set.add(s.charAt(L));
                L++;
            }
            ans = Math.max(ans, L - i);
        }
        return ans;
    }

}
