package task_2.patterns.Singleton;

public class Singleton {

        private static Singleton uniqInstance;
        private Singleton(){}

        public static Singleton getInstance(){
            if (uniqInstance==null)uniqInstance=new Singleton();
            return uniqInstance;
        }

}
