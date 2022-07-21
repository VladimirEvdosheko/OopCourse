package ru.academits.evdoshenko.range;

public record Range(double from, double to) {

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range[] getIntersection(Range range) {
        if (this.to <= range.from || range.to <= this.from) {
            return null;
        }

        return new Range[]{new Range(Math.max(this.from, range.from), Math.min(this.to, range.to))};
    }

    public Range[] getUnion(Range range) {
        if ((this.from <= range.from && this.to >= range.from) || (range.from <= this.from && range.to >= this.from)) {
            return new Range[]{new Range(
                    Math.min(this.from, range.from),
                    Math.max(this.to, range.to))};
        }

        return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
    }

    public Range[] getDifference(Range range) {
        if (this.to <= range.from || range.to <= this.from) {
            return new Range[]{};
        }

        if (this.from == range.from) {
            return new Range[]{new Range(
                    Math.min(this.to, range.to),
                    Math.max(this.to, range.to))};
        }

        if (this.to == range.to) {
            return new Range[]{new Range(
                    Math.min(this.from, range.from),
                    Math.max(this.from, range.from))};
        }

        return new Range[]{new Range(
                Math.min(this.from, range.from),
                Math.max(this.from, range.from)),
                new Range(
                        Math.min(this.to, range.to),
                        Math.max(this.to, range.to))};
    }

    @Override
    public String toString() {
        return String.format("(%.3f; %.3f)", this.from, this.to);
    }
}