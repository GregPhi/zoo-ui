package zoo.api.service.quiz;

import zoo.api.bo.quiz.Quiz;

import java.util.List;

public interface QuizService {
    List<Quiz> findAllQuizzes();

    Quiz findQuizById(int id);

    Quiz addQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz);

    void deleteQuiz(Quiz quiz);
}
