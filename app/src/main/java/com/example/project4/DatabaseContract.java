package com.example.project4;

import android.provider.BaseColumns;

public class DatabaseContract {
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Learning implements BaseColumns {
        public static final String TABLE_NAME = "learning";
        public static final String Category = "category";
        public static final String T_word = "T_word";
        public static final String E_word= "E_word";
        public static final String T_sentence = "T_Sentence";
        public static final String E_Sentence = "E_sentence";
        public static final String audio = "audio";
    }

    public static abstract class Users implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String PASSWORD = "password";
        public static final String EMAIL = "email";
        public static final String NAME = "name";
        public static final String AGE = "age";
    }
    public static abstract class Rate implements BaseColumns {
        public static final String TABLE_NAME = "rate";
        public static final String EMAIL = "email";
        public static final String RATING = "rate";
    }
}