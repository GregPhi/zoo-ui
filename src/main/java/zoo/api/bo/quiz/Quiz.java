package zoo.api.bo.quiz;

import zoo.api.bo.quiz.question.Question;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private int id;
    private List<Question> questions;
    private boolean make;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.make = false;
    }

    public Quiz(int id, List<Question> questions, boolean make) {
        this.id = id;
        this.questions = questions;
        this.make = make;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public boolean isMake() {
        return make;
    }

    public void setMake(boolean make) {
        this.make = make;
    }

    public void setMake(){
        this.make = true;
    }

    public void addQuestion(Question question){
        if(this.questions!=null){
            this.questions.add(question);
        }
    }

    public void removeQuestion(Question question){
        this.questions.remove(question);
    }
}
