package id.or.mate.test.service_question_bank.controller;

import id.or.mate.test.service_question_bank.model.Question;
import id.or.mate.test.service_question_bank.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
@Tag(name = "Question API", description = "CRUD operations for managing questions")

public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Create a new question
    @Operation(summary = "Create a new question", description = "Add a new question to the question bank")
    @ApiResponse(responseCode = "201", description = "Question created successfully", content = @Content(schema = @Schema(implementation = Question.class)))
    @PostMapping
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question) {
        Question createdQuestion = questionService.createQuestion(question);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all questions", description = "Retrieve all questions with pagination")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of questions", content = @Content(schema = @Schema(implementation = Question.class)))
    @GetMapping
    public ResponseEntity<PagedModel<Question>> getAllQuestions(
            @Parameter(description = "Pagination details", example = "{\"page\":0,\"size\":10}") Pageable pageable) {
        Page<Question> questions = questionService.getAllQuestions(pageable);

        // Create a PagedModel
        PagedModel<Question> pagedModel = PagedModel.of(questions.getContent(),
                new PagedModel.PageMetadata(questions.getSize(), questions.getNumber(), questions.getTotalElements()));

        // Add self link (optional)
        pagedModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(QuestionController.class).getAllQuestions(pageable)).withSelfRel());

        return new ResponseEntity<>(pagedModel, HttpStatus.OK);
    }


    // Get a question by ID
    @Operation(summary = "Get a question by ID", description = "Retrieve a specific question by its ID")
    @ApiResponse(responseCode = "200", description = "Question retrieved successfully", content = @Content(schema = @Schema(implementation = Question.class)))
    @ApiResponse(responseCode = "404", description = "Question not found")
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(
            @Parameter(description = "ID of the question to retrieve", required = true) @PathVariable String id) {
        Optional<Question> question = questionService.getQuestionById(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a question by ID
    @Operation(summary = "Update a question", description = "Update the details of an existing question by its ID")
    @ApiResponse(responseCode = "200", description = "Question updated successfully", content = @Content(schema = @Schema(implementation = Question.class)))
    @ApiResponse(responseCode = "404", description = "Question not found")
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(
            @Parameter(description = "ID of the question to update", required = true) @PathVariable String id,
            @Valid @RequestBody Question questionDetails) {
        Optional<Question> updatedQuestion = questionService.updateQuestion(id, questionDetails);
        return updatedQuestion.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a question by ID
    @Operation(summary = "Delete a question", description = "Delete a specific question by its ID")
    @ApiResponse(responseCode = "204", description = "Question deleted successfully")
    @ApiResponse(responseCode = "404", description = "Question not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(
            @Parameter(description = "ID of the question to delete", required = true) @PathVariable String id) {
        if (questionService.deleteQuestion(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
