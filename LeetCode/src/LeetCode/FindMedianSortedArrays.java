package LeetCode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        int n = nums1.length, m = nums2.length, length = n + m, mid = length / 2;
        int i = 0;
        int n1 = 0, n2 = 0;
        /**
         * n+m:奇数，出来的时候正好是所求的中位数-1
         * n+m:偶数，出来的时候i-1和i
         */
        while (p1 < nums1.length && p2 < nums2.length && i <= mid + 1){
            if(nums1[p1] <= nums2[p2]){
                n2 = n1;
                n1 = nums1[p1];
                p1++;
            }
            else{
                n2 = n1;
                n1 = nums2[p2];
                p2++;
            }
            i++;
        }
        while(p1 < nums1.length && i <= mid + 1){
            n2 = n1;
            n1 = nums1[p1];
            p1++;
            i++;
        }
        while(p2 < nums2.length && i <= mid + 1){
            n2 = n1;
            n1 = nums2[p2];
            p2++;
            i++;
        }
        if(length % 2 == 0)
            return (n1 + n2) / 2.0;
        else
            return n1;
    }

    public static void main(String[] args) {
//        FindMedianSortedArrays solu = new FindMedianSortedArrays();
//        int[] nums1 = {0,2,4,6,8,9};
//        int[] nums2 = {};
        String a = "abc";
        
        System.out.print(a.charAt(1));
    }
}
