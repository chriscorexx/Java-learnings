@echo off
if not exist lib\sqlite-jdbc.jar (
  echo SQLite JDBC driver is missing.
  echo Run download-driver.bat first.
  pause
  exit /b 1
)
javac -cp "lib\sqlite-jdbc.jar;." Main.java Database.java Login.java Admin.java Student.java BookingManager.java
if errorlevel 1 (
  echo Compilation failed. Check the Java errors above.
  pause
  exit /b 1
)
java -cp "lib\sqlite-jdbc.jar;." Main
pause
