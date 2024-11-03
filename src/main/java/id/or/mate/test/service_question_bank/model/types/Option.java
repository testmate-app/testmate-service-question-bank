package id.or.mate.test.service_question_bank.model.types;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Option {
    private String id;
    private String text;
    private String imageUrl;
    private Boolean isCorrect;

    public Option(String id, String text, String imageUrl, Boolean isCorrect) {
        this.id = id;
        this.text = text;
        this.imageUrl = imageUrl;
        this.isCorrect = isCorrect;
    }
}
