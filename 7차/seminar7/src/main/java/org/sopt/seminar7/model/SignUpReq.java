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

    private String name;
    private String email;
    private String password;
    private String profileUrl = "https://s3.ap-northeast-2.amazonaws.com/sopt-23-api-test/Profile-icon-9.png";
    private MultipartFile profile;

    public boolean isLogin() {
        return (email != null && password != null);
    }

    public boolean checkProperties() {
        return (email != null && password != null && name != null);
    }
}
