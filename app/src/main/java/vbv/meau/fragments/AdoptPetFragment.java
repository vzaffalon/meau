package vbv.meau.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vbv.meau.R;
import vbv.meau.lists.AdoptAdapter;
import vbv.meau.lists.MyPetsAdapter;
import vbv.meau.models.Pet;

/**
 * Created by vzaffalon on 04/05/2018.
 */

public class AdoptPetFragment extends Fragment {

    private List<Pet> pets;
    protected RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private AdoptAdapter myPetsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adopt_pet_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        if(pets == null){
            pets = new ArrayList<>();
//            Pet pet = new Pet("Pequi");
//            pets.add(pet);
//            pet = new Pet("Luke");
//            pets.add(pet);
//            pet = new Pet("Harry");
//            pets.add(pet);
//            pet = new Pet("Sumail");
//            pets.add(pet);
        }

        if(recyclerView.getAdapter() == null){
            myPetsAdapter = new AdoptAdapter(getContext(), pets,onItemClickListener());
            recyclerView.setAdapter(myPetsAdapter);
        }
        recyclerView.getAdapter().notifyDataSetChanged();
        // Inflate the layout for this fragment

        DatabaseReference mDatabase;// ...
        mDatabase = FirebaseDatabase.getInstance().getReference("pets");
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

                // A new comment has been added, add it to the displayed list
                Pet pet = dataSnapshot.getValue(Pet.class);
                pets.add(pet);
                Collections.shuffle(pets);
                recyclerView.getAdapter().notifyDataSetChanged();
                // ...
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        };
        mDatabase.addChildEventListener(childEventListener);
        return view;
    }

    private AdoptAdapter.OnItemClickListener onItemClickListener(){
        return new AdoptAdapter.OnItemClickListener(){
            @Override
            public void onClickItem(View view, final int idx) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pet", (Serializable) pets.get(idx));
                Fragment adoptPetInfoFragment = new AdoptPetInfoFragment();
                adoptPetInfoFragment.setArguments(bundle);
                changeFragment(adoptPetInfoFragment);
            }
        };
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
