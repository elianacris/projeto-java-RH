#!/bin/bash
export JAVA_HOME=/opt/homebrew/Cellar/openjdk/25.0.2/libexec/openjdk.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH
./mvnw clean test
