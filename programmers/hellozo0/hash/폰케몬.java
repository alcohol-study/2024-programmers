package hellozo0.hash;

import java.util.HashMap;

public class 폰케몬 {
    public int solution(int[] nums) {

        int N = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        if (N / 2 <= map.size()) {
            return N / 2;
        } else {
            return map.size();
        }

    }
}
