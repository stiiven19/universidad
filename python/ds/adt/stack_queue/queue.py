from adt.stack_queue.nodes import StackNode
class Queue():
    def __init__(self):
        self.tail =  None
        self.Front = None
    def is_empty(self):
        return self.tail is None

    def enqueue(self, data):#añade al extremo
        new_node = StackNode(data)
        if self.is_empty():
            self.tail = new_node
            self.Front = new_node
            return True
        else:
            if type(self.Front.data)==type(data):
                #self.Front.next = new_node
                new_node.next = self.tail
                self.tail = new_node
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
        cadena = "["
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
