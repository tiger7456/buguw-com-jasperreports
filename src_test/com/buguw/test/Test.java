/**
 *@copyright Copyright (c) 2008 - 2020
 *@company Giantstone
 */
package com.buguw.test;

import net.sf.jasperreports.engine.base.VirtualizableElementList;
import net.sf.jasperreports.engine.fill.JRBaseFiller;
import net.sf.jasperreports.engine.fill.JRFillBand;
import net.sf.jasperreports.engine.fill.JRVerticalFiller;
import net.sf.jasperreports.engine.query.JRJdbcQueryExecuter;
import net.sf.jasperreports.engine.util.DeduplicableRegistry;


/**
 *@author 方宗虎
 *@since 2012-5-21
 *@version 1.1.0 
 */
public class Test {

    /**
     * @param args void
     */
    public static void main(String[] args) {
        /**
         * JRBaseFiller ===> JRFillBand 
         * ===> JRBaseFiller ===> JRFillDataset 
         * ===> JRJdbcQueryExecuter ===> JRJdbcQueryExecuter 
         * ===> VirtualizableElementList ===> JRVirtualPrintPage
         * ===> JRBaseFiller ===> JRVerticalFiller
         * ===> DeduplicableRegistry ===> JRVirtualizationContext
         * 
         * 
         */
        JRBaseFiller sdd=null;
        JRFillBand dsfs=null;
        JRJdbcQueryExecuter  ttt = null;
        JRVerticalFiller tt=null;
        VirtualizableElementList ssss=null;
        
        DeduplicableRegistry dfsf=null;

    }
    
    /**
     * 
     * 2012-05-21 10:27:30,847 DEBUG [http-8080-2](JRBaseFiller.java:332)     - Fill 1: created for 试算平衡表
2012-05-21 10:27:30,862 DEBUG [http-8080-2](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: BACKGROUND} for band 4581647
2012-05-21 10:27:30,863 DEBUG [http-8080-2](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: TITLE} for band 2607634
2012-05-21 10:27:30,864 DEBUG [http-8080-2](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: PAGE_HEADER} for band 17917939
2012-05-21 10:27:30,864 DEBUG [http-8080-2](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: COLUMN_HEADER} for band 952123
2012-05-21 10:27:30,865 DEBUG [http-8080-2](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: DETAIL} for band 10668819
2012-05-21 10:27:30,866 DEBUG [http-8080-2](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: SUMMARY} for band 14282174
2012-05-21 10:27:30,870 DEBUG [http-8080-2](JRBaseFiller.java:784)     - Fill 1: filling report
2012-05-21 10:27:30,871 DEBUG [http-8080-2](JRBaseFiller.java:1200)     - Fill 1: using virtualizer net.sf.jasperreports.engine.fill.JRFileVirtualizer@1e966fb
2012-05-21 10:27:30,872 DEBUG [http-8080-2](JRFillDataset.java:724)     - Fill 1: Creating sql query executer
2012-05-21 10:27:30,873 DEBUG [http-8080-2](JRJdbcQueryExecuter.java:243)     - SQL query string: SELECT
     TRIALBALANCE."GL_ACCOUNT_ID" AS TRIALBALANCE_GL_ACCOUNT_ID,
     TRIALBALANCE."ACCOUNT_NAME" AS TRIALBALANCE_ACCOUNT_NAME,
     TRIALBALANCE."ORGANIZATION_PARTY_ID" AS TRIALBALANCE_ORGANIZATION_PART,
     TRIALBALANCE."GROUP_NAME" AS TRIALBALANCE_GROUP_NAME,
     TRIALBALANCE."FROM_DATE" AS TRIALBALANCE_FROM_DATE,
     TRIALBALANCE."ORIG_CURRENCY_UOM_ID" AS TRIALBALANCE_ORIG_CURRENCY_UOM,
     TRIALBALANCE."USER_PREF_DATA_TYPE" AS TRIALBALANCE_USER_PREF_DATA_TY,
     TRIALBALANCE."GL_ACCOUNT_RUN_TYPE" AS TRIALBALANCE_GL_ACCOUNT_RUN_TY,
     TRIALBALANCE."POSTED_DEBITS" AS TRIALBALANCE_POSTED_DEBITS,
     TRIALBALANCE."POSTED_CREDITS" AS TRIALBALANCE_POSTED_CREDITS,
     TRIALBALANCE."LAST_POSTED_DEBITS" AS TRIALBALANCE_LAST_POSTED_DEBIT,
     TRIALBALANCE."LAST_POSTED_CREDITS" AS TRIALBALANCE_LAST_POSTED_CREDI,
     TRIALBALANCE."BALANCE_DEBIT" AS TRIALBALANCE_BALANCE_DEBIT,
     TRIALBALANCE."BALANCE_CREDIT" AS TRIALBALANCE_BALANCE_CREDIT,
     TRIALBALANCE."CURRENCY_FLAG" AS TRIALBALANCE_CURRENCY_FLAG
FROM
     "ODS_REPORT"."TRIALBALANCE" TRIALBALANCE
where
     TRIALBALANCE."ORGANIZATION_PARTY_ID" = ?
and TRIALBALANCE."FROM_DATE" = ?
and TRIALBALANCE."ORIG_CURRENCY_UOM_ID" = ?
order by TRIALBALANCE."GL_ACCOUNT_ID"
2012-05-21 10:27:30,873 DEBUG [http-8080-2](JRJdbcQueryExecuter.java:345)     - Parameter #1 (SBNO of type java.lang.String): 0101
2012-05-21 10:27:30,874 DEBUG [http-8080-2](JRJdbcQueryExecuter.java:345)     - Parameter #2 (EndDate of type java.lang.String): 2012-05-11
2012-05-21 10:27:30,874 DEBUG [http-8080-2](JRJdbcQueryExecuter.java:345)     - Parameter #3 (CYCODE of type java.lang.String): CNY
2012-05-21 10:27:30,909 DEBUG [http-8080-2](JRVerticalFiller.java:141)     - Fill 1: no data
2012-05-21 10:27:30,910 DEBUG [http-8080-2](JRVerticalFiller.java:150)     - Fill 1: all sections
2012-05-21 10:27:30,911 DEBUG [http-8080-2](VirtualizableElementList.java:220)     - generated uid 17531354_8012028_5_-701716319 for net.sf.jasperreports.engine.base.ElementsBlock@7a40fc
2012-05-21 10:27:30,911 DEBUG [http-8080-2](VirtualizableElementList.java:78)     - created block net.sf.jasperreports.engine.base.ElementsBlock@7a40fc for []
2012-05-21 10:27:30,912 DEBUG [http-8080-2](JRVirtualPrintPage.java:116)     - created list [] for page net.sf.jasperreports.engine.base.JRVirtualPrintPage@19e0019
2012-05-21 10:27:30,913 DEBUG [http-8080-2](JRBaseFiller.java:1635)     - Fill 1: adding page 1
2012-05-21 10:27:30,913 DEBUG [http-8080-2](JRVerticalFiller.java:307)     - Fill 1: title
2012-05-21 10:27:30,918 DEBUG [http-8080-2](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@1e212d0
2012-05-21 10:27:30,919 DEBUG [http-8080-2](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@1e212d0 having id 31593168_1337567250917_-1832239861
2012-05-21 10:27:30,919 DEBUG [http-8080-2](JRAbstractLRUVirtualizer.java:430)     - registered object net.sf.jasperreports.engine.base.ElementsBlock@7a40fc with id 17531354_8012028_5_-701716319
2012-05-21 10:27:30,920 DEBUG [http-8080-2](JRVerticalFiller.java:383)     - Fill 1: page header
2012-05-21 10:27:30,950 DEBUG [http-8080-2](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@653c7e
2012-05-21 10:27:30,951 DEBUG [http-8080-2](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@667da1
2012-05-21 10:27:30,952 DEBUG [http-8080-2](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@c1efe7
2012-05-21 10:27:30,952 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@653c7e for object net.sf.jasperreports.engine.fill.JRTemplateText@6d41c0
2012-05-21 10:27:30,953 DEBUG [http-8080-2](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@f7b8fc
2012-05-21 10:27:30,954 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@653c7e for object net.sf.jasperreports.engine.fill.JRTemplateText@191b73f
2012-05-21 10:27:30,954 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@f7b8fc for object net.sf.jasperreports.engine.fill.JRTemplateText@195afdb
2012-05-21 10:27:30,955 DEBUG [http-8080-2](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@653c7e having id 6634622_1337567250950_-1674933446
2012-05-21 10:27:30,955 DEBUG [http-8080-2](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@667da1 having id 6716833_1337567250951_500862840
2012-05-21 10:27:30,956 DEBUG [http-8080-2](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@c1efe7 having id 12709863_1337567250952_-146400486
2012-05-21 10:27:30,956 DEBUG [http-8080-2](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@f7b8fc having id 16234748_1337567250953_-1859978143
2012-05-21 10:27:30,957 DEBUG [http-8080-2](JRVerticalFiller.java:462)     - Fill 1: column header
2012-05-21 10:27:31,010 DEBUG [http-8080-2](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@1e8bb4c
2012-05-21 10:27:31,011 DEBUG [http-8080-2](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@60abc5
2012-05-21 10:27:31,011 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@60abc5 for object net.sf.jasperreports.engine.fill.JRTemplateText@ad2738
2012-05-21 10:27:31,085 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@1e8bb4c for object net.sf.jasperreports.engine.fill.JRTemplateText@1ea0024
2012-05-21 10:27:31,086 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@1e8bb4c for object net.sf.jasperreports.engine.fill.JRTemplateText@1af678c
2012-05-21 10:27:31,087 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@1e8bb4c for object net.sf.jasperreports.engine.fill.JRTemplateText@b754b0
2012-05-21 10:27:31,088 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@1e8bb4c for object net.sf.jasperreports.engine.fill.JRTemplateText@19172f
2012-05-21 10:27:31,088 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@1e8bb4c for object net.sf.jasperreports.engine.fill.JRTemplateText@1414306
2012-05-21 10:27:31,089 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@1e8bb4c for object net.sf.jasperreports.engine.fill.JRTemplateText@1977d1b
2012-05-21 10:27:31,089 DEBUG [http-8080-2](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@968df8
2012-05-21 10:27:31,090 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@60abc5 for object net.sf.jasperreports.engine.fill.JRTemplateText@42c966
2012-05-21 10:27:31,091 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@1e8bb4c for object net.sf.jasperreports.engine.fill.JRTemplateText@b45b29
2012-05-21 10:27:31,091 DEBUG [http-8080-2](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@1e8bb4c having id 32029516_1337567251010_-1750511615
2012-05-21 10:27:31,092 DEBUG [http-8080-2](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@60abc5 having id 6335429_1337567251011_-114457067
2012-05-21 10:27:31,092 DEBUG [http-8080-2](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@968df8 having id 9866744_1337567251089_-651375006
2012-05-21 10:27:31,093 DEBUG [http-8080-2](JRVerticalFiller.java:1019)     - Fill 1: summary
2012-05-21 10:27:31,097 DEBUG [http-8080-2](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@cd1779
2012-05-21 10:27:31,098 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@cd1779 for object net.sf.jasperreports.engine.fill.JRTemplateText@c03da9
2012-05-21 10:27:31,099 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@cd1779 for object net.sf.jasperreports.engine.fill.JRTemplateText@1103411
2012-05-21 10:27:31,099 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@cd1779 for object net.sf.jasperreports.engine.fill.JRTemplateText@ca8735
2012-05-21 10:27:31,100 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@cd1779 for object net.sf.jasperreports.engine.fill.JRTemplateText@72dc45
2012-05-21 10:27:31,100 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@cd1779 for object net.sf.jasperreports.engine.fill.JRTemplateText@db4ccf
2012-05-21 10:27:31,101 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@cd1779 for object net.sf.jasperreports.engine.fill.JRTemplateText@18fbefd
2012-05-21 10:27:31,102 DEBUG [http-8080-2](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@cd1779 for object net.sf.jasperreports.engine.fill.JRTemplateText@43ffed
2012-05-21 10:27:31,102 DEBUG [http-8080-2](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@cd1779 having id 13440889_1337567251097_-515596174
2012-05-21 10:27:31,103 DEBUG [http-8080-2](JRBaseFiller.java:846)     - Fill 1: ended
2012-05-21 10:27:31,103 DEBUG [http-8080-2](JRFillDataset.java:793)     - Fill 1: closing query executer
2012-05-21 10:27:31,111 DEBUG [http-8080-2](VirtualizableElementList.java:448)     - Original uid 17531354_8012028_5_-701716319; new uid 0_6518349_6_-130372796
2012-05-21 10:27:31,196 INFO  [http-8080-2](GeneraterReportService.java:742)     - 报表生成完毕!

2012-05-21 10:27:08,720 INFO  [http-8080-1](GeneraterReportService.java:616)     - 开始生成报表，模板：D:/reportData/report_models_jasper/20120424110755703/满页帐(批量打印)（861c）.jasper
2012-05-21 10:27:08,720 INFO  [http-8080-1](GeneraterReportService.java:617)     - {id=20120424100000001264, cyno=01, sbno=0100, _spdt=00000000, _sourceName=ODS_226, _format=pdf, checkBoxSlected=true, _sbno_=0101, _GRN_=null, _ReportName_=null}
2012-05-21 10:27:08,873 DEBUG [http-8080-1](JRBaseFiller.java:332)     - Fill 1: created for 满页帐(批量打印)（861c）
2012-05-21 10:27:09,503 DEBUG [http-8080-1](JRFillBand.java:148)     - Origin {reportName: null, groupName: acno,bandType: GROUP_HEADER} for band 21789789
2012-05-21 10:27:09,504 DEBUG [http-8080-1](JRFillBand.java:148)     - Origin {reportName: null, groupName: acno,bandType: GROUP_FOOTER} for band 21789789
2012-05-21 10:27:09,505 DEBUG [http-8080-1](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: TITLE} for band 10373568
2012-05-21 10:27:09,510 DEBUG [http-8080-1](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: PAGE_HEADER} for band 23702434
2012-05-21 10:27:09,511 DEBUG [http-8080-1](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: COLUMN_HEADER} for band 6379224
2012-05-21 10:27:09,518 DEBUG [http-8080-1](JRFillBand.java:148)     - Origin {reportName: null, groupName: null,bandType: DETAIL} for band 9562749
2012-05-21 10:27:09,771 DEBUG [http-8080-1](JRBaseFiller.java:784)     - Fill 1: filling report
2012-05-21 10:27:09,771 DEBUG [http-8080-1](JRBaseFiller.java:1200)     - Fill 1: using virtualizer net.sf.jasperreports.engine.fill.JRFileVirtualizer@1a0280d
2012-05-21 10:27:09,772 DEBUG [http-8080-1](JRFillDataset.java:724)     - Fill 1: Creating sql query executer
2012-05-21 10:27:09,773 DEBUG [http-8080-1](JRJdbcQueryExecuter.java:243)     - SQL query string: (SELECT
     FULLPAGE_ACCOUNT."ACNO" AS FULLPAGE_ACCOUNT_ACNO,
     FULLPAGE_ACCOUNT."CUNM" AS FULLPAGE_ACCOUNT_CUNM,
     FULLPAGE_ACCOUNT."TRDT" AS FULLPAGE_ACCOUNT_TRDT,
     FULLPAGE_ACCOUNT."USID" AS FULLPAGE_ACCOUNT_USID,
     FULLPAGE_ACCOUNT."SMCD" AS FULLPAGE_ACCOUNT_SMCD,
     FULLPAGE_ACCOUNT."CCNO" AS FULLPAGE_ACCOUNT_CCNO,
     FULLPAGE_ACCOUNT."AMCD" AS FULLPAGE_ACCOUNT_AMCD,
     FULLPAGE_ACCOUNT."TRAM" AS FULLPAGE_ACCOUNT_TRAM,
     FULLPAGE_ACCOUNT."ACBL" AS FULLPAGE_ACCOUNT_ACBL,
     FULLPAGE_ACCOUNT."CYNO" AS FULLPAGE_ACCOUNT_CYNO,
     FULLPAGE_ACCOUNT."MONTH_FLAG" AS FULLPAGE_ACCOUNT_MONTH_FLAG,
     FULLPAGE_ACCOUNT."ACSB" AS FULLPAGE_ACCOUNT_ACSB,
     FULLPAGE_ACCOUNT."GROUP_NAME" AS FULLPAGE_ACCOUNT_GROUP_NAME,
     FULLPAGE_ACCOUNT."TMSP" AS FULLPAGE_ACCOUNT_TMSP,
     FULLPAGE_ACCOUNT."FROM_FLAG" AS FULLPAGE_ACCOUNT_FROM_FLAG

FROM
     "ODS_REPORT"."FULLPAGE_ACCOUNT" FULLPAGE_ACCOUNT

group by FULLPAGE_ACCOUNT."FROM_FLAG" ,
  FULLPAGE_ACCOUNT."TMSP",
 FULLPAGE_ACCOUNT."GROUP_NAME",
 FULLPAGE_ACCOUNT."ACSB",
 FULLPAGE_ACCOUNT."MONTH_FLAG",
  FULLPAGE_ACCOUNT."CYNO",
 FULLPAGE_ACCOUNT."ACBL",
  FULLPAGE_ACCOUNT."TRAM",
 FULLPAGE_ACCOUNT."AMCD",
  FULLPAGE_ACCOUNT."CCNO",
   FULLPAGE_ACCOUNT."SMCD",
 FULLPAGE_ACCOUNT."USID",
  FULLPAGE_ACCOUNT."TRDT",
  FULLPAGE_ACCOUNT."CUNM",
  FULLPAGE_ACCOUNT."ACNO"
having  FULLPAGE_ACCOUNT."ACSB"=  ?  and  FULLPAGE_ACCOUNT."CYNO"=?
 and left(FULLPAGE_ACCOUNT."TRDT",4)=char(year(current timestamp)-1) and month(current timestamp)=1 and day(current timestamp)=1
order by  FULLPAGE_ACCOUNT."ACNO",FULLPAGE_ACCOUNT."TRDT")

union

(SELECT
     FULLPAGE_ACCOUNT."ACNO" AS FULLPAGE_ACCOUNT_ACNO,
     FULLPAGE_ACCOUNT."CUNM" AS FULLPAGE_ACCOUNT_CUNM,
     FULLPAGE_ACCOUNT."TRDT" AS FULLPAGE_ACCOUNT_TRDT,
     FULLPAGE_ACCOUNT."USID" AS FULLPAGE_ACCOUNT_USID,
     FULLPAGE_ACCOUNT."SMCD" AS FULLPAGE_ACCOUNT_SMCD,
     FULLPAGE_ACCOUNT."CCNO" AS FULLPAGE_ACCOUNT_CCNO,
     FULLPAGE_ACCOUNT."AMCD" AS FULLPAGE_ACCOUNT_AMCD,
     FULLPAGE_ACCOUNT."TRAM" AS FULLPAGE_ACCOUNT_TRAM,
     FULLPAGE_ACCOUNT."ACBL" AS FULLPAGE_ACCOUNT_ACBL,
     FULLPAGE_ACCOUNT."CYNO" AS FULLPAGE_ACCOUNT_CYNO,
     FULLPAGE_ACCOUNT."MONTH_FLAG" AS FULLPAGE_ACCOUNT_MONTH_FLAG,
     FULLPAGE_ACCOUNT."ACSB" AS FULLPAGE_ACCOUNT_ACSB,
     FULLPAGE_ACCOUNT."GROUP_NAME" AS FULLPAGE_ACCOUNT_GROUP_NAME,
     FULLPAGE_ACCOUNT."TMSP" AS FULLPAGE_ACCOUNT_TMSP,
     FULLPAGE_ACCOUNT."FROM_FLAG" AS FULLPAGE_ACCOUNT_FROM_FLAG
FROM
     "ODS_REPORT"."FULLPAGE_ACCOUNT" FULLPAGE_ACCOUNT

group by FULLPAGE_ACCOUNT."FROM_FLAG" ,
  FULLPAGE_ACCOUNT."TMSP",
 FULLPAGE_ACCOUNT."GROUP_NAME",
 FULLPAGE_ACCOUNT."ACSB",
 FULLPAGE_ACCOUNT."MONTH_FLAG",
  FULLPAGE_ACCOUNT."CYNO",
 FULLPAGE_ACCOUNT."ACBL",
  FULLPAGE_ACCOUNT."TRAM",
 FULLPAGE_ACCOUNT."AMCD",
  FULLPAGE_ACCOUNT."CCNO",
   FULLPAGE_ACCOUNT."SMCD",
 FULLPAGE_ACCOUNT."USID",
  FULLPAGE_ACCOUNT."TRDT",
  FULLPAGE_ACCOUNT."CUNM",
  FULLPAGE_ACCOUNT."ACNO"
having  FULLPAGE_ACCOUNT."ACSB"=  ?  and  FULLPAGE_ACCOUNT."CYNO"=?
and FULLPAGE_ACCOUNT."FROM_FLAG"='1' and day(current timestamp)=1 and month(current timestamp)!=1 and substr(FULLPAGE_ACCOUNT."TRDT",5,2)=char(month(current timestamp)-1)
order by FULLPAGE_ACCOUNT."TRDT")

union


(SELECT
     FULLPAGE_ACCOUNT."ACNO" AS FULLPAGE_ACCOUNT_ACNO,
     FULLPAGE_ACCOUNT."CUNM" AS FULLPAGE_ACCOUNT_CUNM,
     FULLPAGE_ACCOUNT."TRDT" AS FULLPAGE_ACCOUNT_TRDT,
     FULLPAGE_ACCOUNT."USID" AS FULLPAGE_ACCOUNT_USID,
     FULLPAGE_ACCOUNT."SMCD" AS FULLPAGE_ACCOUNT_SMCD,
     FULLPAGE_ACCOUNT."CCNO" AS FULLPAGE_ACCOUNT_CCNO,
     FULLPAGE_ACCOUNT."AMCD" AS FULLPAGE_ACCOUNT_AMCD,
     FULLPAGE_ACCOUNT."TRAM" AS FULLPAGE_ACCOUNT_TRAM,
     FULLPAGE_ACCOUNT."ACBL" AS FULLPAGE_ACCOUNT_ACBL,
     FULLPAGE_ACCOUNT."CYNO" AS FULLPAGE_ACCOUNT_CYNO,
     FULLPAGE_ACCOUNT."MONTH_FLAG" AS FULLPAGE_ACCOUNT_MONTH_FLAG,
     FULLPAGE_ACCOUNT."ACSB" AS FULLPAGE_ACCOUNT_ACSB,
     FULLPAGE_ACCOUNT."GROUP_NAME" AS FULLPAGE_ACCOUNT_GROUP_NAME,
     FULLPAGE_ACCOUNT."TMSP" AS FULLPAGE_ACCOUNT_TMSP,
     FULLPAGE_ACCOUNT."FROM_FLAG" AS FULLPAGE_ACCOUNT_FROM_FLAG
FROM
     "ODS_REPORT"."FULLPAGE_ACCOUNT" FULLPAGE_ACCOUNT

group by FULLPAGE_ACCOUNT."FROM_FLAG" ,
  FULLPAGE_ACCOUNT."TMSP",
 FULLPAGE_ACCOUNT."GROUP_NAME",
 FULLPAGE_ACCOUNT."ACSB",
 FULLPAGE_ACCOUNT."MONTH_FLAG",
  FULLPAGE_ACCOUNT."CYNO",
 FULLPAGE_ACCOUNT."ACBL",
  FULLPAGE_ACCOUNT."TRAM",
 FULLPAGE_ACCOUNT."AMCD",
  FULLPAGE_ACCOUNT."CCNO",
   FULLPAGE_ACCOUNT."SMCD",
 FULLPAGE_ACCOUNT."USID",
  FULLPAGE_ACCOUNT."TRDT",
  FULLPAGE_ACCOUNT."CUNM",
  FULLPAGE_ACCOUNT."ACNO"
having  FULLPAGE_ACCOUNT."ACSB"=  ?  and  FULLPAGE_ACCOUNT."CYNO"=?
and FULLPAGE_ACCOUNT."FROM_FLAG"='1' and day(current timestamp)!=1 and month(current timestamp)!=1 and
 FULLPAGE_ACCOUNT."MONTH_FLAG"='0'

order by FULLPAGE_ACCOUNT."TRDT")
2012-05-21 10:27:09,773 DEBUG [http-8080-1](JRJdbcQueryExecuter.java:345)     - Parameter #1 (sbno of type java.lang.String): 0100
2012-05-21 10:27:09,774 DEBUG [http-8080-1](JRJdbcQueryExecuter.java:345)     - Parameter #2 (cyno of type java.lang.String): 01
2012-05-21 10:27:09,774 DEBUG [http-8080-1](JRJdbcQueryExecuter.java:345)     - Parameter #3 (sbno of type java.lang.String): 0100
2012-05-21 10:27:09,775 DEBUG [http-8080-1](JRJdbcQueryExecuter.java:345)     - Parameter #4 (cyno of type java.lang.String): 01
2012-05-21 10:27:09,775 DEBUG [http-8080-1](JRJdbcQueryExecuter.java:345)     - Parameter #5 (sbno of type java.lang.String): 0100
2012-05-21 10:27:09,776 DEBUG [http-8080-1](JRJdbcQueryExecuter.java:345)     - Parameter #6 (cyno of type java.lang.String): 01
2012-05-21 10:27:09,966 DEBUG [http-8080-1](VirtualizableElementList.java:220)     - generated uid 1230280_7787695_3_1821317263 for net.sf.jasperreports.engine.base.ElementsBlock@76d4af
2012-05-21 10:27:09,967 DEBUG [http-8080-1](VirtualizableElementList.java:78)     - created block net.sf.jasperreports.engine.base.ElementsBlock@76d4af for []
2012-05-21 10:27:09,967 DEBUG [http-8080-1](JRVirtualPrintPage.java:116)     - created list [] for page net.sf.jasperreports.engine.base.JRVirtualPrintPage@18567de
2012-05-21 10:27:09,968 DEBUG [http-8080-1](JRBaseFiller.java:1635)     - Fill 1: adding page 1
2012-05-21 10:27:09,968 DEBUG [http-8080-1](JRVerticalFiller.java:383)     - Fill 1: page header
2012-05-21 10:27:10,007 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateFrame@171d6fa
2012-05-21 10:27:10,008 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@d8e0dc
2012-05-21 10:27:10,009 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@2f71e2
2012-05-21 10:27:10,009 DEBUG [http-8080-1](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@d8e0dc for object net.sf.jasperreports.engine.fill.JRTemplateText@6e4e82
2012-05-21 10:27:10,010 DEBUG [http-8080-1](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@d8e0dc for object net.sf.jasperreports.engine.fill.JRTemplateText@1e4620e
2012-05-21 10:27:10,011 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@e1c3a7
2012-05-21 10:27:10,011 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateFrame@171d6fa having id 24237818_1337567230007_1137846311
2012-05-21 10:27:10,012 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@d8e0dc having id 14213340_1337567230008_1385527352
2012-05-21 10:27:10,013 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@2f71e2 having id 3109346_1337567230009_-1880614834
2012-05-21 10:27:10,013 DEBUG [http-8080-1](JRAbstractLRUVirtualizer.java:430)     - registered object net.sf.jasperreports.engine.base.ElementsBlock@76d4af with id 1230280_7787695_3_1821317263
2012-05-21 10:27:10,015 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@e1c3a7 having id 14795687_1337567230011_-1758676029
2012-05-21 10:27:10,015 DEBUG [http-8080-1](JRVerticalFiller.java:462)     - Fill 1: column header
2012-05-21 10:27:10,027 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateFrame@1c57a6a
2012-05-21 10:27:10,028 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@1e7e7e8
2012-05-21 10:27:10,028 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@2a5e75
2012-05-21 10:27:10,029 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateFrame@1c57a6a having id 29719146_1337567230027_-2118043393
2012-05-21 10:27:10,030 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@1e7e7e8 having id 31975400_1337567230028_455049757
2012-05-21 10:27:10,031 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@2a5e75 having id 2776693_1337567230028_-1700292236
2012-05-21 10:27:10,032 DEBUG [http-8080-1](JRVerticalFiller.java:708)     - Fill 1: detail
2012-05-21 10:27:10,043 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@16d36a5
2012-05-21 10:27:10,044 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@11e8e72
2012-05-21 10:27:10,044 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@119e82c
2012-05-21 10:27:10,045 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@1d9bf04
2012-05-21 10:27:10,046 DEBUG [http-8080-1](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@1d9bf04 for object net.sf.jasperreports.engine.fill.JRTemplateText@8bb0f8
2012-05-21 10:27:10,046 DEBUG [http-8080-1](DeduplicableRegistry.java:85)     - Added object net.sf.jasperreports.engine.fill.JRTemplateText@10f9a46
2012-05-21 10:27:10,047 DEBUG [http-8080-1](DeduplicableRegistry.java:92)     - Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@10f9a46 for object net.sf.jasperreports.engine.fill.JRTemplateText@1597cac
2012-05-21 10:27:10,048 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@16d36a5 having id 23934629_1337567230043_-799390336
2012-05-21 10:27:10,049 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@11e8e72 having id 18779762_1337567230044_2021104119
2012-05-21 10:27:10,049 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@119e82c having id 18475052_1337567230044_-244614979
2012-05-21 10:27:10,050 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@1d9bf04 having id 31047428_1337567230045_516267456
2012-05-21 10:27:10,050 DEBUG [http-8080-1](JRVirtualizationContext.java:227)     - Cached template net.sf.jasperreports.engine.fill.JRTemplateText@10f9a46 having id 17799750_1337567230046_146681971
2012-05-21 10:27:10,052 DEBUG [http-8080-1](JRVerticalFiller.java:708)     - Fill 1: detail
2012-05-21 10:27:10,065 DEBUG [http-8080-1](JRVerticalFiller.java:708)     - Fill 1: detail
2012-05-21 10:27:10,076 DEBUG [http-8080-1](JRVerticalFiller.java:708)     - Fill 1: detail
2012-05-21 10:27:10,082 DEBUG [http-8080-1](JRVerticalFiller.java:708)     - Fill 1: detail
2012-05-21 10:27:10,098 DEBUG [http-8080-1](JRBaseFiller.java:846)     - Fill 1: ended
2012-05-21 10:27:10,099 DEBUG [http-8080-1](JRFillDataset.java:793)     - Fill 1: closing query executer
2012-05-21 10:27:10,155 DEBUG [http-8080-1](VirtualizableElementList.java:448)     - Original uid 1230280_7787695_3_1821317263; new uid 0_29453104_4_-196092010
2012-05-21 10:27:10,278 INFO  [http-8080-1](GeneraterReportService.java:742)     - 报表生成完毕!
     */

}
