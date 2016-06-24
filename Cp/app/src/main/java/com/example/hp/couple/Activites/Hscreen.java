package com.example.hp.couple.Activites;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hp.couple.Annipage;
import com.example.hp.couple.CardViewActivity;
import com.example.hp.couple.ChatActivity;
import com.example.hp.couple.DataObject;
import com.example.hp.couple.MyRecycleViewAdapter;
import com.example.hp.couple.Notipage;
import com.example.hp.couple.R;
import com.squareup.picasso.Picasso;

/**
 * Created by HP on 1/14/2016.
 */
public class Hscreen extends Activity {
    private static int RESULT_LOAD_IMAGE = 1;
    Button loadimagebtn;
    LinearLayout linearlout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hscreen);

        Button cbb = (Button) findViewById(R.id.b2);
        cbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), January.class);
                startActivity(intent);
            }
        });
        Button mm = (Button) findViewById(R.id.a2);
        mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(intent);
            }
        });
        Button note = (Button) findViewById(R.id.b3);
        note.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Annipage.class);
                startActivity(intent);
            }
        });
        Button noti = (Button) findViewById(R.id.a3);
        noti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Notipage.class);
                startActivity(intent);
            }
        });
        Button questi = (Button) findViewById(R.id.b4);
        questi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CardViewActivity.class);
                startActivity(intent);
            }
        });
        Button menu = (Button) findViewById(R.id.a4);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent);
            }
        });
        Button album = (Button) findViewById(R.id.b1);
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryintent, RESULT_LOAD_IMAGE);
            }
        });
        Button loadimagebtn = (Button) findViewById(R.id.button1);
        loadimagebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent((Intent.ACTION_PICK), MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        linearlout = (LinearLayout) findViewById(R.id.background);

    }


//    @Override
//    public void onActivityResult(int RequestCode,int ResultCode,Intent data){
//        super.onActivityResult(RequestCode, ResultCode, data); 
//
//        if (RequestCode == RESULT_LOAD_IMAGE && ResultCode == RESULT_OK && null!= data){ 
//            Uri selectedImage = data.getData();
//            ImageView iv = (ImageView)findViewById(R.id.background); 
//
//            //Picasso.with(this).load(selectedImage).into(iv); 
//
//        }
//    }}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data){

            Uri selectedimage = data.getData();

            String[] filePathColumn = { MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedimage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            Drawable d = new BitmapDrawable(getResources(), BitmapFactory.decodeFile(picturePath));
          linearlout.setBackground(d);

        }
    }
}
