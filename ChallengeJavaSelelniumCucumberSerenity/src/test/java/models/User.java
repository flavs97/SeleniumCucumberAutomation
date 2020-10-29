package models;


import java.text.SimpleDateFormat;
import java.util.Date;

import static model.DataMassParser.getObjectWithName;

public class User {



    public String name;
    public String lastename;
    public String email;
    public String password;
    public String title;
    public String company;
    public String phone;
    public String address1;
    public String address2;
    public String city;
    public String state;
    public String postal;
    public String country;
    public String referral;
    public String question;

    public static User withName(String nome) {

        return getObjectWithName(nome, User.class);
    }


    public String getEmail() {
        if(email==null || email.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
            String random = sdf.format(new Date());
            email = "teste." + random + "@mailinator.com";
        }
        return email;
    }

    public void setEmail(String email){

        this.email = email;
    }

    public void limparEmail() {

        email = null;
    }

}