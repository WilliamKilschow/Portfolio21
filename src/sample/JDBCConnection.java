package sample;

import java.sql.*;

public class JDBCConnection {

    private String message;

    /**
     * Kalder en connection metode som returnerer et connection objekt.
     *          Dette objekt skaber en connection til vores URL
     * @param url
     * @return
     * @throws SQLException
     */

    public Connection connect(String url)
            throws SQLException {

        return DriverManager.getConnection(url);
    }

    /**
     * Forhindrer SQL injections
     * @param conn
     * @return
     * @throws SQLException
     */

    public PreparedStatement selectpreparedstatement(Connection conn)
            throws SQLException {
        String query = "select Departures.DepTime As DepTime, Trains.Route as Route from Trains, Departures" +
                " INNER JOIN STATIONS  ON STATIONS.StationID = Departures.StationID" +
                " Where StationName = ? AND StationName = ?  ";
        PreparedStatement selectpstmt = null;
        selectpstmt = conn.prepareStatement(query);
        return selectpstmt;
    }

    /**
     * Query der specificerer hvor dataen skal hentes i databasen
     * @param StationName
     * @param conn
     * @return
     * @throws SQLException
     */

    public ResultSet plainstatement(String StationName, Connection conn)
            throws SQLException {
        String query = "select Departures.DepTime As DepTime, Trains.Route as Route from Trains, Departures" +
                " INNER JOIN STATIONS  ON STATIONS.StationID = Departures.StationID" +
                " Where StationName = '" + StationName + "'";
        Statement stmt = null;
        ResultSet res = null;
        stmt = conn.createStatement();
        res = stmt.executeQuery(query);
        return res;
    }

    /**
     * Metode der præsenterer den indhentede data fra databasen
     * @param res
     * @return
     * @throws SQLException
     */
    public String PresentRoute(ResultSet res)
            throws SQLException {

        if (res == null)
            System.out.println("No records");

        while (res != null & res.next()) {

            String foundRoute = res.getString("Route");
            String foundDepartureTime = res.getString("DepTime");
            //System.out.println(foundRoute + " " + foundDepartureTime);
            message = (foundRoute + " " + foundDepartureTime);
        }
        return message;
    }

}
