package org.example.cut_command;

import java.util.List;

public class Position {
    private final Integer start;
    private final Integer end;

    private Position(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public static Position create(List<Integer> pos) {
        return pos.size() == 2 ?
                new Position(pos.get(0), pos.get(1)) : new Position(pos.get(0), null);
    }

    public Integer getStart() { return this.start; }
    public Integer getEnd() { return this.end; }

    @Override
    public String toString() {
        return "{ " + this.start + ", " + this.end + " }";
    }
}
