package adventurelegend.game.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adventurelegend.game.GlobalPlayer;
import adventurelegend.game.R;
import adventurelegend.game.databinding.FragmentInventoryWeaponsBinding;
import adventurelegend.game.databinding.FragmentShoppingBinding;
import adventurelegend.game.objects.ForgeAdapter;
import adventurelegend.game.objects.ShopAdapter;
import adventurelegend.game.objects.WeaponAdapter;

public class ShoppingFragment extends Fragment {

    private FragmentShoppingBinding binding;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentShoppingBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.dinero.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getDinero() + " gold");

        // BACK
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_shopFragment);
            }
        });

        ShopAdapter adapter = new ShopAdapter(((GlobalPlayer) getActivity().getApplication()).getPlayer().getShop().getPotions(), ((GlobalPlayer) getActivity().getApplication()).getPlayer().getShop().getSpecials());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
    }
}