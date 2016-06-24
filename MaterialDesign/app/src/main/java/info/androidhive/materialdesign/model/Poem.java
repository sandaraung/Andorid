package info.androidhive.materialdesign.model;

import info.androidhive.materialdesign.activity.HobbyDetail;

/**
 * Created by HP on 4/4/2016.
 */
public class Poem {

    String jid;
    String name;
    String title;
    String detail;




    public Poem(String title,String detail,String name){

        this.name = name;
        this.title = title;
        this.detail = detail;



    }



    public Poem(String title, String detail, String name, String jid){

        this.name = name;
        this.title = title;
        this.detail = detail;
        this.jid = jid;


    }

    public Poem(String name, String title) {

        this.name = name;
        this.title = title;
    }



    public Poem(HobbyDetail hobbyDetail) {

    }

    public Poem(){

    }


    public String getName(String string){

        return name;
    }

    public void setName(String name){

        this.name = name;
    }

    public String getTitle(String string){
        return title;
    }
    public void setTitle(String title){

        this.title = title;

    }

    public String getDetail(String string){

        return detail;
    }
    public void setDetail(String detail){
        this.detail = detail;
    }


    public String  getJid(String string){

        return jid;

    }

    public void setJid(String jid){

        this.jid = jid;
    }

//
//    public byte[] getTitle() {
//        return new byte[0];
//    }

    public byte[] getDetail() {
        return new byte[0];
    }
//
//    public byte[] getName() {
//        return new byte[0];
//
//    }

//    public byte[] getJid() {
//        return new byte[0];
//    }



    public int getName() {
        return 0;
    }
}
