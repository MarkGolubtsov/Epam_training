package service.implement.security;

import domain.User;
import org.apache.commons.codec.digest.DigestUtils;

public class SecurityPassword {
    private static  final  String[] SALT = new String[]{"Mark","Golubtsov","EPAM"};

    private static final int[] POSITION = new int[]{
      2,4,6
    };
    public String  hidePassword(String password) {
        return DigestUtils.md5Hex(addSalt(password));
    }
    private String addSalt(final String s) {
        String buf=s;
        String res = "";
        for (int i=0;i<SALT.length;i++) {
            int j;
            if ((i-1)<0){
                j=0;
            } else {
                j=POSITION[i-1];
            }
        buf=s.substring(j,POSITION[i])+SALT[i];
        res=res+buf;
        if (i==SALT.length-1){
            res=res+s.substring(POSITION[i],s.length());
        }
        }
        return res;
    }
}
