package task_2.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Iterator {


    private static class LogEvent {
        String msg;
        Exception expType;

        public LogEvent(String msg, Exception expType) {
            this.msg = msg;
            this.expType = expType;
        }
    }

    private static class LogCollector {
        //      one class all - for clarity
        private LinkedList<LogEvent> collectorObj = new LinkedList<>();

        public LogCollector() {

        }

        void collectNewLogData(LogEvent logEvent) {
            this.collectorObj.add(logEvent);
        }

        java.util.Iterator<LogEvent> getData() {
            return collectorObj.iterator();
        }

        void putAllData(java.util.Iterator<LogEvent> data){

        }

    }

    static class LogAnalizator {
        LogEvent[] tableToAnalyze;

        LogAnalizator(LogEvent[] tableToAnalyze) {
            this.tableToAnalyze=tableToAnalyze;
        }

        public java.util.Iterator<LogEvent> getData() {
            return Arrays.stream(tableToAnalyze).iterator();
        }

        @Override
        public String toString() {
            String res="";
            for (int i = 0; i < this.tableToAnalyze.length; i++)res=res+this.tableToAnalyze[i].msg+"\t";
            return res;
        }

        void putAllData(java.util.Iterator<LogEvent> data){
            ArrayList<LogEvent> inputData=new ArrayList();
            while (data.hasNext())inputData.add(data.next());

            this.tableToAnalyze = Stream.concat(Arrays.stream(this.tableToAnalyze), Arrays.stream(inputData.toArray(new LogEvent[inputData.size()])))
                    .toArray(LogEvent[]::new);

        }
    }


    public static void main(String[] args) {
        LogCollector logCollector = new LogCollector();
        for (int i = 0; i < 5; i++) logCollector.collectNewLogData(new LogEvent("Log " + i, null));

        LogAnalizator logAnalizator = new LogAnalizator(new LogEvent[]{new LogEvent("LogAAA 1", null),
                new LogEvent("LogAAA 2", null),
                new LogEvent("LogAAA 3", null)});


        java.util.Iterator<LogEvent> iterArraylist = logCollector.getData();
        System.out.println("Elements Arraylist");
        while (iterArraylist.hasNext())System.out.print(iterArraylist.next().msg+"\t");

        java.util.Iterator<LogEvent> iterArray = logAnalizator.getData();
        System.out.println("\nElements Array");
        while (iterArray.hasNext())System.out.print(iterArray.next().msg+"\t");

        System.out.println("\nAdding to array elems arraylist");
        logAnalizator.putAllData(logCollector.getData());
        System.out.println(logAnalizator);

    }

}
