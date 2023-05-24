package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{

    private static List<Car> carList;
    static {
        carList = new ArrayList<>();
        carList.add(new Car("BMW", "Blue", 505));
        carList.add(new Car("UAZ", "Yellow", 101));
        carList.add(new Car("VAZ", "Red", 202));
        carList.add(new Car("ZIL", "Green", 303));
        carList.add(new Car("GAZ", "Black", 404));
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public List<Car> getCarListOnCount(Integer countCars) {
        List<Car> list = getCars();
        if (countCars == null || countCars < 0 || countCars > list.size()) {
            countCars = list.size();
        }
        return list.stream().limit(countCars).toList();
    }
}
