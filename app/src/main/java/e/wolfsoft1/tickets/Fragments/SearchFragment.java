package e.wolfsoft1.tickets.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import e.wolfsoft1.tickets.Adapters.Recycler1Adapter;
import e.wolfsoft1.tickets.ModelClasses.RecyclerModel1;
import e.wolfsoft1.tickets.R;

/**
 * Created by wolfsoft1 on 22/2/18.
 */

public class SearchFragment extends Fragment {
    private View view;
TextView dates,months;

    private ArrayList<RecyclerModel1> homeListModelClassArrayList;
    private RecyclerView recyclerView;
    private Recycler1Adapter mAdapter;

    String month[]={"S","M","T","W","T","F","S"};
    String date[]={"23","24","25","26","27","28","29"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        months=(TextView)view.findViewById(R.id.month);
        dates=(TextView)view.findViewById(R.id.date);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        homeListModelClassArrayList = new ArrayList<>();

        for (int i = 0; i < month.length; i++) {
            RecyclerModel1 beanClassForRecyclerView_contacts = new RecyclerModel1(month[i],date[i]);

            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
        }

        mAdapter = new Recycler1Adapter(getActivity(),homeListModelClassArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return view;

    }
}
