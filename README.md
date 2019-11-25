## My Quarkus Extension

Simple Quarkus extension registering a HelloWorld Servlet

### How to play wit it

- Compile and install the extension within your local maven repo
```bash
mvn clean install -DskipTests=true
```

- Compile and run the Resteasy application to access the HelloWorld Servlet
```bash
mvn clean install -f application/pom.xml -DskipTests=true
mvn quarkus:dev -f application/pom.xml
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------< me.snowdrop:quarkus-my-ext-getting-started >-------------
[INFO] Building Snowdrop - My Extension - Getting Started 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- quarkus-maven-plugin:1.0.0.Final:dev (default-cli) @ quarkus-my-ext-getting-started ---
Listening for transport dt_socket at address: 5005
2019-11-25 12:44:14,737 INFO  [io.quarkus] (main) Quarkus 1.0.0.Final started in 1.476s. Listening on: http://0.0.0.0:8080
2019-11-25 12:44:14,757 INFO  [io.quarkus] (main) Profile dev activated. Live Coding activated.
2019-11-25 12:44:14,757 INFO  [io.quarkus] (main) Installed features: [cdi, resteasy]
```

**Issue** The extension is not installed as the list only refers to `cdi, resteasy` !!!

### Solution

- Changing the gav to use `quarkus-my-ext-deployment` resolves the issue.
```bash
mvn quarkus:dev -f application/pom.xml                                         
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------< me.snowdrop:quarkus-my-ext-getting-started >-------------
[INFO] Building Snowdrop - My Extension - Getting Started 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- quarkus-maven-plugin:1.0.0.Final:dev (default-cli) @ quarkus-my-ext-getting-started ---
Listening for transport dt_socket at address: 5005
MyExtProcessor.createFeatureItem
MyExtProcessor.createHelloWorldServlet
2019-11-25 14:10:28,570 INFO  [io.quarkus] (main) Quarkus 1.0.0.Final started in 1.175s. Listening on: http://0.0.0.0:8080
2019-11-25 14:10:28,590 INFO  [io.quarkus] (main) Profile dev activated. Live Coding activated.
2019-11-25 14:10:28,590 INFO  [io.quarkus] (main) Installed features: [cdi, my-ext, resteasy]
```

**Question**: So, why do we have to import the "my-extension-deployment" gav of the extension and not "my-exension-runtime" gav as this is the case for the camel-quarkus-example ?

Example of a `camel-quarkus` extension which calls the runtime gav : https://github.com/apache/camel-quarkus/blob/master/examples/rest-json/pom.xml#L37

The definition of the `camel-quarkus` runtime gav for this extensions is : https://github.com/apache/camel-quarkus/blob/master/extensions/platform-http/runtime/pom.xml#L29

### All in one
```bash
git clone https://github.com/cmoulliard/quarkus-my-ext.git && cd quarkus-my-ext
mvn clean install -DskipTests=true
mvn clean install -f application/pom.xml -DskipTests=true
mvn quarkus:dev -f application/pom.xml
or 
java -jar application/target/quarkus-my-ext-application-1.0.0-SNAPSHOT-runner.jar 
2019-11-25 18:16:15,162 INFO  [io.quarkus] (main) quarkus-my-ext-application 1.0.0-SNAPSHOT (running on Quarkus 1.0.0.Final) started in 0.909s. Listening on: http://0.0.0.0:8080
2019-11-25 18:16:15,185 INFO  [io.quarkus] (main) Profile prod activated. 
2019-11-25 18:16:15,186 INFO  [io.quarkus] (main) Installed features: [cdi, resteasy]
```

### Output
```bash
 ~/Code/github/cmoulliard/quarkus-my-ext   master  mvn clean install -DskipTests=true
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] Snowdrop - My Extension - Parent                                   [pom]
[INFO] Snowdrop - My Extension - Runtime                                  [jar]
[INFO] Snowdrop - My Extension - Deployment                               [jar]
[INFO] 
[INFO] -----------------< me.snowdrop:quarkus-my-ext-parent >------------------
[INFO] Building Snowdrop - My Extension - Parent 1.0.0-SNAPSHOT           [1/3]
[INFO] --------------------------------[ pom ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ quarkus-my-ext-parent ---
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ quarkus-my-ext-parent ---
[INFO] Installing /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/pom.xml to /Users/dabou/.m2/repository/me/snowdrop/quarkus-my-ext-parent/1.0.0-SNAPSHOT/quarkus-my-ext-parent-1.0.0-SNAPSHOT.pom
[INFO] 
[INFO] ---------------------< me.snowdrop:quarkus-my-ext >---------------------
[INFO] Building Snowdrop - My Extension - Runtime 1.0.0-SNAPSHOT          [2/3]
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ quarkus-my-ext ---
[INFO] Deleting /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/runtime/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ quarkus-my-ext ---
[WARNING] Using platform encoding (US-ASCII actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ quarkus-my-ext ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding US-ASCII, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/runtime/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ quarkus-my-ext ---
[WARNING] Using platform encoding (US-ASCII actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/runtime/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ quarkus-my-ext ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ quarkus-my-ext ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ quarkus-my-ext ---
[INFO] Building jar: /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/runtime/target/quarkus-my-ext-1.0.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ quarkus-my-ext ---
[INFO] Installing /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/runtime/target/quarkus-my-ext-1.0.0-SNAPSHOT.jar to /Users/dabou/.m2/repository/me/snowdrop/quarkus-my-ext/1.0.0-SNAPSHOT/quarkus-my-ext-1.0.0-SNAPSHOT.jar
[INFO] Installing /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/runtime/pom.xml to /Users/dabou/.m2/repository/me/snowdrop/quarkus-my-ext/1.0.0-SNAPSHOT/quarkus-my-ext-1.0.0-SNAPSHOT.pom
[INFO] 
[INFO] ---------------< me.snowdrop:quarkus-my-ext-deployment >----------------
[INFO] Building Snowdrop - My Extension - Deployment 1.0.0-SNAPSHOT       [3/3]
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ quarkus-my-ext-deployment ---
[INFO] Deleting /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/deployment/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ quarkus-my-ext-deployment ---
[WARNING] Using platform encoding (US-ASCII actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/deployment/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ quarkus-my-ext-deployment ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding US-ASCII, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/deployment/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ quarkus-my-ext-deployment ---
[WARNING] Using platform encoding (US-ASCII actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/deployment/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ quarkus-my-ext-deployment ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding US-ASCII, i.e. build is platform dependent!
[INFO] Compiling 2 source files to /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/deployment/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ quarkus-my-ext-deployment ---
[INFO] Tests are skipped.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ quarkus-my-ext-deployment ---
[INFO] Building jar: /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/deployment/target/quarkus-my-ext-deployment-1.0.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ quarkus-my-ext-deployment ---
[INFO] Installing /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/deployment/target/quarkus-my-ext-deployment-1.0.0-SNAPSHOT.jar to /Users/dabou/.m2/repository/me/snowdrop/quarkus-my-ext-deployment/1.0.0-SNAPSHOT/quarkus-my-ext-deployment-1.0.0-SNAPSHOT.jar
[INFO] Installing /Users/dabou/Code/github/cmoulliard/quarkus-my-ext/deployment/pom.xml to /Users/dabou/.m2/repository/me/snowdrop/quarkus-my-ext-deployment/1.0.0-SNAPSHOT/quarkus-my-ext-deployment-1.0.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO] 
[INFO] Snowdrop - My Extension - Parent 1.0.0-SNAPSHOT .... SUCCESS [  0.288 s]
[INFO] Snowdrop - My Extension - Runtime .................. SUCCESS [  1.448 s]
[INFO] Snowdrop - My Extension - Deployment 1.0.0-SNAPSHOT  SUCCESS [  1.991 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.064 s
[INFO] Finished at: 2019-11-25T18:17:07+01:00
[INFO] ------------------------------------------------------------------------
```