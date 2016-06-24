package info.androidhive.materialdesign.TarYarMinWai;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import info.androidhive.materialdesign.R;

/**
 * Created by HP on 4/7/2016.
 */
public class TaryarAdapter extends ArrayAdapter<TaryarModel> {
    private LayoutInflater inflater;
    private ArrayList<TaryarModel> tarpoem;
    private Context context;
    int Resource;



    public TaryarAdapter(Context c,ArrayList<TaryarModel> tarpoem) {
        super(c,0,tarpoem);

        this.context = c;
        this.tarpoem = tarpoem;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tarpoem.size();
    }

    @Override
    public TaryarModel getItem(int position) {
        return tarpoem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        ViewHolder holder;

        TaryarModel d = tarpoem.get(position);

        Log.d("mylog", "D  : " + d.getTitle());

        if (v == null) {

            v = inflater.inflate(R.layout.taryar_item, parent, false);
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
