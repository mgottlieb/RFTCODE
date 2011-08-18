// DO NOT EDIT: This file is automatically generated.
//
// Only the associated template file should be edited directly.
// Helper class files are automatically regenerated from the template
// files at various times, including record actions and test object
// insertion actions.  Any changes made directly to a helper class
// file will be lost when automatically updated.

package resources;

import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.vp.IFtVerificationPoint;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;
/**
 * Script Name   : <b>VONAPP_0001_Invoke_URL_and_Login</b><br>
 * Generated     : <b>2011/08/15 3:14:46 PM</b><br>
 * Description   : Helper class for script<br>
 * Original Host : Windows XP x86 5.1 build 2600 Service Pack 3 <br>
 * 
 * @since  August 15, 2011
 * @author imcva
 */
public abstract class VONAPP_0001_Invoke_URL_and_LoginHelper extends RationalTestScript
{
	/**
	 * AcceptedAccepted_terms_Condition: with default state.
	 *		.id : accept_1
	 * 		.type : checkbox
	 * 		.value : Accepted_terms_Condition
	 * 		.title : 
	 * 		.class : Html.INPUT.checkbox
	 * 		.name : Accepted
	 * 		.classIndex : 0
	 */
	protected ToggleGUITestObject chkBox_TermsAndConditions() 
	{
		return new ToggleGUITestObject(
                        getMappedTestObject("chkBox_TermsAndConditions"));
	}
	/**
	 * AcceptedAccepted_terms_Condition: with specific test context and state.
	 *		.id : accept_1
	 * 		.type : checkbox
	 * 		.value : Accepted_terms_Condition
	 * 		.title : 
	 * 		.class : Html.INPUT.checkbox
	 * 		.name : Accepted
	 * 		.classIndex : 0
	 */
	protected ToggleGUITestObject chkBox_TermsAndConditions(TestObject anchor, long flags) 
	{
		return new ToggleGUITestObject(
                        getMappedTestObject("chkBox_TermsAndConditions"), anchor, flags);
	}
	
	/**
	 * ApplyForDependentBenefits: with default state.
	 *		.text : Apply for Dependent Benefits >
	 * 		.href : https://test.eauth.va.gov/VONAPP2/dashboard.do?execution=e1s1&_eventId=newDepend ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_applyForDependentBenefits() 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_applyForDependentBenefits"));
	}
	/**
	 * ApplyForDependentBenefits: with specific test context and state.
	 *		.text : Apply for Dependent Benefits >
	 * 		.href : https://test.eauth.va.gov/VONAPP2/dashboard.do?execution=e1s1&_eventId=newDepend ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_applyForDependentBenefits(TestObject anchor, long flags) 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_applyForDependentBenefits"), anchor, flags);
	}
	
	/**
	 * btnBack: with default state.
	 *		.text : Previous
	 * 		.href : https://test.eauth.va.gov/VONAPP2/dashboard.do?execution=e1s3&_eventId_previous
	 * 		.id : btnBack
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_btnPrevious() 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_btnPrevious"));
	}
	/**
	 * btnBack: with specific test context and state.
	 *		.text : Previous
	 * 		.href : https://test.eauth.va.gov/VONAPP2/dashboard.do?execution=e1s3&_eventId_previous
	 * 		.id : btnBack
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_btnPrevious(TestObject anchor, long flags) 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_btnPrevious"), anchor, flags);
	}
	
	/**
	 * btnNext: with default state.
	 *		.text : Save & Continue
	 * 		.href : https://test.eauth.va.gov/VONAPP2/dashboard.do?execution=e1s3&_eventId_continue
	 * 		.id : btnNext
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_btnSaveAndContinue() 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_btnSaveAndContinue"));
	}
	/**
	 * btnNext: with specific test context and state.
	 *		.text : Save & Continue
	 * 		.href : https://test.eauth.va.gov/VONAPP2/dashboard.do?execution=e1s3&_eventId_continue
	 * 		.id : btnNext
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_btnSaveAndContinue(TestObject anchor, long flags) 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_btnSaveAndContinue"), anchor, flags);
	}
	
	/**
	 * Dashboard: with default state.
	 *		.text : Dashboard
	 * 		.href : https://test.eauth.va.gov/ebenefits-portal/ebenefits.portal?_nfpb=true&_nfxr=fal ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_dashboard() 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_dashboard"));
	}
	/**
	 * Dashboard: with specific test context and state.
	 *		.text : Dashboard
	 * 		.href : https://test.eauth.va.gov/ebenefits-portal/ebenefits.portal?_nfpb=true&_nfxr=fal ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_dashboard(TestObject anchor, long flags) 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_dashboard"), anchor, flags);
	}
	
	/**
	 * LogIn: with default state.
	 *		.text : Log In
	 * 		.href : https://pint.ebenefits.va.gov/ebenefits-portal/ebenefits.portal/dsLogon.htm
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_logIn() 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_logIn"));
	}
	/**
	 * LogIn: with specific test context and state.
	 *		.text : Log In
	 * 		.href : https://pint.ebenefits.va.gov/ebenefits-portal/ebenefits.portal/dsLogon.htm
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_logIn(TestObject anchor, long flags) 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_logIn"), anchor, flags);
	}
	
	/**
	 * LogOut: with default state.
	 *		.text : Log Out
	 * 		.href : https://test.eauth.va.gov/ebenefits-portal/ebenefits.portal/logout.htm
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_logOut() 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_logOut"));
	}
	/**
	 * LogOut: with specific test context and state.
	 *		.text : Log Out
	 * 		.href : https://test.eauth.va.gov/ebenefits-portal/ebenefits.portal/logout.htm
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_logOut(TestObject anchor, long flags) 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_logOut"), anchor, flags);
	}
	
	/**
	 * MyEBenefits: with default state.
	 *		.text : My eBenefits
	 * 		.href : https://test.eauth.va.gov/ebenefits-portal/ebenefits.portal?_nfpb=true&_nfxr=fal ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_myEBenefits() 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_myEBenefits"));
	}
	/**
	 * MyEBenefits: with specific test context and state.
	 *		.text : My eBenefits
	 * 		.href : https://test.eauth.va.gov/ebenefits-portal/ebenefits.portal?_nfpb=true&_nfxr=fal ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 0
	 */
	protected GuiTestObject link_myEBenefits(TestObject anchor, long flags) 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_myEBenefits"), anchor, flags);
	}
	
	/**
	 * submitANewApplication: with default state.
	 *		.text : submit a new application
	 * 		.href : https://test.eauth.va.gov/VONAPP2/dashboard.do?execution=e1s1&_eventId=newDepend ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 1
	 */
	protected GuiTestObject link_submitANewApplication() 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_submitANewApplication"));
	}
	/**
	 * submitANewApplication: with specific test context and state.
	 *		.text : submit a new application
	 * 		.href : https://test.eauth.va.gov/VONAPP2/dashboard.do?execution=e1s1&_eventId=newDepend ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 1
	 */
	protected GuiTestObject link_submitANewApplication(TestObject anchor, long flags) 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_submitANewApplication"), anchor, flags);
	}
	
	/**
	 * VeteransOnlineApplicationVONAPPDirectConnect: with default state.
	 *		.text : Veterans Online Application (VONAPP) Direct Connect
	 * 		.href : https://test.eauth.va.gov/ebenefits-portal/ebenefits.portal?_nfpb=true&_nfxr=fal ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 20
	 */
	protected GuiTestObject link_veteransOnlineApplication() 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_veteransOnlineApplication"));
	}
	/**
	 * VeteransOnlineApplicationVONAPPDirectConnect: with specific test context and state.
	 *		.text : Veterans Online Application (VONAPP) Direct Connect
	 * 		.href : https://test.eauth.va.gov/ebenefits-portal/ebenefits.portal?_nfpb=true&_nfxr=fal ...
	 * 		.id : 
	 * 		.title : 
	 * 		.class : Html.A
	 * 		.name : 
	 * 		.classIndex : 20
	 */
	protected GuiTestObject link_veteransOnlineApplication(TestObject anchor, long flags) 
	{
		return new GuiTestObject(
                        getMappedTestObject("link_veteransOnlineApplication"), anchor, flags);
	}
	
	

	protected VONAPP_0001_Invoke_URL_and_LoginHelper()
	{
		setScriptName("VONAPP_0001_Invoke_URL_and_Login");
	}
	
}

