#!/bin/sh

find -name '*.java' | xargs javac -cp termlib.jar -Xlint:all
java -cp .:termlib.jar com.codecool.fiveinarow.FiveInARow