package com.example.administrator.mydenglu.sq;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 第三机房 on 2016/8/2.
 */
public class SPrefrence {
    private Context context;
    private SharedPreferences sp;
    private static SPrefrence msp;
    //SPrefrence的名字
    private String  SP_NAME="sp_name";
    private SPrefrence(Context context){
        this.context=context;
        sp=context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);

    }
    public static SPrefrence getInfo(Context context){
        if(msp==null){
            msp=new SPrefrence(context);
        }
        return  msp;
    }


    //取的方法集合
    public ArrayList<String> get_list() {

        ArrayList<String> list=new ArrayList<>();

        if (sp.getStringSet("list",null)!=null) {
            list.addAll(sp.getStringSet("list", null));
            return list;
        }
        return null;
    }
    //存的方法集合
    public void setSP_NAME(ArrayList<String> list){

        Set<String> set = new HashSet<>();
        set.addAll(list);
        sp.edit().putStringSet("list",set).commit();
    }

}