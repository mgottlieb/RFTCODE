As we discussed yesterday, I have created and uploaded "New VONAPP Project" (projVONAPP) at ftp://mitchgottlieb.com/.
If you open this project in RFT you will see updates folder structure: 
- Config - Do not modify this folder contents yet.
- FuncLib - Do not modify this folder contents yet.
- Logs
- ObjectMap - Do not modify this folder contents yet. Required object map is created and saved at this location.
- TestData - Create csv files in this folder and rename the csv file with corresponding testscript name.
- TestScripts - Create new test scripts in this folder.
 
Under TestScripts folder, as you right click and add new Empty Test Scripts, you will see that new test script is prepopulated with with certain Java code to 
- To read properties file from Config folder
- Instantiate Object Map
- Close any existing open browsers
- Start new browser with URL mentioned in properties file (in Config folder)
- Wait for browser and corresponding webpage to open completly with no errors. 
- and, instructions to follow if csv/datapool to instantiate.
 
To access any test object, for e.g. LogIn button follow below steps:
 - Type "objMap." at required cursor location.
- This will open dropdown with corresponding test objects and other methods.
 - Click on link_logIn() and use dot operator again to select corresponding event.
- objMap.link_logIn().click();
 
I know for the first script it may take some time to adapt to this new framework. 
I have already added first script "VONAPP_0001_Invoke_and_Login"
Do not modify contents of "VONAPP_0000_ObjectMap_Helper".
 
Feel free to give me a call anytime after 1PM today, we can discuss further. How about we do a WebEx at 2PM to 3PM today to discuss further and answer any questions you have?
