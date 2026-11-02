import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();

        // Store all starting cities
        for (List<String> path : paths) {
            set.add(path.get(0));
        }

        // Find the city that is not a starting city
        for (List<String> path : paths) {
            String destination = path.get(1);

            if (!set.contains(destination)) {
                return destination;
            }
        }

        return "";
    }
}