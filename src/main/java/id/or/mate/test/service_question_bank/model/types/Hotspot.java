package id.or.mate.test.service_question_bank.model.types;

import java.util.List;

public class Hotspot {
    private String imageUrl;
    private List<HotspotArea> correctAreas;
    private String explanation;

}

class HotspotArea {
    private String id;
    private String shape; // rectangle, circle, polygon
    private List<Coordinate> coordinates;
    private String description;
}

class Coordinate {
    private Integer x;
    private Integer y;
}
