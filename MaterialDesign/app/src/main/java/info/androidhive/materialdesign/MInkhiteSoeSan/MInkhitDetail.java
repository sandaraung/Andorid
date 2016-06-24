package info.androidhive.materialdesign.MInkhiteSoeSan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import info.androidhive.materialdesign.Database.DatabaseAdapter;
import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.model.Poem;

/**
 * Created by HP on 4/6/2016.
 */
public class MInkhitDetail extends AppCompatActivity {

    TextView txttitle;
    TextView txtpoemdetail;
    String title;
    String poemdetail;

    Toolbar toolbar;
    DatabaseAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minpoem_detail);



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
        Poem poem = new Poem();
        int id = item.getItemId();

        if(item.getItemId() == R.id.idStar){
            item.setChecked(!item.isChecked());
            if (!item.isChecked()) item.setIcon(R.drawable.star3);
            else  {

                item.setIcon((R.drawable.star));



            }

            return true;
        }
        return false;
    }



}
