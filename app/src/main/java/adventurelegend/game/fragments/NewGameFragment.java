package adventurelegend.game.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adventurelegend.game.R;
import adventurelegend.game.databinding.FragmentNewGameBinding;
import adventurelegend.game.objetcs.Player;
import adventurelegend.game.database.PlayerViewModel;


public class NewGameFragment extends Fragment {

    private FragmentNewGameBinding binding;

    private int totales = 15;
    private int fuerza;
    private int destreza;
    private int constitucion;
    private int inteligencia;
    private int carisma;
    private int suerte;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentNewGameBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PlayerViewModel playerViewModel = new ViewModelProvider(requireActivity()).get(PlayerViewModel.class);
        NavController navController = Navigation.findNavController(view);

        //FUERZA
        binding.fuerzaMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    fuerza++;
                    totales--;
                    binding.fuerzaText.setText(fuerza);
                }
            }
        });
        binding.fuerzaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales <= 15) {
                    fuerza--;
                    totales++;
                    binding.fuerzaText.setText(fuerza);
                }
            }
        });

        //DESTREZA
        binding.destrezaMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    destreza++;
                    totales--;
                    binding.destrezaText.setText(destreza);
                }
            }
        });
        binding.destrezaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales <= 15) {
                    destreza--;
                    totales++;
                    binding.destrezaText.setText(destreza);
                }
            }
        });

        //CONSTITUCION
        binding.constitucionMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    constitucion++;
                    totales--;
                    binding.constitucionText.setText(constitucion);
                }
            }
        });
        binding.constitucionMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales <= 15) {
                    constitucion--;
                    totales++;
                    binding.constitucionText.setText(constitucion);
                }
            }
        });

        //INTELIGENCIA
        binding.inteligenciaMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    inteligencia++;
                    totales--;
                    binding.inteligenciaText.setText(inteligencia);
                }
            }
        });
        binding.inteligenciaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales <= 15) {
                    inteligencia--;
                    totales++;
                    binding.inteligenciaText.setText(inteligencia);
                }
            }
        });

        //CARISMA
        binding.carismaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    carisma++;
                    totales--;
                    binding.carismaText.setText(carisma);
                }
            }
        });
        binding.carismaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales <= 15) {
                    carisma--;
                    totales++;
                    binding.carismaText.setText(carisma);
                }
            }
        });

        //SUERTE
        binding.suerteMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    suerte++;
                    totales--;
                    binding.suerteText.setText(suerte);
                }
            }
        });
        binding.suerteMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales <= 15) {
                    suerte--;
                    totales++;
                    binding.suerteText.setText(suerte);
                }
            }
        });

        binding.create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.nombre.getText().toString();

                playerViewModel.insertar(new Player(nombre, fuerza, destreza, inteligencia, constitucion, suerte, carisma));

                navController.navigate(R.id.action_global_mapFragment);
            }
        });
    }

}