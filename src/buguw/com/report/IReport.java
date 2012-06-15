package buguw.com.report;

import buguw.com.report.exception.ReportException;
/**
 * 功能说明:产生的报表接口
 *@author 方宗虎
 *@since 2012-5-15
 *@version 1.1.0
 */
public interface IReport {
    /**
     * 生成报表
     * @throws ReportException  异常
     * @throws Exception void 异常
     */
    public void generateReport()  throws ReportException,Exception ;
    /**
     * 设置生成的报表文件，包括路径。
     * 例如：D:/JsperReport/data/bankwater.txt
     * @param reportFileFullName void
     */
    public void setOutReportFileFullName(String reportFileFullName);
    /**
     * 报表样式文件，支持jasper和jrxml类型的文件
     * @param inputFileName void
     */
    public void setInputFileName(String inputFileName);
    /**
     * 设置jasperPrint
     * @param jrpxmlFile void
     */
    public void setJasperPrint(String jrpxmlFile);
    /**
     * 根据报表填充流导出报表
     * @throws ReportException
     * @throws Exception void
     */
    public void generateReportByJasperPrint() throws ReportException, Exception;
    /**
     * 设置报表样式需要传递的参数MAP和数据源
     * @param dataSource void
     */
    public abstract void injectDataSource(ReportDataSource dataSource);
    
}
