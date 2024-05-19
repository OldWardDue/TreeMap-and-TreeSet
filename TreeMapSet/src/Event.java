import java.util.TreeSet;

class Event implements Comparable<Event> {

    int start;
    int end;
    String title;

    @Override
    public int compareTo(Event event) {
        if (start == event.start) {
            return Integer.compare(end, event.end);
        } else {
            return Integer.compare(start, event.start);
        }
    }

    @Override
    public String toString() {
        return "[ " + start + " - " + end + " ] : " + title;
    }
}
