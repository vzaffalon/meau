package vbv.meau.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vbv.meau.R;

/**
 * Created by vzaffalon on 01/06/2018.
 */

public class TipInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tip_info_fragment, container, false);

        return view;
    }
}
