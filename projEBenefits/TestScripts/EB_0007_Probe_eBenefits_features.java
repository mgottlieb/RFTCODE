package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import resources.TestScripts.EB_0007_Probe_eBenefits_featuresHelper;
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
 * @author imcva
 */
public class EB_0007_Probe_eBenefits_features extends EB_0007_Probe_eBenefits_featuresHelper
{
	/**
	 * Script Name   : <b>EB_0004_Validate_AccessForBenefit_Links</b>
	 * Generated     : <b>Sep 9, 2011 1:58:10 PM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 5.1  Build 2600 (S)
	 * 
	 * @since  2011/09/09
	 * @author imcva
	 */
	enum UserLevel {Level1,Level2,Anonymous}
	public void testMain(String[] args) 
	{
		// TODO Insert code here
		
		/**Instantiate Properties file at Config folder.
		 * Make sure there is testConfig.properties saved at config folder.
		 */
		
		setOption(IOptionName.BRING_UP_LOGVIEWER, false);
		setOption(IOptionName.LOG_APPLICATION_GUI_ACTION, false);
		setOption(IOptionName.LOG_EXCEPTION_SNAPSHOT, true);
		setOption(IOptionName.LOG_FORMAT, "xml");
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("..\\projEBenefits\\Config\\testConfig.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Initiate Shared Object Map here. 
		EB_0000_ObjectMap_Helper objMap = new EB_0000_ObjectMap_Helper();
				
		/**closeBrowserAny(): close all existing browsers*/
		closeBrowserAny();
		/**startBrowser(): Open new browser and invoke URL defined in Config.Properties file
		*/
		startBrowser("Internet Explorer", properties.getProperty("url"));
		objMap.document_eBenefitsHome().waitForExistence(120.0, 20.0);
		
		/**Open and Initialize DataPool.
		To initialize csv testdata file as corresponding test datapool, uncomment below line(s). 
		Also, make sure there is a corresponding csv file at TestData folder.
		csv filename should be same as testscript name. 
		*/
		//IDatapoolIterator oDP = getDataPoolObj("..\\projEBenefits\\TestData\\Level_LoginPwd.csv");		
		//while(!oDP.dpDone()){
			// TODO Insert code here
		if (!objMap.lbl_welcomeTag().exists()){
			getObject(objMap.document_eBenefitsHome(), "Html.BUTTON", ".text", "Login").waitForExistence(30.0,2.0);
			getObject(objMap.document_eBenefitsHome(), "Html.BUTTON", ".text", "Login").click();
			objMap.button_logOnsubmit().waitForExistence(30.0, 2.0);
			//objMap.text_LogInID().setText(oDP.dpString("UserID").trim());
			objMap.text_LogInID().setText("jeff.scott");
			objMap.text_pwd().setText("Imcva@789");
			objMap.button_logOnsubmit().click();
			objMap.lbl_welcomeTag().waitForExistence(15.0, 2.0);
			objMap.document_eBenefitsHome().waitForExistence(15.0, 2.0);
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_welcomeTag(), "Welcome JEFF SCOTT");
		}
		//oDP.dpNext();
	//}
		Object[] objLevel = new Object[1];
		objLevel[0] = new String("Level2");
		callScript("EB_0003_Validate_Benefit_Links", objLevel);
		callScript("EB_0004_Validate_AccessForBenefit_Links", objLevel);
		callScript("EB_0005_Validate_ViewMyBenefits_Links", objLevel);
		callScript("EB_0006_Validate_AccessMyDocs_Links", objLevel);
			
	}
}

