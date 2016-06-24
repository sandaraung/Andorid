package info.androidhive.materialdesign.activity;

import android.app.Activity;
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

import info.androidhive.materialdesign.MInkhiteSoeSan.Minkhite;
import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.TarYarMinWai.Taryar;
import info.androidhive.materialdesign.adapter.FamousAuthorAdapter;
import info.androidhive.materialdesign.model.Author;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ravi on 29/07/15.
 */
public class FamousAuthor extends Fragment {

    private ListView listview;

    private ProgressDialog dialog;
    private static String url = "https://raw.githubusercontent.com/sandaraung/dathana/master/dathana.json";
    private static final String TAG_NAME = "name";
    private static final String TAG_DATHANA = "dathana";


    public FamousAuthor() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);


        listview = (ListView)rootView.findViewById(R.id.authorlist);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(position){
                    case 0:  Intent newActivity = new Intent(getActivity(), Minkhite.class);
                        startActivity(newActivity);
                        break;
                    case 1: Intent i = new Intent(getActivity(), Taryar.class);
                        startActivity(i);
                        break;


                }


            }
        });

        ArrayList<Author> authorlist = new ArrayList<Author>();

        new GetAuthor(getActivity(),authorlist).execute();


        return rootView;
    }


    private class GetAuthor extends AsyncTask<Void, Void, ArrayList<Author>>{


        private Context c;
        private ArrayList<Author> author;

        public GetAuthor(Context context, ArrayList<Author> authormodels) {
            this.c = context;
            author = authormodels;

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
        protected ArrayList<Author> doInBackground(Void... params) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(url).build();

            Response response = null;

            try {
                response = client.newCall(request).execute();
                String json = response.body().string();

                Log.d("author", "author : " + json);

                JSONObject jobjauthor = new JSONObject(json);

                Log.d("authorname","name : " + jobjauthor);

                JSONArray jsonarray = new JSONArray(jobjauthor.getString(TAG_DATHANA));

                Log.d("mylogauthor","value : " + jsonarray);

                for(int i = 0 ; i<jsonarray.length();i++){


                    JSONObject obj = jsonarray.getJSONObject(i);

                    String name = obj.getString("name");
                    Log.d("mylog","name : "+name);
                    author.add(new Author(name));


                }

                return author;

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(ArrayList<Author> authors) {
            super.onPostExecute(authors);

            dialog.dismiss();
            Log.d("mylogg", "data : " + authors.size());

            if(authors != null ){

                FamousAuthorAdapter adapter = new FamousAuthorAdapter(c,authors);
                listview.setAdapter(adapter);

            }else {
                Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
            }

        }
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
