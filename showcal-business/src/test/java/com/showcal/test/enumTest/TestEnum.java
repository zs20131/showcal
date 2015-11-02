package com.showcal.test.enumTest;

import com.showcal.service.domain.SexEnum;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.test.enumTest
 *  Description:
 * ***************************************************************
 *  10/11 0011  V1.0  xiniu    New Files for com.showcal.test.enumTest
 * </pre>
 */
public class TestEnum {
    public static void main(String[] args) {
        String sex = "MALE";
        SexEnum sexEnum = SexEnum.valueOf(sex);
        System.out.println(sexEnum);
    }
}
