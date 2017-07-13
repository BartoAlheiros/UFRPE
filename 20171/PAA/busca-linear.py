import os

vetor = [13,6,5,21,14,11,19,11,16]

def busca_linear(A, x):
	i = 0
	while i < len(A):
		if A[i] == x:
			return i
		else:
			i = i + 1
	if i == len(A):			
			return -1
	
		


x = input('Digite o valor de x: ')
s = busca_linear(vetor, x)

if s != -1:
	print(s+1)
else:
	print(s)	

os.system("pause")