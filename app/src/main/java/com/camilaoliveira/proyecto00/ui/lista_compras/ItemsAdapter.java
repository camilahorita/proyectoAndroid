package com.camilaoliveira.proyecto00.ui.lista_compras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.camilaoliveira.proyecto00.R;

import java.util.ArrayList;

public class ItemsAdapter extends ArrayAdapter<Compras> {
    private ArrayList<Compras> listacompras;

    public ItemsAdapter(@NonNull Context context, int resource, ArrayList<Compras> listacompras) {
        super(context, resource);
        this.listacompras = listacompras;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int index = position;
        if(convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_compra, parent, false);
        }

        TextView item = convertView.findViewById(R.id.itemCompra);

        item.setText(listacompras.get(position).getItem());
        return convertView;
    }
}
