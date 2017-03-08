package dao;

import com.hotelworld.dao.BaseDao;
import com.hotelworld.entity.Member;
import com.hotelworld.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Tondiyee on 2017/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-core.xml", "classpath*:config/spring/spring-hibernate.xml"})
public class BaseDaoTest {
    @Qualifier("baseDaoImpl")
    @Autowired
    private BaseDao dao;

    @Test
    public void testFind() {
        List<Order> list = dao.findBySQL("select * from `order` where o_id = \"111\"", null, Order.class);
        for(Order order:list){
            System.out.println(order);
        }
    }
    @Test
    public void testUpdate(){
        Object[] params = {"4","1",new Date(),1,1,1,1,1};
        int x = dao.updateBySQL("insert into schedule values(?,?,?,?,?,?,?,?)",params);
        System.out.println(x);
    }
}
