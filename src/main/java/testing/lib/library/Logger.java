package testing.lib.library;

import java.util.HashMap;

/**
 * Created by Yun on 1/17/2017.
 */
public class Logger {

    HashMap<String, Integer> last;

    /** Initialize your data structure here. */
    public Logger() {
        last = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!last.containsKey(message)) {
            last.put(message, timestamp);
            return true;
        } else {
            int lastTs = last.get(message);
            if (timestamp - lastTs >= 10) {
                last.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}
