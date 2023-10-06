package player;

import util.io.KL;

import java.awt.event.KeyEvent;

public class JumpState implements State {
    @Override
    public void enter(Player player) {
        if (player.keyListener.isKeyDown(KeyEvent.VK_W) && player.keyListener.isKeyDown(KeyEvent.VK_D)) jump(player, player.jumpHeight, 10);
        else if (player.keyListener.isKeyDown(KeyEvent.VK_W) && player.keyListener.isKeyDown(KeyEvent.VK_A)) jump(player, player.jumpHeight, -10);
        else jump(player, player.jumpHeight, 0);
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
        player.x += player.vx;
        player.y += player.vy;
        player.vy += player.ay;
        if (player.y + PlayerConstants.PLAYER_HEIGHT >= PlayerConstants.FLOOR) {
            pushAbove(player, PlayerConstants.FLOOR);
            stopFalling(player);
            return new IdleState();
        }
        return null;
    }

    private void jump(Player player, double dy, double dx) {
        // y = a(x-h)2 + k, where h is the vertex or x^2 = -4ay
        player.vy -= dy;
        player.vx = dx;
    }

    public void stopFalling(Player player) {
        player.vx = 0;
        player.vy = 0;
    }

    public void pushAbove(Player player, double floor) {
        player.y = floor - PlayerConstants.PLAYER_HEIGHT - 1;
    }

}
