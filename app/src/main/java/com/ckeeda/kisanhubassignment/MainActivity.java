package com.ckeeda.kisanhubassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.ckeeda.kisanhubassignment.Splash.SplashModel;
import com.ckeeda.kisanhubassignment.Splash.SplashView;

public class MainActivity extends AppCompatActivity implements SplashView {

    private ProgressBar mProgress;
    private SplashModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = (ProgressBar) findViewById(R.id.progress);
        mModel = new SplashModel(this,getApplicationContext());
        mModel.load();
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void navigateToSlideShow() {
        if(isFinishing()) return;
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
        finish();

    }
}
