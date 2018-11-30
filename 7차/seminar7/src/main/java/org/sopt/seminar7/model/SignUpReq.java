package org.sopt.seminar7.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ds on 2018-11-28.
 */

@Setter
@NoArgsConstructor
public class SignUpReq {
    private String email;
    private String password;
    private String name;
    private int part;
    private MultipartFile profile;

    public boolean isLogin() {
        if(email != null && password != null) return true;
        return false;
    }
}
