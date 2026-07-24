class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int j =0, i = 0;
        int merge[] = new int[nums1.length + nums2.length];
        int k =0;
        while(i < nums1.length && j< nums2.length){
            if(nums1[i]<= nums2[j]){
                merge[k++] = nums1[i++];
            }else{
                merge[k++] = nums2[j++];
            }
        }

        while(i< nums1.length){
            merge[k++] = nums1[i++];
        }
        while(j< nums2.length){
            merge[k++] = nums2[j++];
        }

        int n= merge.length;
        if(n%2 == 1){
            return merge[n/2];
        }else{
            return (merge[n/2 - 1] + merge[n/2])/2.0;
        }
    }
    
}