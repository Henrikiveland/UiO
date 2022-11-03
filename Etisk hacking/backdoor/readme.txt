1. Open 'backdoor.py' and make sure that 'kali_ip' is correct.

2. Send the file 'backdoor.py' to your ubuntu vm.

3. On Kali vm run 'nc -v -l -p 5555' in terminal.

4. On Ubuntu vm run 'python3 backdoor.py'.

5. Kali vm and Ubuntu vm will now connect and you
   can write non-interactive Unix commands on Kali
   that will execute on Ubuntu and send the
   results back to Kali.