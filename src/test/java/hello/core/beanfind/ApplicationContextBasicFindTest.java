package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanName(){
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // 인스턴스의 객체와 동일한지 비교
        System.out.println("memberService = " + memberService); // 주소를 꺼내주고
        System.out.println("memberService = " + memberService.getClass()); // 인터페이스에 할당된 구현체를 반환해준다.
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        // 컨테이너에 타입이 하나만 존재한다면 타입으로만 조회가 가능하다.
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // 인스턴스의 객체와 동일한지 비교
        System.out.println("memberService = " + memberService); // 주소를 꺼내주고
        System.out.println("memberService = " + memberService.getClass()); // 인터페이스에 할당된 구현체를 반환해준다.
    }

    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // 인스턴스의 객체와 동일한지 비교
        System.out.println("memberService = " + memberService); // 주소를 꺼내주고
        System.out.println("memberService = " + memberService.getClass()); // 인터페이스에 할당된 구현체를 반환해준다.
    }

    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByNameX(){
       //ac.getBean("xxx",MemberService.class);
        //에러가 발생할 경우의 테스트 케이스도 작성해야한다.
        // 컨테이너에 없는 빈을 조회했을 때. 아래와 같은 예외가 터져야한다. () -> 람다
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                                () -> ac.getBean("xxx",MemberService.class));

    }
}
