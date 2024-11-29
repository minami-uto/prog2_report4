package jp.ac.uryukyu.ie.e245755;

public class Warrior extends Hero{ //Heroの上位職
    public Warrior(String name, int hitPoint, int attack){
        super(name, hitPoint, attack);
    }

    //敵への攻撃
    public void attackWithWeponSkill(LivingThing opponent){
        if(getHitPoint() >= 0){
            double attackDamage = 1.5;
            int damage = (int)( attackDamage * getAttack());
            System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
        }

    }
    
}
