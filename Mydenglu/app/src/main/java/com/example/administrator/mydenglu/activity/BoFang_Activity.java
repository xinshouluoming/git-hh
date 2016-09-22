package com.example.administrator.mydenglu.activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;


import com.example.administrator.mydenglu.R;



/**
 * Created by Administrator on 2016/8/21.
 */
public class BoFang_Activity extends AppCompatActivity {
    private VideoView videoView;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("播放中");
        setContentView(R.layout.activity_bofang);
        videoView = (VideoView)findViewById(R.id.videoView);
        playVideo(); // alt+enten
    }

    private void playVideo() {
        // VideoView:一个android提供的,已封装了MediaPlayer + SurfaceView的视频播放控件
        path=getIntent().getStringExtra("path");
        videoView.setVideoPath(path);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
    }
}
