package org.sopt.seminar7.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.sopt.seminar7.dto.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ds on 2018-11-28.
 */

@Data
@NoArgsConstructor
public class SignUpReq {

    private String name;
    private String email;
    private String password;
    private String profileUrl;
    private MultipartFile profile;

    public boolean isLogin() {
        if(email != null && password != null) return true;
        return false;
    }

    public boolean checkProperties() {
        return (email != null && password != null && name != null);
//        if(email != null && password != null && part != 0 && name != null) return true;
//        return false;
    }
}
