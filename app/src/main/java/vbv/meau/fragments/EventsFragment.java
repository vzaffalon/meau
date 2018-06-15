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
import vbv.meau.lists.EventAdapter;
import vbv.meau.lists.TipsAdapter;
import vbv.meau.models.Event;
import vbv.meau.models.Tip;

/**
 * Created by vzaffalon on 04/05/2018.
 */

public class EventsFragment extends Fragment {

    private List<Event> events;
    protected RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private EventAdapter tipsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tips_list_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        if(events == null){
            events = new ArrayList<>();
            Event event = new Event("Feira de adoção de cães e gatos");
            events.add(event);
            event = new Event("Feira de adoção da torre");
            events.add(event);
            event = new Event("Arrecadação no parque");
            events.add(event);
            event = new Event("Corrida de cães e gatos");
            events.add(event);
            event = new Event("Feira de adoção do sudoeste");
            events.add(event);

        }

        if(recyclerView.getAdapter() == null){
            tipsAdapter = new EventAdapter(getContext(), events,onItemClickListener());
            recyclerView.setAdapter(tipsAdapter);
        }
        recyclerView.getAdapter().notifyDataSetChanged();
        // Inflate the layout for this fragment
        return view;
    }

    private EventAdapter.OnItemClickListener onItemClickListener(){
        return new EventAdapter.OnItemClickListener(){
            @Override
            public void onClickItem(View view, final int idx) {
//                Fragment chatFragment = new TipInfoFragment();
//                changeFragment(chatFragment);
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
