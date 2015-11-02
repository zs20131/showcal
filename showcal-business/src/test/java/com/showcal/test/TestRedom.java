package com.showcal.test;

import java.util.Random;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.test
 *  Description:
 * ***************************************************************
 *  10/23 0023  V1.0  xiniu    New Files for com.showcal.test
 * </pre>
 */
public class TestRedom {
    public static void main(String[] args) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += random.nextInt(10);
        }
        System.out.println(result);
    }
}
