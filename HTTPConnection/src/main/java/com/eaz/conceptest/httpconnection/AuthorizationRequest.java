package com.eaz.conceptest.httpconnection;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author JIVL
 */
public class AuthorizationRequest {

    public static void main (String args[]) throws Exception
    {

        //URL url = new URL("https://secure.echosign.com/public/oauth?redirect_uri=https://example.com/oauthDemo&response_type=code&client_id=FXMCMM596L7G5W&scope=agreement_read:group+agreement_write:group+agreement_send:group+library_read:group+library_write:group+user_login:group+user_read:group+user_write:group+widget_read:group+widget_write:group+workflow_read:group+workflow_write:group");
        URL url = new URL("https://secure.na1.echosign.com/public/oauth?redirect_uri=https://example.com/oauthDemo&response_type=code&client_id=FXMCMM596L7G5W&scope=agreement_read:group+agreement_write:group+agreement_send:group+library_read:group+library_write:group+user_login:group+user_read:group+user_write:group+widget_read:group+widget_write:group+workflow_read:group+workflow_write:group");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setInstanceFollowRedirects(Boolean.FALSE);
        connection.connect();

        int code = connection.getResponseCode();
        System.out.println("Response code of the object is "+code);
        if (code==200) {
            System.out.println("OK");
        }
    }
    
}
