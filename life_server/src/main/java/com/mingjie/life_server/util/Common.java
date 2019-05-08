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
}
