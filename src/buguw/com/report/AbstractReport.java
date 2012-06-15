package buguw.com.report;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;


import com.buguw.common.template.SimpleTemplateEngine;
import com.buguw.common.util.ClassUtil;

import buguw.com.report.constant.Constants;
import buguw.com.report.exception.ReportException;
import buguw.com.report.impl.PdfReport;
import buguw.com.report.util.FileTool;
import buguw.com.report.util.TextFormatUtil;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * 功能说明:报表生成核心抽象类
 * @author 方宗虎
 * @since 2012-5-15
 * @version 1.1.0
 */
public abstract class AbstractReport implements IReport {
    /**
     * 日志系统
     */
    private static final Logger LOGGER= Logger.getLogger(AbstractReport.class);
    /**
     * 报表样式文件，支持jasper和jrxml类型的文件
     */
    private String inputFileName = null;
    /**
     * 设置生成的报表文件，包括路径。报表文件名
     */
    private String reportFileName = null;
    /**
     * 报表导出器
     */
    private JRAbstractExporter exporter = null;
    /**
     * 具体格式的报表导出器
     */
    private String exporterName = "JR${type}Exporter";
    /**
     * 存放生成报表所需要的参数
     */
    protected Map<JRExporterParameter, Object> paraMap = new HashMap<JRExporterParameter, Object>();
    /**
     * 存放生成报表所需要的数据源
     */
    protected ReportDataSource reportDataSource = new ReportDataSource();
    /**
     * 报表填充流
     */
    private JasperPrint jasperPrint=null;
    /**
     * 是否填充报表流时使用物理磁盘缓存
     */
    private Boolean isDiskCache = false;
    /**
     * 是否支持格式ooxml导出器
     */
    private boolean isOoxml = false;
    /**
     * 导出格式支持
     */
    private Map<String, String> formatMap=new HashMap<String, String>(); 

    /**
     * @param isDiskCache the isDiskCache to set
     */
    public void setIsDiskCache(Boolean isDiskCache) {
        this.isDiskCache = isDiskCache;
    }
    /**
     * @return the jasperPrint
     */
    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }
    /**
     * @param jasperPrint the jasperPrint to set
     */
    @Override
    public void setJasperPrint(String jrpxmlFile) {
        if (null==jrpxmlFile||"".equalsIgnoreCase(jrpxmlFile)) {
            throw new ReportException("jrpxmlFile is empty!");
        }
        if (!isExtensionName(jrpxmlFile,Constants.XML_EXTENSION_NAME)) {
            File file = new File(jrpxmlFile);
            throw new ReportException("file"+TextFormatUtil.containFormat(file.getAbsoluteFile())+"doesn't support");
        }
        JasperPrint jasperPrint=null;
        try {
            jasperPrint = (JasperPrint)JRLoader.loadObjectFromFile(jrpxmlFile);
        } catch (JRException e) {
            throw new ReportException("setJasperPrint error!"+e);
        }
        this.jasperPrint = jasperPrint;
    }
    /**
     * 初始化报表导出器的参数设置 void
     */
    protected abstract void initExporterParameter();
    /**
     * 根据报表填充流导出报表
     * @throws ReportException
     * @throws Exception void
     */
    @Override
    public void generateReportByJasperPrint() throws ReportException, Exception {
        long start = System.currentTimeMillis();
        try {
            exporter = (JRAbstractExporter) ClassUtil.createClassInstance("net.sf.jasperreports.engine.export."
                    + exporterName);
        } catch (Exception e) {
            throw new RuntimeException("jasperreport doesn't support the exporter "
                    + TextFormatUtil.containFormat(exporterName) + e);
        }
        try {
            File file = new File(reportFileName);
            FileTool.createDirectory(file.getParent());
            exporter.setParameters(paraMap);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reportFileName);
            exporter.exportReport();
        } catch (JRException e) {
            throw new ReportException("generate report failed!" + e);
        }
        LOGGER.info("Report creation time : " + (System.currentTimeMillis() - start));
        System.out.println("Report creation time : " + (System.currentTimeMillis() - start));

    }

    /**
     * 导出报表
     */
    @Override
    public void generateReport() throws ReportException, Exception {
        long start = System.currentTimeMillis();
        setJasperPrint();
   
        this.initExporterParameter();
        exporter.setParameters(paraMap);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reportFileName);
        try {
            File file = new File(reportFileName);
            FileTool.createDirectory(file.getParent());
            exporter.exportReport();
        } catch (JRException e) {
            throw new ReportException("generate report failed!" + e);
        }
        LOGGER.info("Report creation time : " + (System.currentTimeMillis() - start));
        System.out.println("Report creation time : " + (System.currentTimeMillis() - start));
    }

    /**
     * 填充报表
     *  void
     */
    public void setJasperPrint() throws ReportException, Exception{
        if (reportDataSource.getDataSource() == null) {
            throw new ReportException("data source is empty!");
        }

        if (isCompile()) {
            String tempFileName = FileTool.getfileNameWithOutExtensionName(inputFileName);
            tempFileName += ".jasper";
            JasperCompileManager.compileReportToFile(inputFileName, tempFileName);
            inputFileName = tempFileName;
        }

        try {
            if (isOoxml) {
                exporter = (JRAbstractExporter) ClassUtil.createClassInstance("net.sf.jasperreports.engine.export.ooxml."
                        + exporterName);
            }else {
                exporter = (JRAbstractExporter) ClassUtil.createClassInstance("net.sf.jasperreports.engine.export."
                        + exporterName);   
            }

        } catch (Exception e) {
            throw new RuntimeException("jasperreport doesn't support the exporter "
                    + TextFormatUtil.containFormat(exporterName) + e);
        }

        JasperPrint jasperPrint = getJasperPrint(inputFileName, reportDataSource.getDataSourceParameter(),
                reportDataSource.getDataSource());
        // jasperPrint.setPageWidth(Constants.PPT_WIDTH);
        // jasperPrint.setPageHeight(Constants.PPT_HEIGHT);
        this.jasperPrint=jasperPrint;
       
    }
    /**
     * 获取jasperPrint
     * @param filePath
     * @param parameter
     * @param dataSource
     * @return
     * @throws JRException JasperPrint
     */
    private JasperPrint getJasperPrint(String filePath, Map<String, Object> parameter, Object dataSource)
            throws JRException {
        JasperReport jasperReport = null;
        try {
            
            File reportFile = new File(filePath);
            if(!reportFile.exists()){
                throw new ReportException("generate report failed! 文件:"+filePath+"不存在!");
            }
            File cacheDir = new File(reportFile.getParentFile() + "/cacheDir");
            cacheDir.mkdirs();
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(filePath);
            JRFileVirtualizer virtualizer = new JRFileVirtualizer(2, cacheDir.getPath());
            parameter.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
            
            jasperReport = (JasperReport) JRLoader.loadObjectFromFile(filePath);
            if (dataSource instanceof Connection) {
                Connection connection = (Connection) dataSource;
                return JasperFillManager.fillReport(jasperReport, parameter, connection);
            } else if (dataSource instanceof JRDataSource) {
                JRDataSource jrDataSource = (JRDataSource) dataSource;
                return JasperFillManager.fillReport(jasperReport, parameter, jrDataSource);
            } else {
                throw new ReportException("data Source has problem");
            }

        } catch (JRException e) {
            throw new ReportException("get jasper print failed!" + e);
        }
    }

    /**
     * 判断是否需要编译样式文件
     * @return boolean
     */
    private boolean isCompile() {
        if (inputFileName == null || inputFileName.length() == 0) {
            throw new ReportException("input filename parameter is empty!");
        }
        File file = new File(inputFileName);
        if (!file.exists()) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile()) + "is not exist!");
        }
        if (file.isDirectory()) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile())
                    + "is a directory!");
        }
        if (!file.canRead()) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile()) + "can't read!");
        }
        String[] temp = file.getName().split("\\.");
        if (temp.length != 2) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile())
                    + "doesn't have extension name!");
        }
        if (!temp[1].equalsIgnoreCase("jrxml") && !temp[1].equalsIgnoreCase("jasper")) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile())
                    + "extension name is wrong!");
        }
        if (temp[1].equalsIgnoreCase("jrxml")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 判断文件是否是该后缀名
     * @param filePath
     * @param extensionName
     * @return boolean
     */
    private boolean isExtensionName(String filePath,String extensionName) {
        if (filePath == null || "".equals(filePath)||filePath.length() == 0) {
            throw new ReportException("input filePath is empty!");
        }
        if (extensionName == null || "".equals(extensionName)||extensionName.length() == 0) {
            throw new ReportException("input extensionName is empty!");
        }

        File file = new File(filePath);
        if (!file.exists()) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile()) + "is not exist!");
        }
        if (file.isDirectory()) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile())
                    + "is a directory!");
        }
        if (!file.canRead()) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile()) + "can't read!");
        }
        String[] temp = file.getName().split("\\.");
        if (temp.length != 2) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile())
                    + "doesn't have extension name!");
        }
        if (!temp[1].equalsIgnoreCase(extensionName)) {
            throw new ReportException("file " + TextFormatUtil.containFormat(file.getAbsoluteFile())
                    + "extension name is wrong!");
        }
        if (temp[1].equalsIgnoreCase(extensionName)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 构造函数，初始化
     */
    public AbstractReport() {
        initFormatMap();
        String exporterType = this.getClass().getSimpleName()
                .substring(0, this.getClass().getSimpleName().length() - 6);
        Map<String, String> tmpMap = new HashMap<String, String>();
        char lastChar = exporterType.charAt(exporterType.length()-1);
        if ('x'==lastChar) {
            isOoxml=true;
        }
        tmpMap.put("type", exporterType);
        exporterName = SimpleTemplateEngine.merge(exporterName, tmpMap, true);
    }

    /**
     * 设置报表样式需要传递的参数MAP和数据源
     * @param dataSource void
     */
    public void injectDataSource(ReportDataSource dataSource) {
        this.reportDataSource.addParameters(dataSource.getDataSourceParameter());
        this.reportDataSource.setDataSource(dataSource.getDataSource());
    }

    /**
     * 设置生成的报表文件，包括路径。 例如：D:/JsperReport/data/bankwater.txt
     * @param reportFileFullName void
     */
    @Override
    public void setOutReportFileFullName(String reportFileFullName) {
        this.reportFileName = reportFileFullName;
    }

    /**
     * 报表样式文件，支持jasper和jrxml类型的文件
     * @param inputFileName void
     */
    @Override
    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }
    /**
     * 读取文件初始化
     *  void
     */
    private void initFormatMap(){
        Properties prop = new Properties();
        InputStream in = this.getClass().getResourceAsStream("reportexporter.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            throw new ReportException("reportexporter.properties initFormatMap error!"+e);
        }
        Set keyValue = prop.keySet();
        for (Iterator it = keyValue.iterator(); it.hasNext();)
        {
        String key = (String) it.next();
        String value = prop.getProperty(key);
        formatMap.put(key, value);
        }
    }
    
}
