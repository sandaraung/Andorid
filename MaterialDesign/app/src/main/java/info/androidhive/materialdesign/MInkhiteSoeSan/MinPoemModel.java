package info.androidhive.materialdesign.MInkhiteSoeSan;

/**
 * Created by HP on 4/6/2016.
 */
public class MinPoemModel {

    String title;
    String poemdetail;
    String name;

    public MinPoemModel(String title,String poemdetail){

        this.title = title;
        this.poemdetail = poemdetail;


    }

    public MinPoemModel(MInkhitDetail mInkhitDetail) {

    }



    public MinPoemModel() {

    }

    public String getName(){

        return name;

    }
    public void setName(){

        this.name = name;

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
