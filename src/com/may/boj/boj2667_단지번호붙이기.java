package com.may.boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj2667_단지번호붙이기 {
    // 상하좌우 이동 배열
    static int[] xArr = {-1, 0, 1, 0};
    static int[] yArr = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 지도의 크기
//        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int[][] mat = new int[N][N];
        boolean[][] visited = new boolean[N][N]; // 방문

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                mat[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                // == mat[i][j] = input.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>(); // 단지 리스트

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && mat[i][j] == 1) {
                    //System.out.println("반복문에서 dfs 호출");
                    list.add(dfs(mat, visited, i, j));
                }
            }
        }
        selectionSort(list);
        //Arrays.sort(list);

        System.out.println(list.size());
        for(int i = 0; i < list.size();i++)
            System.out.println(list.get(i));
//
//        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
//        System.out.println("시간차이(m) : " + secDiffTime);
    }

    public static void printMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static int dfs(int[][] mat, boolean[][] visited, int startRow, int startCol) {
        //System.out.println("check (" + startRow + ", " + startCol + ")");
        visited[startRow][startCol] = true;
        int ret = 1;
        for(int i = 0; i < 4; i++){
            int x = startRow + xArr[i];
            int y = startCol + yArr[i];

            if(checkRange(mat, x, y) && !visited[x][y] && mat[x][y] == 1){
                //System.out.println("재귀에서 호출");
                ret += dfs(mat, visited, x, y);
            }
        }
        return ret;
    }

    public static boolean checkRange(int[][] mat, int i, int j){
        return i < mat.length && i >= 0 && j < mat.length && j >= 0;
    }

    // 선택 정렬
    public static void selectionSort(List<Integer> list){
        for(int i = 0; i < list.size() - 1; i++){
            int minIdx = i;
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j) < list.get(minIdx)) minIdx = j;
            }
            int temp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, temp);
        }
    }
}