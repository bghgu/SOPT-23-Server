package org.sopt.seminar3.lombok;

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.Wither;

/**
 * Created by ds on 2018-10-22.
 */

/**
 * @Value
 * immutable class 만드는 Annotation
 * 모든 필드를 private final
 * Setter 메소드를 생성하지 않는다.
 * Final class = 더 이상의 상속 불가능
 * import org.springframework.beans.factory.annotation.Value; 와 다르다!!
 *
 * @Wither
 * 값을 변경한 새로운 객체를 만들어 준다.
 *
 * @NonFinal
 * 필드의 final을 선언하지 않을 때 사용
 */


@Value
public class TestValue {
    @Wither(AccessLevel.PROTECTED)
    private int userIdx;
    @NonFinal
    private String name;
    private String email;
}
