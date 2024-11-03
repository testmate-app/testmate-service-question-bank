package id.or.mate.test.service_question_bank.repository;


import id.or.mate.test.service_question_bank.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}