package org.sopt.seminar7.dto;

        import lombok.Data;
        import lombok.NoArgsConstructor;

/**
 * Created by ds on 2018-11-28.
 */

@Data
@NoArgsConstructor
public class User {
    private int userIdx;
    private String name;
    private String part;
    private String profileUrl;
    private boolean auth;
}
