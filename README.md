# spring-utils

This is a tiny utilities library with commonly used features in Spring applications.

## How to use?

### Add the dependency

**Maven** 

```xml
<dependency>
    <groupId>io.github.sivalabs</groupId>
    <artifactId>spring-utils</artifactId>
    <version>0.0.3</version>
</dependency>

<!-- To use SNAPSHOT version -->
<repositories>
    <repository>
        <name>Central Portal Snapshots</name>
        <id>central-portal-snapshots</id>
        <url>https://central.sonatype.com/repository/maven-snapshots/</url>
        <releases>
            <enabled>false</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>

<dependency>
    <groupId>io.github.sivalabs</groupId>
    <artifactId>spring-utils</artifactId>
    <version>0.0.4-SNAPSHOT</version>
</dependency>
```

**Gradle**

```groovy
implementation 'io.github.sivalabs:spring-utils:0.0.3'

// To use SNAPSHOT version

repositories {
    mavenCentral()
    //Groovy DSL
    maven { url = "https://central.sonatype.com/repository/maven-snapshots" }
    //Kotlin DSL
    maven { url = uri("https://central.sonatype.com/repository/maven-snapshots/") }
}

implementation 'io.github.sivalabs:spring-utils:0.0.4-SNAPSHOT'

```

### LoggingAspect

Add `io.github.sivalabs.springutils` package to ComponentScan

```java
@Configuration
@ComponentScan(basePackages={"io.github.sivalabs.springutils"})
public class AppConfig {

}
```

Use `@Loggable` annotation to Class or Method that you want to log.

```java
@Controller
@Loggable
public class MyController {

}

@Service
public class MyService {
    @Loggable
    public void doIt() {
    
    }
}
```

Enable `DEBUG` log level to `io.github.sivalabs.springutils` in `application.properties`.

`logging.level.io.github.sivalabs.springutils=debug`
