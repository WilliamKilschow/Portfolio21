package sample;

import java.sql.Connection;

/**
 * En singleton klasse til vores JDBC objekt, så vi kun har en forbindelse til databasen.
 */
class Model {

    public JDBCConnection retriever;

    private Model() {                                                                                                    //Constructor
        retriever = new JDBCConnection();
    }

    static Model inst;

    /**
     * Metode der sikrer sig at der kun kan være et objekt af denne klasse.
     * @return Model
     */
    static Model getInstance()  {
        if (inst == null) {
            inst = new Model();
        }
        return inst;
    }
}

