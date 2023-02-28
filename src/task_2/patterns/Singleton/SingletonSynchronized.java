package task_2.patterns.Singleton;

public class SingletonSynchronized {
    private static SingletonSynchronized instance;

    public static synchronized SingletonSynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}
