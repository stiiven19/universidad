from colegio_app.colegio import Colegio,Estudiante
from adt.lists.sll import SinglyLinkedList
def menu():
    print("**** MENU DE ADMINISTRACION DE COLEGIOS ****")
    print("1- Crear un colegio")
    print("2- Matricular un estudiante" )
    print("3- Expulsar un estudiante")
    print("4- Obtener el registro de un estudiante")
    print("5- Listas estudiantes matriculados")
    print("6- Reporte")
    print("7- Salir")

def matricula(materia):
    cod = input("Codigo del estudiante: ")
    estudiante=cole.buscarCodigo(cod)
    if estudiante!=None:
        print("Estudiante: "+estudiante.nombre)
        nota = float(input("Nota del estudiante: "))
        while nota<=0.0 and nota>=5.0:
            print("\nError. nota admitida entre 0 y 5\n")
            nota = float(input("Nota del estudiante: "))
        estudiante=Estudiante(estudiante.codigo,materia,estudiante.nombre,nota)
        return estudiante
    else:
        nom = input("Nombre del estudiante: ")  
        nota = float(input("Nota del estudiante: "))
        while nota<=0.0 and nota>=5.0:
            print("\nError. nota admitida entre 0 y 5\n")
            nota = float(input("Nota del estudiante: "))
        estudiante=Estudiante(cod,materia,nom,nota)
        return estudiante


if __name__ == '__main__':
    cole = None
    while True:
        menu()
        opc = int(input("opcion: "))
        if opc == 1:
            nom_cole = input("Nombre del colegio: ")
            cole=Colegio(nom_cole)
            
        elif cole is not None:
            if opc == 2:
                while True:
                    print("\n********Materia a Matricular*********")
                    print("1- Matematicas")
                    print("2- Ciencias")
                    print("3- Sociales")
                    print("4- Español")
                    print("5- Cancelar")
                    opc2=int(input("opcion: "))
                    if opc2==1:
                        print("\nMatricular a matematicas")
                        estudiante2=matricula("Matematicas")
                        cole.matricular(estudiante2)
                    elif opc2==2:
                        print("\nMatricular a Ciencias")
                        estudiante2=matricula("Ciencias")
                        cole.matricular(estudiante2)
                    elif opc2==3:
                        print("\nMatricular a Sociales")
                        estudiante2=matricula("Sociales")
                        cole.matricular(estudiante2)
                    elif opc2==4:
                        print("\nMatricular a Español")
                        estudiante2=matricula("Español")
                        cole.matricular(estudiante2)
                    elif opc2==5:
                        break
                    else:
                        print("opcion NO valida")
                    
                    print("")
                    input("<ENTER> Para continuar...")
                    print("")
                
                
            elif opc == 3:
                pos_exp = int(input("Posicion para expulsar estudiante: "))
                cole.expulsar(pos_exp)
            elif opc == 4:
                cod = input("Codigo del estudiante: ")
                cole.registro(Estudiante(cod))
            elif opc == 5:
                cole.listado()
            elif opc == 7:
                print("Bye Bye!")
                break
            elif opc==6:
                cole.reporte()
            else:
                print("Opcion no valida: ")
        elif opc == 7:
            print("Bye Bye!")
            break
        else:
            print("ADVERTENCIA Es necesario crear un colegio antes de continuar!")
        print("")
        input("<ENTER> Para continuar...")
        print("")
#consultar dentro de las cadenas formateadas justificacion(izq,centro,derecha)
#nota maneje 3 cifras decimales
