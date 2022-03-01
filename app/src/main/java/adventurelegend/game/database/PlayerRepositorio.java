package adventurelegend.game.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import adventurelegend.game.objetcs.Player;

public class PlayerRepositorio {

    AdventureRoomDatabase.ElementosDao playersDao;
    Executor executor = Executors.newSingleThreadExecutor();

    PlayerRepositorio(Application application){
        playersDao = AdventureRoomDatabase.obtenerInstancia(application).obtenerElementosDao();
    }


    LiveData<List<Player>> obtener(){
        return playersDao.obtenerPlayer();
    }


    void insertar(Player player){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                playersDao.insertarPlayer(player);
            }
        });
    }

    void actualizar(Player player){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                playersDao.actualizarPlayer(player);
            }
        });
    }

    void eliminar(Player player) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                playersDao.eliminarPlayer(player);
            }
        });
    }
}
