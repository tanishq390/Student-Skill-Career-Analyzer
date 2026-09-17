package com.careeranalyzer.service;

import com.careeranalyzer.analyzer.CareerMatcher;
import com.careeranalyzer.analyzer.SkillAnalyzer;
import com.careeranalyzer.model.Career;
import com.careeranalyzer.model.Student;
import com.careeranalyzer.recommendation.RoadmapGenerator;
import com.careeranalyzer.util.FileManager;
import com.careeranalyzer.util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class StudentService {

    private Scanner scanner;
    private InputValidator validator;

    private SkillAnalyzer skillAnalyzer;
    private CareerMatcher careerMatcher;
    private RoadmapGenerator roadmapGenerator;
    private FileManager fileManager;

    private List<Career> careers;

    public StudentService(
            Scanner scanner,
            List<Career> careers) {

        this.scanner = scanner;
        this.validator =
                new InputValidator(scanner);

        this.careers = careers;

        this.skillAnalyzer =
                new SkillAnalyzer();

        this.careerMatcher =
                new CareerMatcher();

        this.roadmapGenerator =
                new RoadmapGenerator();

        this.fileManager =
                new FileManager();
    }

    public Student createStudent() {

        System.out.println("\n========== STUDENT PROFILE ==========");

        String name =
                validator.getString(
                        "Enter student name: "
                );

        String branch =
                validator.getString(
                        "Enter branch: "
                );

        double cgpa =
                validator.getDouble(
                        "Enter CGPA: ",
                        0,
                        10
                );

        Student student =
                new Student(name, branch, cgpa);

        addSkills(student);

        return student;
    }

    private void addSkills(Student student) {

        System.out.println(
                "\nEnter skill scores from 0 to 100."
        );

        String[] skillNames = {

                "Java",
                "Python",
                "Data Structures",
                "SQL",
                "Problem Solving",
                "Communication",
                "Networking",
                "Statistics",
                "Machine Learning",
                "Cyber Security"

        };

        for (String skillName : skillNames) {

            double score =
                    validator.getDouble(
                            skillName + " : ",
                            0,
                            100
                    );

            student.addSkill(skillName, score);
        }
    }

    public void runAnalysis(Student student) {

        student.displaySkills();

        skillAnalyzer.displayAnalysis(student);

        careerMatcher.displayCareerMatches(
                student,
                careers
        );

        List<CareerMatcher.CareerResult> results =
                careerMatcher.rankCareers(
                        student,
                        careers
                );

        if (results.isEmpty()) {
            return;
        }

        Career recommendedCareer =
                results.get(0).getCareer();

        double matchScore =
                results.get(0).getMatchScore();

        System.out.println(
                "\n========================================"
        );

        System.out.println(
                "       CAREER RECOMMENDATION"
        );

        System.out.println(
                "========================================"
        );

        System.out.println(
                "Recommended Career: " +
                        recommendedCareer.getName()
        );

        System.out.printf(
                "Match Score       : %.2f%%%n",
                matchScore
        );

        System.out.println(
                "\nSkill Gaps:"
        );

        List<String> gaps =
                careerMatcher.getSkillGaps(
                        student,
                        recommendedCareer
                );

        if (gaps.isEmpty()) {

            System.out.println(
                    "No major skill gaps found!"
            );

        } else {

            for (String gap : gaps) {
                System.out.println("- " + gap);
            }
        }

        roadmapGenerator.displayRoadmap(
                student,
                recommendedCareer
        );

        String save =
                validator.getString(
                        "\nSave report? (yes/no): "
                );

        if (save.equalsIgnoreCase("yes")) {

            fileManager.saveReport(
                    student,
                    results,
                    recommendedCareer
            );
        }
    }
}