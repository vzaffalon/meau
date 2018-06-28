package vbv.meau.lists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import vbv.meau.R;
import vbv.meau.models.Pet;

/**
 * Created by vzaffalon on 10/05/2018.
 */

public class MyPetsAdapter extends RecyclerView.Adapter<MyPetsAdapter.ViewHolder> {

    private final Context context;

    private List<Pet> pets;

    private MyPetsAdapter.OnItemClickListener onItemClickListener;

    public MyPetsAdapter(Context context, List<Pet> pets, OnItemClickListener onItemClickListener){
        this.context=context;
        this.pets = pets;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_pets,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        Pet pet = pets.get(position);
        holder.name.setText(pet.getNome());

        //button click
        if(onItemClickListener != null){
            holder.adapter_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClickItem(holder.adapter_layout, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.pets != null ? this.pets.size() : 0;
    }

    //viewholder com as views

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public LinearLayout adapter_layout;

        public ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.name_text_view);
            adapter_layout = (LinearLayout) view.findViewById(R.id.adapter_pets);
        }
    }


    public interface OnItemClickListener{
        public void onClickItem(View view, int idx);
    }
}
