package com.example.sulta.countryrecyclerviewdemo.Model;

/**
 * Created by sulta on 4/12/2018.
 */

public class Country {
    private String name;
    private int image;
    public Country(){

    }
     public Country(String name){
        this.name=name;

    }
    public Country(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
