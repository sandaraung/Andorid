package info.androidhive.materialdesign.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.MInkhiteSoeSan.MinPoemModel;

/**
 * Created by HP on 4/6/2016.
 */
public class MinPoemAdapter extends ArrayAdapter<MinPoemModel> {


    private LayoutInflater inflater;
    private ArrayList<MinPoemModel> minpoem;
    private Context context;
    int Resource;



    public MinPoemAdapter(Context c,ArrayList<MinPoemModel> minpoem) {
        super(c, 0,minpoem);

        this.context = c;
        this.minpoem = minpoem;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return minpoem.size();
    }

    @Override
    public MinPoemModel getItem(int position) {
        return minpoem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        ViewHolder holder;

        MinPoemModel d = minpoem.get(position);

        Log.d("mylog", "D  : " + d.getTitle());

        if (v == null) {

            v = inflater.inflate(R.layout.minpoem_item, parent, false);
            holder = new ViewHolder();

            holder.poemtitle = (TextView) v.findViewById(R.id.txtmin_item);

            v.setTag(holder);


        } else {
            holder = (ViewHolder) v.getTag();
        }




        holder.poemtitle.setText(d.getTitle());


        return v;
    }

    private class ViewHolder {

        private TextView poemtitle;

    }
}
