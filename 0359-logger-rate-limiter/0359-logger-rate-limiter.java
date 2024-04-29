class Logger {
    HashMap<String,Integer> lastSeen;
    public Logger() {
        lastSeen = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(lastSeen.containsKey(message) && timestamp - lastSeen.get(message) < 10)
        {
            return false;
        }
        else
        {
            lastSeen.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */