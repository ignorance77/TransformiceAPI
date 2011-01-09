package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.listeners.ModChatListener;
import ee.ignorance.transformiceapi.listeners.NormalChatListener;
import ee.ignorance.transformiceapi.listeners.PrivateChatListener;
import ee.ignorance.transformiceapi.listeners.TribeChatListener;
import java.util.ArrayList;


public class ListenerHandler {
    
    private ArrayList<NormalChatListener> normalChatListeners;
    private ArrayList<TribeChatListener> tribeChatListeners;
    private ArrayList<PrivateChatListener> privateChatListeners;
    private ArrayList<ModChatListener> modChatListeners;

    private Player player;

    public ListenerHandler(Player player){
        normalChatListeners = new ArrayList<NormalChatListener>();
        tribeChatListeners = new ArrayList<TribeChatListener>();
        privateChatListeners = new ArrayList<PrivateChatListener>();
        modChatListeners = new ArrayList<ModChatListener>();

        this.player = player;
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

    public void registerPrivateChatListener(PrivateChatListener listener) {
        privateChatListeners.add(listener);
    }

    public void notifyPrivateChatListeners(String sender, String message) {
        for (PrivateChatListener listener : privateChatListeners) {
            listener.processPrivateChatMessage(sender, message);
        }
    }

    public void registerModChatListener(ModChatListener listener) {
         modChatListeners.add(listener);
    }

    public void notifyModChatListeners(String message) {
        for (ModChatListener listener : modChatListeners) {
            listener.processModChatMessage(message);
        }
    }


}
