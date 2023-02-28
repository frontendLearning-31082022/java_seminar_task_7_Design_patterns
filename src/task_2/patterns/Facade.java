package task_2.patterns;

import java.util.ArrayList;
import java.util.Locale;

public class Facade {


    class Client {
        static ArrayList<String> getNewMessages() {
            Server server = new Server("172.432.....");
            String[][] raw = server.getData(2);
            String[][] data = Parser.decode("server 8");
            LocalModule localModule = new LocalModule();
            localModule.checkReqs(data);
            data = XMLformData.makeData();

            ArrayList<String>outPut=new ArrayList<>();
            for (int i = 0; i < data.length; i++) {
                outPut.add(data[6][0]);
            }

            return outPut;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> newMsgs = Client.getNewMessages();
    }

    private static class Server {
        public Server(String s) {
        }

        public String[][] getData(int daysPeriod) {
            return null;
        }
    }

    private static class Parser {
        public static String[][] decode(String s) {
            return null;
        }
    }

    private static class LocalModule {
        public void checkReqs(String[][] data) {
        }
    }

    private static class XMLformData {
        public static String[][] makeData() {
            return null;
        }
    }
}
