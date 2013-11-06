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

public class TwitterClient {
	
	static final String CONSUMER_KEY = "vfRa3Tr5QYaU8Jr2pKHtiA";
	static final String CONSUMER_SECRET = "gGRdIrhPdX2Vrg296xOvTqE4sgOISMphRmPdrGirbU";
	
	Configuration c;
	Twitter t;
	
	public TwitterClient() throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setApplicationOnlyAuthEnabled(true).setUseSSL(true);
		
		t = new TwitterFactory(cb.build()).getInstance();
		t.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		t.getOAuth2Token();
	}
	
	public List<Status> fetchTweets(String handle) {
		try {
			return t.getUserTimeline(handle);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Status>();
		}
	}
	
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
