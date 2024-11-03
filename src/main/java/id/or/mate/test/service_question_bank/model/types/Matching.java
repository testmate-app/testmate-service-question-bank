package id.or.mate.test.service_question_bank.model.types;

import java.util.List;

public class Matching {
    private List<MatchingPair> pairs;
    private Boolean randomizeOptions;
    private String explanation;

}

class MatchingPair {
    private String id;
    private String premise;
    private String response;
    private String premiseImageUrl;
    private String responseImageUrl;
}
