package adventurelegend.game.objects;

public class Enemy {
    private String name;
    private int image;
    private int hp;
    private int damage;
    private int defense;
    private boolean death;
    private int xp;

    public Enemy(String name, int image, int hp, int damage, int defense, int xp) {
        this.name = name;
        this.image = image;
        this.hp = hp;
        this.damage = damage;
        this.defense = defense;
        this.death = false;
    }

    public void reciveDamage(int recived) {
        this.hp -= recived - defense;
        if (hp <= 0) setDeath();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath() {
        this.death = true;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
