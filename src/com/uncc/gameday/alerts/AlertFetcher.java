package com.uncc.gameday.alerts;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.uncc.gameday.R;

// TODO: Auto-generated Javadoc
/**
 * The Class AlertFetcher.
 */


public class AlertFetcher {
        // Class responsible for fetching all alerts as necessary.
        
        /** The max tweets. */
        private int maxTweets = 5;
        
        /**
         * Fetch alerts.
         *
         * @param ctx the ctx
         */
        public void fetchAlerts(Context ctx) {
                // Fetch all alerts. Responsible for discovering what sources need to be fetched.          
                try {
                        // Note we have to use the SharedPreferences so that we have preferences no matter what activity
                        // sent us this context
                        SharedPreferences settings = ctx.getSharedPreferences(ctx.getString(R.string.preferences_file), 0); // MODE_PRIVATE
                        
                        if (settings.getBoolean("ALERT_ORGANIZATION", false))
                                // Fetch organization alerts
                                this.fetchOrganizationAlerts(ctx);
                        if (settings.getBoolean("ALERT_UNIVERSITY", false))
                                // Fetch university alerts
                                this.fetchUniversityAlerts(ctx);
                        
                        // And always fetch alerts made by us. Period.
                        this.fetchGamedayAlerts(ctx);
                } catch (TwitterException e) {
                        Log.w("AlertFetcher", "Unable to fetch alerts from Twitter...", e);
                }
        }
    
        /**
         * Fetch organization alerts.
         * 
         * @param ctx the ctx
         * @throws TwitterException the twitter exception
         */
        private void fetchOrganizationAlerts(Context ctx) throws TwitterException {
        	
    	    //creates configuration for twitter access
    	    ConfigurationBuilder cb = new ConfigurationBuilder();
    	    
            cb.setDebugEnabled(true)
            	.setOAuthConsumerKey("vfRa3Tr5QYaU8Jr2pKHtiA")
            	.setOAuthConsumerSecret("gGRdIrhPdX2Vrg296xOvTqE4sgOISMphRmPdrGirbU")
            	.setOAuthAccessToken("1912299896-uqrhDiif3oX9Ybkf8rM5pQDWN6mW4Y7vRLK47C7")
            	.setOAuthAccessTokenSecret("kZ11I74dcA00pWgQDZelFQz1ADJJMK0ejr6snnU34jUVT");
            
            TwitterFactory tf = new TwitterFactory(cb.build());
            
                // Process fetching organization alerts (alerts retweeted by us)
                // Will not necessarily fetch `maxTweets` tweets.
                String handle = ctx.getString(R.string.gameday_handle);
                Twitter twitter = tf.getInstance();
                List<Status> statuses = twitter.getUserTimeline(handle, new Paging(1, maxTweets));
                
                // Filter for anything created by us (retweet)
                for (Iterator<Status> it = statuses.iterator(); it.hasNext();){
                        // May need to switch to isRetweetByMe (documentation is awful)
                        if (!it.next().isRetweet())
                                it.remove();
                }
                
                String type = AlertType.getValue(AlertType.ORGANIZATION);
                pushToDatabase(statuses, type, ctx);
                
                
                // List contains all valid alerts now
        }
        
        /**
         * Fetch university alerts.
         *
         * @param ctx the ctx
         * @throws TwitterException the twitter exception
         */
        private void fetchUniversityAlerts(Context ctx) throws TwitterException {
                // Process fetching university alerts
                // Guaranteed to get `maxTweets` tweets
        	
    	    //creates configuration for twitter access
    	    ConfigurationBuilder cb = new ConfigurationBuilder();
    	    
            cb.setDebugEnabled(true)
            	.setOAuthConsumerKey("vfRa3Tr5QYaU8Jr2pKHtiA")
            	.setOAuthConsumerSecret("gGRdIrhPdX2Vrg296xOvTqE4sgOISMphRmPdrGirbU")
            	.setOAuthAccessToken("1912299896-uqrhDiif3oX9Ybkf8rM5pQDWN6mW4Y7vRLK47C7")
            	.setOAuthAccessTokenSecret("kZ11I74dcA00pWgQDZelFQz1ADJJMK0ejr6snnU34jUVT");
            
            TwitterFactory tf = new TwitterFactory(cb.build());
            
                String handle = ctx.getString(R.string.university_handle);
                Twitter twitter = tf.getInstance();
                List<Status> statuses = twitter.getUserTimeline(handle, new Paging(1, maxTweets));
                
                String type = AlertType.getValue(AlertType.UNIVERSITY);
                pushToDatabase(statuses, type, ctx);
                
                System.out.println(statuses.get(0).getText());
                // List contains all valid alerts now
        }
        
        /**
         * Fetch gameday alerts.
         *
         * @param ctx the ctx
         * @throws TwitterException the twitter exception
         */
        private void fetchGamedayAlerts(Context ctx) throws TwitterException {
                // Process fetching alerts generated by staff of UNCCGameDay
                // Not guaranteed to get `maxTweets` tweets
        	
        	    //creates configuration for twitter access
        	    ConfigurationBuilder cb = new ConfigurationBuilder();
        	    
                cb.setDebugEnabled(true)
                	.setOAuthConsumerKey("vfRa3Tr5QYaU8Jr2pKHtiA")
                	.setOAuthConsumerSecret("gGRdIrhPdX2Vrg296xOvTqE4sgOISMphRmPdrGirbU")
                	.setOAuthAccessToken("1912299896-uqrhDiif3oX9Ybkf8rM5pQDWN6mW4Y7vRLK47C7")
                	.setOAuthAccessTokenSecret("kZ11I74dcA00pWgQDZelFQz1ADJJMK0ejr6snnU34jUVT");
                
                TwitterFactory tf = new TwitterFactory(cb.build());
            
                String handle = ctx.getString(R.string.gameday_handle);
                Twitter twitter = tf.getInstance();
                List<Status> statuses = twitter.getUserTimeline(handle, new Paging(1, maxTweets));
                
                // Filter out anything not from us
                for (Iterator<Status> it = statuses.iterator(); it.hasNext();){
                        // May need to switch to isRetweetByMe (documentation is awful)
                        if (it.next().isRetweet())
                                it.remove();
                }
                
                String type = AlertType.getValue(AlertType.GAMEDAY);
                pushToDatabase(statuses, type, ctx);

                // List contains all valid alerts now.

        }
        
        //takes list of statuses
        //converts it to Alert object type
        //and persists to database
        public void pushToDatabase(List<Status> statuses, String type, Context ctx)
        {
    		AlertDB db = new AlertDB(ctx);
        	Date todayDate = new Date();
        	todayDate.getTime();
        	for(int i = 0; i < statuses.size(); i++)
        	{
        		Alert temp = new Alert(todayDate, statuses.get(i).getText(), 0, type);
        		db.persist(temp);
        	}
        }
}