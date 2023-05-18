package com.example.datastorage.model;

public class Contact {

    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "contact_id";
    public static final String COLUMN_EMAIL = "contact_email";
    public static final String COLUMN_NAME = "contact_name";

    private String name;
    private String email;
    private int id;

    public Contact() {
    }

    public Contact(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // sql query: creating the table
    public static final String CREATE_TABLE = String.format(
            "CREATE TABLE %s (%s INTEGER PRIMARY_KEY AUTOINCREMENT, " +
                    "%S TEXT," +
                    "%S DATETIME DEFAULT CURRENT_TIMESTAMP" +
                    ")"
            , TABLE_NAME, COLUMN_ID, COLUMN_NAME, COLUMN_EMAIL
    );
}
