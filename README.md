# spring-utils

This is a tiny utilities library with commonly used features in Spring applications.

## How to use?

### Add the dependency

**Maven** 

```
<dependency>
    <groupId>com.github.sivalabs</groupId>
    <artifactId>spring-utils</artifactId>
    <version>0.0.1</version>
</dependency>
```

**Gradle**

`compile group: 'com.github.sivalabs', name: 'spring-utils', version: '0.0.1'`

### LoggingAspect

Add `com.github.sivalabs.springutils` package to ComponentScan

```
@Configuration
@ComponentScan(basePackages={"com.github.sivalabs.springutils"})
public class AppConfig
{

}
```

Use `@Loggable` annotation to Class or Method that you want to log.

```
@Controller
@Loggable
public class MyController
{

}


@Service
public class MyService
{
    @Loggable
    public void doIt() {
    
    }
}
```

Enable `DEBUG` log level to `com.github.sivalabs.springutils` in `application.properties`.

`logging.level.com.github.sivalabs.springutils=debug`


## Developer Notes

Procedure for deploying to Maven Central https://central.sonatype.org/pages/apache-maven.html

Create or update archetypes and set version to SNAPSHOT (ex: 1.0.0-SNAPSHOT)

Deploy SNAPSHOT version to https://oss.sonatype.org/content/repositories/snapshots/

`spring-utils> mvn clean deploy`

Deploy release version to Maven Central

```
spring-utils> mvn release:clean release:prepare
spring-utils> mvn release:perform`
```
