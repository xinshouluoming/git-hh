package com.example.administrator.mydenglu.ShiPing_Data;

/**
 * Created by Administrator on 2016/8/21.
 */
public class datas {
    String title,data,display_name;

    public datas(String title, String data, String display_name) {
        this.title = title;
        this.data = data;
        this.display_name = display_name;
    }

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }

    public String getDisplay_name() {
        return display_name;
    }
}
