from adt.lists.dll import DoublyLinkedList
if __name__ == '__main__':
    lista = DoublyLinkedList()
    print(lista.append(1))
    print(lista.append(2))
    print(lista.append(1))
    print(lista.append(4))
    print(lista.append(1))

    print(lista)

    """try:
		print("data: " + str(lista.forward().data))
		print("data2: " + str(lista.backward().data))
		print("data2: " + str(lista.backward().data))
		print("data2: " + str(lista.backward().data))
		print("data2: " + str(lista.backward().data))
		print("data: " + str(lista.forward().data))
		print("data: " + str(lista.forward().data))
		print("data: " + str(lista.forward().data))

		print("data: " + str(lista.forward().data))
		print("data: " + str(lista.forward().data))
		print("data2: " + str(lista.backward().data))
		print("data2: " + str(lista.backward().data))
		print("data2: " + str(lista.backward().data))
		print("data2: " + str(lista.backward().data))
	except Exception as e:
		print("eror None")"""
