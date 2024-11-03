package id.or.mate.test.service_question_bank.model.types;

import java.util.List;

public class OrderList {
    private List<OrderItem> items;
    private String explanation;

}

class OrderItem {
    private String id;
    private String content;
    private Integer correctPosition;
}
