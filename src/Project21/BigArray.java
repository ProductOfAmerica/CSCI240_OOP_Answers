package Project21;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BigArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MapArray arr = new MapArray();
        while (in.hasNext()) {
            String cmd = in.next();
            if (cmd.equals("get")) {
                String val = arr.getVal(in.nextInt(), in.nextInt());
                System.out.println(val == null ? "N/A" : val);
                continue;
            }
            if (cmd.equals("set")) {
                arr.setVal(in.nextInt(), in.nextInt(), in.next());
                continue;
            }
            if (cmd.equals("row")) {
                int row = in.nextInt();
                for (Element elm : arr.getRow(row)) {
                    System.out.printf("arr[%d][%d]: %s\n", row, elm.index, elm.value);
                }
                continue;
            }
            if (!cmd.equals("col")) continue;
            int col = in.nextInt();
            for (Element elm : arr.getCol(col)) {
                System.out.printf("arr[%d][%d]: %s\n", elm.index, col, elm.value);
            }
        }
    }

    public static class Element {
        public int index;
        public String value;

        public Element(int index, String value) {
            this.index = index;
            this.value = value;
        }
    }

    private static class MapArray extends TreeMap<Integer, TreeMap<Integer, String>> {
        String getVal(int row, int column) {
            return (containsKey(row) && ((TreeMap)get(row)).containsKey(column)) ?
                    (String)((TreeMap)get(row)).get(column) : null;
        }

        List<Element> getRow(int row) {
            LinkedList<Element> rtn = new LinkedList<>();
            Map<Integer, String> rVal = get(row);
            if (rVal != null) {
                for (Integer key : rVal.keySet()) {
                    rtn.add(new Element(key, rVal.get(key)));
                }
            }
            return rtn;
        }

        List<Element> getCol(int column) {
            LinkedList<Element> elements = new LinkedList<>();
            for (Integer row : keySet()) {
                if (!((TreeMap)get(row)).containsKey(column))
                    continue;
                elements.add(new Element(row, (String)((TreeMap)get(row)).get(column)));
            }
            return elements;
        }

        void setVal(int row, int column, String str) {
            if (!containsKey(row))
                put(row, new TreeMap<>());
            ((TreeMap)get(row)).put(column, str);
        }
    }
}