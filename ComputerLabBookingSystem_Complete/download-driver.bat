@echo off
if not exist lib mkdir lib
echo Downloading SQLite JDBC driver...
powershell -NoProfile -ExecutionPolicy Bypass -Command "Invoke-WebRequest -Uri 'https://repo.maven.apache.org/maven2/org/xerial/sqlite-jdbc/3.50.3.0/sqlite-jdbc-3.50.3.0.jar' -OutFile 'lib\sqlite-jdbc.jar'"
if exist lib\sqlite-jdbc.jar (
  echo SQLite JDBC driver downloaded successfully.
) else (
  echo Download failed. Check your internet connection and try again.
)
pause
