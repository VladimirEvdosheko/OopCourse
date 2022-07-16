package ru.academits.evdoshenko.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(double beginning1, double ending1, double beginning2, double ending2) {
        if (beginning1 == beginning2 && ending1 == ending2) {
            return new Range(beginning2, ending2);
        }

        if (ending1 <= beginning2 || ending2 <= beginning1) {
            return null;
        }

        return new Range(Math.max(beginning1, beginning2), Math.min(ending1, ending2));
    }

    public Range[] getUnion(double beginning1, double ending1, double beginning2, double ending2) {
        if (beginning1 < beginning2 && ending1 >= beginning2 || beginning2 < beginning1 && ending2 >= beginning1) {
            return new Range[]{new Range(Math.min(beginning1, beginning2), Math.max(ending1, ending2))};
        }

        return new Range[]{new Range(beginning1, ending1), new Range(beginning2, ending2)};
    }

    public Range[] getDifference(double beginning1, double ending1, double beginning2, double ending2) {
        if (beginning1 == beginning2 && ending1 == ending2) {
            return new Range[]{};
        }

        if (ending1 == beginning2 && beginning1 < beginning2 || ending2 == beginning1 && beginning2 < beginning1) {
            return null;
        }

        if (beginning1 == beginning2) {
            return new Range[]{new Range(beginning1, Math.max(ending1, ending2) - Math.min(ending1, ending2))};
        }

        if (ending1 == ending2) {
            return new Range[]{new Range(beginning1, Math.max(beginning1, beginning2) -
                    Math.min(beginning1, beginning2))};
        }

        return new Range[]{new Range(Math.min(beginning1, beginning2), Math.max(beginning1, beginning2)),
                new Range(Math.min(ending1, ending2), Math.max(ending1, ending2))};
    }
}