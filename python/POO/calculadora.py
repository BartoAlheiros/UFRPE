#calculadora.py
#autor: José Bartolomeu Alheiros Dias Neto
#do tuto: http://pythonclub.com.br/introducao-classes-metodos-python-basico.html
#por Regis Silva.
#Olinda, 13 de julho de 2017.

class Calculadora(object):
	"""documentacao para Calculadora"""
	def __init__(self, a, b): #inicializa o objeto com os valores para os atributos 'a' e 'b'
		self.a = a
		self.b = b

	def soma(self):
		return self.a + self.b

	def subtrai(self):
		return self.a - self.b
	
				