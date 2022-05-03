package jwp.zajecia.springdate.api;

import jwp.zajecia.springdate.dao.entity.Car;
import jwp.zajecia.springdate.manager.CarManager;
import jwp.zajecia.springdate.dao.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarApi {

    private CarManager carManager;

    @Autowired
    public CarApi(CarManager carManager) {
        this.carManager = carManager;
    }

    @GetMapping("/all")
    public Iterable<Car> getAll() { return  carManager.findAll();}

    @GetMapping
    public List<Car> getByColor(@RequestParam Color color) {
        return carManager.findAllByColor(color);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return  carManager.save(car);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car) {
        return  carManager.save(car);
    }

    @DeleteMapping
    public void deleteCar(@RequestParam long index) {
        carManager.delete(index);
    }
}
