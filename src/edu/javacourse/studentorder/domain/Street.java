package edu.javacourse.studentorder.domain;

public class Street {
    private Long streetId;
    private String streetName;

    public Street(Long streetId, String streetName) {
        this.streetId = streetId;
        this.streetName = streetName;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
