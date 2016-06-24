package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import info.androidhive.materialdesign.Database.DatabaseAdapter;
import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.adapter.HobbyAdapter;
import info.androidhive.materialdesign.model.Poem;

public class Favorite extends Fragment {
    private ListView listview;

    DatabaseAdapter mydb;

    public Favorite() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mydb = new DatabaseAdapter(getActivity());
        View rootview = inflater.inflate(R.layout.fragment_favorite, container, false);

        //  ArrayList poemlist = ArrayList mydb.getdata();
        ArrayList<Poem> poemlist = new ArrayList(mydb.getdata());

        Log.d("mylog", "fav : " + poemlist.size());

        HobbyAdapter arrayAdapter = new HobbyAdapter(getActivity(), poemlist);
        String[] name = new String[poemlist.size()];
//        for (int i = 0; i < poemlist.size(); i++) {
//            name[i] = poemlist.get(i).getName();
//        }
//        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, name);
        listview = (ListView) rootview.findViewById(R.id.favlist);

//        listview.setAdapter(adapter);

        return rootview;


    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(Uri uri);
    }

}
