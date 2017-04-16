set projectPath=C:\Projects\Entersekt_Assessment
set classPath=%projectPath%\lib\*

java org.testng.TestNG %projectPath%\testsuites\assessment_testsuite.xml
pause