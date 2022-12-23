Java ClassLoader Demo
=====================

Class loaders are responsible for loading Java classes dynamically to the JVM (Java Virtual Machine) during runtime. They're also part of the JRE (Java Runtime Environment).
Therefore, the JVM doesn't need to know about the underlying files or file systems in order to run Java programs thanks to class loaders.

Furthermore, these Java classes aren't loaded into memory all at once, but rather when they're required by an application. This is where class loaders come into the picture.
They're responsible for loading classes into memory.

# Classloaders

* Bootstrap ClassLoader: Loads the core JDK runtime classes
* Extension ClassLoader: Loads Java Virtual Machine extensions. The classes loaded are defined by the value of the java.ext.dirs Java system property.
* Application ClassLoader: Loads application classes. The classes loaded are defined by the value of the CLASSPATH environment variable or the -classpath Java option
* User Defined ClassLoader: Loads classes from a custom source

![ClassLoader Layers](classloader-3-layers.png)

# ClassLoader Hierarchy

![ClassLoader hierarchy](classloader-hierarchy.png)
 
# Spring Boot ClassLoader
                       
```
+--- spring-boot-loader-play-0.0.1-snapshot.jar
     +--- meta-inf
     +--- boot-inf
     |    +--- classes                            # 1 - project classes
     |    |     +--- org.springframework.boot
     |    |     | \--- springbootbanner.class     # this is our fix
     |    |     | 
     |    |     +--- pl.dk.loaderplay
     |    |          \--- springbootloaderapplication.class
     |    |
     |    +--- lib                                # 2 - nested jar libraries
     |          +--- javax.annotation-api-1.3.1
     |          +--- spring-boot-2.0.0.m7.jar     # original banner class inside
     |          \--- (...)
     |
     +--- org.springframework.boot.loader         # spring boot loader classes
          +--- Jarlauncher.class
          +--- LaunchedURLClassLoader.class
          \--- (...)
```

ClassLoader: `org.springframework.boot.loader.LaunchedURLClassLoader`

# References

* Java ClassLoader: https://www.digitalocean.com/community/tutorials/java-classloader
* Class Loaders in Java: https://www.baeldung.com/java-classloaders