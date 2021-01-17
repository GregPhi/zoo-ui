package zoo.api.service.animal;

import zoo.api.bo.animal.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> findAllAnimals();

    Animal findAnimalById(int id);

    Animal addAnimal(Animal animal);

    Animal updateAnimal(Animal animal);

    void deleteAnimal(Animal animal);
}
