package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;
import ee.ignorance.transformiceapi.shop.Item;

public class EquipItemRequest implements StringMessageRequest {
	private Item item;
	
	public EquipItemRequest(Item item) {
		this.item = item;
	}
	
    @Override
    public byte[] getBytes() {
            ByteBuffer bf = new ByteBuffer();
            bf.write(0x14);
            bf.write(0x11);
            bf.write(0x01);
            bf.print(String.valueOf(item.getId()));
            return bf.getBytes();
    }
}
