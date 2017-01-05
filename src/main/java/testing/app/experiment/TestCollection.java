package testing.app.experiment;

import java.util.*;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestCollection {

    public static void run () {
        Set<Integer> sortedSet = new TreeSet<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return (i2.compareTo(i1));
            }
        });
        sortedSet.add(7);
        sortedSet.add(3);
        sortedSet.add(1);
        sortedSet.add(5);

        Iterator<Integer> iter = sortedSet.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        ArrayList<Integer> list = new ArrayList<> ();
        ListIterator<Integer> rIter = list.listIterator(list.size());

        BitSet bitset = new BitSet(128);
        for (int i = 0; i < 128; i++) {
            if (i%2 == 0) bitset.set(i);
        }
        System.out.println(bitset);
        long []bitArr = bitset.toLongArray();
        int testIndex = bitset.nextSetBit(16);
        System.out.println(bitset.cardinality());

        System.out.println();
        for (int i = bitset.nextSetBit(0); i >= 0; i = bitset.nextSetBit(i+1)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = bitset.previousSetBit(bitset.length()); i >= 0; i = bitset.previousSetBit(i-1)) {
            System.out.print(i + " ");
        }
        System.out.println();

        byte [] bitmap = new byte[4];
        Arrays.fill(bitmap, (byte)0b0);
        for (int i = 0; i < 16; i++) {
            setBitMapTwoBit(bitmap, i, i%4);
        }
        for (int i = 0; i < 16; i++) {
            System.out.println(i + "'s state: " + getBitMapTwoBit(bitmap, i));
        }
        String str = "xyz";
        System.out.println(str);
        str = "abc";
        System.out.println(str);
    }
    private static void setBitMapTwoBit(byte [] bitmap, int num, int state) {
        int len = bitmap.length;
        assert (num < len/2) : "Bitmap not large enough";
        assert (state < 4) : "State cannot be larger than 2^2 = 4";
        int base = num/(8/2);
        int shift = num%(8/2) * 2;

        byte b = (byte) ~(0b11<<shift);
        bitmap[base] &= b;
        b = (byte) ((byte) state<<shift);
        bitmap[base] |= b;
    }
    private static int getBitMapTwoBit(byte [] bitmap, int num) {
        int len = bitmap.length;
        assert (num < len/2) : "Bitmap not large enough";
        int base = num/(8/2);
        int shift = num%(8/2) * 2;

        byte b = (byte) (bitmap[base] >> shift);
        b &= 0b11;
        int state = b;
        return state;
    }

}
