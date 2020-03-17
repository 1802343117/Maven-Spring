package com.soft1851.spring.ioc.other;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sort {
    int[] arr = {10, 1, 4214, 412, 522, 16, 626324, 213};
    int len = arr.length;

    public int[] sort() {
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                // 相邻元素两两相比
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public int[] sortSelection() {
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Sort sort = (Sort) ac.getBean("sort");
        int[] arr = sort.sortSelection();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}