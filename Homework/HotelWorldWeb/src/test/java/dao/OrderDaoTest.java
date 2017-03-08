package dao;

import com.hotelworld.dao.OrderDao;
import com.hotelworld.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Tondiyee on 2017/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-core.xml", "classpath*:config/spring/spring-hibernate.xml"})
public class OrderDaoTest {
    @Autowired
    OrderDao dao;
    @Test
    public void testFindById(){
        List<Order> orders = dao.findUnSettleOrderByHotel("1");
        for(Order order:orders){
            System.out.println(order);
        }
    }
    @Test
    public void testFindTurnoversByHotel(){
        List<Integer> integers = dao.findTurnoversByHotel("1");
        for(Integer i:integers){
            System.out.println(i);
        }
    }
    @Test
    public void testFindRoomTurnoversByHotel(){
        int[] ints = dao.findRoomTurnoversByHotel("1");
        System.out.println(ints[0]+" "+ints[1]+" "+ ints[2]+" "+ints[3]);
    }
    @Test
    public void testFindAllMoney(){
        System.out.println(dao.findAllMoney());
    }
}
