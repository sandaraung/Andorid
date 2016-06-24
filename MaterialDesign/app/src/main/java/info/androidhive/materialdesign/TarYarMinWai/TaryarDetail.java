package info.androidhive.materialdesign.TarYarMinWai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import info.androidhive.materialdesign.Database.DatabaseAdapter;
import info.androidhive.materialdesign.R;

/**
 * Created by HP on 4/7/2016.
 */
public class TaryarDetail extends AppCompatActivity {

    TextView txttitle;
    TextView txtpoemdetail;
    String title;
    String poemdetail;

    Toolbar toolbar;
    DatabaseAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taryar_detail);



        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        txttitle=(TextView)findViewById(R.id.txtmindetailtitle);
        txtpoemdetail=(TextView)findViewById(R.id.txtpoemdetail);

        Intent intent = getIntent();

        title = intent.getStringExtra("title");
        txttitle.setText(title);
        poemdetail=intent.getStringExtra("detail");
        txtpoemdetail.setText(poemdetail);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_star, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Poem poem = new Poem(this);
        int id = item.getItemId();

        if(id == R.id.idStar){
//            Log.d("mylog","I am click");
//            poem.setTitle(title);
//            Log.d("mylog", "TITLE :" + title);
//            poem.setDetail(poemdetail);
//            adp.insertPoem(poem);
//
//            Log.d("mylog","insert :"+poem);

//            Toast.makeText(getApplicationContext(), "Save", Toast.LENGTH_SHORT).show();
//            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
