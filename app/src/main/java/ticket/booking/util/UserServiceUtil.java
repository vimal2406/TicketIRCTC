package ticket.booking.util;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtil {

        public static  String hashpassword(String palinpassword)
        {
            return BCrypt.hashpw(palinpassword, BCrypt.gensalt());
        }

        public static Boolean checkPassword(String hashedpassword, String plainpassword)
        {
            return BCrypt.checkpw(hashedpassword, plainpassword);
        }

        public void gitBranchCheck()
        {
            System.out.println("gitBranchCheck");
        }
}
