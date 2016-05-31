package com.yubaokang.baseframe.utils;

import java.text.DecimalFormat;

/**
 * Created by erhu on 2016/1/20.
 */
public class DataFormatUtils {
    public static String format(double f) {
        DecimalFormat df = new DecimalFormat("#.00");
        return String.valueOf(df.format(f));
    }
}
