REM Set Java home
SET JAVA_HOME=C:\Program Files\Java\jdk1.8.0_131
SET PATH=%JAVA_HOME%\bin;%PATH%

REM Set Selenium version of selenium-server-standalone JAR
SET SELENIUM_VERSION=3.141.59

REM Set Selenium port (default = 4555)
SET SELENIUM_PORT=4555
java -Dwebdriver.gecko.driver=%cd%\geckodriver.exe -Dwebdriver.chrome.driver=%cd%\chromedriver.exe -Dwebdriver.ie.driver=%cd%\IEDriverServer.exe -jar selenium-server-standalone-%SELENIUM_VERSION%.jar -port 4444