javadoc -d .\make\ -sourcepath .\src\main\java -subpackages ru.nsu.izhuravskii

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\ru\nsu\izhuravskii\Stack.java

mkdir .\make\jar
jar cf .\make\jar\Stack.jar -C .\make\bin .