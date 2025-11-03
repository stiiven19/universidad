from tkinter import *
import tkinter as tk
import random
import math

class graph():

    def __init__(self, lista_vertices,edges,alfabetic=False):
        self.lista_vertices=lista_vertices
        if alfabetic == False:
            self.edges=edges
        else:
            self.edges=self.conversor(edges,lista_vertices)
            #print("Ok______")

        self.coor_vertices=[]
        self.ventana=tk.Tk()
        self.ventana.title("Grafo")
        self.ventana.geometry("800x800")

        self.c=Canvas(self.ventana,width=1000,height=1000)
        self.c.place(x=0,y=0)
        self.c.pack()

        #ventana.show_all()
        #self.ventana.mainloop()

    def draw_nodes(self):
        #i=self.lista_pos.size()

        for i in self.lista_vertices:
             x=random.randint(0,700)
             y=random.randint(0,700)
             coordenadas=[x,y]
             self.coor_vertices.append(coordenadas)

             #print("eeewwe",x," ",y)
             self.c.create_oval(x+20,y+20,x-20,y-20,fill="black")

             self.c.create_text(x,y,fill="white",text=i)


        #self.ventana.mainloop()

    def draw_edges(self,floyd=False,path=None):
        i=0


        #self.c.create_text(100,100,fill="blue",text="Click ")
        for ii in self.edges:
            j=0
            h=0

            j=self.edges[i][0]  #De donde sale
            h=self.edges[i][1]  #Donde llega
            #self.coor_vertices[j]


            if floyd is  False:
                colors=["red","green","blue","brown","orange","purple","yellow","black","gray"]
                cc=random.randint(0,6)

            else:
                #turtle.pencolor("black")
                r=0
                for hh in path:
                    if j==path[r] and h==path[r+1]:
                        pass#turtle.pencolor("red")

                    r+=2
                    if r>= len(path):
                            break
            #Etiqueta nodo

            #self.c.create_text(self.coor_vertices[j][0]+15,self.coor_vertices[j][1]+15,fill=colors[cc],text=self.lista_vertices[j])

            #Pendiente
            m=float(((self.coor_vertices[j][1]+0.000)-(self.coor_vertices[h][1]+0.000))/((self.coor_vertices[j][0]+0.000)-(self.coor_vertices[h][0]+0.000)))
            #distancia nodos
            #d=math.sqrt(math.pow((self.coor_vertices[j][1]-self.coor_vertices[h][1]),2)+math.pow((self.coor_vertices[j][0]-self.coor_vertices[h][0]),2))
            #p=10.0/3.0
            #print("\\\\",p)
            #Coordenadas
            y1=self.coor_vertices[j][1]
            y2=self.coor_vertices[h][1]

            x1=self.coor_vertices[j][0]
            x2=self.coor_vertices[h][0]
#            print("##",str(m),"-->",(self.coor_vertices[j][1]),"-",(self.coor_vertices[h][1]),"/",(self.coor_vertices[j][0]),"-",(self.coor_vertices[h][0]))

            if y2>y1 and x2>x1:
                    self.c.create_line(x1+10,y1+10,x2-10,y2-10,fill=colors[cc],width=4)
                    #self.c.create_polygon(x1+10,y1+10,x2-10,y2-10,x1+15,y1+15,x2-15,y2-15,x1+15,y1+15,x2+15,y2+15,fill=colors[cc])
                    self.c.create_oval(x2-5,y2-5,x2-15,y2-15,fill=colors[cc])
                    #self.c.create_line(x2-10,y2-10,x2-5,y2-5,fill=colors[cc])
                    #~self.c.create_line(x2-10,y2-15,x2-5,y2-5,fill=colors[cc])


            if y2>y1 and x1>x2:
                    self.c.create_line(x1-10,y1+10,x2+10,y2-10,fill=colors[cc],width=2)
                    self.c.create_oval(x2+15,y2-5,x2+5,y2-15,fill=colors[cc])


            if y2<y1 and x1>x2:
                    self.c.create_line(x1-10,y1-10,x2+10,y2+10,fill=colors[cc],width=4)
                    self.c.create_oval(x2+15,y2+15,x2+5,y2+5,fill=colors[cc])


            if y2<y1 and x2>x1:
                    self.c.create_line(x1+10,y1-10,x2-10,y2+10,fill=colors[cc],width=2)
                    self.c.create_oval(x2-5,y2+15,x2-15,y2+5,fill=colors[cc])

            i+=1
        self.ventana.mainloop()

    def conversor(self,edges_alfabetic,lista_vertices):
        edges_return=[]

        i=0
        for value in edges_alfabetic:
            minilist=[]
            salida=value[0]
            llegada=value[1]
            peso=value[2]

            j=0
            for v2 in lista_vertices:
                if salida == v2:
                    minilist.append(j)
                    h=0
                    for v3 in lista_vertices:
                        if llegada == v3:
                            minilist.append(h)
                            minilist.append(peso)
                            break
                        h+=1
                j+=1
            i+=1
            edges_return.append(minilist)
        return edges_return


            #    0   1   2   3   4   5   6   7   8   9        10


lista_vertices=["A","B","C","D","E","F","G","H","I","J","San Juan Pasto"]

#edges=[[1,2,"2k"],[3,4,"3k"],[4,1,"7k"],[2,3,"9k"],[0,2,"6k"],[9,5,"3k"],[8,6,"1k"],[7,2,"6k"],[8,0,"2k"]]
edges_alfabetic=[["B","C","2k"],["D","E","3k"],["E","B","7k"],["C","D","9k"],["A","C","6k"],["J","F","3k"],["I","G","1k"],["H","C","6k"],["I","A","2k"]]

#print(edges_alfabetic)
#print(edges)
#print()
#lista_vertices=["A","B","C","D"]
#edges=[[0,1,"3"],[3,2,"4"],[2,0,"34"]]
#edges_alfabetic=[["A","B","3"],["D","C","4"],["C","A","34"]]

#b=graph(lista_vertices,edges_alfabetic,True)
#b=graph(lista_vertices,edges)
#print(b.conversor(edges_alfabetic,lista_vertices))
#b.draw_nodes()
#b.draw_edges()
