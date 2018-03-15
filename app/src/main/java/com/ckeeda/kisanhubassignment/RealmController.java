package com.ckeeda.kisanhubassignment;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.ckeeda.kisanhubassignment.Model.WeatherData;

import io.realm.Realm;
import io.realm.RealmResults;


public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }


    public void clearAll() {

        realm.beginTransaction();

        realm.delete(WeatherData.class);
        realm.commitTransaction();
    }


     public boolean hasdata() {
        return realm.where(WeatherData.class).count() > 0;

          }

       public RealmResults<WeatherData> queryeddata(String region,String weather_parameter) {

        return realm.where(WeatherData.class)
                .contains("region", region)
                .and()
                .contains("Weather",weather_parameter)
                .findAll();

    }
}
