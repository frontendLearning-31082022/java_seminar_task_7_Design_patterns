package task_2.patterns.Singleton;

public class SingletonSynchroVolatile {
    private static volatile SingletonSynchroVolatile instance;

    public static SingletonSynchroVolatile getInstance() {
        SingletonSynchroVolatile localInstance = instance;
        if (localInstance == null) {
            synchronized (SingletonSynchroVolatile.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingletonSynchroVolatile();
                }
            }
        }
        return localInstance;
    }
}