Getting started:

1. Install Maven from http://maven.apache.org
2. Make sure mvn is in your path
3. cd to this directory
4. `mvn eclipse:eclipse -DdownloadSources` creates Eclipse project
5. Import the project into Eclipse
6. If this is your first run-in with Maven, go to Window > Preferences : Java > Build path > Classpath Variable and add `M2_REPO` as <your home dir>/.m2/repository