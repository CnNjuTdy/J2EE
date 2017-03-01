package test;

import com.hotelworld.entity.Member;
import com.hotelworld.entity.state.MemberState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Tondiyee on 2017/2/27.
 */
public class MyTest {
    @Test
    public void TestEnum(){
        MemberState state1 = MemberState.ACTIVE;
        MemberState state2 = MemberState.ACTIVE;
        System.out.println(state1==state2);
    }
}
