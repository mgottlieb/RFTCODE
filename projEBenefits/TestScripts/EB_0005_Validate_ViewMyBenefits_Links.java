package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import resources.TestScripts.EB_0005_Validate_ViewMyBenefits_LinksHelper;
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
public class EB_0005_Validate_ViewMyBenefits_Links extends EB_0005_Validate_ViewMyBenefits_LinksHelper
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
	//Initiate Shared Object Map here. 
	EB_0000_ObjectMap_Helper objMap = new EB_0000_ObjectMap_Helper();

	UserLevel enumUserLevel = UserLevel.valueOf(args[0]);
	switch(enumUserLevel){
		case Level2:
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "Appeal Status");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "Compensation & Pension Claims Status");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_compPensionError(), "Error We are currently unable to access information about the claims you have filed with VA. If you need help, please call 1-800-827-1000.");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "VA Payment History");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_VAErrorAndContact(), "Error We are unable to locate your information online at this time. Please call 1-800-827-1000 or try again later.");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "Specially Adapted Housing Grant Application & Claim Status");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"(apply for benefits online click here)");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "DoD TRICARE Health Insurance");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.document_DOD_dmdcErrorPage(), "DMDC Error Page Sorry!! Application is not available.");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "Service Member Out-of-Pocket Medical Expenses (CCD)");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.document_ccd_dmdcErrorPage(),"DMDC Error Page Sorry!! Application is not available.");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "Servicemembers' Group Life Insurance (SGLI) Status");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.document_ccd_dmdcErrorPage(),"DMDC Error Page Sorry!! Application is not available.");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "Veterans' Group Life Insurance (VGLI)");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_iEcannotDisplay(),"Internet Explorer cannot display the webpage");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "Service Member Civilian Employment Information");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.document_CivilianInfo_dmdcErrorPage(), "DMDC Error Page Sorry!! Application is not available.");
						
			ClickTabLink(objMap.document_eBenefitsHome(), "View my Status", "Service Member Personnel Information");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.document_SGLI_dmdcErrorPage(), "DMDC Error Page Sorry!! Application is not available.");
			break;
		case Level1:
			System.out.println("Level1 Under Construction");
	        break;
		case Anonymous:
			System.out.println("Anonymous Under Construction");
			break;
			
	}
			
	
	}
}

