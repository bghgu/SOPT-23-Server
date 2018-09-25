package org.sopt;


public class Main {

    public static void main(String[] args) {
        //Default 생성자로 객체 생성
        final User user1 = new User();
        //매개변수를 통해 객체 생성

        final User user2 = new User(2, "류지훈", "기획");
        final User temp = new User(0, null, null);

        user1.hello();
        user2.hello();

        final User2 cowalwerPM = new User2(1, "pm@cowalker.com", "1234", "이충엽", 0, null,
                "ImgPath", "개설자", "안녕하세요.", "ImgPath", "ImgPath", "메인기획자", null, "의정부", "tokenValue");

        final User2 cowalwerSubPM = new User2(2, "subPm@cowalekr.com", "5678", "길태환", 0, null,
                "ImgPath", "참여자", "안녕하세요.", "ImgPath", "ImgPath", "서브기획자", null, "의정부", "tokenValue");

        final User2 designer1 = new User2(3, "designer1@cowalekr.com", "5678", "홍지연", 0, null,
                null, "참여자", null, null, null, "디자이너", null, null, "tokenValue");

        final UserBuilder userBuilder = new UserBuilder();

        final User user3 = userBuilder
                .setIdx(3)
                .setName("남윤환")
                .setPart("Android")
                //build 메소드를 통해 객체가 생성되서 반환된다.
                .build();

        user3.hello();

        final User2Builder user2Builder = new User2Builder();

        final User2 designer2 = user2Builder
                .setUserIdx(4)
                .setEmail("designer2@cowalekr.com")
                .setPassword("0000")
                .setName("박채원")
                .setPoint(0)
                .setSignupAt(null)
                .setProfileUrl("ImgPath")
                .setPosition("디자이너")
                .setIntroduce("웹 디자이너입니다.")
                .setPortfolioUrl("ImgPath")
                .setAim(null)
                .setArea("수원")
                .setBackgroundUrl(null)
                .setFcmToken(null)
                .setDepartment(null)
                .build();
    }
}
