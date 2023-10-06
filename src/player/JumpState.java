package player;

import util.io.KL;

import java.awt.event.KeyEvent;

public class JumpState implements State {
    @Override
    public void enter() {

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
        jump(player, 1);

        if (player.vy < 0) {
            while (player.vy <= 0) {
                System.out.println(player.vy);
                jump(player, 0);
            }
//            move(player);
//            return new JumpState();
        }
        return new IdleState();
    }

    private void jump(Player player, double dy) {
        // y = a(x-h)2 + k, where h is the vertex or x^2 = -4ay
        player.vy -= dy;
        player.y += player.vy;
        player.vy += player.ay;
        if (player.y + PlayerConstants.PLAYER_HEIGHT >= PlayerConstants.FLOOR) {
            pushAbove(player, PlayerConstants.FLOOR);
            stopFalling(player);
        }
    }

//    public void move(Player player) {
//        player.y += player.vy;
//        player.vy += player.ay;
//        if (player.y + PlayerConstants.PLAYER_HEIGHT >= PlayerConstants.FLOOR) {
//            pushAbove(player, PlayerConstants.FLOOR);
//            stopFalling(player);
//        }
//
//    }
    public void stopFalling(Player player) {
        player.vy = 0;
    }

    public void pushAbove(Player player, double floor) {
        player.y = floor - PlayerConstants.PLAYER_HEIGHT - 1;
    }

}
