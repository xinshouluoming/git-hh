package com.example.administrator.mydenglu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.mydenglu.R;
import com.example.administrator.mydenglu.activity.JieMian_Activirty;
import com.example.administrator.mydenglu.data.ShuJu;
import com.example.administrator.mydenglu.data.xuesheng;
import com.example.administrator.mydenglu.sq.SPrefrence;

import java.util.ArrayList;

/**
 * Created by 第三机房 on 2016/8/17.
 */
public class DengLu extends Fragment {
    EditText zhanghao,minngm,minngm2;
    CheckBox checkbox;
    TextView textview;
    String Zhanghao,Mima,Zhanghao1,Mima1;
    ArrayList<xuesheng> list;
    ShuJu mshuju;
    mzhanghao mz;

    //sm为记录是否登录正确（0为不正确，1为正确）
    //sp为记录是否记录密码
   static int sm,sp;

    //账号密码监听的类
//    mzhanghao mz;
     SPrefrence msprefrence;
//
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.denglu_fragment,null);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        zhanghao= (EditText) view.findViewById(R.id.zhanghao);
        minngm= (EditText) view.findViewById(R.id.minngm);
        minngm2= (EditText) view.findViewById(R.id.minngm2);
        checkbox= (CheckBox) view.findViewById(R.id.checkbox);
        minngm2.setVisibility(View.GONE);
        textview= (TextView) view.findViewById(R.id.textview);
        textview.setText("登录");

         mz = new mzhanghao();
        msprefrence=SPrefrence.getInfo(getActivity());




        mshuju=ShuJu.getDf(getActivity());




    }

    @Override
    public void onStart() {
        ArrayList<String> smlist = msprefrence.get_list();
        if(smlist!=null) {
            if(smlist.size()==1){
                minngm.setText(smlist.get(0));
                Mima1=smlist.get(0);
            }
            else {
                minngm.setText(smlist.get(1));
                Mima1=smlist.get(1);
            }
            zhanghao.setText(smlist.get(0));
            Zhanghao1=smlist.get(0);
        }


    zhanghao.addTextChangedListener(mz);
    minngm.addTextChangedListener(mz);

        super.onStart();
        list=mshuju.getxuesheng();
        if(list!=null){

        }

        textview.setOnClickListener(new dianji());

    }

    public class dianji implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(Zhanghao==null){
                Zhanghao=Zhanghao1;
            }
            if(Mima==null){
                Mima=Mima1;
            }
            sm=0;
            //判断是否输入正确
            for (int i=0;i<list.size();i++){

                if (list.get(i).getZhanghan().equals(Zhanghao)

                        &&list.get(i).getMima().equals(Mima)){
                    sm=1;
                    break;
                }
            }

            if(sm==1){
//                    SPrefrence的收藏
                ArrayList<String> mlist=new ArrayList<String>();
                mlist.add(Zhanghao);mlist.add(Mima);
                msprefrence.setSP_NAME(mlist);

//                    跳转
                Intent intent = new Intent(getActivity(),JieMian_Activirty.class);
                intent.putExtra("zhanghao", Zhanghao);
                intent.putExtra("mima", Mima);
                getActivity().startActivity(intent);
            }
            else {
//                    Toast.makeText(getActivity(),list.get(0).toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(),"账号密码错误",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public class mzhanghao implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Zhanghao=zhanghao.getText().toString();
            Mima =minngm.getText().toString();

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

}
