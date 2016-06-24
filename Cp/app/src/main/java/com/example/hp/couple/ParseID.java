package com.example.hp.couple;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by HP on 12/23/2015.
 */
public class ParseID extends Application {
    public static final String APPLICATION_ID = "KwMcAzQGxbd5L2UTVCEl4yqoNqxi4znRjdpCPghw";
    public static final String CLIENT_KEY = "BnAddlDsVwyWZyJTyHYOkr5UuYVs8Nb1pWmm40s3";

    @Override
    public void onCreate() {
        super.onCreate();


        Parse.enableLocalDatastore(this);
        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
        ParseObject.registerSubclass(DataObject.class);

    }
}
