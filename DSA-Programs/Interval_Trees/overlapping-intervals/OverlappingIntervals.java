

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

public class OverlappingIntervals {

    public static List<Interval> findOverlappingIntervals(Interval[] intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.length <= 1) {
            return result;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        Interval currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            Interval nextInterval = intervals[i];

            if (currentInterval.end >= nextInterval.start) {
                
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                
                result.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        
        result.add(currentInterval);

        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        };

        List<Interval> overlappingIntervals = findOverlappingIntervals(intervals);

        System.out.println("Original Intervals: " + Arrays.toString(intervals));
        System.out.println("Overlapping Intervals: " + overlappingIntervals);
    }
}
