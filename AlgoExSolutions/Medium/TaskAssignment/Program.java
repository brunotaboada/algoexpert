package AlgoExSolutions.Medium.TaskAssignment;

import java.util.*;
import java.util.stream.Collectors;

/**
 * * Task Assignment
 */
class Program {
    private int getIndexOfTask(Map<Integer, List<Integer>> map, int task) {
        List<Integer> indices = map.get(task);
        int index = indices.remove(indices.size() - 1);
        map.put(task, indices);

        return index;
    }

    private Map<Integer, List<Integer>> mapTaskDurationToIndices(List<Integer> tasks) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int idx = 0; idx < tasks.size(); idx++) {
            if (!map.containsKey(tasks.get(idx))) map.put(tasks.get(idx), new ArrayList<>());

            map.get(tasks.get(idx)).add(idx);
        }

        return map;
    }

    public ArrayList<ArrayList<Integer>> taskAssignment2(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        int[] index = new int[]{0};
        Map<Integer, Integer> map = tasks.stream().collect(Collectors.toMap(e -> index[0]++, e -> e, (e1, e2) -> e1, HashMap::new));
        List<Integer> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
            .map(e -> e.getKey())
            .collect(Collectors.toList());
        int start = 0;
        int end = sorted.size() - 1;

        while (start < end) {
            lists.add(new ArrayList<>(Arrays.asList(sorted.get(start), sorted.get(end))));
            start++;
            end--;
        }

        return lists;
    }

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> assignments = new ArrayList<>();
        Map<Integer, List<Integer>> map = mapTaskDurationToIndices(tasks);
        List<Integer> current = new ArrayList<>();
        int start = 0, end = tasks.size() - 1;

        Collections.sort(tasks);

        while (k > 0 && start < end) {
            current.add(getIndexOfTask(map, tasks.get(start)));
            current.add(getIndexOfTask(map, tasks.get(end)));

            assignments.add(new ArrayList<>(current));

            current.clear();
            ++start;
            --end;
            --k;
        }

        return assignments;
    }
}
