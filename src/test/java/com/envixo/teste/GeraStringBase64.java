package com.envixo.teste;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class GeraStringBase64 {

	public static void main(String[] args) throws IOException {
		
		File arquivo1 = new File("teste.txt");
		byte[] arquivo1Bytes = FileUtils.readFileToByteArray(arquivo1);
		String encoded1String = Base64.getEncoder().encodeToString(arquivo1Bytes);
			
		System.out.println(encoded1String);

	}

}
