package vbv.meau.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import vbv.meau.R;
import vbv.meau.models.Pet;

/**
 * Created by vzaffalon on 04/05/2018.
 */

public class RegisterPetFragment extends Fragment {
    private Button buttonAdotar;
    private Button buttonApadrinhar;
    private Button buttonAjuda;
    private EditText nome;
    private RelativeLayout addPictureButton;
    private EditText  sobre_o_animal;
    private CheckBox brincalhao;
    private CheckBox amoroso;
    private CheckBox calmo;
    private CheckBox guarda;
    private CheckBox timido;
    private CheckBox vacinado;
    private CheckBox vermifugado;
    private CheckBox castrado;
    private CheckBox doente;
    private CheckBox preguicoso;
    private CheckBox termos;
    private CheckBox foto;
    private CheckBox visita;
    private CheckBox acompanhamento;

    private String nomeString;
    private String tipo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.register_pet_fragment, container, false);
        Button confirm_button = (Button) view.findViewById(R.id.confirm_button);

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
                DatabaseReference myRef = mDatabase.getReference();
                Pet pet = new Pet("Luke", "Macho","Grande","Adulto",
                        "Sudoeste","Sem doenças","Nenhuma","Dócil",
                        "Termos de adoção, fotos da casa, visita prévia","Animal muito dócil",
                        "http://portalmelhoresamigos.com.br/wp-content/uploads/2016/05/beijo_lambida_cachorro.png","Ração, remédios",
                        "adoção",false);

                myRef.child("pets").push().setValue(pet);
                Fragment fragment = new ConfirmedPetRegistrationFragment();
                changeFragment(fragment);

            }
        });

        setUpLayout(view);

        return view;
    }

    private void setUpLayout(View view){
        buttonAdotar = view.findViewById(R.id.buttonAdotar);
        buttonApadrinhar = view.findViewById(R.id.buttonApadrinhar);
        buttonAjuda = view.findViewById(R.id.buttonAjuda);
        addPictureButton = view.findViewById(R.id.addPicture);
        sobre_o_animal = view.findViewById(R.id.sobre_o_animal);
        nome = view.findViewById(R.id.nome);
        brincalhao = view.findViewById(R.id.checkbox_bricalhao);
        amoroso = view.findViewById(R.id.checkbox_amoroso);
        calmo = view.findViewById(R.id.checkbox_calmo);
        guarda = view.findViewById(R.id.checkbox_guarda);
        timido = view.findViewById(R.id.checkbox_timido);
        vacinado = view.findViewById(R.id.checkbox_vacinado);
        vermifugado = view.findViewById(R.id.checkbox_vermifugado);
        castrado = view.findViewById(R.id.checkbox_castrado);
        doente = view.findViewById(R.id.checkbox_doente);
        preguicoso = view.findViewById(R.id.checkbox_preguicoso);
        termos = view.findViewById(R.id.checkbox_termo);
        foto = view.findViewById(R.id.checkbox_fotos);
        visita = view.findViewById(R.id.checkbox_visita);
        acompanhamento = view.findViewById(R.id.checkbox_acompanhamento);




        buttonAdotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAdotar.setBackgroundColor(Color.parseColor("#ffd358"));
                buttonApadrinhar.setBackgroundColor(Color.parseColor("#f1f2f2"));
                buttonAjuda.setBackgroundColor(Color.parseColor("#f1f2f2"));
            }
        });


        buttonApadrinhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonApadrinhar.setBackgroundColor(Color.parseColor("#ffd358"));
                buttonAjuda.setBackgroundColor(Color.parseColor("#f1f2f2"));
                buttonAdotar.setBackgroundColor(Color.parseColor("#f1f2f2"));

            }
        });

        buttonAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAjuda.setBackgroundColor(Color.parseColor("#ffd358"));
                buttonApadrinhar.setBackgroundColor(Color.parseColor("#f1f2f2"));
                buttonAdotar.setBackgroundColor(Color.parseColor("#f1f2f2"));

            }
        });





    }

    public void onIdadeRadio(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_filhote:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_adulto:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radio_cachorro:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void onEspecieRadio(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_macho:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_femea:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }


    public void onSexoRadio(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_macho:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_femea:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void onPorteRadio(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pequeno:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_medio:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.radio_grande:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_bricalhao:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_amoroso:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_calmo:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_guarda:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_timido:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_preguicoso:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_vacinado:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_vermifugado:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_castrado:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_doente:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_termo:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;

            case R.id.checkbox_fotos:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
            case R.id.checkbox_visita:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;

            case R.id.checkbox_acompanhamento:
                if (checked){

                }
                // Put some meat on the sandwich
                else{

                }
                // Remove the meat
                break;
        }
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
