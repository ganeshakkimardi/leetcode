package practise.src.main.java.leetCode;

import java.util.*;

import java.util.*;

public class LC981_TimeBasedKey_ValueStore {

    // Helper class
    static class Data {
        String val;
        int time;

        Data(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    // TimeMap implementation
    static class TimeMap {

        private Map<String, List<Data>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(new Data(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            return binarySearch(map.get(key), timestamp);
        }

        private String binarySearch(List<Data> list, int time) {
            int left = 0, right = list.size() - 1;

            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (time < list.get(mid).time) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }

            return list.get(left).time <= time ? list.get(left).val : "";
        }
    }

    // Simulates LeetCode input/output
    public static void main(String[] args) {

        String[] operations = {
                "TimeMap", "set", "get", "get", "set", "get", "get"
        };

        Object[][] values = {
                {},
                {"foo", "bar", 1},
                {"foo", 1},
                {"foo", 3},
                {"foo", "bar2", 4},
                {"foo", 4},
                {"foo", 5}
        };

        List<Object> output = new ArrayList<>();
        TimeMap timeMap = null;

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "TimeMap":
                    timeMap = new TimeMap();
                    output.add(null);
                    break;

                case "set":
                    timeMap.set(
                            (String) values[i][0],
                            (String) values[i][1],
                            (int) values[i][2]
                    );
                    output.add(null);
                    break;

                case "get":
                    String result = timeMap.get(
                            (String) values[i][0],
                            (int) values[i][1]
                    );
                    output.add(result);
                    break;
            }
        }

        System.out.println(output);
    }
}

