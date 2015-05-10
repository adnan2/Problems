package com.mycompany.twitterclientproj;

import static com.mycompany.twitterclientproj.MyTwitterClient.ConsumerKey;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author araza
 */
public class TwitterOperation {

    public TwitterOperation() {
    }

    public TwitterOperation(String accessToken, String accessSecret, String consumerKey, String consumerSecret) {
        this.accessToken = accessToken;
        this.accessSecret = accessSecret;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }

    private String accessToken = null;
    private String accessSecret = null;
    private String consumerKey = null;
    private String consumerSecret = null;
    private OAuthConsumer consumer = null;

    public void initialise() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
        consumer = new CommonsHttpOAuthConsumer(
                consumerKey,
                consumerSecret);

        consumer.setTokenWithSecret(accessToken, accessSecret);
    }

    public JSONObject executeQuery(String url) throws OAuthCommunicationException, OAuthMessageSignerException, OAuthExpectationFailedException, IOException, ParseException {
        if (consumer == null) {
            throw new IllegalStateException("Please initialise TwitterOperation before using it.");
        }
        HttpGet request = new HttpGet(url);
        consumer.sign(request);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new IOException("Can't connect with twitter server, please check your access tokens");
        }
        System.out.println(statusCode + ":" + response.getStatusLine().getReasonPhrase());

        JSONParser jSONParser = new JSONParser();
        Object parsed = jSONParser.parse(new InputStreamReader(response.getEntity().getContent()));
        JSONObject jsonObject = (JSONObject) parsed;
        return jsonObject;
    }
//amirkingkhan

    public List<String> getLastStatuses(String userName, int count) {
        List<String> list = new ArrayList<>();
        try {
            String url = "https://api.twitter.com/1.1/search/tweets.json?q=%40" + userName + "&count=" + count + "&result_type=recent&exclude_replies=true&include_rts=false&include_entities=false";
            JSONObject jsonObject = executeQuery(url);
            JSONArray statuses = (JSONArray) jsonObject.get("statuses");
            ListIterator listIterator = statuses.listIterator();
            for (; listIterator.hasNext();) {
                JSONObject status = (JSONObject) listIterator.next();
                final Object text = status.get("text");
                if (text != null) {
                    list.add(text.toString());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TwitterOperation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

}
