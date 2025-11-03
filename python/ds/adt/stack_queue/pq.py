# coding=UTF-8
from adt.stack_queue.nodes import PriorityNode
class PriorityQueue():
    def __init__(self):
        self.tail =  None
        self.Front = None
    def is_empty(self):
        return self.tail is None

    def enqueue(self, nuevo_dato,prioridad=1):#añade al extremo
        new_node = PriorityNode(nuevo_dato,prioridad)
        current_node = self.tail
        prev_node = None
        if prioridad<1 :
            print("priority: Value error")
            return False

        if type(prioridad) is not type(1):
            print ("priority: Value error")
            return False
        if self.is_empty():
            self.tail = new_node
            self.Front = new_node
            return True
        else:
            if type(self.Front.data)==type(nuevo_dato):
                while current_node.Priority > prioridad:
                    prev_node = current_node
                    current_node = current_node.next
                    if current_node is None:
                        break
                new_node.next = current_node
                if prev_node is None:
                    self.tail = new_node
                else:
                    prev_node.next = new_node
                    if current_node != self.Front:
                        while current_node != self.Front and current_node is not None:
                            prev_node = current_node
                            current_node = current_node.next
                        self.Front = prev_node.next
                return True
        return False

    def dequeue(self):
        current_node = self.tail
        if not self.is_empty():
            if current_node.next is None:
                data = current_node.data
                self.Front = None
                self.tail = None
                return data
            while current_node.next is not self.Front:
                current_node = current_node.next
            self.Front = current_node
            data = current_node.next.data
            current_node.next = None
            return data
        return None

    def front(self):
        if not self.is_empty():
            return self.Front.data
        return None

    def __str__(self):
        cadena = "[,"
        current_node = self.tail
        while current_node is not None:
            cadena = cadena + str(current_node.data)
            current_node = current_node.next
            if current_node is None:
                break
            cadena = cadena + ","
        cadena = cadena + "]"
        return cadena


    def __len__(self):
        total_elementos = 0
        current_node = self.tail
        while current_node is not None:
            total_elementos += 1
            current_node = current_node.next
        return total_elementos
