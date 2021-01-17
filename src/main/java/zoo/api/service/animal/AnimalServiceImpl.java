package zoo.api.service.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zoo.api.bo.animal.Animal;

import java.util.Arrays;
import java.util.List;


@Service
public class AnimalServiceImpl implements AnimalService{

    private RestTemplate restTemplate;
    private String url;

    @Override
    public List<Animal> findAllAnimals() {
        Animal[] animals = this.restTemplate.getForObject(this.url, Animal[].class);
        return Arrays.asList(animals.clone());
    }

    @Override
    public Animal findAnimalById(int id) {
        return this.restTemplate.getForObject(this.url+"{id}", Animal.class,id);
    }

    @Override
    public Animal addAnimal(Animal animal) {
        return this.restTemplate.postForObject(this.url, animal,Animal.class);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        this.restTemplate.put(this.url, animal);
        return animal;
    }

    @Override
    public void deleteAnimal(Animal animal) {
        this.restTemplate.delete(this.url,animal);
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.animals.service.url}")
    void setAnimalServiceUrlUrl(String animalServiceUrl) {
        this.url = animalServiceUrl;
    }
}
