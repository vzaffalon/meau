package vbv.meau.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vbv.meau.R;

/**
 * Created by vzaffalon on 15/06/2018.
 */

public class HistoryInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_info_fragment, container, false);
        return view;
    }
}
