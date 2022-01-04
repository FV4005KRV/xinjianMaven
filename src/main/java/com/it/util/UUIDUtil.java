package com.it.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().substring(18);
    }
    public static String getDate(){
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        return  smf.format(new Date());
    }
}
