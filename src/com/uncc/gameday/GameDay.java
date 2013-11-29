package com.uncc.gameday;

import android.app.Application;
import android.content.Context;

// TODO: Auto-generated Javadoc
/**
 * The Class GameDay.
 */
public class GameDay extends Application{
	
	/** The context. */
	private static Context context;

    /* (non-Javadoc)
     * @see android.app.Application#onCreate()
     */
    public void onCreate(){
        super.onCreate();
        GameDay.context = getApplicationContext();
    }

    /**
     * Provides a static way of getting to the Application-level context.
     * Unless you know *exactly* why you need this, you don't.
     *
     * @return the app context
     */
    public static Context getAppContext() {
    	return GameDay.context;
    }
}
