package com.sheshu.cci5.arraysstrings;

import android.util.SparseIntArray;

import com.sheshu.cci5.Utils;

import static com.sheshu.cci5.Utils.printMatrix;

public class RowColumnZero {

    public static void test(){
        int m = 10;
        int n = 8;
        int[][] mat = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = Utils.randomInteger(10);
            }
        }
        printMatrix(mat);
        rowColumnZero(mat);
        printMatrix(mat);
    }



    private static void rowColumnZero(int[][] mat){
        // TODO: add null check

        SparseIntArray rowZeroMap = new SparseIntArray();
        SparseIntArray colZeroMap = new SparseIntArray();

        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    rowZeroMap.put(i, 1);
                    colZeroMap.put(j, 1);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if (rowZeroMap.indexOfKey(i) >= 0 || colZeroMap.indexOfKey(j) >= 0) {
                    mat[i][j] = 0;
                }
            }
        }
    }

}
