package HW;
// @author dtmirizzi

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class HW9_1Main {

    public static LinkedList fileToLL(String f) throws FileNotFoundException, IOException {
        LinkedList<Double> l = new LinkedList<>();
        FileReader reader = new FileReader(f);//"~/Notebook15-16/CSC/HW/Assignment9/Data.txt" Locally
        BufferedReader input = new BufferedReader(reader);

        while (true) {
            String line = input.readLine();
            if (line == null) {
                break;
            }
            l.add(Double.parseDouble(line));

        }

        input.close();
        return l;
    }

    public static double LLtoSum(LinkedList<Double> l) {
        int sum1 = 0;
        for (Double x : l) {
            sum1 += x;
        }
        return sum1;
    }

    public static int LLtoUnique(LinkedList l) {
        HashSet<Double> d = new HashSet();
        Iterator<Double> it = l.iterator();
        while (it.hasNext()) {
            double x = it.next();
            d.add(x);
        }
        return d.size();

    }

    public static void PrintLLtoUnique(LinkedList<Double> l) {
        System.out.println("------------------");
        HashMap<Double, Integer> map = new HashMap<>();
        for (Double x : l) {
            if (map.containsKey(x)) {
                int it = map.get(x);
                map.put(x, (it + 1));
            }
            else{
            map.put(x, 1);
            }
        }
        Iterator<Double> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            double it=iterator.next();
            double key = it;//map.get(iterator.next());
            double value = map.get(it);

            System.out.println(key + " " + value);
        }
        System.out.println("------------------");
    }

    public static void main(String[] args) throws IOException {
        LinkedList l = new LinkedList();
        l= fileToLL("/home/dtmirizzi/Notebook15-16/CSC/HW/Assignment9/Data.txt");
        System.out.println("sumation of file data: "+LLtoSum(l));
        System.out.println("Number of Unique keys: "+LLtoUnique(l));
        PrintLLtoUnique(l);

    }

}
