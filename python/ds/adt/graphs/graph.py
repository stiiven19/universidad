from adt.lists.sll import SinglyLinkedList
from adt.graphs.node import GraphNode
import math
class Graph():
    """docstring for Graph."""

    def __init__(self):
        self.partida = None
        self.listaNodes = SinglyLinkedList()
        self.matrizDistacia =  []
        self.matrizRecorridos = []
        self.matrizDnew=[]

    def is_empty(self):
        return self.partida is None

    def insertNode(self, new_key):
        new_node = GraphNode(new_key)
        if self.is_empty():
            self.partida = new_node
            self.listaNodes.append(new_node)
            return True
        else:
            if type(self.partida.key) == type(new_key):
                for i in self.listaNodes:
                    if i.key == new_key:
                        return False
                self.listaNodes.append(new_node)
                return True
            else:
                return False

    def insertArist(self, key_orig, key_dest,peso= None):
        node_dest = None
        for i in self.listaNodes:
            if i.key == key_dest:
                node_dest = i
                break
        if self.is_empty():
            return False
        else:
            for i in self.listaNodes:
                if i.key == key_orig and node_dest is not None:
                    return i.AñadirArista(node_dest,peso)
        return False

    def __str__(self):
        cadena = ""
        for i in self.listaNodes:
            cadena+=str(i)+"\n"
        return cadena[:len(cadena) - 1]

    def deleteArist(self, key_orig, key_dest = None):
        node_dest = None
        for i in self.listaNodes:
            if key_dest is None:
                break
            elif key_dest == i.key:
                node_dest = i
                break
        for i in self.listaNodes:
            if key_orig == i.key:
                if key_dest is not None and node_dest is not None:
                    return i.deleteArist(node_dest)

                elif key_dest is None and node_dest is None:
                    return i.deleteArist(node_dest)
                else:
                    return False

    def deleteNode(self,keyNode):
        node_dest = None
        for i in self.listaNodes:
            if keyNode == i.key:
                node_dest = i
                break
        for i in self.listaNodes:
            if node_dest is None:
                break
            i.deleteArist(node_dest)
        self.listaNodes.delete(node_dest)
        """if self.listaNodes.delete(node_dest) is None:
            return False
        else:
            return True"""

    def caminosMinimos(self):
        self.matrizDistacia =  []
        self.matrizRecorridos = []
        self.matrizDnew=[]
        matriz_inv=[]
        listaNodes2 = SinglyLinkedList()
        listaNodes3 = SinglyLinkedList()
        for i in self.listaNodes:
            listaNodes2.append(i)
            listaNodes3.append(i)
        for i in range(len(self.listaNodes)):
            self.matrizDnew.append([0]*len(self.listaNodes))
            self.matrizDistacia.append([0]*len(self.listaNodes))
            self.matrizRecorridos.append([0]*len(self.listaNodes))
            matriz_inv.append([0]*len(self.listaNodes))
        posi=0
        for i in self.listaNodes:
            posh=0
            for h in listaNodes3:
                posz=0
                #self.matrizRecorridos[posi][posh]=h.key
                for z in i.aristas:
                    posy=0
                    for y in listaNodes2:
                        if z.node_dest.key == y.key:
                            self.matrizRecorridos[posi][posy]=i.key
                            self.matrizDistacia[posi][posy]=z.Peso
                            self.matrizDnew[posi][posy]=z.Peso
                            break
                        posy+=1
                    posz+=1
                posh+=1
            posi+=1
        posi=0
        for i in self.listaNodes:
            posy=0
            for y in listaNodes2:
                if self.matrizDistacia[posi][posy]==0:
                    self.matrizDistacia[posi][posy]=math.inf
                    self.matrizDnew[posi][posy]=math.inf
                    self.matrizRecorridos[posi][posy]=None
                if posi==posy:
                    self.matrizDistacia[posi][posy]=0
                    self.matrizDnew[posi][posy]=0
                    self.matrizRecorridos[posi][posy]="-"
                posy+=1
            posi+=1
        posx=0
        matriz_inv2=list(zip(*self.matrizDistacia))
        for i in matriz_inv2[:]:
            posy=0
            for y in i:
                matriz_inv[posx][posy]=y
                posy+=1
            posx+=1
        posx=0
        for x in range(len(self.listaNodes)):
            posy=0
            for y in matriz_inv[:][x]:
                #print("______________________________________________________________")
                posz=0
                #print("Y: "+str(y))
                #print("posx: "+str(posx))
                #print("posy: "+str(posy))
                if y == math.inf:
                    posy+=1
                    continue
                if x==posy:
                    posy+=1
                    continue
                for z in self.matrizDnew[:][x]:
                    if posz==posx:
                        posz+=1
                        continue
                    if z==math.inf:
                        posz+=1
                        continue
                    #print("posx: "+str(posx))
                    #print("x: "+str(x))
                    #print("Z: "+str(z))
                    #print(str(posy)+" = "+str(posz))
                    #print(str(y)+"+"+str(z)+" = "+str(z+y)+" < "+str(self.matrizDnew[posy][posz]))
                    #print(z+y < self.matrizDnew[posy][posz])
                    if z+y < self.matrizDnew[posy][posz]:
                        self.matrizDnew[posy][posz]=z+y
                        matriz_inv[posz][posy]=z+y
                        #self.matrizRecorridos[posy][posz]=self.listaNodes.locate(x).key
                        self.matrizRecorridos[posy][posz]=self.matrizRecorridos[x][posz]
                        #print("x: "+str(self.listaNodes.locate(x).key))
                        #print("x: "+str(x))
                        #print("locate: "+str(self.matrizRecorridos[x][posz]))
                        #print(str(posy)+" = "+str(posz))
                    #print("Z: "+str(z))
                    #print("posz: "+str(posz))
                    posz+=1
                posy+=1
            posx+=1
        """print("recorridos")
        for i in self.matrizRecorridos:
            print (i)
        print("nueva")
        for i in self.matrizDnew:
            print (i)
        print("normal")
        for i in self.matrizDistacia:
            print (i)
        print("inversa")
        for i in matriz_inv:
            print (i)"""
        return self.matrizDnew
