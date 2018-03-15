package com.ckeeda.kisanhubassignment.io;

import android.app.Application;
import android.content.Context;

import com.ckeeda.kisanhubassignment.RealmController;

public class SyncHelper {
    public static Boolean sync(Context applicationContext) {

        Reader urlReader=new Reader();
        urlReader.read(applicationContext);

        if (new RealmController((Application) applicationContext).hasdata())
          return true;
        else
            return false;
    }
}
