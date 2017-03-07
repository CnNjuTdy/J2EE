package utilTest;

import com.hotelworld.util.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Tondiyee on 2017/2/27.
 */
public class DateUtilTest {
    @Test
    public void testGetToday(){
        System.out.println(DateUtil.getToday());
    }
    @Test
    public void testGetSix(){
        System.out.println(DateUtil.getSix());
    }
    @Test
    public void testGetSix2(){
        System.out.println(DateUtil.getSix(DateUtil.nextNDay(new Date(),1)));
    }
    @Test
    public void testNextNDay(){
        System.out.println(DateUtil.nextNDay(new Date(),1));
    }



}
