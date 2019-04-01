
package com.example.lenovo.ex3;



import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;



/**

 * Created by 13922 on 2018/6/17.

 */



public class ItemData {

    private static String[] mDataList = new String[] {

            "   Lion","   Tiger","   Monkey","   Dog","   Cat","   Elephant"

    };
    private static int[] iDataList = new int[] {

            R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant

    };

    private static String[] mUrlList = new String [] {};

    private static List<Map<String,Object>>datalist;

    public static String[] getmDataList() {

        return mDataList;

    }
    public static int[] getiDataList() {

        return iDataList;

    }

    public static List<Map<String,Object>> getDataLIst(String...from) {

        datalist = new ArrayList<Map<String,Object>>();

        for(int i=0;i<mDataList.length;i++) {

            Map<String,Object>map = new HashMap<String,Object>();

            map.put(from[0],mDataList[i]);
            map.put(from[1],iDataList[i]);



            datalist.add(map);

        }

        return datalist;

    }

}
