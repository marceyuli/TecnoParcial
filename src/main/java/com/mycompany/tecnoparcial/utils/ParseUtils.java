package com.mycompany.tecnoparcial.utils;

// import java.sql.Time;
// import java.text.DateFormat;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;

public class ParseUtils {
    public static String styles =
            "body {\n"
            + "  background-color: #f3f3f3;\n"
            + "  font-family: Futura, sans-serif;\n"
            + "}\n"
            + "\n"
            + "div.wrapper {\n"
            + "  margin: 24px 180px;\n"
            + "}\n"
            + "\n"
            + "h1 {\n"
            + "  color: #716eb6;\n"
            + "  text-align: center;\n"
            + "}\n"
            + "\n"
            + "/* Table styles */\n"
            + "\n"
            + "table {\n"
            + "  border-collapse: collapse;\n"
            + "  border-spacing: 0;\n"
            + "}\n"
            + "\n"
            + "td,\n"
            + "th {\n"
            + "  padding: 0;\n"
            + "  text-align: left;\n"
            + "}\n"
            + "\n"
            + "td.c-table__cell:first-of-type {\n"
            + "  padding-left: 36px;\n"
            + "  width: 66px;\n"
            + "}\n"
            + "\n"
            + "table.c-table {\n"
            + "  -moz-border-radius: 4px;\n"
            + "  -webkit-border-radius: 4px;\n"
            + "  background-color: #fff;\n"
            + "  border-radius: 4px;\n"
            + "  font-size: 12px;\n"
            + "  line-height: 1.25;\n"
            + "  margin-bottom: 24px;\n"
            + "  width: 100%;\n"
            + "}\n"
            + "\n"
            + "td.c-table__cell {\n"
            + "  padding: 12px 6px 12px 12px;\n"
            + "  word-wrap: break-word;\n"
            + "}\n"
            + "\n"
            + "thead.c-table__header tr {\n"
            + "  color: #fff;\n"
            + "}\n"
            + "\n"
            + "thead.c-table__header th {\n"
            + "  background-color: #716eb6;\n"
            + "  padding: 18px 6px 18px 12px;\n"
            + "}\n"
            + "\n"
            + "thead.c-table__header th:first-child {\n"
            + "  border-top-left-radius:  4px;\n"
            + "}\n"
            + "\n"
            + "thead.c-table__header th:last-child {\n"
            + "  border-top-right-radius: 4px;\n"
            + "}\n"
            + "\n"
            + "tbody.c-table__body tr {\n"
            + "  border-bottom: 1px solid rgba(113, 110, 182, 0.15);\n"
            + "}\n"
            + "\n"
            + "tbody.c-table__body tr:last-child {\n"
            + "  border-bottom: none;\n"
            + "}\n"
            + "\n"
            + "tbody.c-table__body tr:hover {\n"
            + "  background-color: rgba(113, 110, 182, 0.15);\n"
            + "  color: #272b37;\n"
            + "}\n"
            ;
            
    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean tryParseBoolean(String value) {
        try {
            Boolean.parseBoolean(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean tryParseString(String value){
        if (value.length() == 0) {
            return false;
        }
        return true;
    }
    // public static boolean tryParseDate(String value) throws ParseException {
    //     try {
    //         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //         dateFormat.parse(value);
    //         return true;
    //     } catch (NumberFormatException e) {
    //         return false;
    //     }

    // }

    public static boolean tryParseDate(String value) {
        if (value.length() < 10 || value.length() > 10) {
            return false;
        }
        return true;
    }

    public static boolean tryParseFloat(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
