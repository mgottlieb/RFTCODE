
#Usage of the batch file 
# This will run the PROBE project in EBEN RFT
# Input:
# $1 = Environment (PINT, QA, PREPROD)
# $2 = Run forever every hour for in between X and Y (hour)


#Function: CheckCPropertyFileExist
#input: File name and location
#output: exit if file not found
CFileExist() {
    echo "Checking if $1 exists"
	if [ ! -f $1 ];
	then
		echo "$1 File not found!"
		exit
	fi
	
}






#!/bin/bash
#save_args_as_variables

if [ -z "$1" ]
then
	ENV=PINT
else
	ENV=$1
fi
echo "Exec in Environment "$ENV


HOURLY=0
if [ -n "$2" ]
then
	HOURLY=1
echo "Running hourly "	
fi

WEBDIR=`pwd`
WEBDIR_LOGS=$WEBDIR/logs

RFT_PROJECT_LOCATION="T:\\eBenefits\\IV&V_Team\\RFT\\projEBenefits"
RFT_SCRIPT_NAME=TestScripts.EB_0002_Smoke_Validation
RFT_LOGFILE_NAME=TestScripts.EB_0002_Smoke_Validation


#config file
CONFIGFILE=C:/RFTCODE/testConfig.txt

#Replace ENVIRONMENT=XXX with ENVIRONMENT=$ENV
CFileExist $CONFIGFILE
sed -i "s/^ENVIRONMENT=.*$/ENVIRONMENT=$ENV/g" $CONFIGFILE


#start running at least once
KEEPRUNNING=1
LAUNCHEXEC=1
OFFICEHR_START=6
OFFICEHR_END=18


while [ $KEEPRUNNING -eq "1" ]; do 
	

	if [ $LAUNCHEXEC -eq "1" ]; then
		DATE=`date +%Y%m%d`
		HOUR=`date +%H`
		MIN=`date +%M`
		
		echo "Starting ..."
		echo $DATE
		echo $HOUR:$MIN
		
		DESTDIR=$WEBDIR_LOGS/"$DATE"
		
		if [ ! -d "$DESTDIR" ]
		then
			mkdir "$DESTDIR"
		fi


		#Cleanup all explorers
		echo "Killing all explorers that are open"
		
		#before VBS calls, make sure RFT Config file exists
		CFileExist $CONFIGFILE
		exec cscript.exe $RFT_PROJECT_LOCATION/Logs/KillTaskProcesses.vbs &
		wait
		
		#Execute RFT scripts
		cd $RFT_PROJECT_LOCATION
		echo "**************** Launching SmokeTest... ******************"
		echo ""
		exec java -classpath "$classpath;$IBM_RATIONAL_RFT_INSTALL_DIR\rational_ft.jar" com.rational.test.ft.rational_ft -datastore $RFT_PROJECT_LOCATION -playback $RFT_SCRIPT_NAME  &> $DESTDIR/$HOUR$MIN.log &

		wait
		
		#Shuffle results
		echo "Shuffling Results"
		CFileExist $CONFIGFILE
		exec cscript.exe $RFT_PROJECT_LOCATION/Logs/shuffleSmokeLogs.vbs &

		wait
		
		cd $WEBDIR

	fi
	
	#stop running unless hourly is on and within hour time frame
	KEEPRUNNING=0
	LAUNCHEXEC=0
	if [ $HOURLY -eq "1" ]
		then
			KEEPRUNNING=1
			#Between office hours
			if [ $HOUR -ge $OFFICEHR_START -a $HOUR -lt $OFFICEHR_END ]
			then
				echo "**************** Restart Hourly Exec ***********"
				sleep 3600
				LAUNCHEXEC=1
			fi	
	fi

done

