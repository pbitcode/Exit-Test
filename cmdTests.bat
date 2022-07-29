CALL mvn dependency:copy-dependencies
java -cp target\dependency\*;target\test-classes org.testng.TestNG run_Tests.xml
pause