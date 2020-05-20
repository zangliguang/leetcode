package easy;

import java.util.List;

/**
 * 1436. Destination City
 */
public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        return getNext(paths, paths.get(0).get(0));

    }

    private String getNext(List<List<String>> paths, String current) {
        for (int i = 0; i < paths.size(); i++) {
            if(paths.get(i).get(0).equals(current)){
                current=paths.get(i).get(1);
                paths.remove(i);
                return getNext(paths,current);
            }
        }
        return current;
    }
}
