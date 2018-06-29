package vbv.meau.lists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vbv.meau.R;
import vbv.meau.models.Chat;
import vbv.meau.models.Pet;
import vbv.meau.models.User;

/**
 * Created by vzaffalon on 31/05/2018.
 */

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {

    private final Context context;

    private List<Chat> chats;

    private ChatListAdapter.OnItemClickListener onItemClickListener;

    public ChatListAdapter(Context context, List<Chat> chats, OnItemClickListener onItemClickListener){
        this.context=context;
        this.chats = chats;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_chat,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        Chat chat = chats.get(position);
        holder.name.setText(chat.getNome());
        Picasso.get().load(chat.getFoto()).into(holder.foto);
        holder.descricao.setText(chat.getDescricao());

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
        return this.chats != null ? this.chats.size() : 0;
    }

    //viewholder com as views

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public LinearLayout adapter_layout;
        public CircleImageView foto;
        public TextView descricao;

        public ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.nome);
            adapter_layout = (LinearLayout) view.findViewById(R.id.adapter_chat);
            foto = (CircleImageView) view.findViewById(R.id.foto);
            descricao = (TextView) view.findViewById(R.id.descricao);

        }
    }


    public interface OnItemClickListener{
        public void onClickItem(View view, int idx);
    }
}
