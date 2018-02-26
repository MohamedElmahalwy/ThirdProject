package com.elmahalwy.thirdproject.Activties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.elmahalwy.thirdproject.R;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import butterknife.BindView;

public class StepsActivity extends AppCompatActivity {
    @BindView(R.id.tv_no_video)
    TextView tv_no_video;
    @BindView(R.id.tv_step_description)
    TextView tv_step_description;
    @BindView(R.id.video_steps)
    SimpleExoPlayerView video_steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        InitEventDriven();
    }

    void InitEventDriven() {
        tv_step_description.setText(getIntent().getStringExtra("description"));
        if (getIntent().getStringExtra("video_url").isEmpty()) {
            tv_no_video.setVisibility(View.VISIBLE);
            video_steps.setVisibility(View.GONE);
            tv_no_video.setText("No videos");

        } else {
            tv_no_video.setVisibility(View.GONE);

        }
    }
}
