package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.") // 콘솔창에 표현되는 것
    void getDiscountPrice(){
        //Given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    /*
    * 항상 실패에 대한 결과도 테스트해봐야한다.
    * */
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지말아야한다.")
    void getDiscountPriceF(){
        //Given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        // Assertions.    -- 위에 스태틱 임포트 때문에 클래스를 명시해줄 필요가 없다.
         assertThat(discount).isEqualTo(1000);
    }
}