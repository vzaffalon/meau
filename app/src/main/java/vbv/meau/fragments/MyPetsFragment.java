package vbv.meau.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vbv.meau.R;
import vbv.meau.lists.MyPetsAdapter;
import vbv.meau.models.Pet;

/**
 * Created by vzaffalon on 04/05/2018.
 */

public class MyPetsFragment extends Fragment {

    private List<Pet> pets;
    protected RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyPetsAdapter myPetsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_pets_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        if(pets == null){
            pets = new ArrayList<>();
            Pet pet = new Pet("Pequi");
            pets.add(pet);
            pet = new Pet("Luke");
            pets.add(pet);
            pet = new Pet("Harry");
            pets.add(pet);
            pet = new Pet("Sumail");
            pets.add(pet);
        }

        if(recyclerView.getAdapter() == null){
            myPetsAdapter = new MyPetsAdapter(getContext(), pets);
            recyclerView.setAdapter(myPetsAdapter);
        }
        recyclerView.getAdapter().notifyDataSetChanged();
        // Inflate the layout for this fragment
        return view;
    }
}
