package com.serpider.github.retrofit_sample.model;

/*
Developed for users by @Serpider
Please read the comments thoroughly before use
*/

public class PersonPOJO {

    /*Building a model to receive and store user information*/
    private final String first_name;
    private final String last_name;
    private final String email_name;
    private final String age_name;

    /*Use the CONTRPL + INSER combination key to make constractor and getter setter*/
    public PersonPOJO(String first_name, String last_name, String email_name, String age_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_name = email_name;
        this.age_name = age_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail_name() {
        return email_name;
    }

    public String getAge_name() {
        return age_name;
    }
}
