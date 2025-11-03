from adt.graphs.arist import AristGraph
from adt.lists.sll import SinglyLinkedList
class GraphNode:
    """docstring for TreeNode."""

    def __init__(self, Key):
        self.key = Key
        self.aristas = SinglyLinkedList()

    def AñadirArista(self, node_dest,peso=None):
        arista = AristGraph(self, node_dest, peso)
        #print("nd "+str(node_dest))
        for i in self.aristas :
            if i.node_dest == node_dest:
                return False
        self.aristas.append(arista)
        return True

    def deleteArist(self, node_dest):
        for i in self.aristas:
            if i.node_dest == node_dest:
                self.aristas.delete(i)
                return True
            if node_dest is None:
                self.aristas.delete(i)
        return False



    def __str__(self):
        cadena = str(self.key)
        if not self.aristas.is_empty():
            cadena+= ":"
            for i in self.aristas:
                cadena+=str(i)+","
            cadena=cadena[:len(cadena) - 1]
        return cadena
