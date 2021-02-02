package me.bj.jpashop.service;

import me.bj.jpashop.domain.Member;
import me.bj.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long join = memberService.join(member);

        //then
        Assertions.assertThat(member).isEqualTo(memberService.findOne(join));
    }
    
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        //given
        Member member = new Member();
        member.setName("kim");
        Member member1 = new Member();
        member1.setName("kim");

        //when
        memberService.join(member);
        memberService.join(member1);

        //then
        fail("예외가 발생해야 한다.");
    }
}