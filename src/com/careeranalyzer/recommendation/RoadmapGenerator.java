package com.careeranalyzer.recommendation;

import com.careeranalyzer.model.Career;
import com.careeranalyzer.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoadmapGenerator {

    public List<String> generateRoadmap(
            Student student,
            Career career) {

        List<String> roadmap = new ArrayList<>();

        for (Map.Entry<String, Double> entry :
                career.getRequiredSkills().entrySet()) {

            String skill = entry.getKey();
            double required = entry.getValue();

            double current =
                    student.getSkillScore(skill);

            if (current < required) {

                if (current < 40) {

                    roadmap.add(
                            "Learn " + skill +
                                    " from fundamentals"
                    );

                } else if (current < 70) {

                    roadmap.add(
                            "Practice intermediate " +
                                    skill + " concepts"
                    );

                } else {

                    roadmap.add(
                            "Master advanced " +
                                    skill + " concepts"
                    );
                }
            }
        }

        roadmap.add("Build projects related to "
                + career.getName());

        roadmap.add("Create and maintain a GitHub portfolio");

        roadmap.add("Practice interview questions");

        return roadmap;
    }

    public void displayRoadmap(
            Student student,
            Career career) {

        List<String> roadmap =
                generateRoadmap(student, career);

        System.out.println("\n========================================");
        System.out.println("       PERSONALIZED ROADMAP");
        System.out.println("========================================");

        System.out.println(
                "Target Career: " +
                        career.getName()
        );

        int step = 1;

        for (String item : roadmap) {

            System.out.println(
                    step++ + ". " + item
            );
        }
    }
}