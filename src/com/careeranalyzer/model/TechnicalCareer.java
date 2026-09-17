package com.careeranalyzer.model;

public class TechnicalCareer extends Career {

    public TechnicalCareer(String name, String description) {
        super(name, description);
    }

    @Override
    public String getCareerType() {
        return "Technical";
    }
}