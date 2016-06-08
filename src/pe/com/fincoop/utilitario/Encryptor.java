package pe.com.fincoop.utilitario;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.internet.MimeUtility;

public class Encryptor {
	public static void main(String[] args) throws Exception {

		String urltext = "http://www.sunat.gob.pe/cl-at-ittipcam/tcS01Alias";
		URL url = new URL(urltext);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			
		String inputLine;
			
		int day =  Calendar.getInstance().get(Calendar.DAY_OF_MONTH) -1;
		
		List<Double> values =  new ArrayList<Double>();
		
		while ((inputLine = in.readLine()) != null) {
			if(inputLine.indexOf(">"+day+"<") != -1){
				while ((inputLine = in.readLine()) != null) {
					try {
						double dl = Double.parseDouble(inputLine);
						values.add(dl);
						if(values.size() == 2){
							break;
						}
					} catch (Exception e) {}
				}
			
			}
		}
			
		for (Double v : values) {
			
				System.out.println(v);
			
		}
			
			

		
	}

	private final static String keyBuffer = "56af65d2";

	public static byte[] encode(byte[] b) throws Exception {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		OutputStream b64os = MimeUtility.encode(baos, "base64");

		b64os.write(b);

		b64os.close();

		return baos.toByteArray();

	}

	public static byte[] decode(byte[] b) throws Exception {

		ByteArrayInputStream bais = new ByteArrayInputStream(b);

		InputStream b64is = MimeUtility.decode(bais, "base64");

		byte[] tmp = new byte[b.length];

		int n = b64is.read(tmp);

		byte[] res = new byte[n];

		System.arraycopy(tmp, 0, res, 0, n);

		return res;

	}

	private static SecretKeySpec getKey() {

		// keyBuffer = keyBuffer.substring(0, 8);

		SecretKeySpec key = new SecretKeySpec(keyBuffer.getBytes(), "DES");

		return key;

	}

	public static String decrypts(String s) throws Exception {

		String s1 = null;

		if (s.indexOf("{DES}") != -1) {

			String s2 = s.substring("{DES}".length());

			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			cipher.init(2, getKey());

			byte abyte0[] = cipher.doFinal(decode(s2.getBytes()));

			s1 = new String(abyte0);

		} else {

			s1 = s;

		}

		return s1;

	}

	public static String encrypts(String s) throws Exception {

		byte abyte0[];

		SecureRandom securerandom = new SecureRandom();

		securerandom.nextBytes(keyBuffer.getBytes());

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

		cipher.init(1, getKey());

		abyte0 = encode(cipher.doFinal(s.getBytes())); // antes

		return "{DES}" + new String(abyte0);

	}

}