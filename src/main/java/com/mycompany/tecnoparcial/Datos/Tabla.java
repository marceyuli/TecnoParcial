package com.mycompany.tecnoparcial.Datos;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tabla {

    public String nombres[];
    public List<List<String>> data = new ArrayList<>();

    public Tabla(ResultSet result) {
        try {
            ResultSetMetaData resultSetMetaData = result.getMetaData();
            int nroColumnas = resultSetMetaData.getColumnCount();
            nombres = new String[nroColumnas];

            for (int i = 1; i <= nroColumnas; ++i) {
                nombres[i - 1] = resultSetMetaData.getColumnName(i);
            }

            while (result.next()) {
                List<String> a = new ArrayList<>();
                for (int i = 1; i <= nroColumnas; i++) {
                    a.add(result.getString(i));
                }
                data.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getColumna() {
        return data.get(0).size();
    }

    public int getFila() {
        return data.size();
    }

    public String getData(int i, int j) {
        return data.get(i).get(j);
    }
}
