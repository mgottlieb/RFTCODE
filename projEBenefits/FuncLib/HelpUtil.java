package FuncLib;

import org.eclipse.hyades.execution.runtime.datapool.IDatapool;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import java.io.IOException;
import com.rational.test.ft.UnsupportedActionException;
import com.rational.test.ft.script.RationalTestScript;
import com.rational.test.ft.script.ITestObjectMethodState; 
import com.rational.test.ft.vp.IFtVerificationPoint;
import com.rational.test.ft.datapool.DatapoolUtilities;
import com.rational.test.ft.exceptions.TestObjectMethodExceptionHandler;
import com.rational.test.ft.object.interfaces.*;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File; 
import javax.imageio.ImageIO;

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
	                    	   if ((topObjects[j].getProperty(".caption").equals("Security Alert")) || (topObjects[j].getProperty(".caption").equals("Security Information"))){
	                    		   //logWarning("HtmlScript.onObjectNotFound - dismissing Security Alert dialog.");
	                    		   System.out.println("Html.Dialog."+topObjects[j].getProperty(".caption"));
		                           try
		                           {
		                               dismissedAWindow = true;
		                               //((TopLevelTestObject)topObjects[j]).inputKeys("{enter}");
		                               //while(topObjects[j].exists()){
		                            	   ((TopLevelTestObject)topObjects[j]).inputChars("Y");
		                            	   System.out.println("SecurityInfo");
		                            	 //  sleep(3.0);
		                               //}
		                               
		                               //testObjectMethodState.findObjectAgain();
		                           }
		                           catch(RuntimeException e) {}
	                    	   } else if (topObjects[j].getProperty(".caption").equals("Security Warning")){
	                    		   //logWarning("HtmlScript.onObjectNotFound - dismissing Security Warning dialog.");
	                    		   System.out.println("Html.Dialog."+topObjects[j].getProperty(".caption"));
		                           try
		                           {
		                               dismissedAWindow = true;
		                               ((TopLevelTestObject)topObjects[j]).inputKeys("{right}");
		                               sleep(2.0);
		                               ((TopLevelTestObject)topObjects[j]).inputKeys("{enter}");
		                               sleep(15.0);
		                               while(topObjects[j].getProperty(".caption").equals("Security Warning")){
		                            	   ((TopLevelTestObject)topObjects[j]).inputKeys("{enter}");
		                            	   //sleep(3.0);
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
	                    		   //logWarning("HtmlScript.onObjectNotFound - dismissing Certification Error.");
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
	       //logWarning("HtmlScript.onObjectNotFound; no Html Dialog to dismiss");
	   }
	}
//########################################################################################
	public void closeBrowserAny() 
	{	
		try {
			DomainTestObject domains[] = getDomains();
			for (int i = 0; i < domains.length; ++i){
				TestObject[] topObjects = domains[i].getTopObjects();
				if (topObjects != null){
					for (int j = 0; j < topObjects.length; ++j){
						if (topObjects[j].getProperty(".class").equals("Html.Dialog")){
							((TopLevelTestObject)topObjects[j]).close();
						}
					}
				}
			}
			IWindow[] wins = getTopWindows(); 
			for (int n = 0; n < wins.length; ++n){ 
				if (wins[n].getWindowClassName().equals("IEFrame")){ 
					wins[n].close(); 
				}
			}	
			String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe");
				Runtime.getRuntime().exec("taskkill /F /IM EXCEL.EXE");
			} else {
				// Assuming a non Windows OS will be some version of Unix, Linux, or Mac
				Runtime.getRuntime().exec("kill `ps -ef | grep -i firefox | grep -v grep | awk '{print $2}'`");
				Runtime.getRuntime().exec("kill `ps -ef | grep -i chrome | grep -v grep | awk '{print $2}'`");
				Runtime.getRuntime().exec("kill `ps -ef | grep -i safari | grep -v grep | awk '{print $2}'`");
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
//########################################################################################	
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
	public void ValidateIfLinkEnabled(TestObject objParent, String objUnderTest){
		try {
		System.out.println(objUnderTest);
		TestObject[] oLinkProp = objParent.find(atDescendant(".class","Html.A",".text",objUnderTest.trim()));
		GuiTestObject oLink = new GuiTestObject(oLinkProp[oLinkProp.length - 1]);
		String ActValue = oLink.getProperty(".disabled").toString();
	
		//objUnderTest = objUnderTest.replaceAll(" ", "");
		//String strPattern = "[^a-zA-Z]";
		//objUnderTest = objUnderTest.replaceAll(strPattern, "");
		//vpManual("ValidateIfEnabled_"+objUnderTest, "false", ActValue).performTest();
		if (ActValue == "false"){
			logTestResult("On window <<"+objParent.getProperty(".title") + ">>, link object <<"+objUnderTest+">> is Enabled.", true, "VP_"+objUnderTest);
		} else {
			logTestResult("On window <<" + objParent.getProperty(".title") + ">>, link object <<"+objUnderTest+">> is Disabled.", false, "VP_"+objUnderTest);
			printScreen("..\\projEBenefits\\Logs\\Image_"+objUnderTest+".jpg");
		}
		oLink.unregister();
		oLinkProp=null;
		unregister(oLinkProp);
		}
		catch(Exception e){
			logTestResult("On Window <<"+objParent.getProperty(".title")+">>, for object under test <<"+objUnderTest+">>, 'If Enabled' validation failed with exception <<object not found on the page>>.", false, "VP_"+objUnderTest);
			logError("On Window <<"+objParent.getProperty(".title")+">>, for object under test <<"+objUnderTest+">>, 'If Enabled' validation failed with unhandled exception <<"+e.getMessage()+">>.");
		}
	}
	//########################################################################################	
	public void ValidateIfCheckBoxEnabled(TestObject objParent, String objUnderTest){
		try {
		System.out.println(objUnderTest);
		TestObject[] oLinkProp = objParent.find(atDescendant(".class","Html.INPUT.checkbox",".id",objUnderTest.trim()));
		GuiTestObject oLink = new GuiTestObject(oLinkProp[oLinkProp.length - 1]);
		String ActValue = oLink.getProperty(".disabled").toString();
	
		//objUnderTest = objUnderTest.replaceAll(" ", "");
		//String strPattern = "[^a-zA-Z]";
		//objUnderTest = objUnderTest.replaceAll(strPattern, "");
		//vpManual("ValidateIfEnabled_"+objUnderTest, "false", ActValue).performTest();
		if (ActValue == "false"){
			logTestResult("On window <<"+objParent.getProperty(".title") + ">>, checkbox object <<"+objUnderTest+">> is Enabled.", true, "VP_"+objUnderTest);
		} else {
			logTestResult("On window <<" + objParent.getProperty(".title") + ">>, checkbox object <<"+objUnderTest+">> is Disabled.", false, "VP_"+objUnderTest);
			printScreen("..\\projEBenefits\\Logs\\Image_"+objUnderTest+".jpg");
		}
		oLink.unregister();
		oLinkProp=null;
		unregister(oLinkProp);
		}
		catch(Exception e){
			logTestResult("On Window <<"+objParent.getProperty(".title")+">>, for object under test <<"+objUnderTest+">>, 'If Enabled' validation failed with exception <<object not found on the page>>.", false, "VP_"+objUnderTest);
			logError("On Window <<"+objParent.getProperty(".title")+">>, for object under test <<"+objUnderTest+">>, 'If Enabled' validation failed with unhandled exception <<"+e.getMessage()+">>.");
		}
	}
	//########################################################################################	
	public boolean ValidateCheckBoxState(TestObject objParent, String objUnderTest, String cbState){
		try {
		System.out.println(objUnderTest);
		TestObject[] oLinkProp = objParent.find(atDescendant(".class","Html.INPUT.checkbox",".id",objUnderTest.trim()));
		GuiTestObject oLink = new GuiTestObject(oLinkProp[oLinkProp.length - 1]);
		String ActValue = oLink.getProperty(".checked").toString();
		if (ActValue.equals("false")){
			ActValue = "UnChecked";}
		else{
			ActValue = "Checked";
		}
		
		if (ActValue.equalsIgnoreCase(cbState)){
			logTestResult("On window <<"+objParent.getProperty(".title") + ">>, checkbox object <<"+objUnderTest+">> is "+ActValue+".", true, "VP_"+objUnderTest);
			oLink.unregister();
			oLinkProp=null;
			unregister(oLinkProp);
			return true;
		} else {
			logTestResult("On window <<" + objParent.getProperty(".title") + ">>, checkbox object <<"+objUnderTest+">> is "+ActValue+". Expected to be "+cbState+".", false, "VP_"+objUnderTest);
			printScreen("..\\projEBenefits\\Logs\\Image_"+objUnderTest+".jpg");
			oLink.unregister();
			oLinkProp=null;
			unregister(oLinkProp);
			return false;}
		}
		catch(Exception e){
			logTestResult("On Window <<"+objParent.getProperty(".title")+">>, for object under test <<"+objUnderTest+">>, 'If Enabled' validation failed with exception <<object not found on the page>>.", false, "VP_"+objUnderTest);
			logError("On Window <<"+objParent.getProperty(".title")+">>, for object under test <<"+objUnderTest+">>, 'If Enabled' validation failed with unhandled exception <<"+e.getMessage()+">>.");
			return false;
		}
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
//#####################################################################################################
	public GuiTestObject getObject(TestObject objParent, String classType, String propName, String objUnderTest){
		TestObject[] oLinkProp = objParent.find(atDescendant(".class",classType,propName,objUnderTest));
		GuiTestObject oLink = new GuiTestObject(oLinkProp[0]);
		return oLink;
	}
	//#####################################################################################################
	public void clickButton (TestObject objParent, String objUnderTest){
		TestObject[] oLinkProp = objParent.find(atDescendant(".class","Html.BUTTON",".text",objUnderTest));
		GuiTestObject oLink = new GuiTestObject(oLinkProp[0]);
		oLink.click();
		oLink.unregister();
		oLinkProp=null;
		unregister(oLinkProp);
	}
	//########################################################################################	
	public void clickLink(TestObject objParent, String objUnderTest) {
		TestObject[] oLinkProp = objParent.find(atDescendant(".class","Html.A",".text",objUnderTest.trim()));
		if (objUnderTest.equals("Apply for Benefits")||objUnderTest.equals("View my Status")
				||objUnderTest.equals("Access My Documents")||objUnderTest.equals("Browse Benefits Links")){
			GuiTestObject oLink = new GuiTestObject(oLinkProp[0]);
			oLink.click();
			oLink.unregister();
		}
		else {
			GuiTestObject oLink = new GuiTestObject(oLinkProp[oLinkProp.length - 1]);
			oLink.click();
			oLink.unregister();
		}
		
		
		oLinkProp=null;
		unregister(oLinkProp);
		
	}
//####################################################################################'	
	public static void setText(String s, GuiTestObject gto) {
			gto.click();

			TopLevelTestObject app = (TopLevelTestObject) gto.getTopParent();
			app.inputKeys("{ExtHome}+{ExtEnd}{ExtDelete}");
	  		app.inputKeys(s);

			app.unregister();
	}
	//########################################################################################	
	public void ValidateText(TestObject objParent, String objUnderTest, String ActValue, String expValue){
		//TestObject[] oLinkProp = objParent.find(atDescendant(".class","Html.DIV",".text",objUnderTest));
		//GuiTestObject oLink = new GuiTestObject(oLinkProp[0]);
		//oLink.click();
		//String ActValue = oLink.getProperty(".text").toString();
		//objUnderTest = objUnderTest.replaceAll(" ", "");
		//vpManual("ValidateLabelText_"+objUnderTest, expValue, ActValue).performTest();
		if (ActValue.equals(expValue)){
			logTestResult("On window <<" + objParent.getProperty(".title") + ">>, for object under test <<"+objUnderTest+">>, corresponding '.text' property actual value <<"+ActValue+">> matched expected value <<"+expValue+">>.", true,"VP_"+objUnderTest);
			
		} else {
			logTestResult("On window <<" + objParent.getProperty(".title") + ">>, for object under test <<"+objUnderTest+">>, corresponding '.text' property actual value <<"+ActValue+">> DIDNOT match expected value <<"+expValue+">>.", false, "VP_"+objUnderTest);
			
		}
		//oLink.unregister();
		//oLinkProp=null;
		//unregister(oLinkProp);
	}
	//########################################################################################
	@Override
	public void onAmbiguousRecognition(
			ITestObjectMethodState testObjectMethodState, TestObject[] choices,
			int[] scores) {
		// TODO Auto-generated method stub
		//super.onAmbiguousRecognition(testObjectMethodState, choices, scores);
		testObjectMethodState.setReturnValue(new Integer(0));
	}
	@Override
	public boolean onCallScriptException(RuntimeException e) {
		return false;
		// TODO Auto-generated method stub
		//return super.onCallScriptException(e);
		
	}
	@Override
	public void onSubitemNotFound(ITestObjectMethodState testObjectMethodState,
			TestObject foundObject, String subitemDescription) {
		// TODO Auto-generated method stub
		//super.onSubitemNotFound(testObjectMethodState, foundObject, subitemDescription);
		testObjectMethodState.setReturnValue(new Integer(0));
	}
	@Override
	public void onTestObjectMethodException(
			ITestObjectMethodState testObjectMethodState, TestObject testObject) {
		// TODO Auto-generated method stub
		//super.onTestObjectMethodException(testObjectMethodState, testObject);
		testObjectMethodState.setReturnValue(new Integer(0));
	}
	@Override
	public boolean onUnhandledException(Throwable e) {
		// TODO Auto-generated method stub
		//return super.onUnhandledException(e);
		logInfo(e.getMessage());
	
		
		
		
		return false;
	}
	@Override
	public void onVpFailure(IFtVerificationPoint vp) {
		// TODO Auto-generated method stub
		//super.onVpFailure(vp);
		
	}
//#######################################################################################
	public void printScreen(String filename) {
		try {
				Robot robot = new Robot();
		 		BufferedImage screenShot = robot.createScreenCapture
				(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				ImageIO.write(screenShot, "JPG", new File(filename));
			} catch (Exception e) {
				System.err.println("Unhandled Exception :  " + e);
				e.printStackTrace();
			}
		}


}