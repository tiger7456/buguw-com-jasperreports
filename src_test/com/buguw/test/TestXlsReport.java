package com.buguw.test;

import java.util.HashMap;
import java.util.Map;

import com.buguw.common.util.ClassUtil;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.fill.JRVerticalFiller;
import net.sf.jasperreports.engine.query.JRJdbcQueryExecuter;

import buguw.com.report.IReport;
import buguw.com.report.ReportDataSource;
import buguw.com.report.constant.Constants;
import buguw.com.report.exception.ReportException;
import buguw.com.report.impl.PdfReport;
import buguw.com.report.impl.TextReport;
import buguw.com.report.impl.XlsReport;
import buguw.com.report.util.TextFormatUtil;


public class TestXlsReport {
    public static void main(String[] args) {
        String format=TextFormatUtil.capitalize(Constants.PDF_EXTENSION_NAME);
        IReport report = null;//new XlsReport();
        try {
            report = (IReport) ClassUtil.createClassInstance("buguw.com.report.impl."+format+"Report");
        } catch (Exception e) {
            throw new RuntimeException("jasperreport doesn't support the exporter "
                    + TextFormatUtil.containFormat(format) + e);
        }
        ReportDataSource dataSource = new ReportDataSource();
        report.setInputFileName("D:/report/reportFonts.jrxml");
        report.setOutReportFileFullName("D:/report/reportFonts."+format.toLowerCase());
        Map map = new HashMap();
        map.put("name", "虎哥");
        map.put("size", "200");
        map.put("other", "斯蒂芬韩国和");
        map.put("manager", "说过话时光飞逝");
        dataSource.addParameters(map);
        JRDataSource jrDataSource=new JREmptyDataSource();
        dataSource.setDataSource(jrDataSource);
        report.injectDataSource(dataSource);

        try {
            report.generateReport();
        } catch (ReportException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
