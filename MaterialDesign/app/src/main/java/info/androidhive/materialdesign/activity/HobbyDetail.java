package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import info.androidhive.materialdesign.Database.DatabaseAdapter;
import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.Poem;

public class HobbyDetail extends AppCompatActivity {

    Toolbar toolbar;

    TextView txttitle;
    TextView txtdetail;
    TextView txtname;

    String title, detail, name;

    DatabaseAdapter adp;

    private boolean ischeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_poem_detail);

        adp = new DatabaseAdapter(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ကဗ်ာမ်ား");


        txttitle = (TextView) findViewById(R.id.poemtitle);
        txtdetail = (TextView) findViewById(R.id.poemdetail);
        txtname = (TextView) findViewById(R.id.poemname);
        Intent intent = getIntent();

        title = intent.getStringExtra("title");
        txttitle.setText(title);
        detail = intent.getStringExtra("detail");
        txtdetail.setText(detail);
        Log.d("mylog", "trdy " + detail);
        name = intent.getStringExtra("name");
        txtname.setText(name);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_star, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Poem poem = new Poem(this);
        int id = item.getItemId();

        if(item.getItemId() == R.id.idStar){
            item.setChecked(!item.isChecked());
            if (!item.isChecked()) item.setIcon(R.drawable.star3);
            else  {

                   item.setIcon((R.drawable.star));
                   adp.insertPoem(poem);


            }

            return true;
        }
        return false;




    }

}



