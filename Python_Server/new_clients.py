import socket
import threading

t=threading.Lock()
def main():
	s=socket.socket()
	s.connect(('127.0.0.1',5600))
	print(s.recv(1024))
	print(s.recv(1024))
	fname=raw_input('Filename->')
	while(fname != 'q'):
		if(fname != 'upload'):
			s.send(fname)
			data=s.recv(1024)
			print ('Exists, '+data+' Bytes' )
				
			fname=raw_input('Filename->')
		else:
			s.send(fname)
			
			print('----Upload a File----'.center(80))
			fname_upld=raw_input('Filename->')
			s.send(fname_upld)
			text=raw_input('Enter data')
			s.send(text)
			print(s.recv(1024))
			fname=raw_input('Filename->')
			
	s.close()

if __name__=='__main__':
	main()
