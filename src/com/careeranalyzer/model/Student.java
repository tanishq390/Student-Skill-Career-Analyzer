package com.careeranalyzer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {

    private String name;
    private String branch;
    private double cgpa;

    private List<Skill> skills;
    private Map<String, Double> skillScores;

    public Student(String name, String branch, double cgpa) {
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;

        skills = new ArrayList<>();
        skillScores = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public Map<String, Double> getSkillScores() {
        return skillScores;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
        skillScores.put(skill.getName(), skill.getScore());
    }

    public void addSkill(String name, double score) {
        addSkill(new Skill(name, score));
    }

    public double getSkillScore(String skillName) {
        return skillScores.getOrDefault(skillName, 0.0);
    }

    public double calculateOverallSkillScore() {

        if (skills.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Skill skill : skills) {
            total += skill.getScore();
        }

        return total / skills.size();
    }

    public void displaySkills() {

        System.out.println("\n========== STUDENT SKILLS ==========");

        for (Skill skill : skills) {
            System.out.printf("%-25s : %.1f%n",
                    skill.getName(),
                    skill.getScore());
        }

        System.out.printf("%-25s : %.1f%n",
                "Overall Skill Score",
                calculateOverallSkillScore());
    }
}