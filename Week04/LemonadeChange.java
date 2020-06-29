import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    private static final int RECEIVE = 5;
    private static final int LEVEL1 = 5;
    private static final int LEVEL2 = 10;
    private static final int LEVEL3 = 20;

    public boolean lemonadeChange(int[] bills) {
        if (bills[0] > RECEIVE) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>(bills.length);
        boolean flag = true;
        for (int bill : bills) {
            int count = map.getOrDefault(bill, 0);
            map.put(bill, count + 1);
            int change = bill - RECEIVE;
            int div = change / LEVEL1;
            if (div == 0) {
                continue;
            }
            if (div == 1) {
                if (map.getOrDefault(change, 0) == 0) {
                    return false;
                }
                int count0 = map.getOrDefault(change, 0) - 1;
                map.put(change, count0);
            } else {
                int change1 = LEVEL2;
                int change2 = LEVEL1;
                boolean hasChange1 = map.getOrDefault(change1, 0) >= 1;
                boolean hasChange2 = map.getOrDefault(change2, 0) >= 1;
                if (!hasChange2) {
                    return false;
                }
                if (!hasChange1) {
                    boolean hasChange3 = map.getOrDefault(change2, 0) >= (LEVEL3 - LEVEL1) / LEVEL1;
                    if (!hasChange3) {
                        return false;
                    }
                    int count3 = map.getOrDefault(change2, 0) - ((LEVEL3 - LEVEL1) / LEVEL1);
                    if (count3 > 0) {
                        map.put(change2, count3);
                    } else {
                        map.remove(change2);
                    }
                    continue;
                }
                int count1 = map.getOrDefault(change1, 0) - 1;
                if (count1 > 0) {
                    map.put(change1, count1);
                } else {
                    map.remove(change1);
                }
                int count2 = map.getOrDefault(change2, 0) - 1;
                if (count2 > 0) {
                    map.put(change2, count2);
                } else {
                    map.remove(change2);
                }
            }
        }
        return flag;
    }
}
