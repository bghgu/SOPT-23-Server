package org.sopt.seminar3.lombok;

/**
 * Created by ds on 2018-10-22.
 */
public class Temp {

    void main() {

        Test test = new Test();

        //@Data가 다양한 메소드를 자동으로 만들어 준다.
        TestData testData = new TestData();
        testData.getEmail();
        testData.setUserIdx(0);
        testData.toString();

        //Getter, Setter 메소드 자동 생성
        TestGetterSetter testGetterSetter = new TestGetterSetter();
        testGetterSetter.setEmail("bghgu@naver.com");
        testGetterSetter.getUserIdx();

        //Builder 패턴으로 Builder 자동 생성
        TestBuilder testBuilder = TestBuilder.builder().build();

        //모든 필드의 생성자 자동 생성
        TestAllArgsConstructor testAllArgsConstructor
                = new TestAllArgsConstructor(1, "배다슬", "bghgu@naver.com");

        //@NonNull, final 붙은 키워드의 생성자 자동 생성
        TestRequiredArgsConstructor testRequiredArgsConstructor
                = new TestRequiredArgsConstructor("배다슬", "bghgu@naver.com");

        //NullPointerException 발생
        TestNonNull testNonNull = new TestNonNull(0, null, null);
        //NullPointerException이 발생하지 않는다.
        TestNonNull testNonNull2 = new TestNonNull();

        //Builder 클래스 생성
        TestBuilder.TestBuilderBuilder builder = new TestBuilder.TestBuilderBuilder();

        //Builder 메소드로 Build
        TestBuilder.builder()
                .userIdx(1)
                .name("배다슬")
                .email("bghgu@naver.com")
                .build();

        //immutable 객체
        TestValue testValue = new TestValue(0, "배다슬", "bghgu@naver.com");
        //@Wither
        //값을 변경한 새로운 객체를 만들어 준다.
        TestValue testValue1 = testValue.withUserIdx(1);
    }
}
