package org.sopt.seminar3.lombok;

import lombok.Data;

/**
 * Created by ds on 2018-10-22.
 */

/**
 * @Data
 * 모든 메소드 자동 생성
 * @Setter
 * @Getter
 * @ToString
 * @EqualsAndHashCode
 * @AllArgs & @NoArgs & @RequiredArgs Constructor
 */

@Data
public class TestData {
    private int userIdx;
    private String name;
    private String email;
}
