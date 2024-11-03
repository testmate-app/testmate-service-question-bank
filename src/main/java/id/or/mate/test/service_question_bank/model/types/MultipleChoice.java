package id.or.mate.test.service_question_bank.model.types;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MultipleChoice {
    private List<Option> options;
    private String correctOption;
    private Boolean randomizeOptions;
    private String explanation;

    public MultipleChoice(List<Option> options, String correctOption, Boolean randomizeOptions, String explanation) {
        this.options = options;
        this.correctOption = correctOption;
        this.randomizeOptions = randomizeOptions;
        this.explanation = explanation;
    }
}