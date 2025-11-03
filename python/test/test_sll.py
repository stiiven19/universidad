from adt.lists.sll  import SinglyLinkedList
if __name__=="__main__":
    lista_num=SinglyLinkedList()
    lista_num.append(4)
    lista_num.append(0)
    lista_num.append(1)
    lista_num.append(4)
    lista_num.append(2)
    lista_num.append(3)
    lista_num.append(4)

    lista_num.explorer()

#print(lista_num.remove(5))
#print(lista_num.is_empty())
#print(lista_num.search(0))
#print(lista_num.insert(0,5))

#print(lista_num.locate(-1))

print("")
lista_num.delete(4,True)
lista_num.explorer()
print("")
list = []
for i in lista_num:
    print(i)
