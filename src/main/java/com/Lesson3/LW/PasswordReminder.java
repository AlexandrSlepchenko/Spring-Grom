package com.Lesson3.LW;

import org.springframework.beans.factory.annotation.Autowired;

public class PasswordReminder {

//    @Autowired    - Old injection
//    private DbConnector DbConnector;
//
//    public PasswordReminder(DbConnector DbConnector) {
//        this.DbConnector = DbConnector;
//    }

    private com.Lesson3.LW.DbConnector DbConnector;

    @Autowired // - Constructor injection
    public PasswordReminder(DbConnector DbConnector) {
        this.DbConnector = DbConnector;
    }

    public void sendPassword(){
        //logic
    }

//    @Autowired      - Setter injection
//    public void setDbConnector(com.Lesson3.LW.DbConnector dbConnector) {
//        DbConnector = dbConnector;
//    }
}
