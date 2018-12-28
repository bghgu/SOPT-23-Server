package org.sopt.seminar8.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ds on 2018-12-26.
 */

@Data
@Document(collection = "content")
public class Content {
}
