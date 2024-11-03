package id.or.mate.test.service_question_bank.model.types;

import java.util.List;

public class MultipleAnswer {
    private List<Option> options;
    private List<String> correctOptions;
    private Boolean randomizeOptions;
    private Integer minimumCorrectAnswers;
    private Integer maximumCorrectAnswers;
    private String explanation;

}
