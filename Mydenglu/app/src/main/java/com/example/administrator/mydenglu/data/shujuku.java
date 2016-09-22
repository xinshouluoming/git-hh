package com.example.administrator.mydenglu.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 第三机房 on 2016/8/17.
 */
public class shujuku extends SQLiteOpenHelper{
        private static final String DATA_FORM="data_form_one";//版本
        private Context context;
        public static final String NAME_DATA ="name_data_one";//名字


        //绑定版本
        public shujuku(Context context){
            super(context, DATA_FORM , null, 1);
        }
//    String zhanghan;
//    String mima;
//    String mizi;
//    String xingbie;
//    String nianlin;
        //第一次掉用
        @Override
        public void onCreate(SQLiteDatabase db) {
// zhanghan,mima,mizi,xingbie,nianlin,quangxian
            db.execSQL("create table if not exists "+ NAME_DATA +
                    " ( zhanghan varchar(255) , " +
                     " mima varchar(255) ," +
                     " mizi varchar(255) ," +
                     " xingbie varchar(255) ," +
                     " nianlin varchar(255) ," +
                     " quangxian varchr(255) )"
                   );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

    }
