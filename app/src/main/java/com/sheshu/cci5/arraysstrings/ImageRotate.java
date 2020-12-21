package com.sheshu.cci5.arraysstrings;

import java.util.Arrays;

public class ImageRotate {

    public static void test(){
        int n= 100;
        int[][] image = new int[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = j + 1;
            }
            System.out.println(Arrays.toString(image[i]));
        }
        System.out.println("-----Processing image-------------------------");

        int[][] image2 = rotateImage(image);
        System.out.println("-----Final result-------------------------");

        for(int i=0;i<n;i++) {
            System.out.println(Arrays.toString(image2[i]));
        }
        System.out.println("-----Final-------------------------");

    }

    private static int[][] rotateImage(int[][] image) {

        int n = image.length;
        // cut a diaogonal line across square, and flip the halfs..
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int temp = image[i][j];
                image[i][j] = image[j][n-i-1];
                image[j][n-i-1] = image[n-i-1][n-j-1];
                image[n-i-1][n-j-1] = image[n-j-1][i];
                image[n-j-1][i] = temp;
            }
            System.out.println(Arrays.toString(image[i]));

        }
        return image;
    }
}
