package player;

public class InputBuffer {
    int bufferSize = 20;
    int[] buffer = new int[bufferSize];

    // Offset for the current input in the buffer.
    int currentTick = 0;

    // maxDuration must be <= bufferSize
    public boolean checkSequence(int[] sequence, int maxDuration) {
        int w = sequence.length-1;

        for(int i=0; i<maxDuration; ++i) {
            int direction = buffer[(currentTick-i+bufferSize) % bufferSize];

            if(direction == sequence[w])
                --w;
            if(w == -1)
                return true;
        }

        return false;
    }

}
