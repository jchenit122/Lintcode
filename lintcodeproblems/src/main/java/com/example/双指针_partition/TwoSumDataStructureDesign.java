package com.example.双指针_partition;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenj240 on 8/31/17.
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * add(1); add(3); add(5);
 * find(4) // return true
 * find(7) // return false
 */

public class TwoSumDataStructureDesign {


    public static void main(String[] args) {
        // Your TwoSum object will be instantiated and called as such:
        TwoSum twoSum = new TwoSumDataStructureDesign().new TwoSum();
        //        twoSum.add(1);
        //        twoSum.add(1);
        //        twoSum.add(3);
        //        twoSum.add(0);
        //        twoSum.add(5);
        //        System.out.println(twoSum.find(4));
        //        System.out.println(twoSum.find(2));
        //        System.out.print(twoSum.find(5));
        twoSum.add(-12); ;
        twoSum.add(25); ;
        twoSum.add(-20);
        twoSum.add(-22); ;
        twoSum.add(12); ;
        twoSum.add(-39); ;
        twoSum.add(11); ;
        twoSum.add(-15);
        twoSum.add(25);
        twoSum.add(47);
        twoSum.add(-24);
        twoSum.add(18);
        twoSum.add(21); ;
        twoSum.add(-21);
        twoSum.add(32);
        twoSum.add(-11);
        twoSum.add(-35);
        twoSum.add(37);
        twoSum.add(-8);
        twoSum.add(-18);
        twoSum.add(42);
        twoSum.add(17);
        twoSum.add(16);
        twoSum.add(-46);
        twoSum.add(-27);
        twoSum.add(-34);
        twoSum.add(43);
        twoSum.add(31);
        twoSum.add(-13);
        twoSum.add(44);
        twoSum.add(-6);
        twoSum.add(10);
        twoSum.add(19);
        twoSum.add(12);
        twoSum.add(-11);
        twoSum.add(-12);
        twoSum.add(-25);
        twoSum.add(-39);
        twoSum.add(40);
        twoSum.add(36);
        twoSum.add(-19); ;
        twoSum.add(-43);
        twoSum.add(12);
        twoSum.add(42);
        twoSum.add(-39);
        twoSum.add(3);
        twoSum.add(-33);
        twoSum.add(-5);
        twoSum.add(0);
        twoSum.add(48);
        twoSum.add(-34);
        twoSum.add(-41);
        twoSum.add(-18);
        twoSum.add(16);
        twoSum.add(43);
        twoSum.add(43); ;
        twoSum.add(21);
        twoSum.add(-1);
        twoSum.add(-7);
        twoSum.add(7);
        twoSum.add(-13);
        twoSum.add(26);
        twoSum.add(17);
        twoSum.add(-33);
        twoSum.add(-47); ;
        twoSum.add(23);
        twoSum.add(-7);
        twoSum.add(38);
        twoSum.add(-4);
        twoSum.add(-29);
        twoSum.add(-40); ;
        twoSum.add(-11);
        twoSum.add(-6);
        twoSum.add(-34);
        twoSum.add(-32);
        twoSum.add(46);
        twoSum.add(25); ;
        twoSum.add(-6);
        twoSum.add(22);
        twoSum.add(0);
        twoSum.add(-45);
        twoSum.add(-20);
        twoSum.add(-36);
        twoSum.add(3);
        twoSum.add(-46);
        twoSum.add(39);
        twoSum.add(15);
        twoSum.add(19);
        twoSum.add(28);
        twoSum.add(0);
        twoSum.add(29);
        twoSum.add(9);
        twoSum.add(34);
        twoSum.add(22);
        twoSum.add(-8);
        twoSum.add(1);
        twoSum.add(-28);
        twoSum.add(0);
        twoSum.add(40);
        twoSum.add(47);
        System.out.println(twoSum.find(-20));
        System.out.println(twoSum.find(20));
        System.out.println(twoSum.find(3));
        System.out.println(twoSum.find(-42));
        System.out.println(twoSum.find(14));
        System.out.println(twoSum.find(-1));
        System.out.println(twoSum.find(-38));
        System.out.println(twoSum.find(31));
        System.out.println(twoSum.find(40));
        System.out.println(twoSum.find(-31));
        System.out.println(twoSum.find(-26));
        System.out.println(twoSum.find(41));
        System.out.println(twoSum.find(16));
        System.out.println(twoSum.find(-30));
        System.out.println(twoSum.find(-20));
        System.out.println(twoSum.find(24));
        System.out.println(twoSum.find(2));
        System.out.println(twoSum.find(8));
        System.out.println(twoSum.find(32));
        System.out.println(twoSum.find(42));
        System.out.println(twoSum.find(2));

    }

    public class TwoSum {
        private Map<Integer, Integer> map = new HashMap<>();

        // Add the number to an internal data structure. O(1)
        public void add(int number) {
            // Write your code here
            if (map.get(number) == null) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }

        // Find if there exists any pair of numbers which sum is equal to the value. O(n)
        public boolean find(int value) {
            // Write your code here
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (map.get(value - entry.getKey()) != null) {
                    if (value - entry.getKey() == entry.getKey()) {
                        if (entry.getValue()>1){
                            return true;
                        }else {
                            continue;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }

}
