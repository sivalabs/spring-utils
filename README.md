# spring-utils

This is a tiny utilities library with commonly used features in Spring applications.

## How to use?

### Add the dependency

**Maven** 

```xml
<dependency>
    <groupId>io.github.sivalabs</groupId>
    <artifactId>spring-utils</artifactId>
    <version>0.0.2</version>
</dependency>
```

**Gradle**

```groovy
implementation 'io.github.sivalabs:spring-utils:0.0.2'
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
