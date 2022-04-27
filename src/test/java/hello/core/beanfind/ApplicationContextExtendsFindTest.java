package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 인터페이스 타입 조회시 자식 인터페이스 모두 조회")
    void getExtendsFind(){
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모타입조회 시 메서드명을 정해주면된다.")
    void getExtendsFind2(){
        DiscountPolicy dc = ac.getBean("rateDiscount",DiscountPolicy.class);
        assertThat(dc).isInstanceOf(RateDiscountPolicy.class);
    }
    
    @Test
    @DisplayName("부모타입조회 시 메서드명을 정해주면된다.")
    void getExtendsFind3(){
        RateDiscountPolicy rdc = ac.getBean("rateDiscount",RateDiscountPolicy.class);
        assertThat(rdc).isInstanceOf(RateDiscountPolicy.class);
    }
    
    @Test
    @DisplayName("부모타입조회 시 메서드명을 정해주면된다.")
    void findAllByParents(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println(" key + \"value = \" + beansOfType.get(key) = " +  key + "value = " + beansOfType.get(key));
        }
        assertThat(beansOfType.size()).isEqualTo(2);
        System.out.println("beansOfType = " + beansOfType);
    }

    @Test
    @DisplayName("object 조회 시 메서드명을 정해주면된다.")
    void findAll(){
        //object아래 모든 객체의 정보가 출력된다.
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println(" key + \"value = \" + beansOfType.get(key) = " +  key + "value = " + beansOfType.get(key));
        }
        assertThat(beansOfType.size()).isEqualTo(16);
        System.out.println("beansOfType = " + beansOfType);
    }

    @Configuration
    static class TestConfig{

        @Bean
        public DiscountPolicy rateDiscount(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscount(){
            return new FixDiscountPolicy();
        }
    }
}
