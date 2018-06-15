package vbv.meau.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vbv.meau.R;
import vbv.meau.lists.EventAdapter;
import vbv.meau.models.Event;

/**
 * Created by vzaffalon on 04/05/2018.
 */

public class AdoptionHistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.no_histories_fragment, container, false);

        return view;
    }
}
