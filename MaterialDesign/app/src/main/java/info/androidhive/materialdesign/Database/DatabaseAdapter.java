package info.androidhive.materialdesign.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import info.androidhive.materialdesign.model.Poem;

/**
 * Created by HP on 4/6/2016.
 */
public class DatabaseAdapter {
    long id;
    DatabaseHelper dbHelper;

    public DatabaseAdapter(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public long insertPoem(Poem poem) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(dbHelper.POEM_TITLE, poem.getTitle(0));
        contentValues.put(dbHelper.POEM_DETAITL, poem.getDetail());
        contentValues.put(dbHelper.POEM_POTERY, poem.getName());
        contentValues.put(dbHelper.JSON_ID,poem.getJid());


        id = db.insert(dbHelper.TABLE_NAME, null, contentValues);
        Log.d("mylog", "ID :" + id);
        db.close();
        return id;

    }


    public ArrayList<Poem> getdata(){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Poem> poemList = new ArrayList<Poem>();

        String query = "SELECT * FROM " + dbHelper.TABLE_NAME;

        Cursor c = db.rawQuery(query,null);

        if(c.moveToFirst()){
            do{

                Poem p = new Poem();
                p.setJid(p.getJid(c.getString(0)));
                p.setTitle(p.getTitle(c.getString(1)));
                p.setDetail(p.getDetail(c.getString(2)));
                p.setName(p.getName(c.getString(3)));
                poemList.add(p);

                Log.d("mylog", "getdata : " + p.getDetail(c.getString(2)));
                Log.d("mylog", "getdata : " + p.getName(c.getString(3)));
                Log.d("mylog","getdata : "+ p.getJid(c.getString(0)));

            }while (c.moveToNext());
        }
        db.close();
        return poemList;

    }


}
