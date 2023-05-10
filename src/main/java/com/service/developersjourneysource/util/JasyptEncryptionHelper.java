package com.service.developersjourneysource.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;

public class JasyptEncryptionHelper {

	public static void main(String[] args) {
		StandardPBEStringEncryptor encryptor= new StandardPBEStringEncryptor();
				encryptor.setPassword("IamBatman@07");
				encryptor.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
				encryptor.setProvider(new BouncyCastleProvider());
				encryptor.setIvGenerator(new RandomIvGenerator());
				String encrypt = encryptor.encrypt("lVBT9l+BBdX8vgV4FwFO963Gu9GhU0IHbc0ePoq8");
				System.err.println(encrypt);
				String decrypt = encryptor.decrypt(encrypt);
				System.err.println(decrypt);
				
	}
}
