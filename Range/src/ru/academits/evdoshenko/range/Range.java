package ru.academits.evdoshenko.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if (to <= range.from || range.to <= from) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (from > range.to) {
            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        }

        if (to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }


    public Range[] getDifference(Range range) {
        if (from >= range.to || to <= range.from) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from && range.to < to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (range.from <= from && range.to < to) {
            return new Range[]{new Range(range.to, to)};
        }

        if (from < range.from && to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[0];

    }

    @Override
    public String toString() {
        return String.format("(%.3f; %.3f)", from, to);
    }
}