package vbv.meau.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import vbv.meau.R;

/**
 * Created by vzaffalon on 31/05/2018.
 */

public class LoginFragment extends Fragment {
    private FirebaseAuth mAuth;
    private DatabaseReference dbUsers;
    private EditText loginEmail;
    private EditText loginPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        Button confirm_button = (Button) view.findViewById(R.id.confirm_button);
        EditText loginEmail = (EditText) view.findViewById(R.id.loginEmail);
        EditText loginPassword = (EditText) view.findViewById(R.id.loginPassword);

        mAuth = FirebaseAuth.getInstance();

        dbUsers = FirebaseDatabase.getInstance().getReference("users");

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new RegisterUserFragment();
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

    private boolean loginUser(){
        String email = loginEmail.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();

        if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)){
            if(!isEmailValid(email)){
                Toast.makeText(getContext(), "Email invalido!", Toast.LENGTH_LONG).show();
                return false;
            }

            mAuth.signInWithEmailAndPassword(email, password);


        }else{
            Toast.makeText(getContext(), "Textos vazios!", Toast.LENGTH_LONG).show();
        }

        return false;
    }

    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
