package Project14;

public class CloseableLogger {
    private static CloseableLogger singleton;  // Singleton Logger object

    // Return the singleton Logger
    public static CloseableLogger getLogger() {
        if (singleton == null)
            singleton = new CloseableLogger();   // Lazy creation of singleton
        return singleton;
    }


    private static void close() {
        if(singleton != null) {
            System.err.println("Closing after " + singleton.counter + " messages");
            singleton = null;
        }
    }


    private int counter;

    public CloseableLogger() {
        System.err.printf("Initiating Logging\n");
    }

    public void log(String format, Object... args) {
        counter++;
        System.err.print("Log " + counter + ": ");
        System.err.printf(format + "\n", args);
    }

    public static void main(String[] args) {
        CloseableLogger.getLogger().log("Message 1");
        CloseableLogger.getLogger().log("Message 2");
        CloseableLogger.close();
        CloseableLogger.getLogger().log("Message 3");
        CloseableLogger.getLogger().log("Message 4");
        CloseableLogger.close();
        CloseableLogger.close();  // Should do nothing
        CloseableLogger.getLogger().log("Message 5");
        CloseableLogger.getLogger().log("Message 6");
        CloseableLogger.getLogger().log("Message 7");
        CloseableLogger.close();
        CloseableLogger.close();  // Should do nothing
        CloseableLogger.close();  // Should do nothing
        CloseableLogger.getLogger().log("Message 8");
        CloseableLogger.getLogger().log("Message 9");
    }
} 