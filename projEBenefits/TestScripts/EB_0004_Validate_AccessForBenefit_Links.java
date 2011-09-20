package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import resources.TestScripts.EB_0004_Validate_AccessForBenefit_LinksHelper;
import TestScripts.EB_0003_Validate_Benefit_Links.UserLevel;

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
public class EB_0004_Validate_AccessForBenefit_Links extends EB_0004_Validate_AccessForBenefit_LinksHelper
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
		EB_0000_ObjectMap_Helper objMap = new EB_0000_ObjectMap_Helper();
	UserLevel enumUserLevel = UserLevel.valueOf(args[0]);
		switch(enumUserLevel){
		case Level2:
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "eLearning Center");
			//Except for IE7, this validation will fail for any other browser.
			objMap.document_internetExplorerCanno().waitForExistence(30.0, 1.0);
			ValidateIfLinkEnabled(objMap.document_internetExplorerCanno(),"Diagnose Connection Problems");
			sleep(3.0);
			int brcounter = getBrowserCount();
			if (brcounter > 1){
				closeSpecificBrowser("Internet Explorer cannot display the webpage");
			}
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Transfer Post 9/11 Education Benefits");
			objMap.document_eBenefitsHome().waitForExistence(240.0, 2.0);
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_TransferPost911GIBillEducationBenefits(), "Transfer Post-9/11 GI Bill Education Benefits");
			
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "VetSuccess Employment Search");
			objMap.document_vetEmplSearch().waitForExistence(60.0, 2.0);
			if (objMap.lbl_vetEmplSearchPageText().getProperty(".text").toString().contains("Authentication Failed")){
				logTestResult("On window <<" + objMap.document_vetEmplSearch().getProperty(".title") + ">>, for object under test <<lbl_vetEmplSearchPageText>>, corresponding '.text' property actual value contains <<Authentication Failed>>.", true,"VP_vetEmplSearchPageText");
				
			} else {
				logTestResult("On window <<" + objMap.document_vetEmplSearch().getProperty(".title") + ">>, for object under test <<lbl_vetEmplSearchPageText()>>, corresponding '.text' property actual value <<Authentication Failed>>.", false, "VP_vetEmplSearchPageText");
				
			}
			closeSpecificBrowser("Authentication Failed");
							
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Apply for Veterans Benefits Online (VONAPP)"); 
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"I Am a New VONAPP User");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"I Have Used VONAPP Before");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Search for a Representative");
			ValidateIfButtonEnabled(objMap.document_eBenefitsHome(), "Html.INPUT.button","Next");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Benefits Explorer");
			sleep(3.0);
			brcounter = getBrowserCount();
			if (brcounter > 1){
				closeSpecificBrowser("eBenefits - Apply");
			}
			MaximizeAnyBrowser();
			ValidateIfButtonEnabled(objMap.document_eBenefitsHome(), "Html.INPUT.submit", "Show Benefits");
			ValidateIfButtonEnabled(objMap.document_eBenefitsHome(), "Html.INPUT.button","Reset Profile");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits","Apply for Veterans Benefits - Manage List of Dependents (VONAPP Direct Connect)");
			ValidateIfLinkEnabled(objMap.document_agentOrangeFastTrackC(),"Apply for Dependent Benefits >");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Fast Track Claims Processing System for Vietnam Veterans");
			objMap.document_agentOrangeFastTrackC().waitForExistence(30.0, 1.0);
			ValidateIfLinkEnabled(objMap.document_agentOrangeFastTrackC(),"Welcome");
			ValidateIfLinkEnabled(objMap.document_agentOrangeFastTrackC(),"New User Registration");
			ValidateIfLinkEnabled(objMap.document_agentOrangeFastTrackC(),"Forgot Your Password?");
			ValidateIfLinkEnabled(objMap.document_agentOrangeFastTrackC(),"Submit Questionnaire");
			ValidateIfLinkEnabled(objMap.document_agentOrangeFastTrackC(),"Help");
			ValidateIfLinkEnabled(objMap.document_agentOrangeFastTrackC(),"Contact Fast Track");
			closeSpecificBrowser("Fast Track Claims");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Health Benefits Eligibility Check");
			objMap.document_eBenefitsHome().waitForExistence(60.0, 2.0);
			MaximizeAnyBrowser();
			ValidateIfButtonEnabled(objMap.document_eBenefitsHome(), "Html.INPUT.submit","Calculate");
			ValidateIfButtonEnabled(objMap.document_eBenefitsHome(), "Html.INPUT.button","Reset");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Order Medical Equipment");
			objMap.document_eBenefitsHome().waitForExistence(60.0, 2.0);
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Batteries for Hearing Aids and Other Medical Devices");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Prosthetic Socks");
								
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Specially Adapted Housing Grant Application & Claim Status");
			objMap.document_eBenefitsHome().waitForExistence(60.0, 2.0);
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_SplAdaptedHousingGrantAppl(), "Specially Adapted Housing Grant Application and Claim Status");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"(apply for benefits online click here)");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "VA Home Loan Certificate of Eligibility");
			objMap.document_eBenefitsHome().waitForExistence(60.0, 2.0);
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Please complete an electronic application");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Review an online correspondence file");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Upload requested documents");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Servicemembers' Group Life Insurance (SGLI) Status");
			objMap.document_eBenefitsHome().waitForExistence(240.0, 2.0);
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_lblSGLI(), "Servicemembers' Group Life Insurance (SGLI) Status");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.document_sgliError(), "DMDC Error Page Sorry!! Application is not available.");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Apply for Benefits", "Veterans' Group Life Insurance (VGLI)");
			objMap.document_eBenefitsHome().waitForExistence(240.0, 2.0);
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_iEcannotDisplay(),"Internet Explorer cannot display the webpage");
			
								
			break;
		case Level1:
			System.out.println("Level1 Under Construction");
	        break;
		case Anonymous:
			System.out.println("Anonymous Under Construction");
			break;

	}
				
		//logError("On Window <<"+objMap.document_eBenefitsHome().getProperty(".title")+">>"+e.getMessage() );
		
		
	}
}

