package sample;

import sample.Main;

import java.sql.*;
import java.util.Scanner;

public class JDBCConnection {

    public Connection connect(String url)
            throws SQLException {
        /*Kalder en connection metode som returnerer et connection objekt.
         Dette objekt skaber en connection til vores URL*/
        return DriverManager.getConnection(url);
    }

    //Departures.TrainID As TrainID from Departures// Fra tidligere version
    public PreparedStatement selectpreparedstatement(Connection conn)
            throws SQLException {
        String query = "select Departures.DepTime As DepTime, Trains.Route as Route from Trains, Departures" +
                " INNER JOIN STATIONS  ON STATIONS.StationID = Departures.StationID" +
                " Where StationName = ? AND StationName = ?  ";
        PreparedStatement selectpstmt = null;
        selectpstmt = conn.prepareStatement(query);
        return selectpstmt;
    }

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


    public void PresentRoute(ResultSet res)
            throws SQLException {
        if (res == null)
            System.out.println("No records");
        while (res != null & res.next()) {
            String foundRoute = res.getString("Route");
            String foundDepartureTime = res.getString("DepTime");
            System.out.println(foundRoute + " " + foundDepartureTime);
        }
    }


}
