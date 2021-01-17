package zoo.api.service.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zoo.api.bo.interest.Interest;

import java.util.Arrays;
import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {
    private RestTemplate restTemplate;
    private String url;

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.interest.service.url}")
    void setInterestServiceUrl(String interestServiceUrl) {
        this.url = interestServiceUrl;
    }

    @Override
    public List<Interest> findAllInterest() {
        Interest[] interests = this.restTemplate.getForObject(this.url, Interest[].class);
        return Arrays.asList(interests.clone());
    }

    @Override
    public Interest findInterestById(int id) {
        return this.restTemplate.getForObject(this.url+"{id}", Interest.class,id);
    }

    @Override
    public Interest addInterest(Interest interest) {
        return this.restTemplate.postForObject(this.url, interest,Interest.class);
    }

    @Override
    public Interest updateInterest(Interest interest) {
        this.restTemplate.put(this.url, interest);
        return interest;
    }

    @Override
    public void deleteInterest(Interest interest) {
        this.restTemplate.delete(this.url,interest);
    }
}
