import com.carrent.dao.entities.Car;
import com.carrent.service.service.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-config-test.xml"})
@Transactional(propagation = Propagation.SUPPORTS)
public class CarTest {


    private CarService carService;

    @Test
    public void testUpdateCar(Car car) {
        this.carService.update(car);
        Assert.assertNotNull(car);


    }

    @Test
    public void testFindAll() {
        List list = carService.listCars();
        Assert.assertEquals(list.size(), 1);
    }


}

