cd ..
echo off
echo "Pls ensure you are running tests on either Chrome(Version 89) or Firefox(Version 72.0.2), if not then download the drivers according to your browser version and paste them at location src/main/resources/browser_driver"
CALL mvn test -Dcucumber.filter.tags="@expedia" -Dcucumber.plugin="html:target/Html/expedia_reports.html"
echo "Reports are at location target/Html/expedia_reports.html"
pause
echo on
