# parkinglot

Hi,


======================================================================
DOWNLOAD AND BUILD PROJECT
======================================================================
1. Git location
https://github.com/hemantvsn/parkinglot.git

2. Its a maven PROJECT.
Once you download and extract it, we need to build it.

3. execute 
mvn clean package

The final jar will now be installed locally in /target folder

4. The jar can directly be executed via
hemant@hem-pc:~/PROJECT/parkinglot$ java -jar target/parkinglot-0.0.1-SNAPSHOT.jar


======================================================================
EXECUTING SHELL SCRIPT
======================================================================
In the main directory we have my_program.sh file.
This needs to be executed for triggering the program.
Following are some of the ways:

1. http://stackoverflow.com/questions/8779951/how-do-i-run-a-shell-script-without-using-sh-or-bash-commands

Make your file executable (chmod +x my_program.sh).
Finally, modify your path to add the directory where your script is located:
export PATH=$PATH:/appropriate/directory


2. Make your file executable (chmod +x my_program.sh).
Like
alias my_program='/home/hemant/PROJECT/parkinglot/./my_program.sh'
in .bashrc file and then reload the bash shell via
source .bashrc

3. If neither #1 or #2 works, we can execute the same without any alias
(provided execute permission is present)
a. Go to the directory containing the script
b. ./my_program.sh       -> to launch shell
c. ./my_program.sh input.txt > xyz.txt  -> to directly log all into output file




