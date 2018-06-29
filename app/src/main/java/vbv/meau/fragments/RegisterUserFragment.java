package vbv.meau.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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
import vbv.meau.models.User;

public class RegisterUserFragment extends Fragment{
    private FirebaseAuth mAuth;
    private DatabaseReference dbUsers;
    private Button registerButton;
    private EditText inputName;
    private EditText inputAge;
    private EditText inputPassword;
    private EditText inputConfPassword;
    private EditText inputEmail;
    private EditText inputCity;
    private EditText inputState;
    private EditText inputAddress;
    private EditText inputPhone;
    private EditText inputUsername;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.user_register_fragment, container, false);
        registerButton = (Button) view.findViewById(R.id.buttonRegister);
        inputName = (EditText) view.findViewById(R.id.inputName);
        inputAge = (EditText) view.findViewById(R.id.inputAge);
        inputEmail = (EditText) view.findViewById(R.id.inputEmail);
        inputCity = (EditText) view.findViewById(R.id.inputCity);
        inputState = (EditText) view.findViewById(R.id.inputState);
        inputAddress = (EditText) view.findViewById(R.id.inputAddress);
        inputPhone = (EditText) view.findViewById(R.id.inputPhone);
        inputPassword = (EditText) view.findViewById(R.id.inputPassword);
        inputConfPassword = (EditText) view.findViewById(R.id.inputConfPassword);
        inputUsername = (EditText) view.findViewById(R.id.inputUserName);


        mAuth = FirebaseAuth.getInstance();

        dbUsers = FirebaseDatabase.getInstance().getReference("users");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // method that sign up an user
                if(registerUser()){
                    Fragment fragment = new MyPerfilFragment();
                    changeFragment(fragment);
                }else{
                    Fragment fragment = new RegisterUserFragment();
                    changeFragment(fragment);
                }

            }
        });

        // Inflate the layout for this fragment
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

    private boolean registerUser(){
        String name = inputName.getText().toString().trim();
        String age = inputAge.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        String confPassword = inputConfPassword.getText().toString().trim();
        String address = inputAddress.getText().toString().trim();
        String city = inputAddress.getText().toString().trim();
        String state = inputState.getText().toString().trim();
        String phone = inputPhone.getText().toString().trim();
        String username = inputUsername.getText().toString().trim();
        String urlPhoto = new String("hue");


        if(!TextUtils.isEmpty(name) || !TextUtils.isEmpty(age) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(password) ||
           !TextUtils.isEmpty(confPassword) || !TextUtils.isEmpty(address) || !TextUtils.isEmpty(city) || !TextUtils.isEmpty(state) ||
           !TextUtils.isEmpty(phone) || !TextUtils.isEmpty(username)){

            if(!isEmailValid(email)){
                Toast.makeText(getContext(), "Email digitado nao valido!", Toast.LENGTH_LONG).show();
                return false;
            }

            if(!password.equals(confPassword)){
                Toast.makeText(getContext(), "Senhas inseridas nao iguais!", Toast.LENGTH_LONG).show();
                return false;
            }

            String userId = dbUsers.push().getKey();

            User user = new User(name, age, email, state, city, address, phone, username, password, urlPhoto, userId);
            dbUsers.child(userId).setValue(user);

            Toast.makeText(getContext(), "Usuario criado com sucesso!", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(getContext(), "Um dos campos em branco!", Toast.LENGTH_LONG).show();
        }

        return false;
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
