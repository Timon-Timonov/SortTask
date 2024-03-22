import java.util.*;

public class MyClass implements SortingSolution {

    private final TreeMap<Long, List<SortedInputstream>> map = new TreeMap<>();

    @Override
    public void sortlt(SortedOutputSteram out, SortedInputstream... in) {

        Arrays.asList(in).forEach(this::getNextValue);
        Long minKey = getMinLongValue();

        while (minKey != null) {
            out.write(minKey);
            map.remove(minKey).forEach(this::getNextValue);
            minKey = getMinLongValue();
        }
    }

    private Long getMinLongValue() {

        try {
            return map.firstKey();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    private void getNextValue(SortedInputstream inStream) {

        Long val = inStream.read();
        if (val != null) {
            if (map.containsKey(val)) {
                map.get(val).add(inStream);
            } else {
                List<SortedInputstream> list = new ArrayList<>();
                list.add(inStream);
                map.put(val, list);
            }
        }
    }
}
