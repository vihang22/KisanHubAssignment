package com.ckeeda.kisanhubassignment.Splash;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

import com.ckeeda.kisanhubassignment.RealmController;
import com.ckeeda.kisanhubassignment.io.SyncHelper;


public class SplashModel {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    private Context mContext;
    private SplashView mView;

    public SplashModel(SplashView splashView, Context applicationContext) {
        mView = splashView;
        mContext = applicationContext;
    }

    public void load() {

        if( new RealmController((Application) mContext).hasdata())
           splashDelay();
        else
           dataSync();
    }

    private void splashDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.navigateToSlideShow();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void dataSync() {
        new AsyncTask<Void, Boolean, Boolean>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mView.showProgress();
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                return SyncHelper.sync(mContext);

            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                mView.hideProgress();
                if (aBoolean == Boolean.TRUE) {
                    mView.navigateToSlideShow();
                }
            }
        }.execute();
    }
}
