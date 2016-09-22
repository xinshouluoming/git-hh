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
import com.example.administrator.mydenglu.activity.TianXue;
import com.example.administrator.mydenglu.data.ShuJu;
import com.example.administrator.mydenglu.data.xuesheng;

import java.util.ArrayList;

/**
 * Created by 第三机房 on 2016/8/17.
 */
public class ZhuChe extends Fragment {
    EditText zhanghao,minngm,minngm2;
    CheckBox checkbox;
    TextView textview;
    ArrayList<xuesheng> list;
    ShuJu shuju;
    String Zhanghao,Mima,Mima2;
    int s;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.denglu_fragment,null);
        return v;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        zhanghao= (EditText) view.findViewById(R.id.zhanghao);
        minngm= (EditText) view.findViewById(R.id.minngm);
        minngm2= (EditText) view.findViewById(R.id.minngm2);
        checkbox= (CheckBox) view.findViewById(R.id.checkbox);
        checkbox.setVisibility(View.GONE);
        textview= (TextView) view.findViewById(R.id.textview);
        shuju = ShuJu.getDf(getActivity());


        list = shuju.getxuesheng();
        aaa maaa=new aaa();

        zhanghao.addTextChangedListener(maaa);
        minngm.addTextChangedListener(maaa);
        minngm2.addTextChangedListener(maaa);




            textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((Mima2.equals("学生") || (Mima2.equals("老师")))) {
                        if (Zhanghao == null || Mima == null) {
                            Toast.makeText(getActivity(), "账号密码输入不正确", Toast.LENGTH_SHORT).show();
                        } else {


                            Toast.makeText(getActivity(), "hhhe" + Zhanghao + Mima + Mima2, Toast.LENGTH_SHORT).show();
                            if (list.size() > 0) {
                                for (int i = 0; i < list.size(); i++) {
                                    s = 0;
                                    if (list.get(i).getZhanghan().equals(zhanghao)) {
                                        s = 1;
                                        break;
                                    }
                                }
                            }
                            if (s == 0) {
                                Intent intent = new Intent(getActivity(), TianXue.class);
                                intent.putExtra("zhanghao", Zhanghao);
                                intent.putExtra("mima", Mima);
                                intent.putExtra("quangxian", Mima2);
                                getActivity().startActivity(intent);
                            }
                            if (s == 1) {
                                Toast.makeText(getActivity(), "帐号已存在", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else {
                        Toast.makeText(getActivity(), "权限不正确", Toast.LENGTH_SHORT).show();
                    }
                }

            });


    }
    public class aaa implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Zhanghao = zhanghao.getText().toString();
            Mima     = minngm.getText().toString();
            Mima2    = minngm2.getText().toString();
//
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
