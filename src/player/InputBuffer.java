package player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputBuffer {
    public List<String> buffer;
    private final int bufferSize = 5;

    private Map<String, Long> inputCooldowns;
    private static final long COOLDOWN_DURATION = 200; // in milliseconds

    public InputBuffer() {
        this.buffer = new ArrayList<>();
        this.inputCooldowns = new HashMap<>();
    }

    public void addInput(String input) {
        long currentTime = System.currentTimeMillis();

        // Check if the input has a cooldown period
        if (hasCooldown(input, currentTime)) {
            return;
        }

        buffer.add(input);

        // Trim the buffer if it exceeds the specified size
        if (buffer.size() > bufferSize) {
            buffer.remove(0);
        }

        // Set the cooldown for the input
        setInputCooldown(input, currentTime);
    }

    private boolean hasCooldown(String input, long currentTime) {
        if (inputCooldowns.containsKey(input)) {
            long lastInputTime = inputCooldowns.get(input);
            return currentTime - lastInputTime < COOLDOWN_DURATION;
        }
        return false;
    }

    private void setInputCooldown(String input, long currentTime) {
        inputCooldowns.put(input, currentTime);
    }

    public boolean isInputSequence(String... sequence) {
        // Check if the input buffer contains the specified sequence
        if (buffer.size() < sequence.length) {
            return false;
        }

        for (int i = 0; i < sequence.length; i++) {
            if (!buffer.get(i).equals(sequence[i])) {
                return false;
            }
        }

        return true;
    }

    public void clearBuffer() {
        buffer.clear();
    }
}
