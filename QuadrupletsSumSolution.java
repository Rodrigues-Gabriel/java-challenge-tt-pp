import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupletsSumSolution {

  private static List<List<Integer>> getFourSum(int[] nums, int target) {
    List<List<Integer>> quadrupletsResult = new ArrayList<>();

    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n - 3; i++) {
      for (int j = i + 1; j < n - 2; j++) {
        int x = j + 1;
        int y = n - 1;

        while (x < y) {
          int currentSum = nums[i] + nums[j] + nums[x] + nums[y];
          if (currentSum < target) {
            x++;
          } else if (currentSum > target) {
            y--;
          } else {
            quadrupletsResult.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
            x++;
            y--;
            while (x < y && nums[x] == nums[x - 1]) {
              x++;
            }
            while (x < y && nums[y] == nums[y + 1]) {
              y--;
            }
          }
        }
      }
    }

    return quadrupletsResult;
  }

}