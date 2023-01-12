package com.example.finalprojectufs08;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaDataFragment extends Fragment implements RecyclerViewInterface{

    PizzaAdapter pizzaAdapter;
    RecyclerView recyclerView;
    ArrayList<Pizza> pizzas;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaDataFragment newInstance(String param1, String param2) {
        ListaDataFragment fragment = new ListaDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_data, container, false);

        recyclerView = view.findViewById(R.id.lista_item);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        pizzas = new ArrayList<Pizza>();
        pizzaAdapter = new PizzaAdapter(getActivity(),  this.pizzas, this);

        recyclerView.setAdapter(pizzaAdapter);

        eventChangeListener();
        
        return view;
    }

    private void eventChangeListener() {
        db.collection("pizza")
                // Per EventListener controllare sempre l'import
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w("errore", "Listen failed.", e);
                            return;
                        }

                        for (DocumentChange documentChange: value.getDocumentChanges()) {
                            if (documentChange.getType() == DocumentChange.Type.ADDED) {
                                pizzas.add(documentChange.getDocument().toObject(Pizza.class));
                            }
                            pizzaAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onItemClick(int position) {
        System.out.println(pizzas.get(position).toString());
    }
}