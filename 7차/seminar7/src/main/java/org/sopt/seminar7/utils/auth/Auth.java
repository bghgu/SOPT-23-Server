package org.sopt.seminar7.utils.auth;

import java.lang.annotation.*;

/**
 * Created by ds on 2018-11-28.
 */


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Auth {
}
