package com.careeranalyzer.model;

public class Skill {

    private String name;
    private double score;

    public Skill(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " : " + score;
    }
}