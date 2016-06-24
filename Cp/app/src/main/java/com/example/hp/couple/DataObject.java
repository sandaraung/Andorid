package com.example.hp.couple;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by HP on 1/14/2016.
 */

@ParseClassName("DataObject")
public class DataObject extends ParseObject {



    public String getQuestion(){

        return getString("question");
    }
    public void setQqueston(String question){

        put("question",question);

    }

    public String getFemaleanswer(){

        return getString("femaleanswer");
    }
    public void setFemaleanswer(String femaleanswer){

        put("femaleanswer",femaleanswer);
    }

    public String getMaleanswer(){
        return getString("maleanswer");
    }

    public void setMaleanswer(String maleanswer){

        put("maleanswer",maleanswer);
    }

}
