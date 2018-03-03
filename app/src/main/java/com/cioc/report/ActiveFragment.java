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


/**
 * A simple {@link Fragment} subclass.
 */
public class ActiveFragment extends Fragment {

    ActiveAdapter activeAdapter;
    public static FloatingActionButton fab;
    RecyclerView rv_active;

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
        rv_active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = rv_active.getChildAdapterPosition(v);
                Toast.makeText(getActivity(), ""+itemPosition, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
