package vbv.meau.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vbv.meau.R;

/**
 * Created by vzaffalon on 04/05/2018.
 */

public class RegisterPetFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.register_pet_fragment, container, false);
        Button confirm_button = (Button) view.findViewById(R.id.confirm_button);

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ConfirmedPetRegistrationFragment();
                changeFragment(fragment);

            }
        });

        return view;
    }

    private void changeFragment(Fragment fragment){
        // Create fragment and give it an argument specifying the article it should show
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
