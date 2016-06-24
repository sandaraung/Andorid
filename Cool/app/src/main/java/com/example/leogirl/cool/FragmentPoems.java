package com.example.leogirl.cool;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FragmentPoems extends Fragment {

    private ListView listView;

    private ProgressDialog dialog;
    private static String url = "https://raw.githubusercontent.com/sandaraung/dathana/master/dathana.json";
    private static final String Name = "name";
    private static final String Dathana = "dathana";




    public FragmentPoems() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_fragment_poems, container, false);

        listView = (ListView)rootView.findViewById(R.id.listView_writername);

        ArrayList<Writer_Name> writerlist =new ArrayList<Writer_Name>();
        new Get(getActivity(),writerlist).execute();

        return rootView;

    }

    private class Get extends AsyncTask<Void, Void, ArrayList<Writer_Name>>{


        private Context c;
        private ArrayList<Writer_Name> writer;


        public Get(Context context,ArrayList<Writer_Name> writer){

            this.c = context;
            this.writer = writer;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Please wait.....");
            dialog.setCancelable(false);
            dialog.show();

        }

        @Override
        protected ArrayList<Writer_Name> doInBackground(Void... params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(url).build();

            Response response = null;

            try {

                response = client.newCall(request).execute();

                String json = response.body().string();

                Log.d("mylog","writer : " + json);

                JSONObject jobwriter = new JSONObject(json);

                Log.d("mylog","name : " + jobwriter);


                JSONArray jsonArray = new JSONArray(jobwriter.getString(Dathana));

                Log.d("mylog","value : " + jsonArray);

                for(int i = 0; i<jsonArray.length();i++){

                    JSONObject obj = jsonArray.getJSONObject(i);

                    String poem_name = obj.getString("poem_name");
                    Log.d("mylog"," Poem_Title " + poem_name);

                    String poem = obj.getString("poem");
                    Log.d("mylog", "poem : " + poem);

                    String writer_name = obj.getString("writer_name");
                    Log.d("mylog", " name : " + writer_name);

                    writer.add(new Writer_Name(poem_name,poem,writer_name));

                }

                return writer;


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Writer_Name> writer_names) {


            dialog.dismiss();

            Log.d("mylog","data :" + writer_names.size());

            if(writer_names != null){

                Adapter_writerlist ada = new Adapter_writerlist(c,writer_names);

                listView.setAdapter(ada);

            } else {

                Toast.makeText(getActivity(),"Fail",Toast.LENGTH_SHORT).show();


            }

        }
    }





}
