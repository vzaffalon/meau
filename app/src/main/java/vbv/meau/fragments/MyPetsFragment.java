package vbv.meau.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
//            pets = new ArrayList<>();
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
            myPetsAdapter = new MyPetsAdapter(getContext(), pets,onItemClickListener());
            recyclerView.setAdapter(myPetsAdapter);
        }
        recyclerView.getAdapter().notifyDataSetChanged();
        // Inflate the layout for this fragment
        return view;
    }

    private MyPetsAdapter.OnItemClickListener onItemClickListener(){
        return new MyPetsAdapter.OnItemClickListener(){
            @Override
            public void onClickItem(View view, final int idx) {
                PetInfoFragment petInfoFragment = new PetInfoFragment();
                changeFragment(petInfoFragment);
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
