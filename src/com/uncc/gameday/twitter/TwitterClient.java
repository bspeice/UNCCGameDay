package com.uncc.gameday.twitter;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * The Class TwitterClient.
 * Client used to interface with the Twitter API.
 * Note that while it should be secure to store a Consumer Secret in this
 * class, there is likely a better solution.
 */
public class TwitterClient {
	
	/** The Constant CONSUMER_KEY. */
	static final String CONSUMER_KEY = "vfRa3Tr5QYaU8Jr2pKHtiA";
	
	/** The Constant CONSUMER_SECRET. */
	static final String CONSUMER_SECRET = "gGRdIrhPdX2Vrg296xOvTqE4sgOISMphRmPdrGirbU";
	
	/** The c. */
	Configuration c;
	
	/** The t. */
	Twitter t;
	
	/**
	 * Instantiates a new twitter client.
	 *
	 * @throws TwitterException the twitter exception
	 */
	public TwitterClient() throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setApplicationOnlyAuthEnabled(true).setUseSSL(true);
		
		t = new TwitterFactory(cb.build()).getInstance();
		t.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		t.getOAuth2Token();
	}
	
	/**
	 * Fetch tweets.
	 *
	 * @param handle the handle
	 * @return the list
	 */
	public List<Status> fetchTweets(String handle) {
		try {
			return t.getUserTimeline(handle);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Status>();
		}
	}
	
	/**
	 * Fetch tweets.
	 *
	 * @param handle the handle
	 * @param count The maximum number of tweets to fetch
	 * @return the list
	 */
	public List<Status> fetchTweets(String handle, int count) {
		try {
			return t.getUserTimeline(handle, new Paging(1, count));
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Status>();
		}
	}

}
