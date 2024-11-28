package jp.ac.uryukyu.ie.e245755;

/**
 * 生物共通クラス。
 *  String name; //敵・Heroの名前
 *  int hitPoint; //敵・HeroのHP
 *  int attack; //敵・Heroの攻撃力
 *  boolean dead; //敵・Heroの生死状態。true=死亡。
 * Created by uto on 2024/11/25.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing(String _name, int _hitPoint, int _attack, boolean _dead){
        this.setName(_name);
        this.setHitPoint(_hitPoint);
        this.setAttack(_attack);
        this.setDead(_dead);
    }

    public void setName(String _name){this.name = _name;}
    public void setHitPoint(int _hitPoint){this.hitPoint = _hitPoint;}
    public void setAttack(int _attack){this.attack = _attack;}
    public void setDead(boolean _dead){this.dead = _dead;}

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    //deadのgetter method
    public boolean isDead(){return this.dead;}

    public String getName(){return this.name;}
    public int getHitPoint(){return this.hitPoint;}

    /**
     * 敵・Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(hitPoint >= 0){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", getName());
        }
    }
}