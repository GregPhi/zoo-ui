package zoo.api.service.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zoo.api.bo.quiz.Quiz;

import java.util.Arrays;
import java.util.List;


@Service
public class QuizServiceImpl implements QuizService {

    private RestTemplate restTemplate;
    private String url;

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.quizzes.service.url}")
    void setQuizServiceUrlUrl(String quizServiceUrl) {
        this.url = quizServiceUrl;
    }

    @Override
    public List<Quiz> findAllQuizzes() {
        Quiz[] quizzes = this.restTemplate.getForObject(this.url, Quiz[].class);
        return Arrays.asList(quizzes.clone());
    }

    @Override
    public Quiz findQuizById(int id) {
        return this.restTemplate.getForObject(this.url+"{id}", Quiz.class,id);
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.restTemplate.postForObject(this.url, quiz,Quiz.class);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        this.restTemplate.put(this.url, quiz);
        return quiz;
    }

    @Override
    public void deleteQuiz(Quiz quiz) {
        this.restTemplate.delete(this.url,quiz);
    }
}
