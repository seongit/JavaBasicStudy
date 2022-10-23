import java.lang.annotation.*;

@Deprecated
@SuppressWarnings("1111") // 유효하지 않은 애너테이션은 무시된다.
@TestInfo(testBy = "aaaa",testDate = @DateTime(yymmdd ="20221023",hhmmss = "235959"))
public class Ex12_8 {
    public static void main(String[] args) {
        Class<Ex12_8> cls = Ex12_8.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);

        System.out.println("anno.testedBy()="+anno.testBy());
        System.out.println("anno.testDate().yymmdd()="+anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss()="+anno.testDate().hhmmss());

        for(String str : anno.testTools()){
            System.out.println("testTools="+str);
        }
        System.out.println();

        // Ex12_8에 적용된 모든 애너테이션을 가져온다.
        Annotation[]annoArr = cls.getAnnotations();

        for(Annotation a : annoArr)
            System.out.println(a);
    }
}

@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용가능하도록 지정 (없으면 nullPointException 발생함)
@interface TestInfo{
    int count() default 1;
    String testBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}
@Retention(RetentionPolicy.RUNTIME) // 실생 시에 사용가능하도록 지정 (없으면 nullPointException 발생함)
@interface DateTime{
    String yymmdd();
    String hhmmss();
}

enum TestType {
    FIRST,FINAL
}
