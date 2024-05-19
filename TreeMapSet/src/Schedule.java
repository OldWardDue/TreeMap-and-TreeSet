import java.util.*;

public class Schedule {

    TreeSet<Event> scheduleSet = new TreeSet<Event>();

    Map<Integer, Integer> scheduleMap = new TreeMap<>();

    void addEvent(int start, int end, String title) {
        Event newEvent = new Event();
        newEvent.start = start;
        newEvent.end = end;
        newEvent.title = title;
        scheduleSet.add(newEvent);

        scheduleMap.put(start, scheduleMap.getOrDefault(start, 0) + 1);
        scheduleMap.put(end, scheduleMap.getOrDefault(end, 0) - 1);

    }

    List<Event> getNext3 (int time) {
        Event event = new Event();
        event.start = time;

        NavigableSet<Event> tailSet = scheduleSet.tailSet(event, true);

        List<Event> result = new ArrayList<>(3);

        for(int i = 0; i < 3; i++) {
            if(!tailSet.isEmpty()) {
                result.add(tailSet.pollFirst());
            }
        }
        return result;
    }

    boolean hasOverlaps() {
        int counter = 0;
        for(Integer key : scheduleMap.keySet()) {
            counter += scheduleMap.get(key);
            if(counter > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        schedule.addEvent(9,10,"Daily meeting");
        schedule.addEvent(11,12,"1:1 with Angry Ivan");
        schedule.addEvent(15,16,"Sync - Big Bet project");
        schedule.addEvent(17,20,"Java community meeting");
        schedule.addEvent(19,21,"Private appointment");

        System.out.println(schedule.getNext3(9));
        System.out.println(schedule.hasOverlaps());
    }
}
