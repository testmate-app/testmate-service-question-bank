package id.or.mate.test.service_question_bank.model.types;

import java.util.List;

public class Dropdown {
    private List<DropdownGroup> dropdowns;
    private String explanation;

}

class DropdownGroup {
    private String id;
    private List<String> options;
    private String correctOption;
}
