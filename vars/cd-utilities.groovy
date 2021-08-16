/**
* Maven Windows Unit testing
*/
def doUnitTestForMavenOnWindows(){
  	bat "c:\\jenkins_home\\apps\\maven-3.0\\bin\\mvn test"
}
/**
* Maven Linux Unit testing
*/
def doUnitTestForMavenOnLinux(){
  	sh "/usr/jenkins_home/apps/maven-3.0/bin/mvn test"
}
