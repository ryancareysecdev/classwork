@echo off
set SDIR = %cd%
for /f %%v in ('dir "C:\Program Files\Java" /a:d /b /o:n ^| findstr /s /m "jdk"') do set VERSION=%%v
dir /a:d /b /o:n /p
set /p PROJECT=Enter the project name: 
cd "%SDIR%%PROJECT%"
for %%d IN (*.class) do del %%d
"C:\Program Files\Java\%VERSION%\bin\javac.exe" %PROJECT%.java
cls
if exist "%PROJECT%.htm" (
"C:\Program Files\Java\%VERSION%\bin\appletviewer.exe" %PROJECT%.htm
pause
exit
) else (
"C:\Program Files\Java\%VERSION%\bin\java.exe" %PROJECT%
)
pause