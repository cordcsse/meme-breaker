# Built and Tested on Powershell 6.2
param(
    [Parameter(Mandatory=$true, Position=0)]
    [ValidateSet("build","run","test","clean","package","log")]
    [string]$command
)

$locaL:module = "csse.memebreaker"
$local:entryClass = "memebreaker.App"

# Build
if ($command.Equals("build")) {
    javac "-d" "build" "--module-source-path" "src" "--module" "$locaL:module"
}

# Run
if ($command.Equals("run")) {
    java "--module-path" "build" "--module" "$locaL:module/$local:entryClass"
}

# Clean
if ($command.Equals("clean")) {
    Remove-Item -Path "build"
}

<#
 Test -> run unit tests and build tests

 Package -> package the module(s) into a JAR file
 
 Log -> read compilation/runtime warnings & logs
#>