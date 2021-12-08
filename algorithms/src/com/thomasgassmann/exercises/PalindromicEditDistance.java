package com.thomasgassmann.exercises;

public class PalindromicEditDistance {
    public static int Palindromic_Edit_Distance(char []A)
    {
        int n = A.length;

        //  A:      The input sequence
        //  n:      The length of A;

        int[][] dp =new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int ci = j;
                int cj = i + j;
                dp[ci][cj] = Math.min(
                        Math.min(
                                A[ci] == A[cj] ? dp[ci + 1][cj - 1] : Integer.MAX_VALUE,
                                dp[ci][cj - 1] + 1
                        ),
                        Math.min(
                                dp[ci + 1][cj] + 1,
                                dp[ci + 1][cj - 1] + 1
                        )
                );
            }
        }

        return dp[0][n-1];
    }

    public static int Palindromic_Edit_Distance_solution(char []A, int n)
    {

        //  A:      The input sequence
        //  n:      The length of A;

        int [][]DP_table=new int[n][n];

        for(int i=0;i<n;i++){
            DP_table[i][i]=0;
        }

        for(int i=0;i<n-1;i++){
            if(A[i]==A[i+1])
                DP_table[i][i+1]=0;
            else
                DP_table[i][i+1]=1;
        }

        for(int j=2;j<n;j++)
        {
            for(int i=0;i<n-j;i++)
            {
                int min;

                if(A[i]==A[i+j])
                    min=DP_table[i+1][i+j-1];
                else
                    min=DP_table[i+1][i+j-1]+1;

                if(DP_table[i+1][i+j]+1<min)
                    min=DP_table[i+1][i+j]+1;

                if(DP_table[i][i+j-1]+1<min)
                    min=DP_table[i][i+j-1]+1;


                DP_table[i][i+j]=min;




            }
        }

        return DP_table[0][n-1];

    }
}
