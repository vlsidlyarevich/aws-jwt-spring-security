# Spring boot base with [Amazon Cognito](https://aws.amazon.com/cognito/) token based security. 

### Includes:
* Configured security based on AWS jwt parsing.
* Secured controller for testing.
* Configured quality tools like [checkstyle](https://github.com/vlsidlyarevich/aws-jwt-spring-boot/blob/master/build-tools/quality/checkstyle/checkstyle.gradle), [findbugs](https://github.com/vlsidlyarevich/aws-jwt-spring-boot/blob/master/build-tools/quality/findbugs/findbugs.gradle), [pmd](https://github.com/vlsidlyarevich/aws-jwt-spring-boot/blob/master/build-tools/quality/pmd/pmd.gradle)
* Separated packages for integration and unit tests ([configured to run after unit tests](https://github.com/vlsidlyarevich/aws-jwt-spring-boot/blob/master/build.gradle#L46-L53)) 
* Swagger

### Environment prerequisites:

``` bash 
✗ java -version
java version "1.8.0_152"
Java(TM) SE Runtime Environment (build 1.8.0_152-b16)
Java HotSpot(TM) 64-Bit Server VM (build 25.152-b16, mixed mode)


✗ gradle -version
 
 ------------------------------------------------------------
 Gradle 4.4.1
 ------------------------------------------------------------
 
 Build time:   2017-12-20 15:45:23 UTC
 Revision:     10ed9dc355dc39f6307cc98fbd8cea314bdd381c
 
 Groovy:       2.4.12
 Ant:          Apache Ant(TM) version 1.9.9 compiled on February 2 2017
 JVM:          1.8.0_152 (Oracle Corporation 25.152-b16)
 OS:           Mac OS X 10.13.2 x86_64
```
