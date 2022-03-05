package adventurelegend.game.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adventurelegend.game.GlobalPlayer;
import adventurelegend.game.R;
import adventurelegend.game.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentProfileBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        // BACK
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        binding.nombre.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getNombre());
        binding.level.setText("Lvl " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getNivel());
        binding.dinero.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getDinero() + " g" );
        binding.clase.setText("Aventurero");
        binding.vida.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
        binding.mana.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());
        binding.ataque.setText("ATK " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getAtaque());
        binding.defensa.setText("DEF " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getDefensa());
        binding.fuerza.setText("FUE " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getFuerza());
        binding.destreza.setText("DES " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getDestreza());
        binding.constitucion.setText("CONS " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getConstitucion());
        binding.inteligencia.setText("INT " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getInteligencia());
        binding.suerte.setText("SUE " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getSuerte());
        binding.carisma.setText("CAR " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getCarisma());

    }
}