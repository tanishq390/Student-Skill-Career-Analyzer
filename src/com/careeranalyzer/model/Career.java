package com.careeranalyzer.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Career {

    private String name;
    private String description;

    protected Map<String, Double> requiredSkills;

    public Career(String name, String description) {
        this.name = name;
        this.description = description;
        this.requiredSkills = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Double> getRequiredSkills() {
        return requiredSkills;
    }

    public void addRequiredSkill(String skill, double score) {
        requiredSkills.put(skill, score);
    }

    public abstract String getCareerType();

    public void displayCareer() {

        System.out.println("\nCareer: " + name);
        System.out.println("Type: " + getCareerType());
        System.out.println("Description: " + description);

        System.out.println("Required Skills:");

        for (Map.Entry<String, Double> entry : requiredSkills.entrySet()) {

            System.out.printf("  %-20s : %.1f%n",
                    entry.getKey(),
                    entry.getValue());
        }
    }
}