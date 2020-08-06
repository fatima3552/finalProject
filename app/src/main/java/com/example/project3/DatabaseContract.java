package com.example.project3;
import android.provider.BaseColumns;

import android.provider.BaseColumns;

public class DatabaseContract {
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Users implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COL_NAME = "fullname";
        public static final String COL_PHONENUMBER = "phone";
        public static final String COL_EMAIL="email";
        public static final String COL_PASSWORD="password";
        public static final String COL_CONFIRMPASSWORD= "confirm";
        public static final String COL_CNIC= "cnic";


    }

}
