package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    /*각각의 테스트 메서드가 돌기 전에 가장 먼저 실행되는 메서드 테스트가 2개면 이 메서드도 두번 실행된다.*/
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        // given : 뭐가
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when : 언제
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : 결과
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
