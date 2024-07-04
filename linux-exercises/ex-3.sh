#!/bin/bash

#* Author : Dillon Juriansz

#* 3. Permissions and Ownership:
#* - Create a file named "secure.txt" and set the permissions to read and write for the owner only.
#* - Change the ownership of "secure.txt" to a different user.
#* - Try to modify or delete "secure.txt" using a different user account.
#* - Use the `chown` and `chmod` commands to restore the original ownership and permissions.

touch secure.txt
chmod 600 secure.txt # Owner can read and write because of the 6
sudo chown root secure.txt # Change ownership to root
ls -l secure.txt # Check the permissions of the file
rm secure.txt # Try to remove the file 
sudo chown $USER secure.txt # return acess to the user dillon
chmod 600 secure.txt # return permissions to the user dillon
ls -l secure.txt # Check the permissions of the file
