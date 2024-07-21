package No56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][2];
        }

        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> merge = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++){
            int L = intervals[i][0];
            int R = intervals[i][1];

            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < L){
                merge.add(new int[]{L, R});
            }else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], R);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
