package com.example.administrator.mydenglu.data;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 第三机房 on 2016/8/17.
 */
public class ShuJu {
    private static Context context;
    public  static shujuku df;
    private static ShuJu dfw;
    private static SQLiteDatabase db;
    ArrayList<xuesheng> list;
    Cursor cursor;
    ContentValues values;
    private ShuJu(Context context){
        df = new shujuku(context);
    }
    public static ShuJu getDf(Context context){
        if(dfw==null){
            dfw = new ShuJu(context);
        }
        return dfw;
    }


    //添加进数据库 （一条一条的）
    public void setserve_two(xuesheng dn){
//        zhanghan,mima,mizi,xingbie,nianlin,quangxian
        db = df.getWritableDatabase();
        values =new ContentValues();
        values.put("zhanghan", dn.getZhanghan());
        values.put("mima", dn.getMima());
        values.put("mizi", dn.getMizi());
        values.put("xingbie", dn.getXingbie());
        values.put("nianlin", dn.getNianlin());
        values.put("quangxian",dn.getQuangxian());
        Log.i("dn", dn.getZhanghan()+dn.getMima()+dn.getMizi()+dn.getXingbie()+dn.getNianlin()+dn.getQuangxian());
        Log.i("gg",values.toString());
        db.insert(shujuku.NAME_DATA,null,values);

        db.close();
    }
    //从数据库中取出来（全部）
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public ArrayList<xuesheng> getxuesheng(){
        db=df.getWritableDatabase();
        list  = new ArrayList<>();
        cursor=db.query(true,shujuku.NAME_DATA,
                null,null, null, null, null, null, null,null);

        int a=0;
        while(cursor.moveToNext()){

            a++;
            String zhanghan=cursor.getString(cursor.getColumnIndex("zhanghan"));
            String mima=cursor.getString(cursor.getColumnIndex("mima"));
            String mizi=cursor.getString(cursor.getColumnIndex("mizi"));
            String xingbie=cursor.getString(cursor.getColumnIndex("xingbie"));
            String nianlin=cursor.getString(cursor.getColumnIndex("nianlin"));
            String quangxian =cursor.getString(cursor.getColumnIndex("quangxian"));
            list.add(new xuesheng(zhanghan, mima, mizi, xingbie,  nianlin,quangxian));
        }
        cursor.close();
        db.close();
        Log.i("gg","&&&&&&&&&&&&&&&&&&&"+a);
        return list;
    }
    //删除一条数据或几条数据,条数有string[]来控制
    public void removeserve_two(String string,  String[] ss){
        db = df.getWritableDatabase();
        db.delete(shujuku.NAME_DATA,string +"=?",ss);
        db.close();
    }
}
