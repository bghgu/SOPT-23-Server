package org.sopt.seminar3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Created by ds on 2018-10-19.
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultRes<T> {

    //Response StatusCode
    private int statusCode;

    //Response Message
    private String responseMessage;

    //Response Data
    private T responseData;

    public DefaultRes(final HttpStatus statusCode, final String responseMessage) {
        this.statusCode = statusCode.value();
        this.responseMessage = responseMessage;
        this.responseData = null;
    }
}
