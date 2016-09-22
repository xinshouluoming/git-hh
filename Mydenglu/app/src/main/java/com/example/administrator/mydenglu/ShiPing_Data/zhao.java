package com.example.administrator.mydenglu.ShiPing_Data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/21.
 */
public class zhao {
    Context context;
    public static ArrayList<datas> musicList;
    public static ArrayList<datas> getlist (Context context){
        if(musicList==null){
            //定义出游标来（是每个文件都看）
            musicList = new ArrayList<datas>();
            ContentResolver resolver = context.getContentResolver();
            //Audio 换成Video
            Cursor cursor = resolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    null, null, null,null );
//             private void setVideoList() {
//            // MediaStore.Video.Thumbnails.DATA:视频缩略图的文件路径
//            String[] thumbColumns = { MediaStore.Video.Thumbnails.DATA,
//                    MediaStore.Video.Thumbnails.VIDEO_ID };
//
//            // MediaStore.Video.Media.DATA：视频文件路径；
//            // MediaStore.Video.Media.DISPLAY_NAME : 视频文件名，如 testVideo.mp4
//            // MediaStore.Video.Media.TITLE: 视频标题 : testVideo



            while (cursor.moveToNext()) {
                //用游标来找到数据 （MediaStore.Audio.Media.TITLE可以换成不同的东西来找不同的数据。比如视频等）。
                String  title  =   cursor.getString(cursor.
                        getColumnIndex(MediaStore.Video.Media.TITLE));
                String  data      =   cursor.getString(cursor.
                        getColumnIndex(MediaStore.Video.Media.DATA));
                String  display_name =  cursor.getString(cursor.
                        getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));


                musicList.add(new datas(title,data,display_name));
            }
        }

        return musicList;

    }
}
