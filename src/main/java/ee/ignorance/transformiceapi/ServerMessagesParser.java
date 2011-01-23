package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.FriendJoinResponse;
import ee.ignorance.transformiceapi.protocol.server.IntroduceResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginFailedResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginSuccessResponse;
import ee.ignorance.transformiceapi.protocol.server.ModChatMessageResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseDeathResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseFinishResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseGotCheeseResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseListResponse;
import ee.ignorance.transformiceapi.protocol.server.NormalChatResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseMovedResponse;
import ee.ignorance.transformiceapi.protocol.server.PrivateChatResponse;
import ee.ignorance.transformiceapi.protocol.server.RoomResponse;
import ee.ignorance.transformiceapi.protocol.server.ShamanStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.StartGameResponse;
import ee.ignorance.transformiceapi.protocol.server.SyncStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.TZATResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatMessageResponse;
import ee.ignorance.transformiceapi.protocol.server.TribePlayerResponse;
import ee.ignorance.transformiceapi.protocol.server.URLResponse;

public class ServerMessagesParser {

	public static AbstractResponse parse(byte[] message) throws IOException {
		DataInputStream stream = new DataInputStream(new ByteArrayInputStream(message));
		byte b1 = stream.readByte();
		byte b2 = stream.readByte();
                byte b3 = stream.readByte();
		byte b4 = stream.readByte();
		int codeMajor = stream.readByte();
		int codeMinor = stream.readByte();
		List<Byte> bytes = new ArrayList<Byte>();
		while (stream.available() > 0) {
			byte b = stream.readByte();
			bytes.add(b);
		}
		List<String> rawMessage = split(bytes);
		rawMessage.add(0, "");
                if(b1 == 4 && b2 == 4)
                {
                        ByteBuffer b = new ByteBuffer();
                        b.write(b3);
                        b.write(b4);
                        b.write(codeMajor);
                        b.write(codeMinor);
                        for(int i=0;i<bytes.size();i++)
                                b.write(bytes.get(i));
                        ArrayList<String> m = new ArrayList<String>();
                        m.add(new String(b.getBytes()));
                        return new MouseMovedResponse(m);
                }
		if (codeMajor == 26) {
			if (codeMinor == 22) {
				return new IntroduceResponse(rawMessage);
			}
			if (codeMinor == 27) {
				return new URLResponse(rawMessage);
			}
			if (codeMinor == 3) {
				return new LoginFailedResponse(rawMessage);
			}
			if (codeMinor == 8) {
				return new LoginSuccessResponse(rawMessage);
			}
			if (codeMinor == 26) {
				return new TZATResponse(rawMessage);
			}
                        if (codeMinor == 4) {
				return new ModChatMessageResponse(rawMessage);
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
                if (codeMajor == 6){
                        if(codeMinor == 6){
                            return new NormalChatResponse(rawMessage);
                        }
                        if(codeMinor == 7){
                            return new PrivateChatResponse(rawMessage);
                        }
                }
		if (codeMajor == 8) {
                        if (codeMinor == 5) {
                                return new MouseDeathResponse(rawMessage);
                        }
                        if (codeMinor == 6) {
                                return new MouseFinishResponse(rawMessage);
                        }
			if (codeMinor == 9) {
				return new MouseListResponse(rawMessage);
			}
                        if (codeMinor == 11) {
				return new FriendJoinResponse(rawMessage);
			}
			if (codeMinor == 21) {
				return new SyncStatusResponse(rawMessage);
			}
			if (codeMinor == 20) {
				return new ShamanStatusResponse(rawMessage);
			}
		}
                if (codeMajor == 16){
                        if(codeMinor == 4){
                            return new TribePlayerResponse(rawMessage);
                        }
                        if(codeMinor == 5){
                            return new TribeChatMessageResponse(rawMessage);
                        }
                }
		return null;
	}
	
	private static List<String> split(List<Byte> bytes) {
		List<String> ret = new ArrayList<String>();
		StringBuffer current = new StringBuffer();
		for (int i = 0; i <= bytes.size(); i++) {
			if ((i == bytes.size()) || bytes.get(i) == 1) {
				if (current.length() > 0) {
                                        if(current.charAt(current.length()-1)==0 && current.length()>1)
                                        {
                                                ret.add(current.toString().substring(0, current.length()-2));
                                        }
                                        else
                                        {
                                                ret.add(current.toString());
                                        }
					current = new StringBuffer();
				}
			} else {
				current.append((char)bytes.get(i).byteValue());
			}
		}
		return ret;
	}

}
