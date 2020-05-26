package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * People Whose List of Favorite Companies Is Not a Subset of Another List
 */
public class PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        List<Set<String>> sets = new ArrayList<>();
        for (List<String> favoriteCompany : favoriteCompanies) {
            Set<String> set = new HashSet<>();
            for (String s : favoriteCompany) {
                set.add(s);
            }
            sets.add(set);

        }
        for (int i = 0; i < sets.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < sets.size(); j++) {
                if (i != j && sets.get(j).containsAll(sets.get(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(i);
            }

        }
        return res;
    }
}
