package window.stage;

import component.Entity;
import player.Player;
import window.WindowConstants;

public class Camera {

    double x;
    double w;
    double camCenter;
    Entity p1, p2;
    Stage stage;

    public Camera(Player p1, Player p2, Stage stage) {
        this.p1 = p1;
        this.p2 = p2;
        this.stage = stage;

        this.x = 0;
        this.w = WindowConstants.SCREEN_WIDTH;
    }

    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    public void update(double deltaTime) {
        this.camCenter = (this.x + this.w) / 2;

        stage.setBGOffset((int) (p1.originX < p2.originX ? ((p2.originX - p1.originX)/2) : ((p1.originX - p2.originX)/2)));

        this.camCenter = clamp(this.camCenter, 0, (this.stage.bgFront.getImage().getWidth(null) * stage.scale - this.w));

    }

}
