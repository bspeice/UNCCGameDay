package com.uncc.gameday;

import android.app.Application;
import android.content.Context;

public class GameDay extends Application{
	private static Context context;

    public void onCreate(){
        super.onCreate();
        GameDay.context = getApplicationContext();
    }

    public static Context getAppContext() {
    	return GameDay.context;
    }
}
