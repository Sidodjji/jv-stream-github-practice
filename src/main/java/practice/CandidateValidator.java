package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35   // 🔥 ВАЖНО
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && livedInUkraineEnough(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineEnough(String period) {
        String[] years = period.split("-");
        int from = Integer.parseInt(years[0]);
        int to = Integer.parseInt(years[1]);
        return to - from >= 10;
    }
}
