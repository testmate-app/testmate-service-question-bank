package id.or.mate.test.service_question_bank.model.types;

import java.util.List;
import java.util.Map;

public class Essay {
    private Integer minimumWords;
    private Integer maximumWords;
    private String rubric;
    private List<String> keyPoints;
    private String sampleAnswer;

    // AI Grading Features
    private List<RubricCriteria> rubricCriteria;
    private Boolean checkCoherence;
    private Boolean checkOriginalityRequired;
    private Double similarityThreshold;
    private List<String> requiredConcepts;
    private List<String> prohibitedConcepts;
    private Boolean checkArgumentQuality;
    private Boolean checkSourceCitations;
    private Map<String, Double> conceptWeightage;
}

class RubricCriteria {
    private String criterion;
    private String description;
    private List<RubricLevel> levels;
    private Double weight;
    private List<String> keywordsToCheck;
    private Boolean requiresContextualUnderstanding;
}

class RubricLevel {
    private Integer level;
    private String description;
    private Double score;
    private List<String> indicators;
}
