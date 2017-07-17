
import os
#corte da barra

barras = [0, 2, 3, 7, 8, 9]
#solucao = [0, 0, 0, 0, 0, 0] # a solucao deve ser 0, 2, 4, 7, 9, 11


def melhor(B, o, m):
    if m == 0:
        o[m] = 0
    else:
        a = 0
        s = 0
        l = m
        for i in range(m):
            if o[i] != 0:
                a = o[i] + o[m-i]   
                if a > s:
                    s = a
                    l = i
        if s > B[m]:
            o[m] = s
        else:
            o[m] = B[m]
    

def cut(B):
    C = []
    for c in range(len(B)):
        C.append(0)
        melhor(B, C, c)
    return C

s = cut(barras)

print(s)
os.system("pause")