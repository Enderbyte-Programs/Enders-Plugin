package enderbyteprograms.mcplugins.EndersPlugin.blocklogsystem;

import java.util.HashMap;

public class BlockSystem {
    public static HashMap<String,Integer> placed = new HashMap<String,Integer>();
    public static void incrementplaced(String usename) {
        if (!placed.containsKey(usename)) {
            placed.put(usename,1);
        } else {
            placed.put(usename,placed.get(usename).intValue()+1);
        }
    }
    public static HashMap<String,Integer> broken = new HashMap<String,Integer>();
    public static void incrementbroken(String usename) {
        if (!broken.containsKey(usename)) {
            broken.put(usename,1);
        } else {
            broken.put(usename,broken.get(usename).intValue()+1);
        }
    }
}
