public class Main {

    public static void main(String[] args) {

        // 1. Two sum 15.09.2023
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println("1. Two sum \n [" + result[0] + ", " + result[1] + "]\n\n\n");

        // 2. AddTwoNumbers 16.09.2023
        AddTwoNumbers atn = new AddTwoNumbers();
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(2, new AddTwoNumbers.ListNode(4, new AddTwoNumbers.ListNode(3)));
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(5, new AddTwoNumbers.ListNode(6, new AddTwoNumbers.ListNode(4)));

        AddTwoNumbers.ListNode res = atn.addTwoNumbers(l1, l2);


        // 70. Climbing stairs

        ClimbingStairs climbingStairs = new ClimbingStairs();
        int csres = climbingStairs.ways(45);
        System.out.println(csres);

        //test
    }
}
