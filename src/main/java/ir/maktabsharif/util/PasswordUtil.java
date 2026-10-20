package ir.maktabsharif.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {


    private PasswordUtil(){}

    public static String generatePassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public static boolean checkingPassword(String password,String passwordHash){
        return BCrypt.checkpw(password,passwordHash);
    }
}
