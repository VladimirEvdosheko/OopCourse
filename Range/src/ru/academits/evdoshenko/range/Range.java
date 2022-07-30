package ru.academits.evdoshenko.range;

public class Range {
    private final double from;
    private final double to;

    public Range(double from, double to) {
        this.from = from;
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
        if (this.to <= range.from || range.to <= this.from) {
            return null;
        }

        return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (this.to <= range.from || range.to <= this.from) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
    }


    public Range[] getDifference(Range range) {
        if (this.from >= range.to || this.to <= range.from || (this.from >= range.from && this.to <= range.to)) {
            return new Range[]{};
        }

        if (this.from == range.from) {
            return new Range[]{new Range(range.to, this.to)};
        }

        if (this.to == range.to) {
            return new Range[]{new Range(this.from, range.from)};
        }

        if (this.from < range.from && this.to > range.to) {
            return new Range[]{
                    new Range(this.from, range.from),
                    new Range(range.to, this.to)};
        }

        return new Range[]{
                new Range(this.from, range.from)};
    }

    @Override
    public String toString() {
        return String.format("(%.3f; %.3f)", from, to);
    }
}