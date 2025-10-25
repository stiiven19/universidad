import sys
import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
import os
#from adt.lists.sll import SinglyLinkedList
from adt.trees.binary_search_tree import BinarySearchTree
from adt.trees.exceptions import DuplicateKeyException
from colegio_app.colegio import Estudiante
from adt.trees.traversal import  preorder,preorder_str


class SignalHandlers():
    def __init__(self, builder):
        self.ent_cod = builder.get_object("ent_cod")
        self.ent_nom = builder.get_object("ent_nom")
        self.ent_nota = builder.get_object("ent_nota")

        self.cbx_cod = builder.get_object("cbx_cod")

        self.buff_reporte = builder.get_object("buff_reporte")

        self.estudiantes = BinarySearchTree()

        self.dlg_append = builder.get_object("dlg_append")

        self.dlg_search = builder.get_object("dlg_search")
        self.rbt_terminal = builder.get_object("rbt_terminal")
        self.dlg_info = builder.get_object("dlg_info")
    def on_btn_ing_clicked(self, button):

        nuevo_estudiante = Estudiante(self.ent_cod.get_text(),
                                      self.ent_nom.get_text(),
                                      float(self.ent_nota.get_text()))
        try:
            self.estudiantes.append(nuevo_estudiante)
            self.dlg_append.set_property("text", "Estudiante agregado OK!")
            self.dlg_append.format_secondary_text(
                "Código: " + nuevo_estudiante.codigo +
                "\nNombre: " + nuevo_estudiante.nombre +
                "\nNota: " + str(nuevo_estudiante.nota)
            )
            self.cbx_cod.append_text(nuevo_estudiante.codigo)
            self.buff_reporte.set_text("")
        except DuplicateKeyException as e:
            self.dlg_append.set_property("text",
                                         e.args[0])
            #self.dlg_append.append_text("")
            self.dlg_append.format_secondary_text(" ")
        self.dlg_append.run()
        self.dlg_append.hide()

    def on_btn_bus_clicked(self, button):
        cod_est = self.cbx_cod.get_activate_text()
        if cod_est is not None:
            el_est = self.estudiantes.search(Estudiante(cod_est))
            if el_est is not None:
                info_est = ("El estudiantes de código " + str(el_est.codigo) +
                            " se llama " + str(el_est.nombre) + " y tiene nota: " + str(el_est.nota))
        self.dlg_search.set_property("text",
                                     info_est)
        self.dlg_search.run()
        self.dlg_search.hide()

    def on_btn_reporte_clicked(self, button):
        if self.rbt_terminal.get_active():
            print("\nListado de Estudiantes(Preorder):")
            print("==================================")
            preorder(self.estudiantes)
            self.dlg_info.set_property("text",
                                       "ATENCION: Ver la terminal para el"
                                       "reporte de estudiantes")
            self.dlg_info.run()
            self.dlg_info.hide()
        else:
            self.buff_reporte.set_text(preorder_str(self.estudiantes))
        #cad = "CODIGO         NOMBRE        NOTA\n"
        #cad += str(self.estudiantes)
        #self.buff_reporte.set_text(cad)


class AppPrincipal(Gtk.Application):

    def __init__(self, *arg, **kwargs):
        super().__init__(*arg, **kwargs)
        self.ventana = None

    def do_activate(self):
        if not self.ventana:
            builder = Gtk.Builder()
            #builder.add_from_file("ventana_estudiantes.glade")
            builder.add_from_file(os.path.join(os.path.dirname(__file__), "ventana_estudiantes.glade"))
            self.ventana = builder.get_object("main_window")
            self.add_window(self.ventana)
            builder.connect_signals(SignalHandlers(builder))
        self.ventana.show_all()


if __name__ == "__main__":
    app = AppPrincipal(application_id="adt.trees.binary_search_tree.colegio_glade")
    sys.exit(app.run(sys.argv))
