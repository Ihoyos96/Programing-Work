package MoreExercises;

import java.util.*;

class NumArray{
    
    List<Integer> numArray;
    
    public NumArray(){
        this.numArray = new ArrayList<>();
    }
    
    public void add(int n){
        if (numArray.size() == 0)
            numArray.add(n);
        if (numArray.size() == 1)
            if (n > numArray.get(0))
                numArray.add(n);
            else{
                numArray.add(0, n);
            }
        numArray.add(getIndex(numArray, 0, numArray.size(), n), n);
        
        //more here
        
       
    }
    
    public int getIndex(List<Integer> numList, int low, int high, int num){
        
        int mid = (low + high) / 2;
        if (low == mid)
            return low;
        if (high == mid)
            return high;
        if (num > numList.get(mid)){
            low = mid;
            getIndex(numList, low, high, num);
        }
        if (num < numList.get(mid)){
            high = mid;
            getIndex(numList, low, high, num);
        }
        if (num == mid)
            return mid;
        return 0;
    
    }
}


class Solution {

    public static void main(String[] args) {
        
        NumArray numArray = new NumArray();
        
        numArray.add(7);
        numArray.add(2);
        numArray.add(9);
        numArray.add(14);
        numArray.add(9);
        numArray.add(7);
        numArray.add(10);
        
    }
    
}