package sample;

import java.sql.Connection;
import java.sql.SQLException;


class Model {

    public JDBCConnection retriever;
    Connection conn;
    //Connection er en del af SQLlib


    //Constructor
    private Model() {
        retriever = new JDBCConnection();
    }

    static Model inst;

    static Model getInstance() throws SQLException {
        if (inst == null) {
            inst = new Model();
        }
        return inst;
    }
}

