package com.yisenjing.second2;

/**
 * Created by Yisen on 2/21/16.
 */
public class Atothepowerofb {
    public long atob(int a, int b) {

        if (a == 1) {
            return 1;
        }
        if (b <= 0) {
            return 1;
        }
        return b % 2 == 0 ? atob(a, b / 2) * atob(a, b / 2) : atob(a, b / 2) * atob(a, b / 2) * a;
    }
}
