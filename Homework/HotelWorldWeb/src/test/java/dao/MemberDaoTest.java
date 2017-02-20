package dao;

import com.hotelworld.dao.MemberDao;
import com.hotelworld.entity.Member;
import com.hotelworld.entity.state.MemberState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Tondiyee on 2017/2/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/spring/spring-*.xml"})
public class MemberDaoTest {
    @Autowired
    private MemberDao dao;

    @Test
    public void testFindMemberById() {
        Member member = dao.findMemberById("300");
        System.out.println(member);
    }

    @Test
    public void testSaveMember() {
        Member member = new Member();
        member.setId("410");
        member.setName("tom");
        member.setBalance(10000);
        member.setCredits(1);
        member.setAccount("1");
        member.setPhone("18362926130");
        member.setState(MemberState.INACTIVE);
        if(dao.findMemberById("410")!=null){
            return;
        }
        dao.saveMember(member);
    }

    @Test
    public void testUpdateMemberById() {
        Member member = dao.findMemberById("300");
        if(member==null){
            return ;
        }
        System.out.println(member);
        member.setState(MemberState.CLOSED);
    }

    @Test
    public void testDelMember() {
        Member member = dao.findMemberById("2");
        if(member==null){
            return ;
        }
        dao.delMember(member);
    }
}
