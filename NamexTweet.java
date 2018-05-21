/**
 * @(#)NamexTweet.java
 *
 *
 * @author 
 * @version 1.00 2018/5/14
 */


import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "FP9GS9CA06v6MYzBvxWL4up9x";
    private final static String CONSUMER_KEY_SECRET = "ym9xI6bfyy44hKkZykbF3BwUAahSmBiOVlnoNW5f8tiOLLECU4";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("silahkan kunjungi : http://www.kumpulanmateribaru.ml/");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "qTafeugIIi4H9mkm4jDSBvxJlEDcMsf5CdYfmlgXlbCvf";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1597972568-5dz2iJVpueaKRIUDyGEO1e0D7wuTKutw30GkoBL";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}