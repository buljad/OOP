javadoc -d .\make\ -sourcepath .\src\main\java -subpackages ru.nsu.izhuravskii

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\ru\nsu\izhuravskii\heapsort.java

mkdir .\make\jar
jar cf .\make\jar\heapsort.jar -C .\make\bin .