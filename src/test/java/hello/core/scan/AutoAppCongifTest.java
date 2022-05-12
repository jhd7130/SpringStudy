package hello.core.scan;


import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppCongifTest {

    @Test
    void basicScan(){
        ApplicationContext sc  = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = sc.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    void ExcludeScan(){

    }
}
