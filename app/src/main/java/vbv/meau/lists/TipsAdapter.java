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
import vbv.meau.models.Tip;
import vbv.meau.models.User;

/**
 * Created by vzaffalon on 01/06/2018.
 */

public class TipsAdapter  extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {

    private final Context context;

    private List<Tip> tips;

    private TipsAdapter.OnItemClickListener onItemClickListener;

    public TipsAdapter(Context context, List<Tip> tips, TipsAdapter.OnItemClickListener onItemClickListener){
        this.context=context;
        this.tips = tips;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public TipsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_tips,viewGroup,false);
        TipsAdapter.ViewHolder holder = new TipsAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final TipsAdapter.ViewHolder holder, final int position) {
        Tip tip = tips.get(position);
        holder.name.setText(tip.getCategoria());

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
        return this.tips != null ? this.tips.size() : 0;
    }

    //viewholder com as views

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public LinearLayout adapter_layout;

        public ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.name_text_view);
            adapter_layout = (LinearLayout) view.findViewById(R.id.adapter_tips);
        }
    }


    public interface OnItemClickListener{
        public void onClickItem(View view, int idx);
    }
}
