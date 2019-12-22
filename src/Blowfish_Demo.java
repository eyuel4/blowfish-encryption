import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

public class Blowfish_Demo {
    private static final String ALGORITHM = "Blowfish";
    private static String keyString = "DesireSecretKey";

    public static void encrypt(File inputFile, File outputFile) throws Exception {
        encryptDecrypt(Cipher.ENCRYPT_MODE, inputFile, outputFile);
        System.out.println("File encrypted successfully!");
    }

    public static void decrypt(File inputFile, File outputFile) throws Exception {
        encryptDecrypt(Cipher.DECRYPT_MODE, inputFile, outputFile);
        System.out.println("file decrypted successfully!");
    }

    private static void encryptDecrypt(int cipherMode, File inputFile, File outputFile) throws Exception {
        Key secretKey = new SecretKeySpec(keyString.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(cipherMode, secretKey);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }

    public static void main(String[] args) {
        int passwordLength = 10;
        Otp x =  new Otp();
        Blowfish_Demo.keyString = x.OTP(passwordLength).toString();
        File inputFile = new File("TestFile.txt");
        File encryptedFile = new File("TestFileEncrypted.txt");
        File decryptedFile = new File("TestFileDecrypted.txt");

        try {
            Blowfish_Demo.encrypt(inputFile, encryptedFile);
            Blowfish_Demo.decrypt(encryptedFile, decryptedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
