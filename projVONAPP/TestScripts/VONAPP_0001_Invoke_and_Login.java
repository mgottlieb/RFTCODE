package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import resources.TestScripts.VONAPP_0001_Invoke_and_LoginHelper;
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
public class VONAPP_0001_Invoke_and_Login extends VONAPP_0001_Invoke_and_LoginHelper
{
	/**
	 * Script Name   : <b>VONAPP_0001_Invoke_and_Login</b>
	 * Generated     : <b>Aug 15, 2011 4:15:06 PM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 5.1  Build 2600 (S)
	 * 
	 * @since  2011/08/15
	 * @author imcva
	 */
	public void testMain(Object[] args) 
	{
		/**Instantiate Properties file at Config folder.
		 * Make sure there is testConfig.properties saved at config folder.
		 */
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("..\\projVONAPP\\Config\\testConfig.txt"));
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
			csv filename should be same as testscript name. 
			*/
			String[] testscriptName = this.getScriptName().split("\\.");
			IDatapoolIterator oDP = getDataPoolObj("..\\projVONAPP\\TestData\\" + testscriptName[1] +".csv");
			
			while(!oDP.dpDone()){
				// TODO Insert code here
				System.out.print("Login user: " + oDP.dpString("LoginName") + "\n");
				System.out.print("Password for user: " + oDP.dpString("Password") + "\n");
				objMap.link_logIn().waitForExistence(6.0, 2.0);
				objMap.link_logIn().click();
				
				//Waiting for the page is completely loaded with login submit button is on the page
				objMap.button_LoginSubmit().waitForExistence(180.0, 20.0);
				
				objMap.text_loginId().setText(oDP.dpString("LoginName"));
				objMap.text_pwd().setText(oDP.dpString("Password"));
				
				objMap.button_LoginSubmit().click();
				
				// TODO validate the text from the header
				RootTestObject.getScreenTestObject().performTest(
                                        Screen_imageVP(), 2.0, 
                                        20.0);
				
				
				oDP.dpNext();
			}
		} catch (FileNotFoundException e) {
			logError(e.getMessage().toString());
		} catch (IOException e) {
			logError(e.getStackTrace().toString());
		}
	}
}

