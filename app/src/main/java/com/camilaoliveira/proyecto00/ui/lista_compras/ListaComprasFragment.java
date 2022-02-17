package com.camilaoliveira.proyecto00.ui.lista_compras;

import androidx.lifecycle.ViewModelProvider;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    Button btnAdd;
    private DatabaseReference mDatabase;


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



        FirebaseListAdapter adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object compras, int position) {
                EditText itemDaLista = v.findViewById(R.id.itemCompra);
                Compras iCompra = (Compras) compras;
                itemDaLista.setText(iCompra.getItem());
            }
        };


        listView.setAdapter(adapter);
        adapter.startListening();




    ;


//        ArrayAdapter adapter= new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1 ,arrayOfItems);
//        mDatabase = FirebaseDatabase.getInstance().getReference("Compras");
//        listView = binding.listaCompras;
//        ItemsAdapter adapter = new ItemsAdapter(getContext(), R.layout.item_compra, arrayOfItems);
//        listView.setAdapter(adapter);
//        btnAdd = binding.btnNuevoItem;

//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot child : snapshot.getChildren()){
//                    String item = (String) child.child("item").getValue();
//                    String id = mDatabase.push().getKey();
//                    Compras newItem = new Compras(item);
//                    ArrayList<Compras> arrayOfItems = new ArrayList<Compras>();
//                    ArrayAdapter adapter= new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1 ,arrayOfItems);
//                    adapter.add(newItem);
////                    arrayOfItems.add(newItem);
//                }
//                adapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText textoItem = binding.textoitem;
//                String campoItem = textoItem.getText().toString();
//                String id = mDatabase.push().getKey();
//                Compras item = new Compras(campoItem);
//                mDatabase.child(id).setValue(item);
//                Toast.makeText(getContext(), "Item añadido", Toast.LENGTH_LONG).show();
//
//            }
//        });

        return root;

    }


    //    public void NuevoItem(View view){
//        EditText textoItem = binding.textoitem;
//        String campoItem = textoItem.getText().toString();
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Compras");
//        myRef.setValue("Tomate");
//        if(TextUtils.isEmpty(campoItem)){
//            Toast.makeText(getContext(), "Introduce un item", Toast.LENGTH_LONG).show();
//        }else {
//            String id = mDatabase.push().getKey();
//            Compras item = new Compras(id, campoItem);
//
//            mDatabase.child(id).setValue(item);
//            Toast.makeText(getContext(), "Item añadido", Toast.LENGTH_LONG).show();
//        }
//    }

}
