from adt.lists.sll import SinglyLinkedList


class Estudiante:
    def __init__(self, codigo, nombre="", nota=0.0):  # materia=""
        self.codigo = codigo
        self.nombre = nombre
        self.nota = nota
        # self.materia=materia

    def __eq__(self, otro_estudiante):
        if otro_estudiante == None:
            return False
        else:
            return self.codigo == otro_estudiante.codigo
        # tarea validar que este metodo

    def __lt__(self, otro):
        if isinstance(otro, Estudiante):
            if self.codigo < otro.codigo:
                return True
            else:
                return False

    def __gt__(self, otro):
        if isinstance(otro, Estudiante):
            return self.codigo>otro.codigo

    def __str__(self):
        return str(self.codigo) + "        " + str(self.nombre) + "        " + str(self.nota) + "        "


class Burro:

    def __init__(self, codigo):
        self.codigo = codigo


class Colegio:
    def __init__(self, nombre):
        self.nombre = nombre
        self.lista = SinglyLinkedList()
        self.ciencias = SinglyLinkedList()
        self.matematicas = SinglyLinkedList()
        self.sociales = SinglyLinkedList()
        self.español = SinglyLinkedList()

    def matricular(self, un_estudiante):

        print(" ")
        if un_estudiante.materia == "Matematicas":
            print("matricula matematicas")
            if self.matematicas.append(un_estudiante):
                self.lista.append(un_estudiante)
                print("El estudiante llamado " + un_estudiante.nombre +
                      " fue MATRICULADO en Matematicas")
            else:
                print("El estudiante llamado " +
                      un_estudiante.nombre + " NO fue MATRICULADO")
        elif un_estudiante.materia == "Ciencias":
            if self.ciencias.append(un_estudiante):
                self.lista.append(un_estudiante)
                print("El estudiante llamado " + un_estudiante.nombre +
                      " fue MATRICULADO en Ciencias")
            else:
                print("El estudiante llamado " +
                      un_estudiante.nombre + " NO fue MATRICULADO")
        elif un_estudiante.materia == "Sociales":
            if self.sociales.append(un_estudiante):
                self.lista.append(un_estudiante)
                print("El estudiante llamado " + un_estudiante.nombre +
                      " fue MATRICULADO en Sociales")
            else:
                print("El estudiante llamado " +
                      un_estudiante.nombre + " NO fue MATRICULADO")
        elif un_estudiante.materia == "Español":
            if self.español.append(un_estudiante):
                self.lista.append(un_estudiante)
                print("El estudiante llamado " + un_estudiante.nombre +
                      " fue MATRICULADO en Español")
            else:
                print("El estudiante llamado " +
                      un_estudiante.nombre + " NO fue MATRICULADO")
        else:
            print("El estudiante llamado " +
                  un_estudiante.nombre + " NO fue MATRICULADO")

    def expulsar(self, pos_estu):
        rta = "SI" if self.lista.remove(pos_estu) else "NO"
        print("El estudiante en la posicion " +
              str(pos_estu) + " " + rta + " fue EXPLUSADO!")

    def registro(self, un_estudiante):
        reg_estu = SinglyLinkedList()
        for x in range(self.lista.__len__()):
            if self.lista.locate(x).codigo == un_estudiante.codigo:
                reg_estu.append(self.lista.locate(x))

        if reg_estu.__len__() > 0:
            print("Registro Estudiantil:")
            print("Código        Nombre        Nota        Materia")
            print("-" * 57)
            for x in range(reg_estu.__len__()):
                print(reg_estu.locate(x))

        else:
            print(
                f"No tenemos registrado al estudiante de código {un_estudiante.codigo} en nuestras bases de datos!")

    def listado(self):

        print(f"\n\n\nColegio {self.nombre}")
        print("=" * 57)
        print("Código        Nombre        Nota        Materia")
        print("-" * 57)
        self.lista.explorer()

    def reporte(self):
        estudiantes_mayorNota = self.mayorNota()
        if estudiantes_mayorNota.__len__() != 0:
            print("\n\n")
            print((f"Colegio {self.nombre}").center(25, "="))
            print(" ")
            print(("Reporte Estudiantes con mayor nota").center(25, " "))
            print(
                ("Nota Mayor: " + str(estudiantes_mayorNota.locate(0).nota)).center(25,))
            print(("Código        Nombre        Nota").center(25, " "))
            for x in range(estudiantes_mayorNota.__len__()):
                print(str(estudiantes_mayorNota.locate(x)).center(25, " "))
        else:
            print("NO hay estudiantes matriculados")

    def mayorNota(self):
        total_Elem = self.lista.__len__()
        if total_Elem > 0:
            estudiantes_mayorNota = SinglyLinkedList()
            notaMayor = self.lista.locate(0)
            for x in range(total_Elem):
                self.lista.locate(x)
                if self.lista.locate(x).nota > notaMayor.nota:
                    notaMayor = self.lista.locate(x)
            for y in range(total_Elem):
                if notaMayor.nota == self.lista.locate(y).nota:
                    estudiantes_mayorNota.append(self.lista.locate(y))
            return estudiantes_mayorNota
        else:
            return None

    def buscarCodigo(self, cod):
        for x in range(self.lista.__len__()):
            if self.lista.locate(x).codigo == cod:
                return self.lista.locate(x)
        return None


estudiantes = SinglyLinkedList()
