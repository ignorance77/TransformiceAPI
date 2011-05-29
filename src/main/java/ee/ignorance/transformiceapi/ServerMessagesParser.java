package ee.ignorance.transformiceapi;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import ee.ignorance.transformiceapi.protocol.server.FriendJoinResponse;
import ee.ignorance.transformiceapi.protocol.server.FriendListResponse;
import ee.ignorance.transformiceapi.protocol.server.IntroduceResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginFailedResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginSuccessResponse;
import ee.ignorance.transformiceapi.protocol.server.ModChatResponse;
import ee.ignorance.transformiceapi.protocol.server.MusicUrlResponse;
import ee.ignorance.transformiceapi.protocol.server.PlayerProfileResponse;
import ee.ignorance.transformiceapi.protocol.server.PrivateChatResponse;
import ee.ignorance.transformiceapi.protocol.server.Processable;
import ee.ignorance.transformiceapi.protocol.server.RoomChatResponse;
import ee.ignorance.transformiceapi.protocol.server.RoomResponse;
import ee.ignorance.transformiceapi.protocol.server.ShamanStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.StartGameResponse;
import ee.ignorance.transformiceapi.protocol.server.SyncStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.TZATResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeListResponse;
import ee.ignorance.transformiceapi.protocol.server.TribePlayerResponse;
import ee.ignorance.transformiceapi.protocol.server.UrlResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseBalloonResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseCrouchResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseDeathResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseEmoteResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseFinishResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseGotCheeseResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseJoinRoomResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseLeaveRoomResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseListResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseMoveResponse;

public class ServerMessagesParser {
		private final static String separator = String.valueOf((char) 0x01);
	
        public static Processable parse(byte[] message) throws IOException {
                DataInputStream stream = new DataInputStream(new ByteArrayInputStream(message));
                byte b1 = stream.readByte();
                byte b2 = stream.readByte();

                if (b1 == 1) {
                        if (b2 == 1) {
                        		String msg = stream.readUTF();
                                
                                int codeMajor = msg.charAt(0);
                                int codeMinor = msg.charAt(1);
                                String[] data = msg.split(separator, -1);
                                
                                List<String> rawMessage = Arrays.asList(data);

                                if (codeMajor == 4) {
                                        if (codeMinor == 9) {
                                                return new MouseCrouchResponse(rawMessage);
                                        }
                                }
                                if (codeMajor == 5) {
                                        if (codeMinor == 5) {
                                                return new StartGameResponse(rawMessage);
                                        }
                                        if (codeMinor == 19) {
                                                return new MouseGotCheeseResponse(rawMessage);
                                        }
                                        if (codeMinor == 21) {
                                                return new RoomResponse(rawMessage);
                                        }
                                }
                                if (codeMajor == 8) {
                                        if (codeMinor == 5) {
                                                return new MouseDeathResponse(rawMessage);
                                        }
                                        if (codeMinor == 6) {
                                                return new MouseFinishResponse(rawMessage);
                                        }
                                        if (codeMinor == 7) {
                                                return new MouseLeaveRoomResponse(rawMessage);
                                        }
                                        if (codeMinor == 8) {
                                                return new MouseJoinRoomResponse(rawMessage);
                                        }
                                        if (codeMinor == 9) {
                                                return new MouseListResponse(rawMessage);
                                        }
                                        if (codeMinor == 10) {
                                                return new PlayerProfileResponse(rawMessage);
                                        }
                                        if (codeMinor == 11) {
                                                return new FriendJoinResponse(rawMessage);
                                        }
                                        if (codeMinor == 12) {
                                                return new FriendListResponse(rawMessage);
                                        }
                                        if (codeMinor == 16) {
                                                return new MouseBalloonResponse(rawMessage);
                                        }
                                        if (codeMinor == 21) {
                                                return new SyncStatusResponse(rawMessage);
                                        }
                                        if (codeMinor == 20) {
                                                return new ShamanStatusResponse(rawMessage);
                                        }
                                        if (codeMinor == 22) {
                                                return new MouseEmoteResponse(rawMessage);
                                        }
                                }
                                if (codeMajor == 16) {
                                        if (codeMinor == 4) {
                                                return new TribePlayerResponse(rawMessage);
                                        }
                                        if (codeMinor == 16) {
                                                return new TribeListResponse(rawMessage);
                                        }
                                }
                                if (codeMajor == 26) {
                                        if (codeMinor == 3) {
                                                return new LoginFailedResponse();
                                        }
                                        if (codeMinor == 8) {
                                                return new LoginSuccessResponse(rawMessage);
                                        }
                                        if (codeMinor == 12) {
                                                return new MusicUrlResponse(rawMessage);
                                        }
                                        if (codeMinor == 22) {
                                                return new IntroduceResponse(rawMessage);
                                        }
                                        if (codeMinor == 27) {
                                                return new UrlResponse(rawMessage);
                                        }
                                        if (codeMinor == 26) {
                                                return new TZATResponse();
                                        }
                                }
                        }
                }
                if (b1 == 4) {
                        if (b2 == 4) {
                                return new MouseMoveResponse(stream);
                        }
                }
                if (b1 == 6) {
                        if (b2 == 6) {
                                return new RoomChatResponse(stream);
                        }
                        if (b2 == 7) {
                                return new PrivateChatResponse(stream);
                        }
                        if (b2 == 8) {
                                return new TribeChatResponse(stream);
                        }
                        if (b2 == 10) {
                                return new ModChatResponse(stream);
                        }
                }
                return null;
        }
}
