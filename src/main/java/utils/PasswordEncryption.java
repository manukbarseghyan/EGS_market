package utils;

public class PasswordEncryption {

//    myEncryptionKey =  //your encryption key
//    myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
//    arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
//    ks = new DESedeKeySpec(arrayBytes);
//    skf = SecretKeyFactory.getInstance(myEncryptionScheme);
//    cipher = Cipher.getInstance(myEncryptionScheme);
//    key = skf.generateSecret(ks);
//}
//
//    public String encrypt(String unencryptedString) {
//        String encryptedString = null;
//        try {
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
//            byte[] encryptedText = cipher.doFinal(plainText);
//            encryptedString = new String(Base64.encodeBase64(encryptedText));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return encryptedString;
//    }
//
//    public String decrypt(String encryptedString) {
//        String decryptedText=null;
//        try {
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] encryptedText = Base64.decodeBase64(encryptedString);
//            byte[] plainText = cipher.doFinal(encryptedText);
//            decryptedText= new String(plainText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return decryptedText;
//    }
}
