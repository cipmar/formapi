package com.softwaredevelopmentstuff.httpserver.database;

import com.softwaredevelopmentstuff.httpserver.model.Vendor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    private static final Database INSTANCE = new Database();

    private List<Vendor> vendors = Collections.synchronizedList(new ArrayList<>());

    public static Database instance() {
        return INSTANCE;
    }

    private Database() {
        generateVendorData();
    }

    private void generateVendorData() {
        vendors.add(new Vendor("HP", "US", "123123422"));
        vendors.add(new Vendor("Lenovo", "China", "23432342"));
        vendors.add(new Vendor("Dell", "US", "9876545677"));
        vendors.add(new Vendor("Acer", "China", "345456445"));
        vendors.add(new Vendor("Asus", "China", "6545434345"));
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public Vendor findVendor(String name) {
        return getVendors()
                .stream()
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Vendor not found!"));
    }
}
