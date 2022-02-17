package com.camilaoliveira.proyecto00.ui.recetas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.camilaoliveira.proyecto00.R;
import com.camilaoliveira.proyecto00.ui.RecetaGachasActivity;
import com.camilaoliveira.proyecto00.ui.RecetaHummusActivity;
import com.camilaoliveira.proyecto00.ui.RecetaTortillaActivity;

public class RecetasFragment extends Fragment {

    public RecetasFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recetas, container, false);
        String[] recetaslista ={"Gachas de avena", "Hummus", "Tortilla"};
        ListView listview = (ListView) view.findViewById(R.id.lista);
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>( getActivity(),
                android.R.layout.simple_list_item_1,
                recetaslista);
        listview.setAdapter(myArrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==0){
                    Intent intent = new Intent(getActivity(), RecetaGachasActivity.class);
                    startActivity(intent);
                } else if (position ==1) {
                    Intent intent = new Intent(getActivity(), RecetaHummusActivity.class);
                    startActivity(intent);
                } else if (position==2){
                    Intent intent = new Intent(getActivity(), RecetaTortillaActivity.class);
                    startActivity(intent);
//                    Toast.makeText(getActivity(), "Third", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}


