package com.example.administrator.mydenglu.sq;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.mydenglu.R;
import com.example.administrator.mydenglu.activity.JieMian_Activirty;
import com.example.administrator.mydenglu.data.ShuJu;
import com.example.administrator.mydenglu.data.xuesheng;

import java.util.ArrayList;

/**
 * Created by 第三机房 on 2016/8/17.
 */
public class TianXue extends AppCompatActivity {
    CheckBox nan,nvs;
    String zhanghan;
    String mima;
    String mizi;
    String xingbie="男";
    String nianlin;
    String quangxian;
    EditText mingzi,nianl;
    ShuJu shuju;
    TextView textview_tianxue;
    ArrayList<xuesheng> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tianxie);
        nan= (CheckBox) findViewById(R.id.nan);
        nvs = (CheckBox) findViewById(R.id.nvs);

        mingzi = (EditText) findViewById(R.id.mingzi);
        nianl = (EditText) findViewById(R.id.nianl);

        textview_tianxue = (TextView) findViewById(R.id.textview_tianxue);

        zhanghan= getIntent().getStringExtra("zhanghao");
        mima=getIntent().getStringExtra("mima");
        quangxian = getIntent().getStringExtra("quangxian");

        mingz mz=new mingz();
        mingzi.addTextChangedListener(mz);
        nianl.addTextChangedListener(mz);

        shuju = ShuJu.getDf(TianXue.this);

        nan.setChecked(true);
        nvs.setChecked(false);

         checkbok mcheckbok=new checkbok();
         nan.setOnClickListener(mcheckbok);
         nvs.setOnClickListener(mcheckbok);


        textview_tianxue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((xingbie!=null)&&(mizi!=null)&&(nianlin!=null)){
                    //数据库的存储
                    shuju.setserve_two(new xuesheng(zhanghan,mima,mizi,xingbie,nianlin,quangxian));

                    list=shuju.getxuesheng();

                    Toast.makeText(TianXue.this,list.toString(), Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(TianXue.this,JieMian_Activirty.class);
                    startActivity(intent);
                    finish();

                }
                else {
                    Toast.makeText(TianXue.this,"你的输入不正确",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



    public class checkbok implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.nan:
                    nan.setChecked(true);
                    nvs.setChecked(false);
                    xingbie="男";
                    break;
                case R.id.nvs:
                    nan.setChecked(false);
                    nvs.setChecked(true);
                    xingbie="女";
                    break;

            }
        }
    }
    public class mingz implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            mizi=mingzi.getText().toString();
            nianlin=nianl.getText().toString();

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
