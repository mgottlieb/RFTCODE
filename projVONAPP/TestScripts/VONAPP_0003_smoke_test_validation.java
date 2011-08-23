package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import resources.TestScripts.VONAPP_0003_smoke_test_validationHelper;
import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;
/**
 * Description   : Functional Test Script
 * @author Bhavna Vyas
 */
public class VONAPP_0003_smoke_test_validation extends VONAPP_0003_smoke_test_validationHelper
{
	/**
	 * Script Name   : <b>VONAPP_0003_smoke_test_validation</b>
	 * Generated     : <b>Aug 17, 2011 10:49:56 AM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 5.1  Build 2600 (S)
	 * 
	 * @since  2011/08/17
	 * @author Bhavna Vyas
	 */
	public void testMain(Object[] args) 
	{
		// TODO Insert code here
		
		/**Instantiate Properties file at Config folder.
		 * Make sure there is testConfig.properties saved at config folder.
		 */
		Properties properties = new Properties();
		try {
			
			properties.load(new FileInputStream("..//projVONAPP//Config//testConfig.txt"));
			
			//Initiate Shared Object Map here. 
			VONAPP_0000_ObjectMap_Helper objMap = new VONAPP_0000_ObjectMap_Helper();
					
			/**closeBrowserAny(): close all existing browsers*/
			closeBrowserAny();
			/**startBrowser(): Open new browser and invoke URL defined in Config.Properties file
			*/
			startBrowser("Internet Explorer", properties.getProperty("url"));
			objMap.document_eBenefitsHome().waitForExistence(120.0, 20.0);
			
			/**Open and Initialize DataPool.
			To initialize csv testdata file as corresponding test datapool, uncomment below line(s). 
			Also, make sure there is a corresponding csv file at TestData folder.
			csv filename should be same as testscript name. **/
			
			//String[] testscriptName = this.getScriptName().split("\\.");
			//IDatapoolIterator oDP = getDataPoolObj("..\\projVONAPP\\TestData\\VONAPP_0003_smoke_test_validation .csv");		
			
			//while(!oDP.dpDone()){
				// TODO Insert code here
				
				// Invoke eBenefits and login as Roger.Reyes
				callScript("TestScripts.VONAPP_0001_Invoke_and_Login");
				
				//Click tab 'My eBenefits' and click link 'Veterans Online Application (VONAPP) Direct Connect' 
				objMap.link_myEBenefits().waitForExistence(6.0,2.0);
				objMap.link_myEBenefits().click();
				
				objMap.link_veteransOnlineApplication().waitForExistence(6.0,2.0);
				objMap.link_veteransOnlineApplication().click();
			
				//Validate new Tab 'Manage Dependents (VONAPP II)' exist and enabled. 
				objMap.tab_ManageDependentsVONAPPII().exists();
				ValidateIfEnabled(objMap.document_eBenefitsHome(),"Manage Dependents (VONAPP II)");
				
				//Validate new Links 'Apply for Dependent Benefits >', 'Manage Dependents', 'submit a new application', 
				//'Continue', 'Delete' and 'contact the VA'. exist and enabled. 
				
				objMap.link_applyForDependentBenefits().exists();
				ValidateIfEnabled(objMap.document_eBenefitsHome(),"Apply for Dependent Benefits");
				
				objMap.link_ManageDependents().exists();
				ValidateIfEnabled(objMap.document_eBenefitsHome(),"Manage Dependents");
				
				objMap.link_submitANewApplication().exists();
				ValidateIfEnabled(objMap.document_eBenefitsHome(),"submit a new application");
				
				objMap.link_Continue().exists();
				ValidateIfEnabled(objMap.document_eBenefitsHome(),"Continue");
				
				objMap.link_Delete().exists();
				ValidateIfEnabled(objMap.document_eBenefitsHome(),"Delete");
				
				objMap.link_ContactTheVA().exists();
				ValidateIfEnabled(objMap.document_eBenefitsHome(),"Contact the VA");
				
				//Validate table 'Open Applications' for it's headers exist and are in the expected sequence. 
				objMap.table_OpenApplications().exists();
				//print the Hash Table
				System.out.println(objMap.table_OpenApplications().getTestDataTypes());
				printTableData(objMap.table_OpenApplications());
				//The keys in the Hash table are the valid test data type arguments to getTestData()
				objMap.table_OpenApplications().getTestData("Application Type");
				objMap.table_OpenApplications().getTestData("Created");
				objMap.table_OpenApplications().getTestData("Last Updated");
				objMap.table_OpenApplications().getTestData("Last Opened");
				objMap.table_OpenApplications().getTestData("Expired");
				
				//Validate table 'Submitted Applications' for it's headers exist and are in the expected sequence
				objMap.table_SubmittedApplications().exists();
				//print the Hash Table
				System.out.println(objMap.table_SubmittedApplications().getTestDataTypes());
				printTableData(objMap.table_SubmittedApplications());
				//The keys in the Hash table are the valid test data type arguments to getTestData()
				objMap.table_SubmittedApplications().getTestData("Application Type");
				objMap.table_SubmittedApplications().getTestData("Created");
				objMap.table_SubmittedApplications().getTestData("Last Updated");
				objMap.table_SubmittedApplications().getTestData("Expired");
				objMap.table_SubmittedApplications().getTestData("Submitted");
				
		//	} commented out while
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

public void printTableData(TestObject table) {

   Enumeration<String> testDataTypes = table.getTestDataTypes().keys();
   
	   while (testDataTypes.hasMoreElements()) {
	      String testDataType = testDataTypes.nextElement();
	      System.out.println(testDataType);
	      ITestData iData = table.getTestData(testDataType);
	      if (iData instanceof ITestDataTable) {
	         ITestDataTable iTableData = (ITestDataTable) table
	                                    .getTestData(testDataType);
	         int rows = iTableData.getRowCount();
	         int cols = iTableData.getColumnCount();
	         for (int col = 0; col < cols; col++) {
	            System.out.print(iTableData.getColumnHeader(col));
	            System.out.print("\t\t");
	         }
	         System.out.print("\n");
	         for (int row = 0; row < rows; row++) {
	            for (int col = 0; col < cols; col++) {
	               System.out.print(iTableData.getCell(row, col));
	               System.out.print("\t\t");
	            }
	            System.out.print("\n\n");
	         }
	         System.out.print("\n");
	       } else if ( iData instanceof ITestDataText ) {
	          ITestDataText iText = (ITestDataText) iData;
	          String text = iText.getText();
	    System.out.println(text + "\n\n" );
	 }
	    }
}
}



