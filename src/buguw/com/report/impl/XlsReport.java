package buguw.com.report.impl;

import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import buguw.com.report.AbstractReport;

public class XlsReport extends AbstractReport {

    @Override
    protected void initExporterParameter() {
      //数字的类型都变成了文本类型解决办法
        paraMap.put(JRXlsAbstractExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
    }

}
