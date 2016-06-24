package com.example.leogirl.cool;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by leogirl on 5/30/16.
 */
public class Adapter_writerlist extends ArrayAdapter<Writer_Name> {

    private LayoutInflater inflater;
    private ArrayList<Writer_Name> writer;
    private Context context;
    int Resource;



    public Adapter_writerlist(Context c, ArrayList<Writer_Name> writer) {
        super(c, 0,writer);

        this.context = c;
        this.writer = writer;

        Log.d("mylog"," Adapter :" + writer.size());

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return writer.size();
    }

    @Override
    public Writer_Name getItem(int position) {
        return writer.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder;

        Writer_Name wn = writer.get(position);

        Log.d("mylog", " D  :  " + wn.getWriter_name());

        Log.d("mylog", " Poem : " + wn.getPoem());


        if(convertView == null){

            convertView = inflater.inflate(R.layout.writer_list_item,parent,false);
            holder = new ViewHolder();

            holder.writer_name = (TextView)convertView.findViewById(R.id.writer_list);
            holder.poem = (TextView)convertView.findViewById(R.id.poem);
            holder.poem_name = (TextView)convertView.findViewById(R.id.poem_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.writer_name.setText(wn.getWriter_name());
        holder.poem.setText(wn.getPoem());
        holder.poem_name.setText(wn.getPoem_name());

        return convertView;

    }

    private class ViewHolder{

       private TextView writer_name;
        private TextView poem;
        private TextView poem_name;

    }

}
