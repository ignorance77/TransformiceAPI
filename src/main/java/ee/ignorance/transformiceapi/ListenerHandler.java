package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.listeners.NormalChatListener;
import ee.ignorance.transformiceapi.listeners.TribeChatListener;
import java.util.ArrayList;


public class ListenerHandler {
    
    private ArrayList<NormalChatListener> normalChatListeners;
    private ArrayList<TribeChatListener> tribeChatListeners;

    public ListenerHandler(){
        normalChatListeners = new ArrayList<NormalChatListener>();
        tribeChatListeners = new ArrayList<TribeChatListener>();
    }
    
    
    public void registerNormalChatListener(NormalChatListener listener) {
        normalChatListeners.add(listener);
    }

    public void notifyNormalChatListeners(String sender, String message) {
        for (NormalChatListener listener : normalChatListeners) {
            listener.processNormalChatMessage(sender, message);
        }
    }
    
    public void registerTribeChatListener(TribeChatListener listener) {
        tribeChatListeners.add(listener);
    }

    public void notifyTribeChatListeners(String sender, String message) {
        for (TribeChatListener listener : tribeChatListeners) {
            listener.processTribeChatMessage(sender, message);
        }
    }


}
