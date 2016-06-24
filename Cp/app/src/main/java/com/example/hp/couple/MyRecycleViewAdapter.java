package com.example.hp.couple;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 1/14/2016.
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.DataObjectHolder> {

    String fontpath = "fonts/zawgyi.ttf";
    String str;
    private static final int MAX_TEXT = 160;

    Context context;
    private static String LOG_TAG = "MyRecycleViewAdapter";
    private ArrayList<DataObject> mDataset;


    public MyRecycleViewAdapter(Context mContext, ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
        context = mContext;

    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, int position) {

        Typeface tt = Typeface.createFromAsset(context.getAssets(), fontpath);
        holder.txtMale.setTypeface(tt);
        holder.txtFemale.setTypeface(tt);
        holder.txtquestion.setTypeface(tt);
        holder.btnSave.setTypeface(tt);
        holder.editanswer.setTypeface(tt);

        final DataObject d = mDataset.get(position);

        Log.d("mylog", "Ans :" + d.getFemaleanswer()+"");
        if (d.getFemaleanswer() == null && d.getMaleanswer() == null) {

            holder.txtFemale.setVisibility(View.GONE);
            holder.txtMale.setVisibility(View.GONE);

        } else if (d.getMaleanswer() != null) {


            holder.txtMale.setText(d.getMaleanswer());
            holder.txtFemale.setVisibility(View.GONE);
           // holder.ln.setVisibility(View.VISIBLE);


        } else if (d.getFemaleanswer() != null) {

            holder.txtFemale.setText(d.getFemaleanswer());
            holder.txtMale.setVisibility(View.GONE);
          //  holder.ln.setVisibility(View.VISIBLE);


        } else if (d.getFemaleanswer() != null && d.getMaleanswer() != null) {

          //  holder.ln.setVisibility(View.GONE);
            holder.txtFemale.setVisibility(View.VISIBLE);
            holder.txtMale.setVisibility(View.VISIBLE);

        }

        holder.txtquestion.setText(d.getQuestion());

        //push to server
        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ans = holder.editanswer.getText().toString();
                Log.d("mylog", "Ans :" + ans);
                holder.txtFemale.setVisibility(View.VISIBLE);
                holder.txtMale.setVisibility(View.VISIBLE);
                putToServer(holder, d, ans);

            }
        });

    }

    private void putToServer(final DataObjectHolder holder, final DataObject d, final String answser) {

        ParseQuery<DataObject> query = ParseQuery.getQuery(DataObject.class);

        query.whereEqualTo("objectId", d.getObjectId());
        query.findInBackground(new FindCallback<DataObject>() {
            @Override
            public void done(List<DataObject> list, ParseException e) {

                if (e == null) {
                    for (DataObject d1 : list) {

                        d1.setObjectId(d.getObjectId());
                        d1.setFemaleanswer(answser);
                        d1.setQqueston(d.getQuestion());
                        d1.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    holder.txtFemale.setText(answser);
                                    holder.editanswer.setText("");
                                    Toast.makeText(context, "Upload", Toast.LENGTH_SHORT).show();
                                } else {
                                    Log.d("mylog", "Error :" + e.getMessage());
                                }
                            }
                        });
                    }

                } else {
                    Log.d("Post retrieval", "Error: " + e.getMessage());
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void addItem(DataObject dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }


    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        //
        TextView txtquestion;
        TextView txtFemale;
        TextView txtMale;
        Button btnSave;
        EditText editanswer;
        Button btnFemale;
      //  LinearLayout ln;

        public DataObjectHolder(View v) {
            super(v);
//
            txtquestion = (TextView) v.findViewById(R.id.txtQuestion);
            txtFemale = (TextView) v.findViewById(R.id.txtFemale);
            txtMale = (TextView) v.findViewById(R.id.txtMale);
            btnSave = (Button) v.findViewById(R.id.btnsave);
            editanswer = (EditText) v.findViewById(R.id.editanswer);
//            btnMale = (Button) v.findViewById(R.id.btnMale);



            Log.i(LOG_TAG, "Adding Listener");


        }

    }


}
