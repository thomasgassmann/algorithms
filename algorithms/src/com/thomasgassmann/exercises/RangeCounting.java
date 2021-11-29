package com.thomasgassmann.exercises;

public class RangeCounting {
    public static int Range_Counting(int A[], int n, int k_l, int k_r)
    {
        int lowerBound = FindIndex(A, n, k_l);
        int upperBound = FindIndex(A, n, k_r);

        return upperBound - lowerBound;
    }

    private static int FindIndex(int A[], int n, int search) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] < search) {
                l = mid + 1;
            } else if (A[mid] > search) {
                r = mid - 1;
            } else if (A[mid] == search) {
                return mid;
            }
        }

        return l;
    }

    public static int Range_Counting_Solution(int A[], int n, int k_l, int k_r)
    {

        //  A:      The array of sorted integers
        //  n:      The number of integers in A
        //  k_l:    The left boundary of the range
        //  k_r:    The right boundary of the range

        int l,r,m;

        int left_index,right_index;

        // Decide left;

        if(k_l<A[0])
            left_index=-1;
        else if(k_l>A[n-1])
            left_index=n-1;
        else
        {
            l=0;
            r=n-1;
            while(r-l>1)
            {
                m=(l+r)/2;
                if(A[m]>k_l)
                    r=m;
                else if(A[m]<k_l)
                    l=m;

            }

            left_index=l;

        }

        if(k_r<A[0])
            right_index=0;
        else if(k_r>A[n-1])
            right_index=n;
        else
        {
            l=0;
            r=n-1;
            while(r-l>1)
            {
                m=(l+r)/2;
                if(A[m]>k_r)
                    r=m;
                else if(A[m]<k_r)
                    l=m;

            }

            right_index=r;

        }




        return right_index-left_index-1;


    }
}
