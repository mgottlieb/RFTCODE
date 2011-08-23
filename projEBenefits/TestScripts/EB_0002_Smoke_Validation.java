package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import resources.TestScripts.EB_0002_Smoke_ValidationHelper;
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
public class EB_0002_Smoke_Validation extends EB_0002_Smoke_ValidationHelper
{
	/**
	 * Script Name   : <b>EB_0002_Smoke_Validation</b>
	 * Generated     : <b>Aug 22, 2011 11:11:24 AM</b>
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
			properties.load(new FileInputStream("..\\projEBenefits\\Config\\testConfig.txt"));
			//Initiate Shared Object Map here. 
			EB_0000_ObjectMap_Helper objMap = new EB_0000_ObjectMap_Helper();
					
			/**closeBrowserAny(): close all existing browsers*/
			closeBrowserAny();
			/**startBrowser(): Open new browser and invoke URL defined in Config.Properties file
			*/
			sleep (3.0);
			startBrowser("Internet Explorer", properties.getProperty("url"));
			//sleep(30.0);
			//handleExceptions();
			
			
			/*if (objMap.Dialog_SecurityInfo().exists()){
				while (objMap.dialog_htmlDialogButtonYes().exists()){
					objMap.dialog_htmlDialogButtonYes().click();
					sleep (3.0);
				}
			}
			*/
			objMap.document_eBenefitsHome().waitForExistence(15.0, 2.0);
			getObject(objMap.document_eBenefitsHome(), "Html.BUTTON", ".text", "Login").waitForExistence(30.0,2.0);
			getObject(objMap.document_eBenefitsHome(), "Html.BUTTON", ".text", "Login").click();
			
			objMap.button_logOnsubmit().waitForExistence(30.0, 2.0);
			objMap.text_LogInID().setText("jeff.scott");
			objMap.text_pwd().setText("Imcva@789");
			objMap.button_logOnsubmit().click();
			
			objMap.lbl_welcomeTag().waitForExistence(10.0, 2.0);
			String actValue = objMap.lbl_welcomeTag().getProperty(".text").toString();
			vpManual("ValidateWelcomeLabelText", "Welcome JEFF SCOTT", actValue).performTest();
			
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Apply for Benefits");
			clickLink(objMap.document_eBenefitsHome(),"Apply for Benefits");
			objMap.document_eBenefitsHome().waitForExistence(15.0, 2.0);
			//objMap.lbl_welcomeTag().waitForExistence(20.0,2.0);
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"eLearning Center");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Veterans On-Line Applications (VONAPP)");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Specially Adapted Housing Grant Application & Claim Status");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Transfer Post 9/11 Education Benefits");
			
					
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"View my Status");
			clickLink(objMap.document_eBenefitsHome(),"View my Status");
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			//objMap.lbl_welcomeTag().waitForExistence(20.0,2.0);
			//objMap.button_logout().waitForExistence(6.0, 2.0);
					
			
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Access My Documents");
			clickLink(objMap.document_eBenefitsHome(),"Access My Documents");
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			//objMap.lbl_welcomeTag().waitForExistence(20.0,2.0);
			
			
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Browse Benefits Links");
			clickLink(objMap.document_eBenefitsHome(),"Browse Benefits Links");
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			//objMap.lbl_welcomeTag().waitForExistence(20.0,2.0);
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Benefits By State");
			clickLink(objMap.document_eBenefitsHome(),"Benefits By State");
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Compensation");
			clickLink(objMap.document_eBenefitsHome(),"Compensation");
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Death");
			clickLink(objMap.document_eBenefitsHome(),"Death");
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Education");
			clickLink(objMap.document_eBenefitsHome(),"Education");
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Employment");
			clickLink(objMap.document_eBenefitsHome(),"Employment");
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Financial Services");
			clickLink(objMap.document_eBenefitsHome(),"Financial Services");
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Health");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Housing");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Insurance");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Prescription Refill");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Rate Table");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Retirement");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Calculator");
			ValidateIfEnabled(objMap.document_eBenefitsHome(),"Calendar");
			
			
			objMap.document_eBenefitsHome().waitForExistence(10.0, 2.0);
			getObject(objMap.document_eBenefitsHome(), "Html.BUTTON", ".value", "Logout").waitForExistence(30.0,2.0);
			getObject(objMap.document_eBenefitsHome(), "Html.BUTTON", ".value", "Logout").click();
			
			
			
						
			//getObject(objMap.document_eBenefitsHome(), "Apply for Benefits").waitForExistence(30.0,2.0);
			//getObject(objMap.document_eBenefitsHome(), "Apply for Benefits").click();
			
			/**Open and Initialize DataPool.
			To initialize csv testdata file as corresponding test datapool, uncomment below line(s). 
			Also, make sure there is a corresponding csv file at TestData folder.
			csv filename should be same as testscript name. 
			*/
			/*IDatapoolIterator oDP = getDataPoolObj("..\\projEBenefits\\TestData\\EB_0002_Smoke_Validation .csv");		
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
	
//#################################################################################################################################'
	public void handleExceptions(){
		boolean dismissedAWindow = false;
		   DomainTestObject domains[] = getDomains();
		   for (int i = 0; i < domains.length; ++i)
		   {
		       if (domains[i].getName().equals("Html"))
		       {
		           // HTML domain is found.
		           TestObject[] topObjects = domains[i].getTopObjects();
		           if (topObjects != null)
		           {
		               try
		               {
		                   for (int j = 0; j < topObjects.length; ++j)
		                   {
		                	   System.out.println("Check1: Unexpected Window Displayed - "+topObjects[j].getProperty(".class"));
		                       if (topObjects[j].getProperty(".class").equals("Html.Dialog"))
		                       {
		                           // A top-level HtmlDialog is found.
		                    	   if ((topObjects[j].getProperty(".caption").equals("Security Alert")) || (topObjects[j].getProperty(".caption").equals("Security Information"))){
		                    		   logWarning("HtmlScript.onObjectNotFound - dismissing Security Alert dialog.");
		                    		   System.out.println("Html.Dialog");
			                           try
			                           {
			                               dismissedAWindow = true;
			                               //((TopLevelTestObject)topObjects[j]).inputKeys("{enter}");
			                               ((TopLevelTestObject)topObjects[j]).inputChars("Y");
			                               //testObjectMethodState.findObjectAgain();
			                           }
			                           catch(RuntimeException e) {}
		                    	   } else if (topObjects[j].getProperty(".caption").equals("Security Warning")){
		                    		   logWarning("HtmlScript.onObjectNotFound - dismissing Security Warning dialog.");
		                    		   System.out.println("Html.Dialog");
			                           try
			                           {
			                               dismissedAWindow = true;
			                               ((TopLevelTestObject)topObjects[j]).inputKeys("{right}");
			                               sleep(2.0);
			                               ((TopLevelTestObject)topObjects[j]).inputKeys("{enter}");
			                               sleep(15.0);
			                               while(topObjects[j].exists()){
			                            	   ((TopLevelTestObject)topObjects[j]).inputKeys("{enter}");
			                            	   sleep(5.0);
			                               }
			                               //((TopLevelTestObject)topObjects[j]).inputChars("Y");
			                               //testObjectMethodState.findObjectAgain();
			                           }
			                           catch(RuntimeException e) {}
		                    	   }
		                    	   
		                       }
		                       else if (topObjects[j].getProperty(".class").equals("Html.HtmlBrowser"))
		                       {
		                           // A top-level HtmlDialog is found.
		                    	   //if (topObjects[j].getProperty(".caption").equals("Certificate Error: Navigation Blocked")){
		                    		   logWarning("HtmlScript.onObjectNotFound - dismissing Certification Error.");
			                           try
			                           {
			                        	   dismissedAWindow = true;
			                        	   TestObject[] oLinkProp = ((TopLevelTestObject)topObjects[j]).find(atDescendant(".class","Html.A",".text","Continue to this website (not recommended)."));
			                       			GuiTestObject oLink = new GuiTestObject(oLinkProp[0]);
			                       			oLink.click();
			                       			oLink.unregister();
			                       			oLinkProp=null;
			                       			unregister(oLinkProp);
			                       			
			                           }
			                           catch(RuntimeException e) {}
		                    	   //}
		                       }
		                   }
		               }
		               finally
		               {
		                   //unregister all references to top objects
		                   unregister(topObjects);
		               }
		           }
		                       
		       }
		   }
		   if (dismissedAWindow)
		   {
		       //  try again
		       //testObjectMethodState.findObjectAgain();
		   }
		   else
		   {
		       logWarning("HtmlScript.onObjectNotFound; no Html Dialog to dismiss");
		   }
	}
}

