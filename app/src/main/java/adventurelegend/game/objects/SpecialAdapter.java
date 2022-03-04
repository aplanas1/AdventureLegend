package adventurelegend.game.objects;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import adventurelegend.game.R;
import adventurelegend.game.databinding.ViewholderItemBinding;

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.ViewHolder> {

    private List<Special> list;

    public SpecialAdapter(List<Special> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewholderItemBinding binding = ViewholderItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.nombre.setText(list.get(position).getNombre());
        holder.binding.precio.setText("Valor: " + list.get(position).getPrecio());
        holder.binding.imagen.setImageResource(R.drawable.star1);
        holder.binding.cuadro.setBackgroundColor(Color.parseColor(list.get(position).getColor()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewholderItemBinding binding;

        public ViewHolder(@NonNull ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}