#!/bin/bash

current_dir=$(pwd)
script_dir=$(dirname $0)

echo $current_dir
echo $script_dir
java -jar $script_dir/target/parkinglot-0.0.1-SNAPSHOT.jar $1
