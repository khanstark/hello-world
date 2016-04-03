import socket
import os
import threading
from stark.dirs import *
def main():
	s=socket.socket()
	s.bind(('127.0.0.1',5600))
	s.listen(1)
	c,addr=s.accept()
	st='---Welcome to Python File Server---'.center(80)+'Type "upload" to upload new file'.center(80)
	c.send(st)
	c.send('  '.join(all_file()))
	fname=c.recv(1024)	
	while(fname != 'q'):
		if(fname != 'upload'):	
			if(os.path.isfile(fname)):
			
				c.send(str(os.path.getsize(fname)))
			else:
				c.send('ERROR! Not a file')
			fname=c.recv(1024)
		else:
			upld=c.recv(1024)
			text=c.recv(1024)
			with open(upld,'wb') as f:
				f.write(text)
			c.send('---File uploaded successfully---'.center(80))	
			fname=c.recv(1024)	
	s.close()

	
	
if __name__=='__main__':
	main()
