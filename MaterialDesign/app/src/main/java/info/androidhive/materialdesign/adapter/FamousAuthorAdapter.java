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
import info.androidhive.materialdesign.model.Author;

/**
 * Created by HP on 4/4/2016.
 */
public class FamousAuthorAdapter extends ArrayAdapter<Author> {

    private LayoutInflater inflater;
    private ArrayList<Author> author;
    private Context context;
    int Resource;

    public FamousAuthorAdapter(Context c, ArrayList<Author> author) {
        super(c,0,author);

        this.context = c;
        this.author = author;

        Log.d("mylog", " Adapter : " + author.size());
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }

    @Override
    public int getCount() {
        return author.size();
    }

    @Override
    public Author getItem(int position) {
        return author.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {



        ViewHolder holder;

        Author d = author.get(position);

        Log.d("mylog", "D  : " + d.getName());

        if (v == null) {

            v = inflater.inflate(R.layout.author_item, parent, false);
            holder = new ViewHolder();

            holder.authorname = (TextView) v.findViewById(R.id.authortext);

            v.setTag(holder);


        } else {
            holder = (ViewHolder) v.getTag();
        }




        holder.authorname.setText(d.getName());


        return v;


    }


    private class ViewHolder{

        private TextView authorname;
    }
}
