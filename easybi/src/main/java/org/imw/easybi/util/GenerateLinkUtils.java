package org.imw.easybi.util;

import org.imw.easybi.pojo.User;

public class GenerateLinkUtils {

    public static String generateActivateLink(User user){
        return "http://loalhost:8080/easybi/activityUser?username="+user.getUsername()+"&code="+user.getActivationCode();
    }
}
