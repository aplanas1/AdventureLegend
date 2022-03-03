package adventurelegend.game.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import adventurelegend.game.GlobalPlayer;
import adventurelegend.game.R;
import adventurelegend.game.databinding.FragmentInventoryWeaponsBinding;
import adventurelegend.game.databinding.ViewholderWeaponBinding;
import adventurelegend.game.objects.Weapon;
import adventurelegend.game.objects.WeaponAdapter;

public class InventoryWeaponsFragment extends Fragment {

    private FragmentInventoryWeaponsBinding binding;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentInventoryWeaponsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        // ARMORS
        binding.armorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_inventoryFragment_armors);
            }
        });
        // POTIONS
        binding.potionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_inventoryFragment_potions);
            }
        });
        // SPECIAL
        binding.specialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_inventoryFragment_special);
            }
        });
        // BACK
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_mapFragment);
            }
        });

        WeaponAdapter adapter = new WeaponAdapter(((GlobalPlayer) getActivity().getApplication()).getPlayer().getInventory().getWeapons());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        /*WeaponAdapter weaponAdapter = new WeaponAdapter(((GlobalPlayer) getActivity().getApplication()).getPlayer().getInventory().getWeapons());
        binding.recyclerView.setAdapter(weaponAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(weaponAdapter);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));*/

    }
}