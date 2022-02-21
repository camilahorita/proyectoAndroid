package com.camilaoliveira.proyecto00.ui.lista_compras;

import androidx.lifecycle.ViewModelProvider;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.camilaoliveira.proyecto00.R;
import com.camilaoliveira.proyecto00.databinding.FragmentListaComprasBinding;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListaComprasFragment extends Fragment {



    FirebaseDatabase database ;
    private ListaComprasViewModel listacomprasViewModel;
    private FragmentListaComprasBinding binding;
    ListView listView;
    Button btnAdd, btnDelete;
    private DatabaseReference mDatabase;
    FirebaseListAdapter adapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listacomprasViewModel =
                new ViewModelProvider(this).get(ListaComprasViewModel.class);

        binding = FragmentListaComprasBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

//        ArrayList<Compras> arrayOfItems = new ArrayList<Compras>();
        listView = binding.listaCompras;



        Query query = FirebaseDatabase.getInstance().getReference().child("Compras");
        FirebaseListOptions<Compras> options = new FirebaseListOptions.Builder<Compras>()
                .setLayout(R.layout.item_compra)
                .setQuery(query, Compras.class)
//                .setLifecycleOwner(this)
                .build();



        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object compras, int position) {
                EditText itemDaLista = v.findViewById(R.id.itemCompra);
                Compras iCompra = (Compras) compras;
                itemDaLista.setText(iCompra.getItem());
                Button delete=(Button)v.findViewById(R.id.btnx);


                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatabaseReference item=adapter.getRef(position) ;
                        item.removeValue();
                    }
                });
            }
        };


        listView.setAdapter(adapter);
        adapter.startListening();




         mDatabase = FirebaseDatabase.getInstance().getReference("Compras");

        btnAdd = binding.btnNuevoItem;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase = FirebaseDatabase.getInstance().getReference("Compras");
                EditText textoItem = binding.textoitem;
                String campoItem = textoItem.getText().toString();
                String id = mDatabase.push().getKey();
                Compras item = new Compras(campoItem);
                mDatabase.child(id).setValue(item);
                Toast.makeText(getContext(), "Item añadido", Toast.LENGTH_SHORT).show();
                textoItem.setText("");

            }
        });



        return root;
    }

}
