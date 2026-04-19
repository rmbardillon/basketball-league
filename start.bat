@echo off
set "JAVA_HOME=C:\Program Files\Java\jdk-22"
set "PATH=%JAVA_HOME%\bin;%PATH%"

echo Starting Basketball League Backend...
start "Backend" cmd /k "set "JAVA_HOME=C:\Program Files\Java\jdk-22" && set "PATH=C:\Program Files\Java\jdk-22\bin;%PATH%" && cd /d C:\Users\romsk\IdeaProjects\basketball-league && mvn spring-boot:run"

echo Starting Basketball League Frontend...
start "Frontend" cmd /k "cd /d C:\Users\romsk\Coding\Web Development\NextJS\basketball-league && npm run dev"
