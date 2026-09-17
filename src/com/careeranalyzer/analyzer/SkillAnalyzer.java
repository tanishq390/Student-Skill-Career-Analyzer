package com.careeranalyzer.analyzer;

import com.careeranalyzer.model.Skill;
import com.careeranalyzer.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SkillAnalyzer {

    public double calculateAverage(Student student) {
        return student.calculateOverallSkillScore();
    }

    public List<Skill> getStrongestSkills(Student student, int count) {

        List<Skill> sortedSkills = new ArrayList<>(student.getSkills());

        sortedSkills.sort(
                Comparator.comparingDouble(Skill::getScore).reversed()
        );

        if (count > sortedSkills.size()) {
            count = sortedSkills.size();
        }

        return sortedSkills.subList(0, count);
    }

    public List<Skill> getWeakestSkills(Student student, int count) {

        List<Skill> sortedSkills = new ArrayList<>(student.getSkills());

        sortedSkills.sort(
                Comparator.comparingDouble(Skill::getScore)
        );

        if (count > sortedSkills.size()) {
            count = sortedSkills.size();
        }

        return sortedSkills.subList(0, count);
    }

    public String getSkillLevel(double score) {

        if (score >= 80) {
            return "Advanced";
        } else if (score >= 60) {
            return "Intermediate";
        } else if (score >= 40) {
            return "Beginner";
        } else {
            return "Needs Improvement";
        }
    }

    public void displayAnalysis(Student student) {

        System.out.println("\n========================================");
        System.out.println("          SKILL ANALYSIS");
        System.out.println("========================================");

        System.out.printf("Overall Score : %.2f%n",
                student.calculateOverallSkillScore());

        System.out.println("\nStrongest Skills:");

        for (Skill skill : getStrongestSkills(student, 3)) {

            System.out.printf(
                    "- %s : %.1f (%s)%n",
                    skill.getName(),
                    skill.getScore(),
                    getSkillLevel(skill.getScore())
            );
        }

        System.out.println("\nSkills to Improve:");

        for (Skill skill : getWeakestSkills(student, 3)) {

            System.out.printf(
                    "- %s : %.1f (%s)%n",
                    skill.getName(),
                    skill.getScore(),
                    getSkillLevel(skill.getScore())
            );
        }
    }
}