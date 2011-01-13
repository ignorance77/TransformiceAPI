package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginFailedResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginSuccessResponse;
import ee.ignorance.transformiceapi.protocol.server.MapXMLResponse;
import ee.ignorance.transformiceapi.protocol.server.ModChatMessageResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseFinishResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseListResponse;
import ee.ignorance.transformiceapi.protocol.server.NormalChatResponse;
import ee.ignorance.transformiceapi.protocol.server.PrivateChatResponse;
import ee.ignorance.transformiceapi.protocol.server.RoomResponse;
import ee.ignorance.transformiceapi.protocol.server.ShamanStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.StartGameResponse;
import ee.ignorance.transformiceapi.protocol.server.SyncStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.TZATResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatResponse;

public abstract class CommandProcessor {

	public static CommandProcessor create(AbstractResponse command) {
		if (command instanceof RoomResponse) {
			return new RoomResponseProcessor();
		}
		if (command instanceof StartGameResponse) {
			return new StartGameResponseProcessor();
		}
		if (command instanceof TZATResponse) {
			return new TZATResponseProcessor();
		}
		if (command instanceof MouseListResponse) {
			return new MouseListProcessor();
		}
		if (command instanceof LoginSuccessResponse) {
			return new LoginSuccessProcessor();
		}
		if (command instanceof LoginFailedResponse) {
			return new LoginFailedProcessor();
		}
		if (command instanceof SyncStatusResponse) {
			return new SyncStatusProcessor();
		}
		if (command instanceof ShamanStatusResponse) {
			return new ShamanStatusProcessor();
		}
                if (command instanceof NormalChatResponse) {
			return new NormalChatProcessor();
		}
                if (command instanceof TribeChatResponse) {
			return new TribeChatProcessor();
		}
                if (command instanceof PrivateChatResponse) {
			return new PrivateChatProcessor();
		}
                if (command instanceof ModChatMessageResponse) {
			return new ModChatMessageProcessor();
		}
                if (command instanceof MouseFinishResponse) {
                        return new MouseFinishProcessor();
                }

                if (command instanceof MapXMLResponse) {
                        return new MapXMLProcessor();
                }
		return null;
	}
	
	public abstract void process(AbstractResponse command, Player player);
	
}
