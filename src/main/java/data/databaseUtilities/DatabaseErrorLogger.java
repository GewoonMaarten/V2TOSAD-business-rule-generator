package data.databaseUtilities;

import java.util.ArrayList;

public class DatabaseErrorLogger {
    private static DatabaseErrorLogger instance = null;

    private static ArrayList<String> errorList = new ArrayList<String>();

    public static DatabaseErrorLogger getInstance() {
        if(instance == null) {
            instance = new DatabaseErrorLogger();
        }
        return instance;
    }

    public void addError(String errorMessage) {
        if(!checkIfErrorExists(errorMessage))
            errorList.add(errorMessage);
    }

    private boolean checkIfErrorExists(String error) {
        for (String e :
                errorList) {
            if (error.equals(e))
                return true;
        }
        return false;
    }

    public String getErrors() {
        String errors = "";
        if (!errorList.isEmpty())
            errors = " caused by:\n";
        for (String s :
                errorList) {
            errors += s + "\n";
        }
        return errors;
    }
}
