package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.FriendJoinResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginFailedResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginSuccessResponse;
import ee.ignorance.transformiceapi.protocol.server.ModChatMessageResponse;
import ee.ignorance.transformiceapi.protocol.server.NormalChatResponse;
import ee.ignorance.transformiceapi.protocol.server.PrivateChatResponse;
import ee.ignorance.transformiceapi.protocol.server.RoomResponse;
import ee.ignorance.transformiceapi.protocol.server.ShamanStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.StartGameResponse;
import ee.ignorance.transformiceapi.protocol.server.SyncStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.TZATResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatMessageResponse;
import ee.ignorance.transformiceapi.protocol.server.TribePlayerResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.*;
import ee.ignorance.transformiceapi.processors.mouse.*;

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
                if (command instanceof TribeChatMessageResponse) {
			return new TribeChatMessageProcessor();
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
                if (command instanceof MouseDeathResponse) {
                        return new MouseDeathProcessor();
                }
                if (command instanceof FriendJoinResponse) {
                        return new FriendJoinProcessor();
                }
                if (command instanceof TribePlayerResponse) {
                        return new TribePlayerProcessor();
                }
                if (command instanceof MouseMovedResponse) {
                        return new MouseMovedProcessor();
                }
                if (command instanceof MouseGotCheeseResponse) {
                        return new MouseGotCheeseProcessor();
                }
                if (command instanceof MouseEmoteResponse) {
                        return new MouseEmoteProcessor();
                }
                if (command instanceof MouseBalloonResponse) {
                        return new MouseBalloonProcessor();
                }
                if (command instanceof MouseJoinRoomResponse) {
                        return new MouseJoinRoomProcessor();
                }
                if (command instanceof MouseLeaveRoomResponse) {
                        return new MouseLeaveRoomProcessor();
                }
		return null;
	}
	
	public abstract void process(AbstractResponse command, PlayerImpl player);
	
}
