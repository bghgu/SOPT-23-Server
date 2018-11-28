package org.sopt.seminar7.utils;

/**
 * Created by ds on 2018-11-28.
 */
public class ResponseMessage {

    public static final String LOGIN_SUCCESS = "로그인 성공";
    public static final String LOGIN_FAIL = "로그인 실패";

    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String NOT_FOUND_USER = "회원을 찾을 수 없습니다.";
    public static final String ALREADY_USER = "이미 존재하는 Email입니다.";
    public static final String CREATED_USER = "회원 가입 성공";
    public static final String FAIL_CREATE_USER = "회원 가입 실패";
    public static final String UPDATE_USER = "회원 정보 수정 성공";
    public static final String DELETE_USER = "회원 탈퇴 성공";

    public static final String READ_ALL_CONTENTS = "모든 글 조회 성공";
    public static final String READ_CONTENT = "글 조회 성공";
    public static final String NOT_FOUND_CONTENT = "글이 존재하지 않습니다.";
    public static final String CREATE_CONTENT = "글 작성 성공";
    public static final String FAIL_CREATE_CONTENT = "글 작성 실패";
    public static final String UPDATE_CONTENT = "글 수정 성공";
    public static final String DELETE_CONTENT = "글 삭제 성공";
    public static final String LIKE_CONTENT = "글 좋아요/해제 성공";

    public static final String READ_ALL_COMMENTS = "모든 댓글 조회 성공";
    public static final String READ_COMMENT = "댓글 조회 성공";
    public static final String NOT_FOUND_COMMENT = "댓글이 존재하지 않습니다.";
    public static final String CREATE_COMMENT = "댓글 작성 성공";
    public static final String FAIL_CREATE_COMMENT = "댓글 작성 실패";
    public static final String UPDATE_COMMENT = "댓글 수정 성공";
    public static final String FAIL_UPDATE_COMMENT = "댓글 수정 실패";
    public static final String DELETE_COMMENT = "댓글 삭제 성공";
    public static final String FAIL_DELETE_COMMENT = "댓글 삭제 실패";
    public static final String LIKE_COMMENT = "댓글 좋아요";
    public static final String UNLIKE_COMMENT = "댓글 좋아요 해제";
    public static final String FAIL_COMMENT = "댓글 좋아요 실패";
    public static final String FAIL_UNLIKE_COMMENT = "댓글 좋아요 해제 실패";

    public static final String AUTHORIZED = "인증 성공";
    public static final String UNAUTHORIZED = "인증 실패";
    public static final String FORBIDDEN = "인가 실패";

    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
    public static final String SERVICE_UNAVAILABLE = "현재 서비스를 사용하실 수 없습니다. 잠시후 다시 시도해 주세요.";

    public static final String DB_ERROR = "데이터베이스 에러";
}
