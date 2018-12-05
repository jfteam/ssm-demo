package org.jfteam.framework.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/5 14:59
 */
public class DateUtilsTest {

    @Test
    public void getDate() {
    }

    @Test
    public void add() {
        final String date = DateUtils.getDate(DateUtils.add(3));
        System.out.println(date);
    }
}