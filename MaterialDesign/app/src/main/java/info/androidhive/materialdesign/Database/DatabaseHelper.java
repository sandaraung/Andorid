package info.androidhive.materialdesign.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by HP on 4/6/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "DBSave";
    public static final String COLUMN_ID = "id";
    public static final int DATABASE_VERSION = 1;
    public static final String JSON_ID = "jid";
    public static final String TABLE_NAME = "poems";

    public static final String POEM_TITLE = "poem_title";
    public static final String POEM_DETAITL = "poem_detail";
    public static final String POEM_POTERY = "potery";

    String CREATE_CONTACTS_TABLE = " CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY_KEY  AUTO_INCREMENT , " + JSON_ID + " INT , " +  POEM_TITLE + " TEXT, " + POEM_DETAITL + " TEXT, " + POEM_POTERY + " TEXT " + " ); ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACTS_TABLE);
        Log.d("mylog", "crete table :" + CREATE_CONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists poem");
        onCreate(db);
    }


}
