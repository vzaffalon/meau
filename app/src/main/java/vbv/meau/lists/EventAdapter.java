package vbv.meau.lists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        holder.nome.setText(event.getNome());
        holder.data.setText(event.getData());
        holder.informacoes.setText(event.getInformacoes());
        holder.local.setText(event.getLocal());

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
        public TextView data;
        public LinearLayout adapter_layout;
        private TextView local;
        private TextView informacoes;
        public TextView nome;

        public ViewHolder(View view){
            super(view);
            data = (TextView) view.findViewById(R.id.data);
            local = (TextView) view.findViewById(R.id.local);
            informacoes = (TextView) view.findViewById(R.id.informacoes);
            nome = (TextView) view.findViewById(R.id.nome);

            adapter_layout = (LinearLayout) view.findViewById(R.id.adapter_event);
        }
    }


    public interface OnItemClickListener{
        public void onClickItem(View view, int idx);
    }
}