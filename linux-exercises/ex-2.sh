#!/bin/bash

#* Author : Dillon Juriansz

#* 2. Directory Navigation and Listing:
#* - Create a directory structure with nested directories and files.
#* - Use the `ls` command to list the contents of the directories.
#* - Use the `cd` command to navigate to different directories within the structure.
#* - Use the `pwd` command to verify the current directory at each step.
#* - Use the `tree` command to display the complete directory structure.

mkdir -p Exercise2/{dir1,dir2,dir3}
touch Exercise2/{file1,file2,file3}.txt
ls Exercise2
cd Exercise2/dir1
pwd
cd ../dir2
pwd
cd ../dir3
pwd
cd ../..
tree Exercise2
