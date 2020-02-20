#!/bin/bash
javac mulStrMain.java -d bin
javac Solution.java -d bin
cd bin
java mulStrMain
cd ..