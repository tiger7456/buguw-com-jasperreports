package buguw.com.report.impl;

import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import buguw.com.report.AbstractReport;
import buguw.com.report.constant.Constants;


public class TextReport extends AbstractReport {
    @Override
    protected void initExporterParameter() {
        paraMap.put(JRTextExporterParameter.CHARACTER_WIDTH, new Float(5));
        paraMap.put(JRTextExporterParameter.CHARACTER_HEIGHT, new Float(33));
        paraMap.put(JRTextExporterParameter.CHARACTER_ENCODING, Constants.REPORTER_FILE_CODE);
    }

}
