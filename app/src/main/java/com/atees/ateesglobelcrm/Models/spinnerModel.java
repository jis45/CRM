package com.atees.ateesglobelcrm.Models;

import java.io.Serializable;

public class spinnerModel implements Serializable {

    private  String name;
    private  int image;



    public spinnerModel(){

    }
        public String getName() {
            return name;
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
