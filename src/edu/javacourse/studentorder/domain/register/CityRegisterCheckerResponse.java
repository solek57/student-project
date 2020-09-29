package edu.javacourse.studentorder.domain.register;

public class CityRegisterCheckerResponse {

    private boolean existence;
    private Boolean temporal;

    public CityRegisterCheckerResponse(boolean existence, Boolean temporal) {
        this.existence = existence;
        this.temporal = temporal;
    }

    public boolean isExistence() {
        return existence;
    }

    public void setExistence(boolean existence) {
        this.existence = existence;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }
}
