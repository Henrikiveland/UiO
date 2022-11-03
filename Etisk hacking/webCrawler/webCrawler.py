from requests import get

meta_ip = "10.0.2.4"
target_website = "http://" + meta_ip + "/mutillidae"

directory = open("dirs.txt", "r")
x = 1

for line in directory:
	url = target_website + "/" + line.strip()
	response = get(url)
	if (response):
		print(response , " from " , url)
	print( " ",x, "of 4614 (",round((x/46.14), 1),"%)",end="\r")
	x +=1
	

	
