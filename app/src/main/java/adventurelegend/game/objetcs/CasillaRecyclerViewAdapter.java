package adventurelegend.game.objetcs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adventurelegend.game.R;

public class CasillaRecyclerViewAdapter extends RecyclerView.Adapter<CasillaRecyclerViewAdapter.MyViewHolder> {

    public ArrayList<Casilla> casillaModelArrayList;
    Context cxt;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView place;
        public ImageView player;

        public MyViewHolder(View itemView) {
            super(itemView);
            place = itemView.findViewById(R.id.place);
            player = itemView.findViewById(R.id.player);
        }
    }

    public CasillaRecyclerViewAdapter(ArrayList<Casilla> arrayList, Context mContext) {
        this.cxt = mContext;
        this.casillaModelArrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_mapy, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Casilla currentItem = casillaModelArrayList.get(position);
        holder.place.setImageResource(currentItem.getPlace_image());
        holder.player.setImageResource(currentItem.getPlayer_image());

    }

    @Override
    public int getItemCount() {
        return casillaModelArrayList.size();
    }

}
