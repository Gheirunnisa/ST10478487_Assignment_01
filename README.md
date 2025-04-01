name: Android Build
on:
push:
branches:
-main
-develop
pull request:
branches:
-main
-develop
job:
build:
run ons: ubuntu latest
steps:
-name: Check out repository
uses: action/checkouta@v2
-name: set up JDK 17
uses: action/setup-java@v2
with:
distribution: 'temurin'
java version: '17'
cache: 'gradle'
-name: Give permission to Gradlew
run: chmod +x gradlew
-name: Build with Gradle
run: ./gradlew assembleDebug
-name: Run Unit Test
run: ./gradlew testDebugUnitTest
-name: Upload APK Artifact
uses: actions/upload-artifact@v3
with:
name: app-debug-apk
app/build/outputs/apk/debug/app-debug.apk
