package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        // DI컨테이너에 @Configuration이 붙은 클래스를 담고 실행시키면
        ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = app.getBean("memberService",MemberService.class);

       /* AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/
        //MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
