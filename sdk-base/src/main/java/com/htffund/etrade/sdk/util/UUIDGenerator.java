package com.htffund.etrade.sdk.util;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public class UUIDGenerator  {
	public static String getID() {
		return StringUtils.remove(UUID.randomUUID().toString(), '-');
	}

	/**简化的ID
	 * @return 指定长度的ID
	 */
	public  static String getShortID(int length){
		UUID uuid = UUID.randomUUID();

        long lsb = uuid.getLeastSignificantBits();
        long msb = uuid.getMostSignificantBits();

        byte[] uuidBytes = ByteBuffer.allocate(16).putLong(msb).putLong(lsb).array();

        // Strip down the '==' at the end and make it url friendly
        //改为自建方法,resin自带版本过低,无encodeBase64URLSafeString
        //return Base64.encodeBase64URLSafeString(uuidBytes).substring(0, length);
        String newStr=new String(Base64.encodeBase64(uuidBytes));
        newStr=newStr.replace("/", "_").replace("+", "-");
         
        if(newStr.length()<length){
        	length=newStr.length();
        }
        
        return newStr.substring(0, length);
	}
	
	public static void main(String[] args) {
		UUID.randomUUID();
		HashMap map =new HashMap();
		long time = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			String id=UUIDGenerator.getShortID(16);
			if(map.containsKey(id)){
				System.out.println(id);
			}
			map.put(id, id);
		}
		time = System.currentTimeMillis() - time;
		System.out.println(time);
	}
}
