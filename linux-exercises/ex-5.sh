#!/bin/bash

#* Author : Dillon Juriansz

#* 5. File Compression and Archiving:
#* - Create a directory with multiple files and subdirectories.
#* - Use the `tar` command to create a compressed tarball of the directory.
#* - Use the `gzip` command to compress a single file separately.
#* - Use the `zip` command to create a zip archive of the directory or individual files.

mkdir -p Exercise5/dir{1..3}
touch Exercise5/file{1..3}.txt
tar -cfv Exercise5.tar Exercise5
gzip Exercise5/file1.txt
zip -r Exercise5.zip Exercise5
ls -l
