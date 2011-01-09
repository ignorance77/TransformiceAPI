package ee.ignorance.transformiceapi;

import java.util.ArrayList;
import java.util.List;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.IntroduceResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginFailedResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginSuccessResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseListResponse;
import ee.ignorance.transformiceapi.protocol.server.NormalChatResponse;
import ee.ignorance.transformiceapi.protocol.server.PrivateChatResponse;
import ee.ignorance.transformiceapi.protocol.server.RoomResponse;
import ee.ignorance.transformiceapi.protocol.server.ShamanStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.StartGameResponse;
import ee.ignorance.transformiceapi.protocol.server.SyncStatusResponse;
import ee.ignorance.transformiceapi.protocol.server.TZATResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatResponse;
import ee.ignorance.transformiceapi.protocol.server.URLResponse;

public class ServerMessagesParser {

	public static AbstractResponse parse(byte[] bytes) {
		List<String> rawMessage = split(bytes);
		int codeMajor = (int) rawMessage.get(0).charAt(0);
		int codeMinor = (int) rawMessage.get(0).charAt(1);
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
		}
		if (codeMajor == 5) {
			if (codeMinor == 21) {
				return new RoomResponse(rawMessage);
			}
			if (codeMinor == 5) {
				return new StartGameResponse(rawMessage);
			}
		}
                if (codeMajor == 6){
                        if(codeMinor == 6){ //Normal chat message
                            return new NormalChatResponse(rawMessage);
                        }
                        if(codeMinor == 7){ //private chat message
                            return new PrivateChatResponse(rawMessage);
                        }
                }
		if (codeMajor == 8) {
			if (codeMinor == 9) {
				return new MouseListResponse(rawMessage);
			}
			if (codeMinor == 21) {
				return new SyncStatusResponse(rawMessage);
			}
			if (codeMinor == 20) {
				return new ShamanStatusResponse(rawMessage);
			}
		}
                if (codeMajor == 16){
                        if(codeMinor == 5){ //Tribe message
                            return new TribeChatResponse(rawMessage);
                        }
                }
		return null;
	}

	private static List<String> split(byte[] bytes) {
		List<String> ret = new ArrayList<String>();
		StringBuffer current = new StringBuffer();
		for (int i = 0; i <= bytes.length; i++) {
			if ((i == bytes.length) || bytes[i] == 1) {
				if (current.length() > 0) {
					ret.add(current.toString());
					current = new StringBuffer();
				}
			} else {
				current.append((char)bytes[i]);
			}
		}
		return ret;
	}

}
