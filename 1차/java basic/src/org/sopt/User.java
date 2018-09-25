package org.sopt;

/**
 * Created by ds on 2018-09-25.
 */

public class User {

    //Field = 속성 = 상태 = 멤버 변수

    //회원 고유 번호
    private int idx;

    //이름
    private String name;

    //파트
    private String part;

    /**
     * 회원 객체 생성자
     * Default 생성자
     * 매개변수가 없는 생성자
     */
    public User() {
        this.idx = 9;
        this.name = "배다슬";
        this.part = "Server";
    }

    /**
     * 회원 객체 생성자
     * 매개변수가 있는 생성자
     *
     * @param idx      회원 고유 번호
     * @param name     이름
     * @param part     파트
     */
    public User(final int idx, final String name, final String part) {
        this.idx = idx;
        this.name = name;
        this.part = part;
    }

    //인사 메소드
    public void hello() {
        System.out.println("안녕하세요. 저는 " + part + "파트 " + name + "입니다.");
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(final int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(final String part) {
        this.part = part;
    }
}
