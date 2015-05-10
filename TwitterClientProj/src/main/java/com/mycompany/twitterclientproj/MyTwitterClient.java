/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterclientproj;

import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author araza
 */
public class MyTwitterClient {

    static String AccessToken = "-----------";
    static String AccessSecret = "-----------";
    static String ConsumerKey = "-----------";
    static String ConsumerSecret = "-----------";

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        TwitterOperation o = new TwitterOperation(AccessToken, AccessSecret, ConsumerKey, ConsumerSecret);
        o.initialise();
        List<String> statuses = o.getLastStatuses("amirkingkhan", 5);
        int i = 0;
        for (String s : statuses) {
            System.out.println(++i + ": " + s);
        }
    }
}
