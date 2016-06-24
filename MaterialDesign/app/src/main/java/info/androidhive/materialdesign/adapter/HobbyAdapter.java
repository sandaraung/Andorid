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
import info.androidhive.materialdesign.model.Poem;

/**
 * Created by HP on 4/4/2016.
 */
public class HobbyAdapter extends ArrayAdapter<Poem> {

    private LayoutInflater inflater;
    private ArrayList<Poem> poem;
    private Context context;
    int Resource;

    public HobbyAdapter(Context c, ArrayList<Poem> poem) {
        super(c, 0,poem);
        
        this.context = c;
        this.poem = poem;
        Log.d("mylog" , " Adapter : " + poem.size());
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }



    @Override
    public int getCount() {
        return poem.size();
    }

    @Override
    public Poem getItem(int position) {
        return poem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {


        ViewHolder holder;


        Poem p = poem.get(position);

        Log.d("mylog", " Name : " + p.getName());

        if(v == null ){

            v  = inflater.inflate(R.layout.poem_item,parent,false);
            holder = new ViewHolder();
            holder.poemauthorname= (TextView)v.findViewById(R.id.poemauhorname);
            holder.poemtitle = (TextView)v.findViewById(R.id.poemtitle1);


            v.setTag(holder);

        } else {

            holder = (ViewHolder)v.getTag();
        }


        holder.poemtitle.setText(p.getTitle());
        holder.poemauthorname.setText(p.getName());

//        Picasso.with(context).load(p.getImage()).into(holder.imgpoem);
//
//        String s = p.getName();
//        s = s.substring(0,30);
//        s = s + "Read More.....";
//        holder.poemname.setText(s);

        return v;


    }


    private class ViewHolder {

        private TextView poemauthorname;
        private TextView poemtitle;

    }



}
