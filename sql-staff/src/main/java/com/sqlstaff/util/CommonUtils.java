package com.sqlstaff.util;

import java.util.UUID;

public class CommonUtils {
    
	/*
	 * length=32
	 */
    public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}