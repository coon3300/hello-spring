package hello.hello_spring;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.JpaMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;

@Configuration
public class SpringConfig {

    /*
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
     */

    /*
    //@PersistenceContext
    private EntityManager em; // jpa

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
     */
    private final MemberRepository memberRepository;// 스프링 데이터 jpa

    public SpringConfig(MemberRepository memberRepository) { // 스프링 데이터 jpa
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository); // 스프링 데이터 jpa
    }
/*
    @Bean
    public TimeTraceAop timeTraceAop(){ // @component 사용.
        return new TimeTraceAop();
    }
*/
    /*
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em); //jpa
    }
     */

}
