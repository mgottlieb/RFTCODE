Dim filesys
Dim objUnderTest(100)
Dim Result(100)
Dim objIndex: objIndex = 0
Dim blnFlag: blnFlag = false
On Error Resume Next

set filesys=CreateObject("Scripting.FileSystemObject")
Sourcefolderpath="T:\eBenefits\IV&V_Team\RFT\projEBenefits_logs\TestScripts.EB_0002_Smoke_Validation\"
destfolderpath = "T:\eBenefits\IV&V_Team\RFT\projEBenefits\Logs\"
ArchiveFolderPath = "T:\eBenefits\IV&V_Team\RFT\projEBenefits\Logs\Archive\"
XMLfilename = "rational_ft_log.xml"
newXMLfilename = "EB_0002_SmokeVal_log.xml"
XLSFilename = "EB_0002_ConsolidatedSmokeVal_log.xls"
currDayTime = Month(Date)&Day(Date)&"_"&Hour(Time)&Minute(Time)&Second(Time)

If filesys.FolderExists(ArchiveFolderPath) Then
	'msgbox true
	If filesys.FileExists(destfolderpath&XMLfilename) then
		filesys.MoveFile destfolderpath&XMLfilename, ArchiveFolderPath&currDayTime&"_"&newXMLfilename
	End If 
	filesys.MoveFile destfolderpath&XLSFilename, ArchiveFolderPath&currDayTime&"_"&XLSFilename
	filesys.CopyFile ArchiveFolderPath&currDayTime&"_"&XLSFilename, destfolderpath
	filesys.MoveFile destfolderpath&currDayTime&"_"&XLSFilename, destfolderpath&XLSFilename
End If

If filesys.FileExists(Sourcefolderpath&XMLfilename) Then
   filesys.CopyFile Sourcefolderpath&XMLfilename, destfolderpath
   'filesys.MoveFile destfolderpath&XMLfilename, destfolderpath&newXMLfilename
End If

Set objXMLDoc = CreateObject("Microsoft.XMLDOM") 
objXMLDoc.async = False 
objXMLDoc.load(destfolderpath&XMLfilename) 
Set Root = objXMLDoc.documentElement.firstchild
Set EventNodeList = Root.getElementsByTagName("Event")
ExeDate = EventNodeList(0).getAttribute("Timestamp")
For EventCounter = 0 to EventNodeList.length-1
	Set PropNodeList = EventNodeList(EventCounter).getElementsByTagName("Property")
	''msgbox PropNodeList.Length
	''msgbox EventNodeList(EventCounter).getAttribute("Result")
	For PropCounter = 0 To PropNodeList.Length-1
		''msgbox PropNodeList(PropCounter).getAttribute("additional_info")
		If PropNodeList(PropCounter).getAttribute("additional_info") <> "" Then
			arrAttr = Split(PropNodeList(PropCounter).getAttribute("additional_info"), "_")
			objUnderTest(objIndex) = arrAttr(1)
			''msgbox objUnderTest(objIndex)
			Result(objIndex) = EventNodeList(EventCounter).getAttribute("Result")
			''msgbox Result(objIndex)
			objIndex = objIndex + 1
		End If
	Next	
	''msgbox EventNodeList(ElemCounter).childnodes.item(0).nodename
	''msgbox EventNodeList(ElemCounter).childnodes.item(0).getAttribute("line_number")
	'Set PropNode = EventNodeList(ElemCounter).childnodes.item(0)
	'If (PropNode.getAttribute("line_number") <> Null) Then
	'	arrAttr = Split(PropNode.getAttribute("line_number").value, "_")
	'	objUnderTest = arrAttr(1)
	'	'msgbox objUnderTest
   	'	'msgbox EventNodeList(ElemCounter).getAttribute("Result")
   	'End If
next


 


Set objExcel = CreateObject("Excel.Application")
Set objWorkbook = objExcel.Workbooks.Open(destfolderpath&XLSFilename)
objExcel.visible = false

NoOfSheets = objExcel.ActiveWorkbook.Sheets.Count
'msgbox NoOfSheets
'msgbox Monthname(month(date),true)
For counter = 1 To NoOfSheets
	If objWorkbook.WorkSheets(counter).Name = Monthname(month(date),true) then
		blnFlag  = true
	End if
Next

'msgbox blnFlag
strSheetName = Monthname(month(date),true)
if blnFlag = false then
	objWorkbook.Sheets.Add ,objWorkbook.WorkSheets(objWorkbook.WorkSheets.Count)
	objWorkbook.ActiveSheet.name = Monthname(month(date),true)
   ''msgbox blnFlag
End if

objWorkbook.WorkSheets(strSheetName).Activate
for ColCounter = 1 to 31
	If objWorkbook.WorkSheets(strSheetName).Cells(1, ColCounter).Value = "" then
		Exit for
	End if 
next
objWorkbook.WorkSheets(1).Cells(1, ColCounter).Value = "ValidateIfEnabled_Results_"&MOnth(Date)&"_"&Day(Date)&"_"&Year(Date)
objWorkbook.WorkSheets(1).Cells(2, ColCounter).Value = ExeDate
objIndex = 0
For RowCounter = 3 to Ubound(objUnderTest)
	''msgbox objWorkbook.WorkSheets(strSheetName).Cells(RowCounter , 2).Value
	''msgbox objUnderTest(objIndex)
	If objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, 2).Value <> "" then
		If trim(objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, 2).Value) = trim(objUnderTest(objIndex)) then
			objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, ColCounter).Value = Result(objIndex)
			objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, ColCounter).font.Bold = TRUE
				If UCAse(objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, ColCounter).value) = "PASS" then
					objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, ColCounter).Interior.ColorIndex = 4
				Else
					objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, ColCounter).Interior.ColorIndex = 3
				End If	
		Else 
			objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, ColCounter).Value = "ObjUnderTest <<"&objUnderTest(objIndex)&">> do not match with expected <<"&objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, 2).Value&">>."
			objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, ColCounter).font.Bold = TRUE
			objWorkbook.WorkSheets(strSheetName).Cells(RowCounter, ColCounter).Interior.ColorIndex = 3
		End if
	END IF
	objIndex = objIndex + 1
Next
'Set objRange = objExcel.ActiveCell.EntireColumn
'objRange.AutoFit()

objWorkbook.WorkSheets(strSheetName).columns(ColCounter).AutoFit()
objExcel.ActiveWorkbook.save
objExcel.ActiveWorkbook.Close
objExcel.Application.Quit

 

 
 