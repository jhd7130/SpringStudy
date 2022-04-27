package hello.core.XmlAppContext;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.support.GenericXmlContextLoader;

import javax.management.DescriptorKey;

public class XmlAppContext {

    @Test
    @DisplayName("엑스엠엘파이로 조회")
    void getBeanFromXml(){
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService MC = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(MC).isInstanceOf(MemberService.class);

    }
}
