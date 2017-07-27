package com.blanink.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public class StringToListUtils {

    public static List<String> stringToList(String str,String sign){
        Log.e("@@@@",str.toString());

        List<String> strList=new ArrayList<>();
        if(str!=null){
            String [] st=str.split(sign);
            Log.e("@@@@",st.length+"");
            for (String s:
                st ) {
                strList.add(s);
            }
        }
        Log.e("@@@@",strList.toString());
        return strList;
    }
}
