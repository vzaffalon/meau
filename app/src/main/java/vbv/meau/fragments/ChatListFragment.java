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
import vbv.meau.lists.AdoptAdapter;
import vbv.meau.lists.ChatListAdapter;
import vbv.meau.models.Pet;
import vbv.meau.models.User;

/**
 * Created by vzaffalon on 31/05/2018.
 */

public class ChatListFragment extends Fragment {
    private List<User> users;
    protected RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private ChatListAdapter chatListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_list_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        if(users == null){
            users = new ArrayList<>();
            User user = new User("Victor Zaffalon");
            users.add(user);
            user = new User("Bruno Bergamaschi");
            users.add(user);
            user = new User("Victor Araujo");
            users.add(user);
            user = new User("Pedro Alberto");
            users.add(user);
            user = new User("Jose Araujo");
            users.add(user);
            user = new User("Dudu Nobre");
            users.add(user);
        }

        if(recyclerView.getAdapter() == null){
            chatListAdapter = new ChatListAdapter(getContext(), users,onItemClickListener());
            recyclerView.setAdapter(chatListAdapter);
        }
        recyclerView.getAdapter().notifyDataSetChanged();
        // Inflate the layout for this fragment
        return view;
    }

    private ChatListAdapter.OnItemClickListener onItemClickListener(){
        return new ChatListAdapter.OnItemClickListener(){
            @Override
            public void onClickItem(View view, final int idx) {
                Fragment chatFragment = new ChatFragment();
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