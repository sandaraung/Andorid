package info.androidhive.materialdesign.activity;

/**
 * Created by Ravi on 29/07/15.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.adapter.HobbyAdapter;
import info.androidhive.materialdesign.model.Poem;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Hobby extends Fragment {


    private ListView listview;
    private ProgressDialog dialog;
    private static String urlpoem = "https://raw.githubusercontent.com/sandaraung/dathana/master/new.json";
    private static final String TAG_NAME = "name";
    private static final String TAG_TITLE = "title";
    private static final String TAG_POEM = "poem";


    public Hobby() {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        final ArrayList<Poem> poemlist = new ArrayList<Poem>();

        listview = (ListView)rootView.findViewById(R.id.poemlist);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(getActivity(), HobbyDetail.class);
                intent.putExtra("title",poemlist.get(position).getTitle());
                intent.putExtra("detail", poemlist.get(position).getDetail());
                Log.d("mylog","Detail : "+poemlist.get(position).getDetail());
                intent.putExtra("name", poemlist.get(position).getName());
                startActivity(intent);



            }
        });



        new GetPoem(getActivity(),poemlist).execute();

        return rootView;
    }


    public class GetPoem extends AsyncTask<Void, Void,ArrayList<Poem>>{

        private Context c;
        ArrayList<Poem> poem;


        public GetPoem(Context context,ArrayList<Poem> mpoem){

            this.c = context;
            poem = mpoem;

        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(getActivity());
            dialog.setMessage("plz wait.....");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected ArrayList<Poem> doInBackground(Void... params) {

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

                    String name = obj.getString("name");
                    String title = obj.getString("title");
                    String detail = obj.getString("detail");

                    Log.d("mylog","name : "+ name);
//                    poem.add(new Poem(name));
//                    poem.add(new Poem(title));

                    poem.add(new Poem(title,detail,name));

                }

                return poem;

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(ArrayList<Poem> poems) {
            super.onPostExecute(poems);

            dialog.dismiss();
//            Log.d("mylog", "data : " + poems.size());

            if(poems != null ){

                HobbyAdapter adapter = new HobbyAdapter(c,poems);
                listview.setAdapter(adapter);

            }else {
                Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
            }


        }
    }


}
