package com.buguw.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import buguw.com.report.IReport;
import buguw.com.report.ReportDataSource;
import buguw.com.report.exception.ReportException;
import buguw.com.report.impl.TextReport;


public class TestTxtReport {
    public static void main(String[] args) {
        Connection connection = null;
        try {
//            ConfigManager.setRootPath("config");
//            ConnectionManager.setConfigFileName("connection-manager.xml");
//            ConnectionManager manager = ConnectionManager.getInstance();
//            connection = manager.getConnection();
            IReport report = new TextReport();
            ReportDataSource dataSource = new ReportDataSource();
            report.setInputFileName("D:/JsperReport/data/bankwater.jrxml");
            report.setOutReportFileFullName("D:/JsperReport/data/bankwater.txt");
            dataSource.setDataSource(connection);
            Map map = new HashMap();
            dataSource.addParameters(map);
            report.injectDataSource(dataSource);
            report.generateReport();
        } catch (ReportException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}
