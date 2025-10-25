import sys
import os
import gi
import math
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
from adt.graphs.graph   import Graph
from grafos_app.class_grafo import graph


class SignalHandlers():
    def __init__(self, builder):

        self.NdDato = builder.get_object("NdDato")
        self.IngNode = builder.get_object("IngNode")

        self.NdOrigen = builder.get_object("NdOrigen")
        self.NdDestino = builder.get_object("NdDestino")
        self.NdPeso = builder.get_object("NdPeso")
        self.IngArista = builder.get_object("IngArista")


        self.NdDatoE = builder.get_object("NdDatoE")
        self.ElmNodo = builder.get_object("ElmNodo")

        self.NdOrigenE = builder.get_object("NdOrigenE")
        self.NdDestinoE = builder.get_object("NdDestinoE")
        self.ElmArista = builder.get_object("ElmArista")

        self.ndO = builder.get_object("ndO")
        self.ndD = builder.get_object("ndD")

        self.dl1 = builder.get_object("dl1")
        self.dl2 = builder.get_object("dl2")

        self.list1 = builder.get_object("list1")
        self.list2 = builder.get_object("list2")
        self.list3 = builder.get_object("list3")
        self.list4 = builder.get_object("list4")
        self.tree1 = builder.get_object("tree1")

        self.txv_screentext = builder.get_object("txv_screentext")
        self.txv_screentext2 = builder.get_object("txv_screentext2")

        self.grafo = Graph()
        """self.grafo.insertNode("a")
        self.grafo.insertNode("b")
        self.grafo.insertNode("c")

        self.grafo.insertArist("a","b",2)
        self.grafo.insertArist("a","c",2)
        self.grafo.insertArist("b","a",2)
        self.grafo.insertArist("c","a",2)"""


    def on_insertNode(self, button):
        text=self.NdDato.get_text()
        if len(text) !=0:
            if self.grafo.insertNode(text):
                print("insertado")
                self.list1.insert(len(self.list1),[text+":"])
                self.NdDato.set_text("")
                self.NdDato.grab_focus()
                self.floyd()
        else:
            self.dl2.format_secondary_text("Error NO ha llenado TODAS las casillas")
            self.dl2.run()
            self.dl2.hide()
    def on_insertArist(self,button):
        key_orig = self.NdOrigen.get_text()
        key_dest = self.NdDestino.get_text()
        peso = self.NdPeso.get_text()

        if len(key_orig) != 0 and len(key_dest) != 0 and len(peso) != 0:
            if not peso.isdigit() and not (peso[0]=="-" and peso[1:].isdigit()):
                self.dl2.format_secondary_text("Peso debe ser un Numero")
                self.dl2.run()
                self.dl2.hide()
                return
            if self.grafo.insertArist(key_orig,key_dest,int(peso)):
                posi=0
                for i in self.list1:
                    if i[0][0] == key_orig:
                        i[0] = str(self.grafo.listaNodes.locate(posi))
                    posi+=1
                self.floyd()
            else:
                self.dl1.format_secondary_text("Ya existe una conexion entre los nodos")
                self.dl1.run()
                self.dl1.hide()
        else:
            self.dl2.format_secondary_text("Error NO ha llenado TODAS las casillas")
            self.dl2.run()
            self.dl2.hide()
        #print(self.grafo)

    def on_elimNode(self, button):
        text=self.NdDatoE.get_text()
        if len(text) !=0:
            self.grafo.deleteNode(text)
            lis1 = []
            for i in self.list1:
                lis1.append([i[0]])
            self.list1.clear()
            posi=0
            for i in lis1:
                if i[0][0]==text:
                    lis1.pop(posi)
                posi+=1
            for i in range(len(lis1)):
                self.list1.append(lis1[i])
            self.NdDatoE.set_text("")
            self.NdDatoE.grab_focus()
            self.floyd()
        else:
            self.dl2.format_secondary_text("Error NO ha llenado TODAS las casillas")
            self.dl2.run()
            self.dl2.hide()

    def on_elimArist(self, button):
        key_orig = self.NdOrigenE.get_text()
        key_dest = self.NdDestinoE.get_text()
        if len(key_orig) != 0 and len(key_dest) != 0 :
            if self.grafo.deleteArist(key_orig, key_dest):
                list = []
                text = str(self.grafo)
                for i in self.grafo.listaNodes:
                    list.append([str(i)])
                self.list1.clear()
                for i in range(len(list)):
                    self.list1.append(list[i])
                self.floyd()
            else:
                self.dl2.format_secondary_text("No Existe Esa Arista")
                self.dl2.run()
                self.dl2.hide()
        else:
            self.dl2.format_secondary_text("Error NO ha llenado TODAS las casillas")
            self.dl2.run()
            self.dl2.hide()
        #print(self.grafo)
        #_______________________________________________________________________________________________________________________________
    def on_btn_buscar_clicked(self, button):
        node_orig = self.ndO.get_text()
        node_dest = self.ndD.get_text()
        pos=0
        poss=0
        if len(node_dest) == 0 or len(node_orig)==0:
            self.dl2.format_secondary_text("Error NO ha llenado TODAS las casillas")
            self.dl2.run()
            self.dl2.hide()
            return
        bandera1=False
        bandera2=False
        for i in self.grafo.listaNodes:
            if i.key == node_orig:
                bandera1=True
                pos+=1
                break
            pos+=1
        for i in self.grafo.listaNodes:
            if i.key == node_dest:
                bandera2=True
                poss+=1
                break
            poss+=1
        matriz = self.grafo.caminosMinimos()
        matrizRecorridos = self.grafo.matrizRecorridos
        """print("matrizes")
        for i in matrizRecorridos:
            print()
            print (i)
        print("r")
        for i in matriz:
            print()
            print (i)"""
        if bandera1 is False or bandera2 is False:
            self.dl1.format_secondary_text("Verificar Que El Nodo "+str(node_orig)+" Y El Nodo "+str(node_dest)+" Se Encuentren En El Grafo")
            self.dl1.run()
            self.dl1.hide()
            return
        else:
            if matrizRecorridos[pos-1][poss-1] == "  -  " or matriz[pos-1][poss-1] == math.inf:
                self.dl1.format_secondary_text("NO Hay Ningun Camino Desde El Nodo "+str(node_orig)+" Hasta el Nodo: "+str(node_dest))
                self.dl1.run()
                self.dl1.hide()
                return
            if matrizRecorridos[pos-1][poss-1] == node_orig:
                self.dl1.format_secondary_text("Desde el Nodo: "+str(node_orig)+" Hasta el Nodo: "+str(node_dest)+"\n"+
                                               "Tenemos Un Camino Directo \n"+
                                               "Con un Peso: "+str(matriz[pos-1][poss-1]))
                self.dl1.run()
                self.dl1.hide()
                return
            respuesta=str(node_orig)+self.__caminos(matrizRecorridos,node_orig,matrizRecorridos[pos-1][poss-1])+" -> "+str(matrizRecorridos[pos-1][poss-1])+" -> "+node_dest
            self.dl1.format_secondary_text("--------------------Camino Minimo---------------\n"
                                           +"Desde el Nodo: "+str(node_orig)+" Hasta el Nodo: "+str(node_dest)
                                           +"\n"+str(respuesta)+"\n"+
                                           "Con un Peso: "+str(matriz[pos-1][poss-1]))
            self.dl1.run()
            self.dl1.hide()
        #print(pos-1)
        #print(matriz[pos-1][poss-1])
        #print(poss-1)
        #print(matrizRecorridos[pos-1][poss-1])

    def floyd (self):
        mostrar2="----------Matriz de Distancias---------\n"
        mostrar3="----------Matriz de Recorridos---------\n"
        mostrar2+="      "
        mostrar3+="      "
        self.lista_vertices=[]
        for i in self.grafo.listaNodes:
            self.lista_vertices.append(i.key)
            mostrar2+="| "+str(i.key)+"  "
            mostrar3+="|    "+str(i.key)+"      "
        mostrar2+="\n"
        mostrar3+="\n"
        matrizdistancias=self.grafo.caminosMinimos()
        pos=0
        for i in matrizdistancias:
            mostrar2+="  "+str(self.lista_vertices[pos])+"  "
            for y in i:
                if y==math.inf:
                    mostrar2+="| "+str( "∞")+"  "
                else:
                    mostrar2+="| "+str(y)+"  "
            mostrar2+=" \n"
            pos+=1

        pos=0
        for i in self.grafo.matrizRecorridos:
            mostrar3+="  "+str(self.lista_vertices[pos])+"  "
            for y in i:
                if y is None or y == "  -  " :
                    mostrar3+="| "+str(y)+"  "
                else:
                    mostrar3+="|    "+str(y)+"      "
            pos+=1
            mostrar3+=" \n"
        self.txv_screentext2.set_text(mostrar3)
        self.txv_screentext.set_text(mostrar2)

        #_________________________________________________________________________________________________________________________________________________________________________

    def __caminos(self,matriz,node_orig,node_dest):
        #print("origen: "+str(node_orig))
        #print("destino: "+str(node_dest))
        poss=0
        pos=0
        respuesta=""
        for y in self.grafo.listaNodes:
            if y.key == node_dest:
                break
            poss+=1
        for y in self.grafo.listaNodes:
            #print(y.key)
            #print(node_orig)
            if y.key == node_orig:
                #print("respuesta: "+respuesta)
                #print("matriz: "+str(matriz[pos][poss]))
                if node_orig==matriz[pos][poss] or matriz[pos][poss]== "  -  " :
                    return ""
                respuesta+=self.__caminos(matriz,node_orig,matriz[pos][poss])+" -> "+str(matriz[pos][poss])
                #print("respuesta: "+respuesta)
                break
            pos+=1
        return respuesta


    def on_graficar_clicked(self,button):
        lista_vertices = []
        edges=[]
        matriz = self.grafo.caminosMinimos()
        for i in self.grafo.listaNodes:
            lista_vertices.append(i.key)
            for y in i.aristas:
                edges.append([y.node_orig.key,y.node_dest.key,y.Peso])
        #print(lista_vertices)
        #print(edges)
        b=graph(lista_vertices,edges,True)
        b.draw_nodes()
        b.draw_edges()


class AppPrincipal(Gtk.Application):

    def __init__(self, *arg, **kwargs):
        super().__init__(*arg, **kwargs)
        self.ventana = None

    def do_activate(self):
        if not self.ventana:
            builder = Gtk.Builder()
            #builder.add_from_file("grafos_app.grafos.glade")
            builder.add_from_file(os.path.join(os.path.dirname(__file__), "grafos.glade"))
            self.ventana = builder.get_object("main_window")
            self.add_window(self.ventana)
            builder.connect_signals(SignalHandlers(builder))
        self.ventana.show_all()


if __name__ == "__main__":
    app = AppPrincipal(application_id="grafos")
    sys.exit(app.run(sys.argv))
