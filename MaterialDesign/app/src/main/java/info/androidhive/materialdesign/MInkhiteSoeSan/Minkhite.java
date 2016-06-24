package info.androidhive.materialdesign.MInkhiteSoeSan;

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
import info.androidhive.materialdesign.adapter.MinPoemAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Minkhite extends AppCompatActivity {

    private ListView listview;
    private ProgressDialog dialog;
    private static String urlpoem = "https://raw.githubusercontent.com/sandaraung/dathana/master/minkhite.json";
    private static final String TAG_NAME = "name";
    private static final String TAG_POEM = "minpoem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minkhite);





        listview = (ListView)findViewById(R.id.listmin);

        final ArrayList<MinPoemModel> poemlist = new ArrayList<MinPoemModel>();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(getApplicationContext(), MInkhitDetail.class);
                intent.putExtra("title",poemlist.get(position).getTitle());
                intent.putExtra("detail", poemlist.get(position).getPoemdetail());

                startActivity(intent);


            }
        });

        new GetPoem(this,poemlist).execute();


    }



    public  class GetPoem extends AsyncTask<Void, Void,ArrayList<MinPoemModel>> {

        private Context c;
        ArrayList<MinPoemModel> poem;


        public GetPoem(Context context,ArrayList<MinPoemModel> poemmodels){

            this.c=context;
            poem = poemmodels;

        }




        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Minkhite.this);
            dialog.setMessage("plz wait.....");
            dialog.setCancelable(false);
            dialog.show();


        }

        @Override
        protected ArrayList<MinPoemModel> doInBackground(Void... params) {

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
                    poem.add(new MinPoemModel(title,poemdetail));


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
        protected void onPostExecute(ArrayList<MinPoemModel> poemModels) {
            super.onPostExecute(poemModels);

            dialog.dismiss();
            Log.d("mylog","data : "+ poemModels.size());

            if(poemModels != null ){

                MinPoemAdapter adapter = new MinPoemAdapter(Minkhite.this,poemModels);
                listview.setAdapter(adapter);

            }else {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
