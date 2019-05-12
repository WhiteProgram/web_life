package com.mingjie.life_server.util;

import java.util.Date;

public class Common {
    /**
     * 获取10位数时间戳
     * @return
     */
    public static int get_current(){
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }
    public static int[] stringsToints(String[] strs){
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        return arr;
    }
}
