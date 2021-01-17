package zoo.api.service.interest;

import zoo.api.bo.interest.Interest;

import java.util.List;

public interface InterestService {
    List<Interest> findAllInterest();

    Interest findInterestById(int id);

    //List<Interest> findInterestByTypeOfInterestRestaurant();
    //List<Interest> findInterestByTypeOfInterestWC();
    //List<Interest> findInterestByTypeOfInterestShop();

    Interest addInterest(Interest interest);

    Interest updateInterest(Interest interest);

    void deleteInterest(Interest interest);
}
