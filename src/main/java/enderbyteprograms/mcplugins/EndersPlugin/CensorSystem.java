package enderbyteprograms.mcplugins.EndersPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CensorSystem {
    public static List<String> censored = new ArrayList<String>(Arrays.stream(new String[] {}).toList());

    public static boolean allowed(String data) {
        for (String s:censored) {
            if (data.toLowerCase().contains(s.toLowerCase(Locale.ROOT))) {
                return false;
            }

        }
        return true;
    }
}
