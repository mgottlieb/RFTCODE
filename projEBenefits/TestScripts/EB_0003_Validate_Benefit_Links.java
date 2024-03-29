package TestScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.eclipse.hyades.execution.runtime.datapool.IDatapoolIterator;
import resources.TestScripts.EB_0003_Validate_Benefit_LinksHelper;
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
public class EB_0003_Validate_Benefit_Links extends EB_0003_Validate_Benefit_LinksHelper

{
	/**
	 * Script Name   : <b>EB_0003_Validate_Benefit_Links</b>
	 * Generated     : <b>Sep 7, 2011 2:24:53 PM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 5.1  Build 2600 (S)
	 * 
	 * @since  2011/09/07
	 * @author imcva
	 */
	enum UserLevel {Level1,Level2,Anonymous}
	public boolean blnFlag[] = new boolean[6];
	public void testMain(String[] args) 
	{
		// TODO Insert code here
		
		/**Instantiate Properties file at Config folder.
		 * Make sure there is testConfig.properties saved at config folder.
		 */
		
		//Initiate Shared Object Map here. 
		EB_0000_ObjectMap_Helper objMap = new EB_0000_ObjectMap_Helper();
					
		UserLevel enumUserLevel = UserLevel.valueOf(args[0]);
		
		switch(enumUserLevel){
			case Level2:
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links", "Benefits By State");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Benefits By State");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Compensation");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Compensation");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Death");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Death");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Education");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Education");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Employment");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Employment");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Financial Services");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Financial Services");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Health");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Health");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Housing");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Housing");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Insurance");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Insurance");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Retirement");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Retirement");
				
				ClickTabLink(objMap.document_eBenefitsHome(), "Browse Benefits Links","Travel & Transportation");
				ValidateRecipientCheckBox(objMap.document_eBenefitsHome(), "Travel & Transportation");
				break;
			case Level1:
				System.out.println("Level1 Under Construction");
		        break;
			case Anonymous:
				System.out.println("Anonymous Under Construction");
				break;

		}
				
	}
//#########################################################################################################################	
	public void ClickTabLink(TestObject objParent, String objTab, String objLink) {
		objParent.waitForExistence(30.0, 2.0);
		//ValidateIfEnabled(objParent,objTab);
		clickLink(objParent,objTab);
		objParent.waitForExistence(30.0, 2.0);
		//ValidateIfEnabled(objParent,objLink);
		clickLink(objParent,objLink);
		}
//######################################################################################################
	public void ValidateRecipientCheckBox(TestObject objParent, String objLink){
		if(objLink.equalsIgnoreCase("Benefits By State")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Care Management Team", "UnChecked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[5] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Compensation")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Care Management Team", "UnChecked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[5] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Death")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Care Management Team", "UnChecked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[5] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Education")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Care Management Team", "UnChecked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[5] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Employment")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Financial Services")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Care Management Team", "UnChecked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[5] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Health")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Care Management Team", "UnChecked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[5] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Housing")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Insurance")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Care Management Team", "UnChecked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[5] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Retirement")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}else if(objLink.equalsIgnoreCase("Travel & Transportation")) {
			blnFlag[0] = ValidateCheckBoxState(objParent, "Caregiver Delegate", "Checked");
			blnFlag[1] = ValidateCheckBoxState(objParent, "Family Member", "UnChecked");
			blnFlag[2] = ValidateCheckBoxState(objParent, "Service Member", "Checked");
			blnFlag[3] = ValidateCheckBoxState(objParent, "Veteran", "Checked");
			blnFlag[4] = ValidateCheckBoxState(objParent, "Wounded Warrior", "Checked");
		}
		
		for (int intIndex = 0; intIndex<blnFlag.length;intIndex++){
			blnFlag[0] = blnFlag[0] && blnFlag[intIndex];
		}
		if (blnFlag[0]){
			logTestResult("On window <<"+objParent.getProperty(".title") + ">>, link object <<"+objLink+">> passed validation.", true, "VP_"+objLink);
		} else {
			logTestResult("On window <<" + objParent.getProperty(".title") + ">>, link object <<"+objLink+">> failed validation.", false, "VP_"+objLink);
		}
	}
}

