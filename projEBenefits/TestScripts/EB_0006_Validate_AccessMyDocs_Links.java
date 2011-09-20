package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import resources.TestScripts.EB_0006_Validate_AccessMyDocs_LinksHelper;
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
public class EB_0006_Validate_AccessMyDocs_Links extends EB_0006_Validate_AccessMyDocs_LinksHelper
{
	/**
	 * Script Name   : <b>EB_0006_Validate_AccessMyDocs_Links</b>
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
			ClickTabLink(objMap.document_eBenefitsHome(), "Access My Documents", "Download VA Letters");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"update your contact information");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Service Verification (AB7)");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Commissary (AB3)");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Application for Uniformed Services Identification Card DEERS Enrollment (DD1172)");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Access My Documents", "Federal Individual Recovery Plan (FIRP)");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_fedIndRecFIRP(), "JEFF SCOTT");
			ValidateIfButtonEnabled(objMap.document_eBenefitsHome(), "","Filter");
			ValidateIfButtonEnabled(objMap.document_eBenefitsHome(), "","Print FIRP");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Access My Documents", "Move!23 Health Questionnaire");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Click here to begin the MOVE!23 questionnaire.");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Access My Documents", "Request State Benefits Information");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.text_fullName(), "JEFF SCOTT");
			ValidateIfButtonEnabled(objMap.document_eBenefitsHome(), "","Submit");
			
			ClickTabLink(objMap.document_eBenefitsHome(), "Access My Documents", "Veterans' Group Life Insurance (VGLI) Status and Download");
			ValidateLblText(objMap.document_eBenefitsHome(), objMap.lbl_iEcannotDisplay(), "Internet Explorer cannot display the webpage");
			ValidateIfLinkEnabled(objMap.document_eBenefitsHome(),"Diagnose Connection Problems");
			
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

