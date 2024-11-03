package id.or.mate.test.service_question_bank.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class QuestionAnalytics {
    private Double difficultyIndex;
    private Double discriminationIndex;
    private Double reliabilityScore;
    private Integer timesUsed;
    private Double averageScore;
    private Double averageTimeSpent;
    private Map<String, Double> skillPerformanceMetrics;
    private List<MisconceptionPattern> commonMisconceptions;
    private Map<String, Integer> responseDistribution;
    private Double aiConfidenceScore;
    private LocalDateTime lastAnalyzedAt;

}
class MisconceptionPattern {
    private String pattern;
    private String explanation;
    private Integer frequency;
    private List<String> recommendedResources;
}

