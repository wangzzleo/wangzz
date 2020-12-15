package com.wangzz.tmp;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Temp implements Serializable {

    private static Integer i = 10;

    public static void main(String[] args) {
        KeyTest keyTest = new KeyTest(1);
        Map<KeyTest, String> map = new HashMap<>();
        map.put(keyTest, "八宝粥");
        System.out.println(map);
        System.out.println(map.get(keyTest));
        keyTest.id = 2;
        System.out.println(map);
        System.out.println(map.get(keyTest));
    }

    static class KeyTest {

        private int id;

        public KeyTest(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KeyTest) {
                return ((KeyTest) obj).id == id;
            }
            return false;
        }
    }

    private static void tt(Integer t) {
        t = null;
    }

    public static class TempSubClass {
        private void tt(Integer t) {
            t = null;
        }
    }

}
