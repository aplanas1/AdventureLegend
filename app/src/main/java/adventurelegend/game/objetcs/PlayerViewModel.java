package adventurelegend.game.objetcs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PlayerViewModel extends AndroidViewModel  {

    PlayerRepositorio playerRepositorio;

    MutableLiveData<Player> playerSeleccionado = new MutableLiveData<>();


    public PlayerViewModel(@NonNull Application application) {
        super(application);

        playerRepositorio = new PlayerRepositorio(application);
    }


    public LiveData<List<Player>> obtener(){
        return playerRepositorio.obtener();
    }

    public void insertar(Player player){
        playerRepositorio.insertar(player);
    }

    public void eliminar(Player player){
        playerRepositorio.eliminar(player);
    }

    public void seleccionar(Player player){
        playerSeleccionado.setValue(player);
    }

    public MutableLiveData<Player> seleccionado(){
        return playerSeleccionado;
    }
}
