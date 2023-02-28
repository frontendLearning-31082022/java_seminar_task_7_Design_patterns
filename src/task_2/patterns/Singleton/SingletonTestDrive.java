package task_2.patterns.Singleton;

public class SingletonTestDrive {
//    https://habr.com/ru/post/129494/
    public static void main(String[] args) {
        Singleton singletonTry1=Singleton.getInstance();
        Singleton singletonTry2=Singleton.getInstance();

        SingletonSynchroVolatile singletonSynchroVolatileTry1= SingletonSynchroVolatile.getInstance();
        SingletonSynchroVolatile singletonSynchroVolatileTry2= SingletonSynchroVolatile.getInstance();

        SingletonStaticField statFieldTry1=SingletonStaticField.INSTANCE;
        SingletonStaticField statFieldTry2=SingletonStaticField.INSTANCE;

        SingletonEnum singletonEnumTry1=SingletonEnum.INSTANCE;
        SingletonEnum singletonEnumTry2=SingletonEnum.INSTANCE;

        SingletonSynchronized singletonSynchronizedTry1=SingletonSynchronized.getInstance();
        SingletonSynchronized singletonSynchronizedTry2=SingletonSynchronized.getInstance();

        SingletonSynchroVolatile singletonSynchroVolatilTry1=SingletonSynchroVolatile.getInstance();
        SingletonSynchroVolatile singletonSynchroVolatilTry2=SingletonSynchroVolatile.getInstance();
    }
}
