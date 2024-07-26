package No438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

        for (int i = 0; i < p.length(); i++){
            if (need.containsKey(p.charAt(i))){
                Integer i1 = need.get(p.charAt(i));
                i1++;
                need.put(p.charAt(i), i1);
            }else {
                need.put(p.charAt(i), 1);
            }
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        ArrayList<Integer> res = new ArrayList<>();

        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)){
                if (windows.containsKey(c)){
                    Integer i = windows.get(c);
                    i++;
                    windows.put(c, i);
                }else {
                    windows.put(c, 1);
                }

                if (windows.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (right - left >= p.length()){
                if (valid == need.size()){
                    res.add(left);
                }
                char a = s.charAt(left);
                left++;

                if (need.containsKey(a)){
                    if (windows.get(a).equals(need.get(a))){
                        valid--;
                    }
                    Integer i = windows.get(a);
                    i--;
                    windows.put(a, i);
                }
            }
        }
        return res;
    }
}
