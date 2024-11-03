package id.or.mate.test.service_question_bank.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import id.or.mate.test.service_question_bank.model.types.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Setter
@Getter
@Data
@Document(collection = "question")
public class Question {
    @Id
    private String id;

    // Basic Info
    @Field("code")
    private String code;
    @Field("title")
    private String title;
    @Field("type")
    private String type;
    @Field("difficulty_level")
    private String difficultyLevel;
    @Field("subject")
    private String subject;
    @Field("topic")
    private String topic;
    @Field("sub_topic")
    private String subTopic;
    @Field("tags")
    private List<String> tags;
    @Field("language")
    private String language;
    @Field("score")
    private Double score;
    @Field("time_limit")
    private Integer timeLimit;
    @Field("description")
    private String description;
    @Field("active")
    private Boolean active;

    // AI Learning Objectives & Skills
    @Field("keywords")
    private List<String> keywords;
    @Field("learning_objectives")
    private List<String> learningObjectives;
    @Field("cognitive_skills")
    private List<String> cognitiveSkills;  // Bloom's Taxonomy levels
    @Field("competencies")
    private List<String> competencies;
    @Field("skill_weightage")
    private Map<String, Double> skillWeightage; // Skill to importance ratio

    // Common Question Content
    @Field("question_text")
    private String questionText;
    @Field("attachments")
    private List<String> attachments;
    @Field("video_url")
    private String videoUrl;
    @Field("metadata")
    private Map<String, String> metadata;

    // AI Grading Configuration
    @Field("ai_grading_config")
    private AIGradingConfig aiGradingConfig;

    // Question Type Specific Details
    @Field("multiple_choice")
    private MultipleChoice multipleChoice;
    @Field("multiple_answer")
    private MultipleAnswer multipleAnswer;
    @Field("true_false")
    private TrueFalse trueFalse;
    @Field("fill_blanks")
    private FillBlanks fillBlanks;
    @Field("essay")
    private Essay essay;
    @Field("matching")
    private Matching matching;
    @Field("hotspot")
    private Hotspot hotspot;
    @Field("dropdown")
    private Dropdown dropdown;
    @Field("type_in")
    private TypeIn typeIn;
    @Field("order_list")
    private OrderList orderList;

    // AI Analysis & Performance Data
    @Field("analytics")
    private QuestionAnalytics analytics;

    // Audit Fields
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

}