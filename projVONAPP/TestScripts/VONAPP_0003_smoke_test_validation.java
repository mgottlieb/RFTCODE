package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
			
			properties.load(new FileInputStream("..\\Config\\testConfig.properties"));
			
			//Initiate Shared Object Map here. 
			VONAPP_0000_ObjectMap_Helper objMap = new VONAPP_0000_ObjectMap_Helper();
					
			/**closeBrowserAny(): close all existing browsers*/
			//closeBrowserAny();
			/**startBrowser(): Open new browser and invoke URL defined in Config.Properties file
			*/
			startBrowser("Internet Explorer", properties.getProperty("url"));
			objMap.document_eBenefitsHome().waitForExistence(120.0, 20.0);
			
			/**Open and Initialize DataPool.
			To initialize csv testdata file as corresponding test datapool, uncomment below line(s). 
			Also, make sure there is a corresponding csv file at TestData folder.
			csv filename should be same as testscript name. **/
			
			//String[] testscriptName = this.getScriptName().split("\\.");
			IDatapoolIterator oDP = getDataPoolObj("..\\projVONAPP\\TestData\\VONAPP_0003_smoke_test_validation .csv");		
			
			while(!oDP.dpDone()){
				// TODO Insert code here
				
				// Invoke eBenefits and login as Roger.Reyes
				
				document_eBenefitsHome().waitForExistence(120.0, 20.0);
				
				System.out.print("Login user: " + oDP.dpString("LoginName") + "\n");
				System.out.print("Password for user: " + oDP.dpString("Password") + "\n");
				objMap.link_logIn().waitForExistence(6.0, 2.0);
				objMap.link_logIn().click();
				
				//Waiting for the page is completely loaded with login submit button is on the page
				objMap.button_LoginSubmit().waitForExistence(180.0, 20.0);
				
				objMap.text_loginId().setText(oDP.dpString("LoginName"));
				objMap.text_pwd().setText(oDP.dpString("Password"));
				objMap.button_LoginSubmit().click();
				//what to do for security certificate.for the next page
				
				//////////////////////////////////////////////////////////////////////////
				//Click tab 'My eBenefits' and click link 'Veterans Online Application (VONAPP) Direct Connect' 
				
				objMap.link_myEBenefits().click();
				objMap.link_veteransOnlineApplication().click();
				
				//Validate new Tab 'Manage Dependents (VONAPP II)' exist and enabled. 

				//objMap.manageDependetsVONAPPII().exists();// What to do for Manage dependents??????????
				ValidateIfEnabled(document_eBenefitsHome(),"Manage Dependents (VONAPP II)");
				
				//Validate new Links 'Apply for Dependent Benefits >', 'Manage Dependents', 'submit a new application', 
				//'Continue', 'Delete' and 'contact the VA'. exist and enabled. 
				
				objMap.link_applyForDependentBenefits().exists();
				ValidateIfEnabled(document_eBenefitsHome(),"Apply for Dependent Benefits");
				
				//objMap.link_ManageDependents().exists();// What to do for Manage dependents??????????
				ValidateIfEnabled(document_eBenefitsHome(),"Manage Dependents");
				
				objMap.link_submitANewApplication().exists();
				ValidateIfEnabled(document_eBenefitsHome(),"submit a new application");
				
				objMap.link_btnSubmitAndContinue().exists();
				ValidateIfEnabled(document_eBenefitsHome(),"Continue");
				
				//need to add for delete and contact the VA exists 
				//objMap.link_delete().exists(); ?????????
				ValidateIfEnabled(document_eBenefitsHome(),"Delete");
				ValidateIfEnabled(document_eBenefitsHome(),"Contact the VA");
				
				//Validate table 'Open Applications' for it's headers exist and are in the expected sequence. 
				ValidateIfEnabled(document_eBenefitsHome(),"Open Appllications");//???????
				
				//Validate table 'Submitted Applications' for it's headers exist and are in the expected sequence
				objMap.link_submitANewApplication().exists();
				ValidateIfEnabled(document_eBenefitsHome(),"Submitted Applications");//???????
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private TestObject document_eBenefitsHome() {
		// TODO Auto-generated method stub
		return null;
	}

	public void ValidateIfEnabled(TestObject objParent, String objUnderTest){
		TestObject[] oLinkProp = objParent.find(atDescendant(".class","Html.A",".text",objUnderTest));
		GuiTestObject oLink = new GuiTestObject(oLinkProp[0]);
		//oLink.click();
		String ActValue = oLink.getProperty(".disabled").toString();
		objUnderTest = objUnderTest.replaceAll(" ", "");
		vpManual("ValidateIfEnabled_"+objUnderTest, "false", ActValue).performTest();
		oLink.unregister();
		oLinkProp=null;
		unregister(oLinkProp);
		}
	
	private IDatapoolIterator getDataPoolObj(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

