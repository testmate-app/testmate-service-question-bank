package id.or.mate.test.service_question_bank.model;

import java.util.List;
import java.util.Map;

public class AIGradingConfig {
    private Boolean autoGradingEnabled;
    private GradingModel gradingModel; // BASIC, ADVANCED, CUSTOM
    private Double confidenceThreshold;
    private Boolean requiresHumanReview;
    private List<String> gradingCriteria;
    private Map<String, Double> criteriaWeights;
    private List<String> keywordsToCheck;
    private Boolean plagiarismCheckEnabled;
    private Map<String, Object> modelSpecificSettings;

    // Language Processing Settings
    private Boolean spellCheckEnabled;
    private Boolean grammarCheckEnabled;
    private List<String> acceptedLanguages;
    private Boolean languageQualityCheck;

    // Feedback Generation
    private Boolean autoFeedbackEnabled;
    private FeedbackLevel feedbackLevel; // BASIC, DETAILED, COMPREHENSIVE
    private List<String> feedbackTemplates;
    private Boolean includeImprovementSuggestions;
    private Boolean includeResourceSuggestions;

}

// Enums
 enum GradingModel {
    BASIC,
    ADVANCED,
    CUSTOM
}

enum FeedbackLevel {
    BASIC,
    DETAILED,
    COMPREHENSIVE
}
