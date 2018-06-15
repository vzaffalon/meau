package vbv.meau.lists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import vbv.meau.R;
import vbv.meau.models.Event;
import vbv.meau.models.User;

/**
 * Created by vzaffalon on 01/06/2018.
 */


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private final Context context;

    private List<Event> events;

    private EventAdapter.OnItemClickListener onItemClickListener;

    public EventAdapter(Context context, List<Event> events, OnItemClickListener onItemClickListener){
        this.context=context;
        this.events = events;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_event,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        Event event = events.get(position);
        holder.name.setText(event.getName());

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
        return this.events != null ? this.events.size() : 0;
    }

    //viewholder com as views

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public LinearLayout adapter_layout;

        public ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.name_text_view);
            adapter_layout = (LinearLayout) view.findViewById(R.id.adapter_event);
        }
    }


    public interface OnItemClickListener{
        public void onClickItem(View view, int idx);
    }
}