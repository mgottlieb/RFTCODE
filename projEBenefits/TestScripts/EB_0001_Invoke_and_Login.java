package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import resources.TestScripts.EB_0001_Invoke_and_LoginHelper;
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
 * @author 281MGOTT
 */
public class EB_0001_Invoke_and_Login extends EB_0001_Invoke_and_LoginHelper
{
	/**
	 * Script Name   : <b>EB_0001_Invoke_and_Login</b>
	 * Generated     : <b>Aug 22, 2011 10:26:16 AM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 5.1  Build 2600 (S)
	 * 
	 * @since  2011/08/22
	 * @author 281MGOTT
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
			/*IDatapoolIterator oDP = getDataPoolObj("..\\projEBenefits\\TestData\\EB_0001_Invoke_and_Login .csv");		
			while(!oDP.dpDone()){
				// TODO Insert code here
				 
			}
			*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

