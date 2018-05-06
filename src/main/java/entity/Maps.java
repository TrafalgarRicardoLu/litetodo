package entity;

import java.util.HashMap;
import java.util.List;

/**
 * @author trafalgar
 */
public class Maps {
    private static HashMap<String, List<Event>> labelMap = new HashMap<>();

    private static HashMap<String, List<Event>> priorityMap = new HashMap<>();

    private static HashMap<String, List<Event>> projectMap = new HashMap<>();

    public static void initMaps() {

    }

    public static HashMap<String, List<Event>> getLabelMap() {
        return labelMap;
    }


    public static HashMap<String, List<Event>> getPriorityMap() {
        return priorityMap;
    }


    public static HashMap<String, List<Event>> getProjectMap() {
        return projectMap;
    }

}
