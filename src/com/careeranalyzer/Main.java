package com.careeranalyzer;

import com.careeranalyzer.model.Career;
import com.careeranalyzer.model.TechnicalCareer;
import com.careeranalyzer.model.NonTechnicalCareer;
import com.careeranalyzer.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Career> careers =
                createCareerDatabase();

        StudentService service =
                new StudentService(
                        scanner,
                        careers
                );

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "   STUDENT SKILL & CAREER PATH ANALYZER"
        );

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "\nAnalyze your skills and discover suitable"
        );

        System.out.println(
                "career paths based on your current abilities."
        );

        boolean running = true;

        while (running) {

            System.out.println(
                    "\n============== MENU =============="
            );

            System.out.println(
                    "1. Start Career Analysis"
            );

            System.out.println(
                    "2. View Career Database"
            );

            System.out.println(
                    "3. Exit"
            );

            System.out.print(
                    "Enter choice: "
            );

            String choice =
                    scanner.nextLine();

            switch (choice) {

                case "1":

                    try {

                        service.runAnalysis(
                                service.createStudent()
                        );

                    } catch (Exception e) {

                        System.out.println(
                                "Unexpected error: " +
                                        e.getMessage()
                        );
                    }

                    break;

                case "2":

                    displayCareerDatabase(
                            careers
                    );

                    break;

                case "3":

                    running = false;

                    System.out.println(
                            "\nThank you for using the "
                                    + "Career Analyzer!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }

        scanner.close();
    }

    private static List<Career> createCareerDatabase() {

        List<Career> careers =
                new ArrayList<>();

        // Software Developer

        Career softwareDeveloper =
                new TechnicalCareer(
                        "Software Developer",
                        "Designs and develops software applications."
                );

        softwareDeveloper.addRequiredSkill(
                "Java", 75
        );

        softwareDeveloper.addRequiredSkill(
                "Data Structures", 70
        );

        softwareDeveloper.addRequiredSkill(
                "Problem Solving", 75
        );

        softwareDeveloper.addRequiredSkill(
                "SQL", 60
        );

        softwareDeveloper.addRequiredSkill(
                "Communication", 60
        );

        careers.add(softwareDeveloper);

        // Backend Developer

        Career backendDeveloper =
                new TechnicalCareer(
                        "Backend Developer",
                        "Develops server-side applications and APIs."
                );

        backendDeveloper.addRequiredSkill(
                "Java", 75
        );

        backendDeveloper.addRequiredSkill(
                "SQL", 75
        );

        backendDeveloper.addRequiredSkill(
                "Data Structures", 65
        );

        backendDeveloper.addRequiredSkill(
                "Problem Solving", 70
        );

        careers.add(backendDeveloper);

        // Data Analyst

        Career dataAnalyst =
                new TechnicalCareer(
                        "Data Analyst",
                        "Analyzes data to generate useful insights."
                );

        dataAnalyst.addRequiredSkill(
                "Python", 70
        );

        dataAnalyst.addRequiredSkill(
                "SQL", 75
        );

        dataAnalyst.addRequiredSkill(
                "Statistics", 70
        );

        dataAnalyst.addRequiredSkill(
                "Communication", 65
        );

        careers.add(dataAnalyst);

        // AI/ML Engineer

        Career mlEngineer =
                new TechnicalCareer(
                        "AI/ML Engineer",
                        "Builds machine learning and AI solutions."
                );

        mlEngineer.addRequiredSkill(
                "Python", 80
        );

        mlEngineer.addRequiredSkill(
                "Machine Learning", 75
        );

        mlEngineer.addRequiredSkill(
                "Statistics", 70
        );

        mlEngineer.addRequiredSkill(
                "Problem Solving", 75
        );

        careers.add(mlEngineer);

        // Cyber Security

        Career cyberSecurity =
                new TechnicalCareer(
                        "Cyber Security Analyst",
                        "Protects systems, networks and data."
                );

        cyberSecurity.addRequiredSkill(
                "Networking", 75
        );

        cyberSecurity.addRequiredSkill(
                "Cyber Security", 80
        );

        cyberSecurity.addRequiredSkill(
                "Python", 60
        );

        cyberSecurity.addRequiredSkill(
                "Problem Solving", 70
        );

        careers.add(cyberSecurity);

        // Project Manager

        Career projectManager =
                new NonTechnicalCareer(
                        "Project Manager",
                        "Manages teams, projects and deadlines."
                );

        projectManager.addRequiredSkill(
                "Communication", 85
        );

        projectManager.addRequiredSkill(
                "Problem Solving", 75
        );

        projectManager.addRequiredSkill(
                "Data Structures", 40
        );

        careers.add(projectManager);

        return careers;
    }

    private static void displayCareerDatabase(
            List<Career> careers) {

        System.out.println(
                "\n=========================================="
        );

        System.out.println(
                "             CAREER DATABASE"
        );

        System.out.println(
                "=========================================="
        );

        for (Career career : careers) {

            career.displayCareer();

            System.out.println(
                    "------------------------------------------"
            );
        }
    }
}