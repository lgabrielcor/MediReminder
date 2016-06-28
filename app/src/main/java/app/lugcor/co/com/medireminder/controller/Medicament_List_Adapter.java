package app.lugcor.co.com.medireminder.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import app.lugcor.co.com.medireminder.R;
import app.lugcor.co.com.medireminder.model.Historial_Dosis;


/**
 * Created by luisgabrielcorredorcombita on 23/07/15.
 */
public class Medicament_List_Adapter extends BaseAdapter{

    Context context;
    Historial_Dosis[] data;
    private static LayoutInflater inflater = null;

    public Medicament_List_Adapter(Context context, Historial_Dosis[] data){
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return data[position].getMedicamentId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if(view == null)
            view = inflater.inflate(R.layout.medicament_item_list, null);

        TextView medicament_title = (TextView)view.findViewById(R.id.medicament_title);
        medicament_title.setText(data[position].getMedicamentName());

        TextView patology_title = (TextView)view.findViewById(R.id.patology_title);
        patology_title.setText(data[position].getPatology());

        TextView dose = (TextView)view.findViewById(R.id.dose_title);
        dose.setText(data[position].getDose()+", "+data[position].getNextDose());

        return view;
    }
}
