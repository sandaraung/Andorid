package info.androidhive.materialdesign.TarYarMinWai;

import info.androidhive.materialdesign.MInkhiteSoeSan.MInkhitDetail;

/**
 * Created by HP on 4/7/2016.
 */
public class TaryarModel {

    String title;
    String poemdetail;
    String name;

    public TaryarModel(String title,String poemdetail){

        this.title = title;
        this.poemdetail = poemdetail;


    }

    public TaryarModel(MInkhitDetail mInkhitDetail) {

    }


    public String getTitle(){

        return title;
    }

    public void setTitle(String title){

        this.title = title;
    }

    public String getPoemdetail(){
        return poemdetail;
    }

    public void setPoemdetail(String poemdetail){

        this.poemdetail = poemdetail;

    }

}
