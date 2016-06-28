package app.lugcor.co.com.medireminder.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.lugcor.co.com.medireminder.R;

/**
 * Created by luisgabrielcorredorcombita on 18/07/15.
 */
public class Header_Main_2 extends Fragment {
    View view;
    Button add;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(view == null)
            view = inflater.inflate(R.layout.header_main_2, container);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
