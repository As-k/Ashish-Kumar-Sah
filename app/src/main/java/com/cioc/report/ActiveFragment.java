package com.cioc.report;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActiveFragment extends Fragment {

    ActiveAdapter activeAdapter;
    public static FloatingActionButton fab;
    RecyclerView rv_active;
    ArrayList arrayList;

    public ActiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_active, container, false);
        fab = v1.findViewById(R.id.fab);
        fabActoin();
        arrayList = new ArrayList();

        rv_active = v1.findViewById(R.id.rv_active);
        rv_active.setLayoutManager(new LinearLayoutManager(getActivity()));

        activeAdapter = new ActiveAdapter(getActivity());
        rv_active.setAdapter(activeAdapter);
        rvActiveClick();

        return v1;
    }

    private void fabActoin(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Add a new Editor", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), NewEditorActivity.class));
            }
        });
    }

    public void rvActiveClick(){
        rv_active.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
                        String itemPosition = (String) arrayList.get(position);

                        String item = view.toString();
                        Intent intent = new Intent(getActivity(),ViewActivity.class);
                        intent.putExtra("name",item);
                        startActivity(intent);
                    }
                })
        );
    }

}
