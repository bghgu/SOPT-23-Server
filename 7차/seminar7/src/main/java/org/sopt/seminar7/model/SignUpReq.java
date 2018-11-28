package org.sopt.seminar7.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ds on 2018-11-28.
 */

@Setter
@ToString
@NoArgsConstructor
public class SignUpReq {
    private String email;
    private String password;
    private String name;
    private int part;
    private MultipartFile profile;
}
