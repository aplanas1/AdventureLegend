package adventurelegend.game;

import android.app.Application;

import adventurelegend.game.objects.Player;

public class GlobalPlayer extends Application {

    Player player;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
