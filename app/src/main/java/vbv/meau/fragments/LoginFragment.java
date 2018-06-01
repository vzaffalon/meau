package vbv.meau.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vbv.meau.R;

/**
 * Created by vzaffalon on 31/05/2018.
 */

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        Button confirm_button = (Button) view.findViewById(R.id.confirm_button);

        return view;
    }
}
