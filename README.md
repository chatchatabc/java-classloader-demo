Java ClassLoader Demo
=====================

# Classloaders

* Bootstrap ClassLoader: Loads the core JDK runtime classes
* Extension ClassLoader: Loads Java Virtual Machine extensions. The classes loaded are defined by the value of the java.ext.dirs Java system property.
* Application ClassLoader: Loads application classes. The classes loaded are defined by the value of the CLASSPATH environment variable or the -classpath Java option
* User Defined ClassLoader: Loads classes from a custom source

![ClassLoader Layers](classloader-3-layers.png)

# ClassLoader Hierarchy

![ClassLoader hierarchy](classloader-hierarchy.png)

# References

* Java ClassLoader: https://www.digitalocean.com/community/tutorials/java-classloader
* Class Loaders in Java: https://www.baeldung.com/java-classloaders