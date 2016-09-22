package com.example.administrator.mydenglu.GongJu;



import com.example.administrator.mydenglu.data.xuesheng;

import java.util.Comparator;

/**
 * Created by 第三机房 on 2016/8/19.
 */
public class Paixue implements Comparator {

    public int compare(Object arg0, Object arg1) {
        xuesheng user0=(xuesheng) arg0;
        xuesheng user1=(xuesheng) arg1;
        //首先比较年龄，如果年龄相同，则比较名字
        int flag=user0.getNianlin().compareTo(user1.getNianlin());
        if(flag==0){
            return user0.getMizi().compareTo(user1.getMima());
//            if (flag==0){
//             如果还相同就比较别的
//                return user0.get
//            }
        }else{
            return flag;
        }
    }
}
