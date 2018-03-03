package com.cioc.report;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class ApprovalFragment extends Fragment {

    ApprovalAdapter approvalAdapter;
    RecyclerView rv_approval;

    public ApprovalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_approval, container, false);

        rv_approval = v1.findViewById(R.id.rv_approval);
        rv_approval.setLayoutManager(new LinearLayoutManager(getActivity()));

        approvalAdapter = new ApprovalAdapter(getActivity());
        rv_approval.setAdapter(approvalAdapter);


        return v1;
    }

}
