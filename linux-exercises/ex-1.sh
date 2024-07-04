#!/bin/bash

#* Author : Dillon Juriansz

#* 1. File Manipulation:
#* - Create a directory called "Exercise1" and navigate into it.
#* - Create a file named "file1.txt" and add some text to it.
#* - Create a copy of "file1.txt" named "file2.txt" in the same directory.
#* - Rename "file2.txt" to "newfile.txt".
#* - Move "newfile.txt" to the parent directory.
#* - Remove "file1.txt" from the current directory.

mkdir -p Exercise1
cd Exercise1
echo "Hello World" > file1.txt
cp file1.txt file2.txt
mv file2.txt newfile.txt
mv newfile.txt ..
rm file1.txt
