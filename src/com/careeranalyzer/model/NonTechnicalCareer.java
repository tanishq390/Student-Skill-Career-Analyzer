package com.careeranalyzer.model;

public class NonTechnicalCareer extends Career {

    public NonTechnicalCareer(String name, String description) {
        super(name, description);
    }

    @Override
    public String getCareerType() {
        return "Non-Technical";
    }
}