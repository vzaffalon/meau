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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vbv.meau.R;
import vbv.meau.lists.ChatListAdapter;
import vbv.meau.lists.TipsAdapter;
import vbv.meau.models.Event;
import vbv.meau.models.Tip;
import vbv.meau.models.TipInfo;
import vbv.meau.models.User;

/**
 * Created by vzaffalon on 04/05/2018.
 */

public class TipsFragment extends Fragment {

    private List<Tip> tips;
    protected RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private TipsAdapter tipsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tips_list_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        if(tips == null){
            tips = new ArrayList<>();
//            ArrayList<TipInfo> tipInfos = new ArrayList<>();
//            TipInfo tipInfo = new TipInfo("","Titulo","descricao");
//            tipInfos.add(tipInfo);
//            tipInfo = new TipInfo("","Titulo","descricao");
//            tipInfos.add(tipInfo);
//            tipInfo = new TipInfo("","Titulo","descricao");
//            tipInfos.add(tipInfo);
//            Tip tip = new Tip("Comportamento",tipInfos);
//            tips.add(tip);
        }

        if(recyclerView.getAdapter() == null){
            tipsAdapter = new TipsAdapter(getContext(), tips,onItemClickListener());
            recyclerView.setAdapter(tipsAdapter);
        }
        recyclerView.getAdapter().notifyDataSetChanged();
        // Inflate the layout for this fragment


        DatabaseReference mDatabase;// ...
        mDatabase = FirebaseDatabase.getInstance().getReference("tips");
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

                // A new comment has been added, add it to the displayed list
                Tip tip = dataSnapshot.getValue(Tip.class);
                tips.add(tip);
                Collections.shuffle(tips);
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

    private TipsAdapter.OnItemClickListener onItemClickListener(){
        return new TipsAdapter.OnItemClickListener(){
            @Override
            public void onClickItem(View view, final int idx) {
                Fragment chatFragment = new TipInfoFragment();
                changeFragment(chatFragment);
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
