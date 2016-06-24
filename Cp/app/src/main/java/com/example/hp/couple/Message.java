package com.example.hp.couple;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by HP on 1/13/2016.
 */
@ParseClassName("Message")
public class Message extends ParseObject {

public String getUserId(){
    return getString("userId");
}
    public String getBody(){
        return getString("body");
    }
    public void setUserId (String userId){
        put("userId", userId);
    }
    public void setBody(String body) {
        put("body", body);

    }
}
