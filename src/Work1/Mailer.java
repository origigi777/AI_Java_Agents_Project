package Work1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mailer {

    private final HashMap<Integer, List<BaseMessage>> mReciverMessageHashMap = new HashMap<>();

    public Mailer(int numberOfAgents) {
        for (int i = 0; i < numberOfAgents; i++) {
            mReciverMessageHashMap.put(i, new ArrayList<>());
        }
    }

    public void sendMessage(int receiver, BaseMessage m) {
        List<BaseMessage> listOfMessage = mReciverMessageHashMap.get(receiver);
        synchronized (listOfMessage) {
            listOfMessage.add(m);
        }
    }

    public BaseMessage readMessage(int receiver) {
        List<BaseMessage> l = mReciverMessageHashMap.get(receiver);
        if (l.isEmpty()) {
            return null;
        }
        synchronized (l) {
            BaseMessage m = l.get(0);
            l.remove(0);
            return m;
        }
    }

}
