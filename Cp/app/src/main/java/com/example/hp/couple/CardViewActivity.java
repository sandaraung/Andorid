package com.example.hp.couple;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 1/14/2016.
 */
public class CardViewActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "mylog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cardview);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        getDataSet();

    }


    @Override
    protected void onResume() {
        super.onResume();
        mRecyclerView.setAdapter(mAdapter);
    }


    private void getDataSet() {

        final ArrayList result = new ArrayList<DataObject>();

        ParseQuery<DataObject> query = ParseQuery.getQuery("DataObject");
        query.orderByAscending("createdAt");
        query.findInBackground(new FindCallback<DataObject>() {
            @Override
            public void done(List<DataObject> list, ParseException e) {
                if (e == null) {
                    result.addAll(list);
                    Log.d("mylog", "list" + result.size());
                    mAdapter = new MyRecycleViewAdapter(CardViewActivity.this, result);
                    mAdapter.notifyDataSetChanged();
                //    mAdapter.notifyDataStateChanged();
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    Log.d("mylog", "error" + e.getMessage());
                }
            }
        });

    }


}
