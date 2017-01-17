package testing.lib.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yun.li on 1/15/17.
 */
public class Vector2D2 implements Iterator<Integer> {

    int r;
    int c;

    ArrayList<ArrayList<Integer>> cache;

    public Vector2D2(List<List<Integer>> vec2d) {
        cache = new ArrayList<>();
        for (List<Integer> l : vec2d) {
            cache.add(new ArrayList<>(l));
        }
        r = 0;
        c = 0;
        while (r < cache.size()-1 && c == cache.get(r).size()) {
            r++;
            c = 0;
        }
    }

    @Override
    public Integer next() {
        int res = cache.get(r).get(c);
        c++;
        while (r < cache.size()-1 && c == cache.get(r).size()) {
            r++;
            c = 0;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        if (cache.isEmpty()) {
            return false;
        }
        return !(r == cache.size() - 1 && c >= cache.get(r).size());
    }
}
//public class Vector2D2 implements Iterator<Integer> {
//
//    int r;
//    int c;
//
//    ArrayList<ArrayList<Integer>> cache;
//
//    public Vector2D2(List<List<Integer>> vec2d) {
//        cache = new ArrayList<>();
//        for (List<Integer> l : vec2d) {
//            cache.add(new ArrayList<>(l));
//        }
//        r = 0;
//        c = 0;
//        while (r < cache.size()-1 && c == cache.get(r).size()) {
//            r++;
//            c = 0;
//        }
//    }
//
//    @Override
//    public Integer next() {
//        int res = cache.get(r).get(c);
//        c++;
//        while (r < cache.size()-1 && c == cache.get(r).size()) {
//            r++;
//            c = 0;
//        }
//        return res;
//    }
//
//    @Override
//    public boolean hasNext() {
//        if (cache.isEmpty()) {
//            return false;
//        }
//        return !(r >= cache.size() - 1 && c >= cache.get(r).size());
//    }
//}