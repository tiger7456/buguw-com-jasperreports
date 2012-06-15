package buguw.com.report;

import java.util.HashMap;
import java.util.Map;
/**
 * 功能说明：报表参数MAP和数据源
 *@author 方宗虎
 *@since 2012-5-15
 *@version 1.1.0
 */
public class ReportDataSource {
    /**
     * 数据源
     */
    private Object dataSource = null;
    /**
     * 参数
     */
    private Map<String, Object> map = new HashMap<String, Object>();

    /**
     * 增加一个参数
     * @param name
     * @param value void
     */
    public void addParameter(String name,Object value){
        map.put(name, value);
    }
    /**
     * 批量增加参数
     * @param paraMap void
     */
    public void addParameters(Map<String, Object> paraMap){
        map.putAll(paraMap);
    }

    /**
     * 获取参数map
     * @return Map<String,Object>
     */
    public Map<String, Object> getDataSourceParameter(){
        return map;
    }
    /**
     * @return the dataSource
     */
    public Object getDataSource() {
        return dataSource;
    }
    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(Object dataSource) {
        this.dataSource = dataSource;
    }
    
}
