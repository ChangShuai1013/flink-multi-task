package com.cs.flink.utils;

public class Utils {

    // string 转换成 整数数组
    public static Integer[] string2IntergerArray(String str, String regex){
        String[] subs = str.split(regex);
        Integer[] rst = new Integer[subs.length];
        for (Integer i = 0;i< subs.length;i++){
            rst[i] = Integer.parseInt(subs[i],10);
        }
        return rst;
    }
}
