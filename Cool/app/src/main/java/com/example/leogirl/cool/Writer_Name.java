package com.example.leogirl.cool;

/**
 * Created by leogirl on 5/30/16.
 */
public class Writer_Name {


    String writer_name;
    String poem;
    String poem_name;
    String title;

    public Writer_Name(String writer_name,String poem,String poem_name){

        this.writer_name = writer_name;
        this.poem = poem;
        this.poem_name = poem_name;

    }




    public String getWriter_name(){

        return writer_name;
    }

    public  void setWriter_name(String writer_name){

        this.writer_name = writer_name;
    }

    public String getPoem(){

        return poem;

    }

    public void setPoem(String poem){

        this.poem = poem;
    }

    public String getPoem_name(){

        return poem_name;
    }

    public void setPoem_name(String poem_name){

        this.poem_name = poem_name;

    }




}
