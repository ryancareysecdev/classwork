@echo off
set SDIR=%cd%
for /f %%v in ('dir "C:\Program Files\Java" /a:d /b /o:n ^| findstr /s /m "jdk"') do set VERSION=%%v
for /f %%d IN ('dir /b /s *.class') do del %%d
for /f %%f IN ('dir /a:d /b /o:n') do (
cd "%SDIR%\%%f"
"C:\Program Files\Java\"%VERSION%"\bin\javac.exe" "%%f.java"
@echo on
echo %%f compiled
@echo off
)
pause