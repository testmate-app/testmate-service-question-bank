package id.or.mate.test.service_question_bank.service;

import id.or.mate.test.service_question_bank.model.Question;
import id.or.mate.test.service_question_bank.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    public Optional<Question> getQuestionById(String id) {
        return questionRepository.findById(id);
    }

    public Optional<Question> updateQuestion(String id, Question questionDetails) {
        return questionRepository.findById(id).map(question -> {
            question.setCode(questionDetails.getCode());
            question.setTitle(questionDetails.getTitle());
            question.setType(questionDetails.getType());
            question.setDifficultyLevel(questionDetails.getDifficultyLevel());
            question.setSubject(questionDetails.getSubject());
            question.setTopic(questionDetails.getTopic());
            question.setSubTopic(questionDetails.getSubTopic());
            question.setTags(questionDetails.getTags());
            question.setLanguage(questionDetails.getLanguage());
            question.setScore(questionDetails.getScore());
            question.setTimeLimit(questionDetails.getTimeLimit());
            question.setDescription(questionDetails.getDescription());
            question.setActive(questionDetails.getActive());
            question.setKeywords(questionDetails.getKeywords());
            question.setLearningObjectives(questionDetails.getLearningObjectives());
            question.setCognitiveSkills(questionDetails.getCognitiveSkills());
            question.setCompetencies(questionDetails.getCompetencies());
            question.setSkillWeightage(questionDetails.getSkillWeightage());
            question.setQuestionText(questionDetails.getQuestionText());
            question.setAttachments(questionDetails.getAttachments());
            question.setVideoUrl(questionDetails.getVideoUrl());
            question.setMetadata(questionDetails.getMetadata());
            question.setAiGradingConfig(questionDetails.getAiGradingConfig());
            return questionRepository.save(question);
        });
    }

    public boolean deleteQuestion(String id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}