package Exercises;
import java.util.ArrayList;
import java.util.List;

public class Median {
    public static void main(String[] args) {
    	
        int[] nums = {3, 2, 5, 7, 4, 19, 5, 32, 19 };
        List<Integer> numList = new ArrayList<>();
        
        for(int i=0; i < nums.length; i++){
            int high = numList.size();
            int low = 0;
            
            while (low < high){
                int mid = (high + low) / 2;
                if (nums[i] <= numList.get(mid)){
                    high = mid;
                }
                else if(nums[i] >= numList.get(mid)){
                    low = mid + 1;
                }
            }
            numList.add(low, nums[i]);
            System.out.println(String.format("%.1f", getMedian(numList)));
        }
        
    }

    public static float getMedian(List<Integer> numList) {
        if (numList.isEmpty()) {
            return 0;
        } else if (numList.size() % 2 == 1) { //odd size
            return numList.get((numList.size()) / 2);
        } else { //even size
            return (numList.get(numList.size() / 2) + numList.get(numList.size() / 2 - 1)) / 2f;
        }
    }
}