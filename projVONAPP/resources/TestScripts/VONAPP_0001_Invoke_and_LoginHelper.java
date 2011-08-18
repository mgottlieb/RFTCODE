// DO NOT EDIT: This file is automatically generated.
//
// Only the associated template file should be edited directly.
// Helper class files are automatically regenerated from the template
// files at various times, including record actions and test object
// insertion actions.  Any changes made directly to a helper class
// file will be lost when automatically updated.

package resources.TestScripts;
import FuncLib.HelpUtil;
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
 * Script Name   : <b>VONAPP_0001_Invoke_and_Login</b><br>
 * Generated     : <b>2011/08/16 2:57:25 PM</b><br>
 * Description   : Helper class for script<br>
 * Original Host : Windows XP x86 5.1 build 2600 Service Pack 3 <br>
 * 
 * @since  August 16, 2011
 * @author Bhavna Vyas
 */
public abstract class VONAPP_0001_Invoke_and_LoginHelper extends FuncLib.HelpUtil
{
	/**
	 * Locate and return the verification point Screen_image object in the SUT.
	 */
	protected IFtVerificationPoint Screen_imageVP() 
	{
		return vp("Screen_image");
	}
	protected IFtVerificationPoint Screen_imageVP(TestObject anchor)
	{
		return vp("Screen_image", anchor);
	}
	
	

	protected VONAPP_0001_Invoke_and_LoginHelper()
	{
		setScriptName("TestScripts.VONAPP_0001_Invoke_and_Login");
	}
	
}
