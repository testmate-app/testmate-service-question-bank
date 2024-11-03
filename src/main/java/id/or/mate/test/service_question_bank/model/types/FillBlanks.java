package id.or.mate.test.service_question_bank.model.types;

import java.util.List;

public class FillBlanks {
    private List<BlankSpace> blanks;
    private Boolean caseSensitive;
    private String explanation;

}

class BlankSpace {
    private String id;
    private List<String> acceptableAnswers;
    private Double score;
}
