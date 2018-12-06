-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- user Table Create SQL
CREATE TABLE user
(
    `userIdx`     INT             NOT NULL    AUTO_INCREMENT COMMENT '회원 고유 번호', 
    `name`        VARCHAR(45)     NULL        COMMENT '이름', 
    `email`       VARCHAR(45)     NULL        COMMENT '이메일', 
    `password`    VARCHAR(45)     NULL        COMMENT '비밀번호', 
    `profileUrl`  VARCHAR(145)    NULL        COMMENT '프로필', 
    PRIMARY KEY (userIdx)
);

ALTER TABLE user COMMENT '회원';

CREATE INDEX user_Index_1 ON user
(
    email, password
);


-- content Table Create SQL
CREATE TABLE content
(
    `contentIdx`   INT            NOT NULL    AUTO_INCREMENT COMMENT '컨텐츠 고유 번호', 
    `userIdx`      INT            NULL        COMMENT '컨텐츠 고유 번호', 
    `body`         VARCHAR(45)    NULL        COMMENT '컨텐츠 내용', 
    `createdDate`  DATETIME       NULL        COMMENT '작성 날짜', 
    `likeCount`    INT            NULL        COMMENT '좋아요 카운트', 
    PRIMARY KEY (contentIdx)
);

ALTER TABLE content COMMENT '컨텐츠';

ALTER TABLE content ADD CONSTRAINT FK_content_userIdx_user_userIdx FOREIGN KEY (userIdx)
 REFERENCES user (userIdx)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- comment Table Create SQL
CREATE TABLE comment
(
    `commentIdx`   INT            NOT NULL    AUTO_INCREMENT COMMENT '댓글 고유 번호', 
    `userIdx`      INT            NULL        COMMENT '작성자 고유 번호', 
    `body`         VARCHAR(45)    NULL        COMMENT '댓글 내용', 
    `createdDate`  DATETIME       NULL        COMMENT '작성 날짜', 
    `likeCount`    INT            NULL        COMMENT '좋아요 카운트', 
    `contentIdx`   INT            NULL        COMMENT '컨텐츠 고유 번호', 
    PRIMARY KEY (commentIdx)
);

ALTER TABLE comment COMMENT '댓글';

CREATE INDEX comment_Index_1 ON comment
(
    userIdx
);

ALTER TABLE comment ADD CONSTRAINT FK_comment_userIdx_user_userIdx FOREIGN KEY (userIdx)
 REFERENCES user (userIdx)  ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE comment ADD CONSTRAINT FK_comment_contentIdx_content_contentIdx FOREIGN KEY (contentIdx)
 REFERENCES content (contentIdx)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- contentLike Table Create SQL
CREATE TABLE contentLike
(
    `contentIdx`  INT    NOT NULL    COMMENT '컨텐츠 고유 번호', 
    `userIdx`     INT    NOT NULL    COMMENT '회원 고유 번호'
);

ALTER TABLE contentLike COMMENT '컨텐츠 좋아요';

CREATE INDEX contentLike_Index_1 ON contentLike
(
    contentIdx
);

ALTER TABLE contentLike ADD CONSTRAINT FK_contentLike_contentIdx_content_contentIdx FOREIGN KEY (contentIdx)
 REFERENCES content (contentIdx)  ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE contentLike ADD CONSTRAINT FK_contentLike_userIdx_user_userIdx FOREIGN KEY (userIdx)
 REFERENCES user (userIdx)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- commentLike Table Create SQL
CREATE TABLE commentLike
(
    `commentIdx`  INT    NOT NULL    COMMENT '댓글 고유 번호', 
    `userIdx`     INT    NOT NULL    COMMENT '회원 고유 번호'
);

ALTER TABLE commentLike COMMENT '댓글 좋아요';

CREATE INDEX commentLike_Index_1 ON commentLike
(
    commentIdx
);

ALTER TABLE commentLike ADD CONSTRAINT FK_commentLike_commentIdx_comment_commentIdx FOREIGN KEY (commentIdx)
 REFERENCES comment (commentIdx)  ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE commentLike ADD CONSTRAINT FK_commentLike_userIdx_user_userIdx FOREIGN KEY (userIdx)
 REFERENCES user (userIdx)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- contentPhoto Table Create SQL
CREATE TABLE contentPhoto
(
    `photoIdx`    INT             NOT NULL    AUTO_INCREMENT COMMENT '사진 고유 번호', 
    `contentIdx`  INT             NULL        COMMENT '컨텐츠 고유 번호', 
    `photoUrl`    VARCHAR(145)    NULL        COMMENT '사진 주소', 
    PRIMARY KEY (photoIdx)
);

ALTER TABLE contentPhoto COMMENT '컨텐츠 사진';

CREATE INDEX contentPhoto_Index_1 ON contentPhoto
(
    contentIdx
);

ALTER TABLE contentPhoto ADD CONSTRAINT FK_contentPhoto_contentIdx_content_contentIdx FOREIGN KEY (contentIdx)
 REFERENCES content (contentIdx)  ON DELETE RESTRICT ON UPDATE RESTRICT;


