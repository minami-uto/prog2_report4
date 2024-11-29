package jp.ac.uryukyu.ie.e245755;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    /*
     * attackWithWeponSkillにてattackの150%ダメージになっていることの検証。
     * Warriorクラスからオブジェクトを生成し、attackWithWeponSkillを3回実行し、3回ともattackの150%ダメージになっていることを確認する
     * 検証手順
     *  (1) 上位ヒーローと敵を準備。念の為複数回攻撃を繰り返したいため一撃で倒れない体力を用意する。
     *  (2) 上位ヒーローはattackWithWeponSkillで攻撃。このとき、敵の受けたダメージ量が常に上位ヒーローのattack150%分で固定されていることを期待。
     *  (3) これを３度繰り返す。
     */
    
    @Test
    void attackWithWeponSkillTest(){
        int beforEnemyHP;
        Warrior demoWarrior = new Warrior("デモ上位勇者", 100,100);
        Enemy demoslime = new Enemy("スライムもどき", 1000, 10);

        for (int i=1; i<=3; i++){
            beforEnemyHP = demoslime.getHitPoint();
            demoWarrior.attackWithWeponSkill(demoslime);
            demoslime.attack(demoWarrior);
            assertEquals(demoWarrior.getAttack()*1.5, beforEnemyHP - demoslime.getHitPoint());
        }
    }
}
