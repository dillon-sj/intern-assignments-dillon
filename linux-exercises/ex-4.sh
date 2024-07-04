#!/bin/bash

#* Author : Dillon Juriansz

#* 4. Searching and Filtering:
#* - Create a file named "data.txt" with some text content.
#* - Use the `cat` command to display the contents of "data.txt".
#* - Use the `grep` command to search for a specific word or pattern in "data.txt".
#* - Use the `grep` command with the `-r` option to search for the same word or pattern
#* recursively in a directory.

echo "Helloing, my name is Dillon Juriansz" > data.txt
cat data.txt
grep "Dillon" data.txt
grep -r "Dillon" . # '.' represents the current directory. The more you know :)


