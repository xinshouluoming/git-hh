package com.example.administrator.mydenglu.sq;

/**
 * Created by 第三机房 on 2016/8/18.
 */
public class denglu_sq {
    String zhanghao,mima;
    int sp;

    public denglu_sq(String zhanghao, String mima, int sp) {
        this.zhanghao = zhanghao;
        this.mima = mima;
        this.sp = sp;
    }

    public String getZhanghao() {
        return zhanghao;
    }

    public void setZhanghao(String zhanghao) {
        this.zhanghao = zhanghao;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }
}
