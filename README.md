## My Quarkus Extension

Simple Quarkus extension registering a HelloWorld Servlet

### How to play wit it

- Compile and install the extension within your local maven repo
```bash
mvn clean install -DskipTests=true
```

- Run the getting started - Resteasy application to access the HelloWorld Servlet
```bash
mvn quarkus:dev -f getting-started/pom.xml
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

**ISSUE**. The extension is not installed as the list onluy refers to `cdi, resteasy`
