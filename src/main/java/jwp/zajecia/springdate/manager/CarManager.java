package jwp.zajecia.springdate.manager;

import jwp.zajecia.springdate.dao.Color;
import jwp.zajecia.springdate.dao.CarRepo;
import jwp.zajecia.springdate.dao.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarManager {
    private CarRepo carRepo;

    @Autowired
    public CarManager(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Car save(Car car) {
        return carRepo.save(car);
    }

    public void delete(Long id) {
        carRepo.deleteById(id);
    }

    public Iterable<Car> findAll() {
        return carRepo.findAll();
    }

    public List<Car> findAllByColor(Color color) {
        return  carRepo.findAllByKolor(color);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDb() {
        save(new Car("Mercedes","GT",Color.BLUE));
        save(new Car("Audi","R8",Color.BLACK));
        save(new Car("BMW","M2",Color.RED));
        save(new Car("Lamborghini","Gallardo",Color.BLUE));
        save(new Car("Porsche","GT",Color.BLACK));
    }
}
