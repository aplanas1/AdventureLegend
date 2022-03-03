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
import adventurelegend.game.databinding.FragmentNewGameBinding;
import adventurelegend.game.objects.Player;


public class NewGameFragment extends Fragment {

    private FragmentNewGameBinding binding;

    private int totales = 15;
    private int fuerza = 0;
    private int destreza = 0;
    private int constitucion = 0;
    private int inteligencia = 0;
    private int carisma = 0;
    private int suerte = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentNewGameBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        binding.totalesText.setText("" + totales);

        //FUERZA
        binding.fuerzaText.setText("" + fuerza);
        binding.fuerzaMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    fuerza++;
                    totales--;
                    binding.fuerzaText.setText("" + fuerza);
                    binding.totalesText.setText("" + totales);
                }
            }
        });
        binding.fuerzaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fuerza > 0) {
                    fuerza--;
                    totales++;
                    binding.fuerzaText.setText("" + fuerza);
                    binding.totalesText.setText("" + totales);
                }
            }
        });

        //DESTREZA
        binding.destrezaText.setText("" + destreza);
        binding.destrezaMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    destreza++;
                    totales--;
                    binding.destrezaText.setText("" + destreza);
                    binding.totalesText.setText("" + totales);
                }
            }
        });
        binding.destrezaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (destreza > 0) {
                    destreza--;
                    totales++;
                    binding.destrezaText.setText("" + destreza);
                    binding.totalesText.setText("" + totales);
                }
            }
        });

        //CONSTITUCION
        binding.constitucionText.setText("" + constitucion);
        binding.constitucionMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    constitucion++;
                    totales--;
                    binding.constitucionText.setText("" + constitucion);
                    binding.totalesText.setText("" + totales);
                }
            }
        });
        binding.constitucionMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (constitucion > 0) {
                    constitucion--;
                    totales++;
                    binding.constitucionText.setText("" + constitucion);
                    binding.totalesText.setText("" + totales);
                }
            }
        });

        //INTELIGENCIA
        binding.inteligenciaText.setText("" + inteligencia);
        binding.inteligenciaMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    inteligencia++;
                    totales--;
                    binding.inteligenciaText.setText("" + inteligencia);
                    binding.totalesText.setText("" + totales);
                }
            }
        });
        binding.inteligenciaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inteligencia > 0) {
                    inteligencia--;
                    totales++;
                    binding.inteligenciaText.setText("" + inteligencia);
                    binding.totalesText.setText("" + totales);
                }
            }
        });

        //CARISMA
        binding.carismaText.setText("" + carisma);
        binding.carismaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    carisma++;
                    totales--;
                    binding.carismaText.setText("" + carisma);
                    binding.totalesText.setText("" + totales);
                }
            }
        });
        binding.carismaMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (carisma > 0) {
                    carisma--;
                    totales++;
                    binding.carismaText.setText("" + carisma);
                    binding.totalesText.setText("" + totales);
                }
            }
        });

        //SUERTE
        binding.suerteText.setText("" + suerte);
        binding.suerteMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totales > 0) {
                    suerte++;
                    totales--;
                    binding.suerteText.setText("" + suerte);
                    binding.totalesText.setText("" + totales);
                }
            }
        });
        binding.suerteMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (suerte > 0) {
                    suerte--;
                    totales++;
                    binding.suerteText.setText("" + suerte);
                    binding.totalesText.setText("" + totales);
                }
            }
        });

        binding.create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.nombre.getText().toString();

                ((GlobalPlayer)getActivity().getApplication()).setPlayer(new Player(nombre,fuerza,destreza,inteligencia,constitucion,suerte,carisma));

                navController.navigate(R.id.action_global_mapFragment);
            }
        });
    }

}