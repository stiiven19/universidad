from adt.lists.cll	import CircularLinkedList
if __name__=="__main__":
	lista=CircularLinkedList()
	print(lista.append(7))
	print(lista.append(7))
	print(lista.append(5))
	print(lista.append(6))
	print(lista.append(7))
	lista.explorer()
	"""print(lista.insert(1,0))
	print(lista.insert(2,1))
	print(lista.insert(3,2))
	print(lista.insert(4,3))"""

	#print("remove: "+str(lista.remove(var)))

#	print(lista.__len__())
	#print(lista.delete(7,True))

	#print(lista.delete())
	#lista1=[]
	#print(lista)
	#print("delete: "+str(lista.delete(7,True)))

	
	#print("search: "+str(lista.search(0)))
	if lista.head!=None:
		print("head: " + str(lista.head.data))
	if lista.tail!=None:
		print("tail: " + str(lista.tail.data))
	lista.explorer()
	
	
