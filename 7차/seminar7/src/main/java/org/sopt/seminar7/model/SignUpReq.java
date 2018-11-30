package org.sopt.seminar7.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ds on 2018-11-28.
 */

@Data
@NoArgsConstructor
public class SignUpReq {

    private String email;
    private String password;
    private String name;
    private int part = 0;
    private MultipartFile profile;
    private String profileUrl;

    public boolean isLogin() {
        if(email != null && password != null) return true;
        return false;
    }

    public boolean checkProperties() {
        if(email != null && password != null && part != 0 && name != null) return true;
        return false;
    }
}
