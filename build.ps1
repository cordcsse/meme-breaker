# Built and Tested on Powershell 6.2
param(
    [Parameter(Mandatory=$true, Position=0)]
    [ValidateSet("build","run","test","clean","pkg","log")]
    [string]$command
)

$locaL:module = "csse.memebreaker"
$local:entryClass = "memebreaker.App"

# Build
if ($command.Equals("build")) {
    if (-not (Test-Path -Path "build")) {
        New-Item -Path "build" -ItemType "Directory"
    }
    javac @("-d", "build", "--module-source-path=src", "--module=$locaL:module")
}

# Run
if ($command.Equals("run")) {
    if (Test-Path -Path "build/csse.memebreaker.jar") {
        java @("-jar", "$locaL:module.jar") 
    } else {
        java @("--module-path=build", "--module=$locaL:module/$local:entryClass")
    }
}

# Clean
if ($command.Equals("clean")) {
    Remove-Item -Path "build"
}

# Package
if ($command.Equals("pkg")) {
    jar @("-c", "--file=build/$locaL:module.jar", "--main-class=$local:entryClass", "-C", "build/$locaL:module", ".")
}
<#
 Test -> run unit tests and build tests

 Package -> package the module(s) into a JAR file
 
 Log -> read compilation/runtime warnings & logs
#>