package adventurelegend.game.objects;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import adventurelegend.game.R;
import adventurelegend.game.databinding.ViewholderItemBinding;

public class ArmorAdapter extends RecyclerView.Adapter<ArmorAdapter.ViewHolder> {

    private List<Armor> list;

    public ArmorAdapter(List<Armor> list) {
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
        holder.binding.atributo.setText("Defensa: " + list.get(position).getDefensa());
        holder.binding.precio.setText("Valor: " + list.get(position).getPrecio());
        holder.binding.imagen.setImageResource(R.drawable.helmet1);
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