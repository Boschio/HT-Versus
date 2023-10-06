package player;

import util.HitBox;
import util.io.KL;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AttackState implements State{
    @Override
    public void enter(Player player) {

    }

    @Override
    public void exit() {

    }

    @Override
    public State input(KL e) {
        return null;
    }

    @Override
    public State update(Player player, double deltaTime) {
        HandleAttack(player);
        return new IdleState();
    }

    private void HandleAttack(Player player){
        player.isAttacking = true;
//        HitBox h = new HitBox((int) player.x + PlayerConstants.PLAYER_WIDTH,(int) player.y + 50,150,70, Color.RED);
//
//        return h;
    }
}
