package org.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class PPAP {
    static Deque<Character> dq = new ArrayDeque<>();
    static final String PPAP = "PPAP";
    static final Character P = 'P';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] carr = br.readLine().toCharArray();
        for (int i = 0; i < carr.length; i++) {
            dq.add(carr[i]);
            if (dq.size() >= 4) {
                Character one = dq.pollLast();
                Character two = dq.pollLast();
                Character three = dq.pollLast();
                Character four = dq.pollLast();
                String str = new StringBuilder().append(four).append(three).append(two).append(one)
                        .toString();
                if (str.equals(PPAP)) {
                    dq.add(P);
                } else {
                    dq.add(four);
                    dq.add(three);
                    dq.add(two);
                    dq.add(one);
                }
            }
        }
        if (dq.size() == 1 && dq.peek() == P) {
            System.out.println(PPAP);
        } else {
            System.out.println("NP");
        }
    }
}
