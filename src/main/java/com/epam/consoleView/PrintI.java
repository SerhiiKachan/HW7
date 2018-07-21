package com.epam.consoleView;

import java.sql.SQLException;

@FunctionalInterface
public interface PrintI {
    void print() throws SQLException;
}
