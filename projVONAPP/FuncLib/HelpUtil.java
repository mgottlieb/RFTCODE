package FuncLib;

import org.eclipse.hyades.execution.runtime.datapool.IDatapool;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import com.rational.test.ft.script.RationalTestScript;
import com.rational.test.ft.script.ITestObjectMethodState; 
import com.rational.test.ft.datapool.DatapoolUtilities;
import com.rational.test.ft.object.interfaces.*;
//import com.rational.test.ft.object.interfaces.TopLevelTestObject;
/**
 * Description   : Super class for script helper
 * 
 * @author imcva
 * @since  August 01, 2011
 */
public abstract class HelpUtil extends RationalTestScript
{
	//TODO Insert shared functionality here
	/** 
	* Overrides the base implementation of 
	* onObjectNotFound. Whenever this event 
	* occurs, look through all the active domains 
	* (places where objects might be found). 
	* For HTML domains (Java and other domains 
	* are skipped) finds all the top objects. 
	* If the top object is an Html Dialog, 
	* types an Enter key to dismiss the dialog. 
	* Logs a warning when this happens. */ 
	
	public void onObjectNotFound(ITestObjectMethodState testObjectMethodState)
	{
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
	                    	   if (topObjects[j].getProperty(".caption").equals("Security Alert")){
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
	       testObjectMethodState.findObjectAgain();
	   }
	   else
	   {
	       logWarning("HtmlScript.onObjectNotFound; no Html Dialog to dismiss");
	   }
	}
//########################################################################################
	public void closeBrowserAny() 
	{
		IWindow[] wins = getTopWindows(); 
		for (int n = 0; n < wins.length; ++n) 
		{ 
			if (wins[n].getWindowClassName().equals("IEFrame")) 
				{ 
					wins[n].close(); 
				}
		} 
	}
//########################################################################################	
	public DomainTestObject getDomainTestObj(String DomainName){
		DomainTestObject [] DomainColl = getDomains();
		DomainTestObject strDomain = null;
		for (int intCounter = 0; intCounter<DomainColl.length; intCounter++){
			if ((boolean)((String) DomainColl[intCounter].getName()).equalsIgnoreCase(DomainName)){
				strDomain = DomainColl[intCounter];
				break;
			}
		}
		return strDomain;
	}
//########################################################################################	
	public void ValidateIfEnabled(TestObject objParent, String objUnderTest){
		TestObject[] oLinkProp = objParent.find(atDescendant(".class","Html.A",".text",objUnderTest));
		GuiTestObject oLink = new GuiTestObject(oLinkProp[0]);
		//oLink.click();
		String ActValue = oLink.getProperty(".disabled").toString();
		objUnderTest = objUnderTest.replaceAll(" ", "");
		vpManual("ValidateIfEnabled_"+objUnderTest, "false", ActValue).performTest();
		/*if (ActValue == "false"){
			logInfo("On window " + objParent.getProperty(".text") + ", object "+objUnderTest+" is Enabled.");
		} else {
			logError("On window " + objParent.getProperty(".text") + ", object "+objUnderTest+" is Disabled.");
		}*/
		oLink.unregister();
		oLinkProp=null;
		unregister(oLinkProp);
	}
//########################################################################################	
	public void ClickObj(TestObject objParent, String objUnderTest) {
		TestObject[] oLinkProp = objParent.find(atDescendant(".class","Html.A",".text",objUnderTest));
		GuiTestObject oLink = new GuiTestObject(oLinkProp[0]);
		oLink.click();
		oLink.unregister();
		oLinkProp=null;
		unregister(oLinkProp);
		
	}
//########################################################################################
	public IDatapoolIterator getDataPoolObj(String filePath){
		//java.io.File csvFile = new java.io.File((String) "C:\\Documents and Settings\\imcva\\IBM\\rationalsdp\\workspace\\Project_Murali\\datapools\\eBenefitsSmokeVP_pint.csv");
		java.io.File csvFile = new java.io.File(filePath);
		IDatapool oDataPool = (IDatapool) DatapoolUtilities.loadCSV(csvFile, ",", true);
		IDatapoolIterator oDPIterator =  dpFactory().open((IDatapool) oDataPool, null);
		oDPIterator.dpInitialize((IDatapool) oDataPool);
		return oDPIterator;
		
	}
//########################################################################################
	public void maximizeWindow(boolean blnFlag){
		DomainTestObject domains[] = getDomains();
		for (int i = 0; i < domains.length; ++i){
		   if (domains[i].getName().equals("Html")){
			   // HTML domain is found.
	           TestObject[] topObjects = domains[i].getTopObjects();
	           TopLevelTestObject topWindow = new TopLevelTestObject(topObjects[0]);
	           if (blnFlag = true){
	        	   topWindow.maximize();
	           }else {topWindow.maximize();}
	        }
		}        
	}
}