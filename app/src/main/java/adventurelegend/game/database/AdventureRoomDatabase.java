package adventurelegend.game.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

import adventurelegend.game.objetcs.Armor;
import adventurelegend.game.objetcs.Casilla;
import adventurelegend.game.objetcs.Inventory;
import adventurelegend.game.objetcs.Map;
import adventurelegend.game.objetcs.Player;
import adventurelegend.game.objetcs.Potion;
import adventurelegend.game.objetcs.Special;
import adventurelegend.game.objetcs.Weapon;

// https://www.youtube.com/watch?v=K8yKH5Ak84E <---- IMPORTANTE VER, COMO HACER RELACIONES 1-N EN ROOM
@Database(entities = {Player.class, Inventory.class, Weapon.class, Armor.class, Potion.class, Special.class, Map.class, Casilla.class}, version = 1, exportSchema = false)
public abstract class AdventureRoomDatabase extends RoomDatabase {

    public abstract ElementosDao obtenerElementosDao();

    private static volatile AdventureRoomDatabase INSTANCIA;

    static AdventureRoomDatabase obtenerInstancia(final Context context) {
        if (INSTANCIA == null) {
            synchronized (AdventureRoomDatabase.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context,
                            AdventureRoomDatabase.class, "adventurelegend.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);

                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCIA;
    }

    @Dao
    interface ElementosDao {
        //PLAYER
        @Query("SELECT * FROM Player")
        LiveData<List<Player>> obtenerPlayer();
        @Insert
        void insertarPlayer(Player player);
        @Update
        void actualizarPlayer(Player player);
        @Delete
        void eliminarPlayer(Player player);

        //INVENTORY
        @Query("SELECT * FROM Inventory")
        LiveData<List<Inventory>> obtenerInventory();
        @Insert
        void insertarInventory(Inventory inventory);
        @Update
        void actualizarInventory(Inventory inventory);
        @Delete
        void eliminarInventory(Inventory inventory);

        //WEAPON
        @Query("SELECT * FROM Weapon")
        LiveData<List<Weapon>> obtenerWeapon();
        @Insert
        void insertarWeapon(Weapon weapon);
        @Update
        void actualizarWeapon(Weapon weapon);
        @Delete
        void eliminarWeapon(Weapon weapon);

        //ARMOR
        @Query("SELECT * FROM Armor")
        LiveData<List<Armor>> obtenerArmor();
        @Insert
        void insertarArmor(Armor armor);
        @Update
        void actualizarArmor(Armor armor);
        @Delete
        void eliminarArmor(Armor armor);

        //POTION
        @Query("SELECT * FROM Potion")
        LiveData<List<Potion>> obtenerPotion();
        @Insert
        void insertarPotion(Potion potion);
        @Update
        void actualizarPotion(Potion potion);
        @Delete
        void eliminarPotion(Potion potion);

        //SPECIAL
        @Query("SELECT * FROM Special")
        LiveData<List<Special>> obtenerSpecial();
        @Insert
        void insertarSpecial(Special special);
        @Update
        void actualizarSpecial(Special special);
        @Delete
        void eliminarSpecial(Special special);

        //MAP
        @Query("SELECT * FROM Map")
        LiveData<List<Map>> obtenerMap();
        @Insert
        void insertarMap(Map map);
        @Update
        void actualizarMap(Map map);
        @Delete
        void eliminarMap(Map map);

        //CASILLA
        @Query("SELECT * FROM Map")
        LiveData<List<Casilla>> obtenerCasilla();
        @Insert
        void insertarCasilla(Casilla casilla);
        @Update
        void actualizarCasilla(Casilla casilla);
        @Delete
        void eliminarCasilla(Casilla casilla);
    }

}
