@echo off
@REM del /s /q compiled\*.class
javac -d ./compiled Main.java
java -cp ./compiled Main
