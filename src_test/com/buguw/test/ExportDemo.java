/**
 *@copyright Copyright (c) 2008 - 2020
 *@company Giantstone
 */
package com.buguw.test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRLineBox;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.type.HorizontalAlignEnum;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.util.JRBoxUtil;

/**
 * @author 方宗虎
 * @since 2012-5-21
 * @version 1.1.0
 */
public class ExportDemo {
    public static final String DEFAULT_STYLE_NAME = "normalStyle";

    /** title sytle */
    public static final String TITLE_STYLE_NAME = "titleStyle";

    /** column header style */
    public static final String CAPTION_STYLE_NAME = "columnHeaderStyle";

    public static final int WIDTH = 0, HEIGHT = 1;
    public static final int TOP = 0, RIGHT = 1, BOTTOM = 2, LEFT = 3;

    /** page width and hieght */
    public static final int[] PAGE_A4 = { 595, 842 };

    // ~8000
    public static final int[] PAGE_8000 = { 1500, 842 };

    /** page margin,top-right-bottom-left */
    public static final int[] PAGE_MARGIN = { 20, 30, 20, 30 };

    public static int PAGE_WIDTH = 0;

    public JasperDesign createJasperDesign() throws Exception {
        JasperDesign jasperDesign = new JasperDesign();
        jasperDesign.setName("DefaultReport");

        jasperDesign.setPageWidth(595);
        jasperDesign.setPageHeight(842);
        jasperDesign.setColumnWidth(515);
        jasperDesign.setColumnSpacing(0);
        jasperDesign.setLeftMargin(40);
        jasperDesign.setRightMargin(40);
        jasperDesign.setTopMargin(50);
        jasperDesign.setBottomMargin(50);
        jasperDesign.setTitleNewPage(false);
        jasperDesign.setSummaryNewPage(false);
        jasperDesign.setIgnorePagination(true);// 不显示分页表头
        jasperDesign.setWhenNoDataType(WhenNoDataTypeEnum.NO_DATA_SECTION);

        JRDesignStyle normalStyle = new JRDesignStyle();
        normalStyle.setName(DEFAULT_STYLE_NAME);
        normalStyle.setDefault(true);
        normalStyle.setFontName("宋体");
        normalStyle.setFontSize(10);
//        normalStyle.setPdfFontName("STSong-Light");
//        normalStyle.setPdfEncoding("UniGB-UCS2-H");
//        normalStyle.setPdfEmbedded(true);
        normalStyle.setHorizontalAlignment(HorizontalAlignEnum.JUSTIFIED);

        // title style
        JRDesignStyle titleStyle = new JRDesignStyle();
        titleStyle.setName(TITLE_STYLE_NAME);
        titleStyle.setDefault(false);
        titleStyle.setFontName("宋体");
        titleStyle.setFontSize(20);
//        titleStyle.setPdfFontName("STSong-Light");
//        titleStyle.setPdfEncoding("UniGB-UCS2-H");
//        titleStyle.setPdfEmbedded(true);
        titleStyle.setHorizontalAlignment(HorizontalAlignEnum.CENTER);
        titleStyle.setForecolor(Color.BLACK);
        titleStyle.setBlankWhenNull(true);

        // caption style
        JRDesignStyle captionStyle = new JRDesignStyle();
        captionStyle.setName(CAPTION_STYLE_NAME);
        captionStyle.setDefault(false);
        captionStyle.setFontName("宋体");
        captionStyle.setFontSize(12);
//        captionStyle.setPdfFontName("STSong-Light");
//        captionStyle.setPdfEncoding("UniGB-UCS2-H");
//        captionStyle.setPdfEmbedded(true);
        captionStyle.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
        // captionStyle.setForecolor( Color.ORANGE );
        captionStyle.setBold(true);
        // captionStyle.setBackcolor( Color.LIGHT_GRAY );
        captionStyle.setBlankWhenNull(true);
        jasperDesign.addStyle(normalStyle);
        jasperDesign.addStyle(titleStyle);
        jasperDesign.addStyle(captionStyle);

        addFileds(jasperDesign);
        addTextFields(jasperDesign);
        return jasperDesign;
    }

    public JasperReport compile() throws Exception {
        return JasperCompileManager.compileReport(createJasperDesign());
    }

    private List<JRDesignField> dyColumns() {
        List<JRDesignField> list = new ArrayList<JRDesignField>();
        JRDesignField id = new JRDesignField();
        id.setName("id");
        id.setDescription("编号  ");
        id.setValueClass(java.lang.Integer.class);
        list.add(id);

        JRDesignField firstName = new JRDesignField();
        firstName.setName("firstName");
        firstName.setDescription("姓氏  ");
        firstName.setValueClass(java.lang.String.class);
        list.add(firstName);

        JRDesignField lastName = new JRDesignField();
        lastName.setName("lastName");
        lastName.setDescription("名字  ");
        lastName.setValueClass(java.lang.String.class);
        list.add(lastName);

        JRDesignField hireDate = new JRDesignField();
        hireDate.setName("hireDate");
        hireDate.setDescription("出生日期  ");
        hireDate.setValueClass(java.util.Date.class);
        list.add(hireDate);
        return list;
    }

    public void addFileds(JasperDesign jasperDesign) throws Exception {
        for (JRDesignField field : dyColumns()) {
            jasperDesign.addField(field);
        }
    }

    public void addTextFields(JasperDesign jasperDesign) {

        JRDesignBand textFieldBand = new JRDesignBand();
        textFieldBand.setHeight(15);

        JRDesignBand columnHeaderBand = new JRDesignBand();
        columnHeaderBand.setHeight(15);
        int x = 0;
        int y = 15;
        for (JRDesignField item : dyColumns()) {
            // add text field
            JRDesignTextField textField = new JRDesignTextField();
            JRLineBox box = textField.getLineBox();
            // JRLineBox = new JRBaseLineBox(textField);
            textField.setX(x);
            JRBoxUtil.setToBox((byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, Color.black, Color.black, Color.black,
                    Color.black, Color.black, box.getOwnPadding(), box.getOwnTopPadding(), box.getOwnLeftPadding(),
                    box.getOwnBottomPadding(), box.getOwnRightPadding(), box);

            // textField.setY(0);
            textField.setWidth(100);
            textField.setHeight(15);
            // textField.setPositionType(PositionTypeEnum.FLOAT);
            textField.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
            // textField.setStyle( design.getDefaultStyle() );
            textField.setStretchWithOverflow(true);
            JRDesignExpression expression = new JRDesignExpression();
            expression.setText("$F{" + item.getName() + "}");
            if (item.getValueClass().isAssignableFrom(java.util.Date.class))
                textField.setPattern("yyyy-MM-dd HH:mm:ss");
            if (item.getValueClass().isAssignableFrom(java.lang.Integer.class)) {
                textField.setPattern("###,###.##");
            }
            textField.setExpression(expression);
            textField.setBlankWhenNull(true);
            textField.setPrintWhenDetailOverflows(true);
            textFieldBand.addElement(textField);

            // add column header
            JRDesignStaticText columnHeaderText = new JRDesignStaticText();

            box = columnHeaderText.getLineBox();

            JRBoxUtil.setToBox((byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, Color.black, Color.black, Color.black,
                    Color.black, Color.black, 0, 0, 0, 0, 0, box);
            columnHeaderText.setText(item.getDescription());
            columnHeaderText.setX(x);
            columnHeaderText.setY(0);
            columnHeaderText.setWidth(item.getDescription().length() <= 6 ? 100 : item.getDescription().length() * 16);
            columnHeaderText.setHeight(15);
            columnHeaderText.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
            columnHeaderText.setStyleNameReference(CAPTION_STYLE_NAME);
            columnHeaderBand.addElement(columnHeaderText);
            x += 100;
            PAGE_WIDTH += columnHeaderText.getWidth();
        }

        JRDesignBand band = new JRDesignBand();
        band.setHeight(30);

        JRDesignStaticText staticText = new JRDesignStaticText();
        staticText.setX(0);
        staticText.setY(0);
        staticText.setWidth(PAGE_WIDTH);
        staticText.setHeight(30);
        staticText.setStyleNameReference(TITLE_STYLE_NAME);

        staticText.setText("测试  ");
        band.addElement(staticText);
        jasperDesign.setTitle(band);
        jasperDesign.setColumnHeader(columnHeaderBand);
        ((JRDesignSection) jasperDesign.getDetailSection()).addBand(textFieldBand);
    }

    public List<Employees> createBeanCollection() throws CloneNotSupportedException {
        List<Employees> list = new ArrayList<Employees>();
        Employees emp1 = new Employees();
        emp1.setId(2);
        emp1.setFirstName("测试 ");
        emp1.setLastName("测试2 ");
        emp1.setHireDate(new Date());
        list.add(emp1);

        for (int i = 0; i < 100; i++) {
            Employees emp = (Employees) emp1.clone();
            emp.setId(i);
            list.add(emp);
        }

        return list;
    }

    public JasperPrint fillReport() throws Exception {
        JRDataSource dataSource = new JRBeanCollectionDataSource(createBeanCollection(), false);
        JasperReport report = compile();
        // Map<String,Object> parameter = new HashMap<String, Object>();
        // parameter.put("id", Integer.class);
        // parameter.put("firstName", String.class);
        // parameter.put("lastName", String.class);
        // parameter.put("hireDate", java.util.Date.class);
        return JasperFillManager.fillReport(report, null, dataSource);
    }

    public void export() throws Exception {
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT,fillReport());
        exporter.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, "d:\\demo1.pdf");

        // JRCsvExporter exporter = new JRCsvExporter();
        // exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT,fillReport());
        // exporter.setParameter(JRCsvExporterParameter.OUTPUT_FILE_NAME,
        // "d:\\demo1.csv");
        // exporter.setParameter(JRCsvExporterParameter.CHARACTER_ENCODING,
        // "gbk");
        // exporter.setParameter(JRCsvExporterParameter.RECORD_DELIMITER, "\n");
        // exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ",");
        // JRXlsExporter exporter = new JRXlsExporter();
        // exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT,fillReport());
        // exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,
        // "d:\\demo1.xls");
        // exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
        // Boolean.FALSE);
        // exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
        // exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,false);
        // exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER,
        // Boolean.FALSE);
        // exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES, new
        // String[]{"测试"});
        exporter.exportReport();

    }

    public static void main(String[] args) throws Exception {
        ExportDemo demo = new ExportDemo();
        demo.export();
    }
}
