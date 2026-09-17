package com.careeranalyzer.analyzer;

import com.careeranalyzer.model.Career;
import com.careeranalyzer.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CareerMatcher {

    public double calculateMatch(Student student, Career career) {

        Map<String, Double> requiredSkills =
                career.getRequiredSkills();

        if (requiredSkills.isEmpty()) {
            return 0;
        }

        double totalMatch = 0;

        for (Map.Entry<String, Double> entry : requiredSkills.entrySet()) {

            String skill = entry.getKey();
            double requiredScore = entry.getValue();

            double studentScore =
                    student.getSkillScore(skill);

            double match;

            if (requiredScore == 0) {
                match = 100;
            } else {

                match = (studentScore / requiredScore) * 100;

                if (match > 100) {
                    match = 100;
                }
            }

            totalMatch += match;
        }

        return totalMatch / requiredSkills.size();
    }

    public List<CareerResult> rankCareers(
            Student student,
            List<Career> careers) {

        List<CareerResult> results = new ArrayList<>();

        for (Career career : careers) {

            double score = calculateMatch(student, career);

            results.add(new CareerResult(career, score));
        }

        results.sort(
                Comparator.comparingDouble(
                        CareerResult::getMatchScore
                ).reversed()
        );

        return results;
    }

    public void displayCareerMatches(
            Student student,
            List<Career> careers) {

        List<CareerResult> results =
                rankCareers(student, careers);

        System.out.println("\n========================================");
        System.out.println("          CAREER MATCHING");
        System.out.println("========================================");

        int rank = 1;

        for (CareerResult result : results) {

            System.out.printf(
                    "%d. %-30s %.2f%%%n",
                    rank++,
                    result.getCareer().getName(),
                    result.getMatchScore()
            );
        }
    }

    public List<String> getSkillGaps(
            Student student,
            Career career) {

        List<String> gaps = new ArrayList<>();

        for (Map.Entry<String, Double> entry :
                career.getRequiredSkills().entrySet()) {

            String skill = entry.getKey();
            double required = entry.getValue();

            double current = student.getSkillScore(skill);

            if (current < required) {
                gaps.add(
                        skill +
                                " (Current: " +
                                current +
                                ", Required: " +
                                required +
                                ")"
                );
            }
        }

        return gaps;
    }

    public static class CareerResult {

        private Career career;
        private double matchScore;

        public CareerResult(
                Career career,
                double matchScore) {

            this.career = career;
            this.matchScore = matchScore;
        }

        public Career getCareer() {
            return career;
        }

        public double getMatchScore() {
            return matchScore;
        }
    }
}