import java.util.Random;

public class Otp {
    char[] OTP(int len) {
        System.out.println("Generating one time password: ");
        System.out.print("Your OTP is : ");

        String numbers = "0123456789";

        // Using random method
        Random rndm_method = new Random();
        char[] otp = new char[len];
        for (int i = 0; i < len; i++) {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        System.out.println(otp);
        return otp;
    }

}
