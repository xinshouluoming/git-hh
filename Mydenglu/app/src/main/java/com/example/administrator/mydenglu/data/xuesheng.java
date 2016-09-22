package com.example.administrator.mydenglu.data;

/**
 * Created by 第三机房 on 2016/8/17.
 */
public class xuesheng {
//    zhanghan,mima,mizi,xingbie,nianlin,quangxian
    String zhanghan;
    String mima;
    String mizi;
    String xingbie;
    String nianlin;
    String quangxian;

    public xuesheng(String zhanghan, String mima, String mizi,
                    String xingbie, String nianlin,String quangxian) {
        this.zhanghan = zhanghan;
        this.mima = mima;
        this.mizi = mizi;
        this.xingbie = xingbie;
        this.nianlin = nianlin;
        this.quangxian=quangxian;
    }

    public String getZhanghan() {
        return zhanghan;
    }

    public void setZhanghan(String zhanghan) {
        this.zhanghan = zhanghan;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public String getMizi() {
        return mizi;
    }

    public void setMizi(String mizi) {
        this.mizi = mizi;
    }

    public String getXingbie() {
        return xingbie;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie;
    }

    public String getNianlin() {
        return nianlin;
    }

    public void setNianlin(String nianlin) {
        this.nianlin = nianlin;
    }

    public String getQuangxian() {
        return quangxian;
    }

    public void setQuangxian(String quangxian) {
        this.quangxian = quangxian;
    }
}
