package com.example.administrator.mydenglu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydenglu.GongJu.Paixue;
import com.example.administrator.mydenglu.R;
import com.example.administrator.mydenglu.ShiPing_Data.datas;
import com.example.administrator.mydenglu.ShiPing_Data.zhao;
import com.example.administrator.mydenglu.data.ShuJu;
import com.example.administrator.mydenglu.data.xuesheng;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 第三机房 on 2016/8/17.
 */
public class JieMian_Activirty extends AppCompatActivity {
    NavigationView navigation;
    RecyclerView recyclerview_jiemian,
                 recyclerview_activit;
    private ArrayList<xuesheng> list, mlist;
    private ArrayList<xuesheng> xuelist,laoslist;
    private  ArrayList<String>stlist,xstlist;
    private  ArrayList<datas>  dataslist;
    private ShuJu shuju;
    private String zhanghao,mima,quangxia;

    public JieMian_Activirty() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.avtivity_jiemian);

        navigation= (NavigationView) findViewById(R.id.navigation);

        recyclerview_jiemian= (RecyclerView) findViewById(R.id.recyclerview_jiemian);
        recyclerview_activit= (RecyclerView) findViewById(R.id.recyclerview_activit);

        shuju=ShuJu.getDf(this);
        xuelist=new ArrayList<>();
        mlist=new ArrayList<>();
        laoslist=new ArrayList<>();
        stlist =new ArrayList<>();
        xstlist=new ArrayList<>();





        stlist.add("增加");stlist.add("删除");stlist.add("查看");stlist.add("修改");
        xstlist.add("查看");xstlist.add("修改");
    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerview_jiemian.setLayoutManager(
                new GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false)
        );
        recyclerview_activit.setLayoutManager(new GridLayoutManager
                (this,1,GridLayoutManager.VERTICAL,false));


        zhao mzhao = new zhao();
        dataslist = mzhao.getlist(JieMian_Activirty.this);
        recyclerview_jiemian.setAdapter(new fillrclist(dataslist));


        zhanghao = getIntent().getStringExtra("zhanghao");
        mima  = getIntent().getStringExtra("mima");

        list = shuju.getxuesheng();
//对list的排序
        Collections.sort(list,new Paixue());

        for(int i=0;i<list.size();i++){
            if (list.get(i).getZhanghan().equals(zhanghao)){
                quangxia = list.get(i).getQuangxian();
            }
            if(list.get(i).getQuangxian().equals("学生")){
                xuelist.add(list.get(i));
            }
            else {
                laoslist.add(list.get(i));
            }
        }
        if (laoslist!=null){
            mlist.addAll(laoslist);}
        if (laoslist!=null){
            mlist.addAll(xuelist);
        }



if(quangxia!=null) {
    if (quangxia.equals("学生")) {
        if (xuelist.size() > 0) {
            Toast.makeText(JieMian_Activirty.this, "学生", Toast.LENGTH_SHORT).show();
//                recyclerview_jiemian.setAdapter(new fillrclist(xuelist));

            recyclerview_activit.setAdapter(new fill(stlist));
        }
    }
    if (quangxia.equals("老师")) {
        if (mlist.size() > 0) {
            Toast.makeText(JieMian_Activirty.this, "老师", Toast.LENGTH_SHORT).show();
//                recyclerview_jiemian.setAdapter(new fillrclist(mlist));

            recyclerview_activit.setAdapter(new fill(stlist));

        }
    }
}

        getsfms(new sfms() {
            @Override
            public void fm(int id) {
                Intent intent=new Intent(JieMian_Activirty.this,BoFang_Activity.class);
                intent.putExtra("path",dataslist.get(id).getData());
                startActivity(intent);


            }

            @Override
            public void sfm(int id) {
                if(quangxia.equals("老师")){
               switch (id){
                   case 0:
                       break;
                   case 1:
                       break;
                   case 2:
                       break;
                   case 3:
                       break;
               }
                }
                if(quangxia.equals("学生")){
                          switch (id){
                              case 0:
                                  break;
                              case 1:
                                  break;
                          }
                }

            }
        });

    }
    //回调接口
    interface  sfms{
        void fm(int id);
        void sfm(int id);
    }
    private  sfms mfms;
    public void getsfms(sfms mfms){
        this.mfms=mfms;
    }

    //recyclerview_activity的填充器
    class  fillrclist extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//        ArrayList<xuesheng> slist;
        ArrayList<datas> slist;
        public fillrclist( ArrayList<datas> list){
            this.slist=list;
        }
        class vholder extends RecyclerView.ViewHolder{
            LinearLayout ll_shiping;
            TextView  textView_fill;


            public vholder(View itemView) {
                super(itemView);
                ll_shiping = (LinearLayout) itemView.findViewById(R.id.ll_shiping);
                textView_fill = (TextView) itemView.findViewById(R.id.textview_fill);



            }

        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(JieMian_Activirty.this).inflate(
                    R.layout.fill_recyclerview_jiemian,null);
            return new vholder(v);
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ((vholder) holder).textView_fill.setText(slist.get(position).getDisplay_name());
            ((vholder) holder).ll_shiping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mfms!=null){
                        mfms.fm(position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {

            return list.size();
        }
    }
    //
    class  fill extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        ArrayList<String> slist;
        public fill( ArrayList<String> list){
            this.slist=list;
        }
        class vholder extends RecyclerView.ViewHolder{

            TextView  textview_r;


            public vholder(View itemView) {
                super(itemView);
                textview_r = (TextView) itemView.findViewById(R.id.textview_r);

            }

        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(JieMian_Activirty.this).inflate(
                    R.layout.texrview_recyclerview,null);
            return new vholder(v);
        }
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ((vholder) holder).textview_r.setText(slist.get(position));
            ((vholder) holder).textview_r.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mfms!=null){
                        mfms.sfm(position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {

            return list.size();
        }
    }
}

