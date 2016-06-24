package info.androidhive.materialdesign.TarYarMinWai;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import info.androidhive.materialdesign.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Taryar extends AppCompatActivity {

    private ListView listview;
    private ProgressDialog dialog;
    private static String urlpoem = "https://raw.githubusercontent.com/sandaraung/dathana/master/taryar.json";
    private static final String TAG_NAME = "name";
    private static final String TAG_POEM = "taryar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taryar);





        listview = (ListView)findViewById(R.id.listtaryar);

        final ArrayList<TaryarModel> poemlist = new ArrayList<TaryarModel>();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(getApplicationContext(), TaryarDetail.class);
                intent.putExtra("title", poemlist.get(position).getTitle());
                intent.putExtra("detail", poemlist.get(position).getPoemdetail());

                startActivity(intent);


            }
        });

        new GetPoem(this,poemlist).execute();


    }



    public  class GetPoem extends AsyncTask<Void, Void,ArrayList<TaryarModel>> {

        private Context c;
        ArrayList<TaryarModel> poem;


        public GetPoem(Context context,ArrayList<TaryarModel> poemmodels){

            this.c=context;
            poem = poemmodels;

        }




        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Taryar.this);
            dialog.setMessage("plz wait.....");
            dialog.setCancelable(false);
            dialog.show();


        }

        @Override
        protected ArrayList<TaryarModel> doInBackground(Void... params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(urlpoem).build();

            Response response = null;

            try{

                response = client.newCall(request).execute();
                String json = response.body().string();

                Log.d("mylogpoem", "poem : " + json);

                JSONObject jobj = new JSONObject(json);
                JSONArray jsonarray = new JSONArray(jobj.getString(TAG_POEM));

                Log.d("mylogpoem","value : " + jsonarray);

                for(int i = 0 ; i<jsonarray.length();i++){


                    JSONObject obj = jsonarray.getJSONObject(i);

                    String title = obj.getString("title");
                    String poemdetail = obj.getString("poemdetail");

                    Log.d("mylog","name : "+title);
                    poem.add(new TaryarModel(title,poemdetail));


                }

                return poem;

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(ArrayList<TaryarModel> tar) {
            super.onPostExecute(tar);

            dialog.dismiss();
            Log.d("mylog","data : "+ tar.size());

            if(tar != null ){

                TaryarAdapter adapter = new TaryarAdapter(Taryar.this,tar);
                listview.setAdapter(adapter);

            }else {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
