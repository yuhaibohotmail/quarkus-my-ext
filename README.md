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
mvn quarkus:dev -f application/pom.xml -DnoDeps
```