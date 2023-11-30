package util;

public class Time {


     public static double timeStarted = System.nanoTime();

     public static int frame = 0; // Tick

     public static double timeSinceLastTick = 0;

     private static double timeBetweenTicks = 1.0/60.0;

     /**
      * <p>
      * Used to determine the time since the program started running
      *</p>
      * @return      util.Time in seconds
      */
     public static double getTime(){return (System.nanoTime() - timeStarted) * 1E-9;}

     public static void setDebugSpeed(double d) {
          timeBetweenTicks = 1.0/d;
     }

     public static void incrementFrame() {
          frame++;
     }

     public static void update(double deltaTime) {
          timeSinceLastTick += deltaTime;
          if (timeSinceLastTick >= timeBetweenTicks) {
               frame++;
               timeSinceLastTick = 0;
          }
     }

}
