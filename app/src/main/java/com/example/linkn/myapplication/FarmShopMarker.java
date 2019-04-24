package com.example.linkn.myapplication;

import android.annotation.SuppressLint;

import java.util.StringJoiner;

public class FarmShopMarker {

    static final String CITY = "ort";

    static final String SHOP_NAME = "shopname";

    static final String STREET = "straße";

    static final String STREET_NUMBER = "hausnummer";

    static final String ZIP_CODE = "plz";

    private String id;

    private String shopName;

    private String city;

    private String zipCode;

    private String streetNumber;

    private String street;

    public String getShopName() {
        return shopName;
    }

    @SuppressLint("NewApi")
    public String getAddressString() {

        return new StringJoiner(" ")
                .add(street == null ? "" : street)
                .add(streetNumber == null ? "" : streetNumber)
                .add(zipCode == null ? "" : zipCode)
                .add(city == null ? "" : city)
                .toString();
    }

    public FarmShopMarker(String id, String shopName, String city, String zipCode, String streetNumber, String street) {

        this.id = id;
        this.shopName = shopName;
        this.city = city;
        this.zipCode = zipCode;
        this.streetNumber = streetNumber;
        this.street = street;
    }

    public static class FarmShopMarkerBuilder {

        private String id;
        private String shopName;
        private String city;
        private String zipCode;
        private String streetNumber;
        private String street;

        public FarmShopMarkerBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public FarmShopMarkerBuilder setShopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        public FarmShopMarkerBuilder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public FarmShopMarkerBuilder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public FarmShopMarkerBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public FarmShopMarkerBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public FarmShopMarker build() {
            return new FarmShopMarker(id, shopName, city, zipCode, streetNumber, street);
        }

    }
    public String getId(){
        return id;
    }


}
