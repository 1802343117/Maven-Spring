package com.soft1851.spring.ioc.entity;

import java.util.Random;

public class Sort {
    public void Beansort() {
        int arr[] = new int[10];
        Random r = new Random();
        //循环添加随机数
        for(int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        //对数组中的元素进行排序
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int max = arr[i];
                    arr[i] = arr[j];
                    arr[j] = arr[i];
                }
            }
        }
        //遍历输出
        for(int z : arr) {
            System.out.print(z + "\t");
        }
    }
}
