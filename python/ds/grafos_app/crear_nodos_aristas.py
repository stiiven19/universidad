import sys
import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk

#from adt.lists.sll import SinglyLinkedList
class SignalHandlers():
    def __init__(self, builder):
        self.entryCod = builder.get_object("entryCod")
        self.EntryName = builder.get_object("EntryName")
        self.tree = builder.get_object("tree")

        self.tablas = builder.get_object("tablas")
        self.dlg = builder.get_object("dlg")
        self.dlg2 = builder.get_object("dlg2")
        self.col3 = builder.get_object("col3")
    def btn_cod_clicked_cb(self,boton):
        #print("entry: "+self.entryCod.get_text())
        #print("len: "+str(len(self.entryCod.get_text())))
        if len(self.entryCod.get_text())<2 or len(self.EntryName.get_text())<2:
            self.dlg.run()
            self.dlg.hide()
            return
        try:
            int(self.entryCod.get_text())
        except ValueError :
            self.dlg2.run()
            self.dlg2.hide()
            self.entryCod.set_text("")
            return
        #self.tablas.append([123,"steven"])
        #self.tablas.append([345,"pedro"])
        #self.tablas.append([567,"maria"])
        if len(self.entryCod.get_text())>2:
            self.tablas.append([int(self.entryCod.get_text()),self.EntryName.get_text(),True])

    def on_btn_name_clicked(self,boton):
        if len(self.entryCod.get_text())<2 or len(self.EntryName.get_text())<2:
            self.dlg.run()
            self.dlg.hide()
            return
        try:
            int(self.entryCod.get_text())
        except ValueError :
            self.dlg2.run()
            self.dlg2.hide()
            self.entryCod.set_text("")
            return
        #self.tablas.append([123,"steven"])
        #self.tablas.append([345,"pedro"])
        #self.tablas.append([567,"maria"])
        if len(self.entryCod.get_text())>2:
            self.tablas.append([int(self.entryCod.get_text()),self.EntryName.get_text(),False])
    def on_col3_clicked(self,col,path):
        print("col3")
    def on(self, row,path,ult):
        pass
        #print("row")
    def on_togle_toggled(self,widget,path):
        #print(widget[0])
        #print(widget.get_activatable())
        """if widget.get_active():
            widget.set_active(False)
            print("falso")
        else:
            widget.set_active(True)
            print("verdad")"""
        print(path)
        #self.tablas[path][2] = not self.tablas[path][2]
        #print(self.col3.get_cell_renderers())
        wid = Gtk.CellRendererToggle()
        wid.set_active(True)
        selected_path = Gtk.TreePath(path)
        #print(len(self.tablas))
        print(selected_path)
        wid
        #print(self.tablas[1][2])
        for row in self.tablas:
            print(str(row[0])+" "+str(row[1])+" "+str(row[2]))
            #print((row.path == selected_path))
            print(type(row[2]))
            row[2] = (row.path == selected_path)




class AppPrincipal(Gtk.Application):

    def __init__(self, *arg, **kwargs):
        super().__init__(*arg, **kwargs)
        self.ventana = None

    def do_activate(self):
        if not self.ventana:
            builder = Gtk.Builder()
            builder.add_from_file("s.glade")
            self.ventana = builder.get_object("main_window")
            self.add_window(self.ventana)
            builder.connect_signals(SignalHandlers(builder))
        self.ventana.show_all()


if __name__ == "__main__":
    app = AppPrincipal(application_id="123")
    sys.exit(app.run(sys.argv))
