package com.ypan.spitest;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public class TestSpiMain {
    public static void main(String[] args) {
        ServiceLoader<Search> load = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = load.iterator();
        if (iterator.hasNext()) {
            Search search = iterator.next();
            List<String> strings = search.searchDoc("666");
        }

    }
}
