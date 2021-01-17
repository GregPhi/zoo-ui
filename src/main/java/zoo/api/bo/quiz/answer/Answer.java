package zoo.api.bo.quiz.answer;

public class Answer {
    private int id;
    private String answer;
    private String url_picture;
    private boolean isGood;

    public Answer() {
        isGood = false;
    }

    public Answer(String answer, String url_picture, boolean isGood) {
        this.answer = answer;
        this.url_picture = url_picture;
        this.isGood = isGood;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUrl_picture() {
        return url_picture;
    }

    public void setUrl_picture(String url_picture) {
        this.url_picture = url_picture;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public void isGoodTrue(){
        isGood = true;
    }
}
