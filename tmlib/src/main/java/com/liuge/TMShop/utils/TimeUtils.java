package com.liuge.TMShop.utils;

/**
 * Created by jiang on 2016/11/30.
 */

import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {
    static Handler handler;
    static Runnable runnable;
    //字符串转时间戳
    public static String getTime(String timeString){
        String timeStamp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date d;
        try{
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = String.valueOf(l);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return timeStamp;
    }
    //字符串转时间戳
    public static String getTime2(String timeString){
        String timeStamp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d;
        try{
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = String.valueOf(l);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return timeStamp;
    }
    //字符串转时间戳
    public static String getTimes(String timeString){
        String timeStamp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d;
        try{
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = String.valueOf(l);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return timeStamp;
    }
    //字符串转时间戳
    public static String getTime3(String timeString){
        String timeStamp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date d;
        try{
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = String.valueOf(l);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return timeStamp;
    }
    //字符串转时间戳
    public static String getTime4(String timeString){
        String timeStamp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH小时mm分ss秒");
        Date d;
        try{
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = String.valueOf(l);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return timeStamp;
    }
    //字符串转时间戳
    public static String getTime5(String timeString){
        String timeStamp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd天HH小时mm分ss秒");
        Date d;
        try{
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = String.valueOf(l);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return timeStamp;
    }

    //字符串转时间戳
    public static String getTime6(String timeString){
        String timeStamp = null;
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        Date d;
        try{
            d = sdf.parse(timeString);
            long l = d.getTime();
            timeStamp = String.valueOf(l);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return timeStamp;
    }

    //时间戳转字符串
    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(l);//单位秒
        return timeString;
    }

    //时间戳转字符串
    public static String getStr2Time(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(l);//单位秒
        return timeString;

    }
    //时间戳转字符串
    public static String getStr2Times(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long  l = Long.valueOf(timeStamp);
        Date date=new Date(l);
        timeString = sdf.format(date);//单位秒
        return timeString;
    }
    //时间戳转字符串
    public static String getStr2HourTimes(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(l);//单位秒
        return timeString;
    }
    //时间戳转字符串
    public static String getStr2HourTimes2(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH小时mm分ss秒");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(l);//单位秒
        return timeString;
    }
    //时间戳转字符串
    public static String getStr2HourTimes4(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(l);//单位秒
        return timeString;
    }

    //时间戳转字符串
    public static String getStr2HourTimes5(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(l);//单位秒
        return timeString;
    }

    //时间戳转字符串
    public static String getStr2HourTimes3(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd天HH小时mm分ss秒");
        long  l = Long.valueOf(timeStamp)*1000;
        timeString = sdf.format(l);//单位秒
        return timeString;
    }
    //计算时间差，保留到s
    public static double getdataUp(String nowTime,String upTime){
        double secends=(double)(Long.valueOf(nowTime)-(Long.valueOf(upTime)))/60/1000;
        return secends;
    }

    //计算天数
    public static double getdaynum(String start,String end){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//输入日期的格式
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = null;
        try {
            date2 = simpleDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar cal1 = new GregorianCalendar();
        GregorianCalendar cal2 = new GregorianCalendar();
        cal1.setTime(date1);
        cal2.setTime(date2);
        double dayCount = (cal2.getTimeInMillis()-cal1.getTimeInMillis())/(1000*3600*24);//从间隔毫秒变成间隔天数
        return dayCount;
    }

    public static void getReturnTime(String time, final Button tv){
        final String[] timeStamp = {getTime3(time)};
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                timeStamp[0] =""+(Integer.valueOf(timeStamp[0])-1000);
                tv.setText("剩余时间：" + getStr2HourTimes(timeStamp[0]));
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    public static void getReturnTime(final String time, final TextView tv){
//        if(getTimes(time)!=null) {
            final String[] timeStamp = {"" + (Long.valueOf(time) - (System.currentTimeMillis()/1000))};
            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    timeStamp[0] =""+(Integer.valueOf(timeStamp[0])-1);
                    tv.setText("剩余：" + getStr2HourTimes3(timeStamp[0]));
                    handler.postDelayed(this, 1000);
                }
            };
            handler.postDelayed(runnable, 1000);
//        }else{
//            tv.setText("暂未设置结束时间");
//        }
    }

    public static void getReturnTime2(String time, final TextView tv){
        final String[] timeStamp = {getTime4(time)};
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                timeStamp[0] =""+(Integer.valueOf(timeStamp[0])-1000);
                tv.setText("" + getStr2HourTimes2(timeStamp[0]));
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }
    public static void getReturnTime3(String time, final TextView tv){
        final String[] timeStamp = {getTime5(time)};
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                timeStamp[0] =""+(Integer.valueOf(timeStamp[0])-1000);
                tv.setText("" + getStr2HourTimes3(timeStamp[0]));
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    public static void getReturnTime4(String time, final TextView tv, final animlistener listener){
//        final String[] timeStamp = {getTime6(time)};
        final int[] second=new int[2];
        second[0]=formatTurnSecond(time);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                second[0] =second[0]-1;
                tv.setText(change(second[0]));
                listener.dolistener();
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }
    public interface animlistener{
        public void dolistener();
    }

    public static void getClose(){
        if(handler!=null&&runnable!=null){
            handler.removeCallbacks(runnable);
        }
    }

    /*
   * 将时分秒转为秒数
   * */
    public static int formatTurnSecond(String time) {
        String s = time;
        int index1 = s.indexOf(":");
        int index2 = s.indexOf(":", index1 + 1);
        int mm = Integer.parseInt(s.substring(0, index1));
        int ss = Integer.parseInt(s.substring(index1 + 1, index2));
//        int ss = Integer.parseInt(s.substring(index2 + 1));

        return mm * 60 + ss;
    }

    /*
        * 将秒数转为时分秒
        * */
    public static String change(int second) {
        int day=0;
        int h=0;
        int m = 0;
        int s = 0;

        int temp = second % 60;

        day=second/(60*60*24);
        h=second / (60*60);
        m=second / 60;
        s=temp;


       return day+"天"+h+"小时"+m+"分"+s+"秒";

    }
}