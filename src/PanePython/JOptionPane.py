from distutils import command
import tkinter as tk
import sys
from PIL import Image, ImageTk

ventana=tk.Tk()
ruta='src/PanePython/'
alto_ventana = 300
ancho_ventana = 520
fondoAux='#005566'
#99AABB
x_ventana = ventana.winfo_screenwidth() // 2 - ancho_ventana // 2
y_ventana = ventana.winfo_screenheight() // 2 - alto_ventana // 2



posicion = str(ancho_ventana) + "x" + str(alto_ventana) + "+" + str(x_ventana) + "+" + str(y_ventana)
ventana.geometry(posicion)
ventana.config(bg=fondoAux)
ventana.resizable(False, False)



textAux1=tk.StringVar()
textAux2=tk.StringVar()



def doSomething():
    variable=20
    print(variable)
    close_window()



ventana.protocol('WM_DELETE_WINDOW', doSomething)



variable=0



def close_window():
    ventana.destroy()



def replaceExceptions(strAux):
    strAux=strAux.replace('á','#u00e1')
    strAux=strAux.replace('é','#u00e9')
    strAux=strAux.replace('í','#u00ed')
    strAux=strAux.replace('ó','#u00f3')
    strAux=strAux.replace('ú','#u00fa')
    strAux=strAux.replace('Á','#u00c1')
    strAux=strAux.replace('É','#u00c9')
    strAux=strAux.replace('Í','#u00cd')
    strAux=strAux.replace('Ó','#u00d3')
    strAux=strAux.replace('Ú','#u00da')
    strAux=strAux.replace('ñ','#u00f1')
    strAux=strAux.replace('Ñ','#u00d1')
    strAux=strAux.replace(' ','_')
    return strAux



def Var0():
    variable=0
    print(variable)
    close_window()



def Var1():
    variable=1
    print(variable)
    close_window()



def Var2():
    variable=2
    print(variable)
    close_window()



def Var3():
    variable=3
    print(variable)
    close_window()



def Var5():
    variable=5
    print(variable)
    close_window()



def Var10():
    variable=10
    print(variable)
    close_window()



def getInfo():
    print(replaceExceptions(textAux1.get())+";"+replaceExceptions(textAux2.get()))
    close_window()

def PreguntasEntrada():
    ventana.title('Entrada')
    ventana.iconphoto(False, tk.PhotoImage(file=ruta+'Home.png'))



imagenZ=Image.open(ruta+'discord.jpg')
imagenZ.thumbnail((530,750), Image.ANTIALIAS)
tkimage = ImageTk.PhotoImage(imagenZ)
label=tk.Label(ventana, image=tkimage, width=520, height=300).place(x=0, y=0)

botonIR=tk.Button(ventana, text="Iniciar Reconocimiento",font=("Bahnschrift"),fg="black", command=Var0).place(x=20, y=230)
botonIF=tk.Button(ventana, text="Ir a Favoritos",font=("Bahnschrift"), fg="black", command=Var1).place(x=215, y=230)
botonB=tk.Button(ventana, text="Busqueda",fg="black", font=("Bahnschrift"), command=Var2).place(x=340, y=230)
botonC=tk.Button(ventana, text="Cerrar",fg="black", font=("Bahnschrift"), command=Var3).place(x=440, y=230)
ventana.mainloop()



def BotFavorito(aux):
    ventana.title('Bot-Favoritos')
    ventana.iconphoto(False, tk.PhotoImage(file=ruta+'favorite.png'))
    if(aux=='resume'):
        imagenZ=Image.open(ruta+'reproducir.png')
        imagenZ.thumbnail((250,250), Image.ANTIALIAS)
        tkimage = ImageTk.PhotoImage(imagenZ)
        botonPause=tk.Button(ventana, image=tkimage, width=150, height=150, bd=0,bg=fondoAux, activebackground=fondoAux,command=Var5).place(x=180, y=50)

    else:
        imagenZ=Image.open(ruta+'pause.png')
        imagenZ.thumbnail((250,250), Image.ANTIALIAS)
        tkimage = ImageTk.PhotoImage(imagenZ)
        botonPause=tk.Button(ventana, image=tkimage, width=150, height=150, bd=0,bg=fondoAux, activebackground=fondoAux,command=Var10).place(x=180, y=50)



ventana.title('BOT-Favorito')

botonIR=tk.Button(ventana, text="Siguiente",font=("Bahnschrift"),fg="black", command=Var0).place(x=20, y=230)
botonIF=tk.Button(ventana, text="Volver a la Entrada",font=("Bahnschrift"), fg="black", command=Var1).place(x=115, y=230)
botonAF=tk.Button(ventana, text="Eliminar Favorito",font=("Bahnschrift"), fg="black", command=Var2).place(x=282, y=230)
botonC=tk.Button(ventana, text="Cerrar",fg="black", font=("Bahnschrift"), command=Var3).place(x=435, y=230)
ventana.mainloop()




def BotEmotion(aux):

    ventana.iconphoto(False, tk.PhotoImage(file=ruta+'emotion.png'))



if(aux=='resume'):
    imagenZ=Image.open(ruta+'reproducir.png')
    imagenZ.thumbnail((250,250), Image.ANTIALIAS)
    tkimage = ImageTk.PhotoImage(imagenZ)
    botonPause=tk.Button(ventana, image=tkimage, width=150, height=150, bd=0,bg=fondoAux, activebackground=fondoAux,command=Var5).place(x=180, y=50)

else:
    imagenZ=Image.open(ruta+'pause.png')
    imagenZ.thumbnail((250,250), Image.ANTIALIAS)
    tkimage = ImageTk.PhotoImage(imagenZ)
    botonPause=tk.Button(ventana, image=tkimage, width=150, height=150, bd=0,bg=fondoAux, activebackground=fondoAux,command=Var10).place(x=180, y=50)

ventana.title('BOT-Emotion')
botonIR=tk.Button(ventana, text="Siguiente",font=("Bahnschrift"),fg="black", command=Var0).place(x=20, y=230)
botonIF=tk.Button(ventana, text="Volver a la Entrada",font=("Bahnschrift"), fg="black", command=Var1).place(x=115, y=230)
botonAF=tk.Button(ventana, text="Añadir a Favoritos",font=("Bahnschrift"), fg="black", command=Var2).place(x=282, y=230)
botonC=tk.Button(ventana, text="Cerrar",fg="black", font=("Bahnschrift"), command=Var3).place(x=440, y=230)
ventana.mainloop()



def MensajeWarning():

    ventana.iconphoto(False, tk.PhotoImage(file=ruta+'warning.png'))



imagenZ=Image.open(ruta+'SinMusic.png')
imagenZ.thumbnail((250,250), Image.ANTIALIAS)
tkimage = ImageTk.PhotoImage(imagenZ)
label=tk.Label(ventana, image=tkimage, width=250, height=250, bd=0,bg=fondoAux, activebackground=fondoAux).place(x=140, y=20)



ventana.title('Dato Curioso')
botonIF=tk.Button(ventana, text="Volver a la Entrada",font=("Bahnschrift"), fg="black", command=Var1).place(x=180, y=210)
ventana.mainloop()




def Busqueda():
    ventana.title('Busqueda')



imagenZ=Image.open(ruta+'buscar.png')
imagenZ.thumbnail((460,680), Image.ANTIALIAS)
tkimage = ImageTk.PhotoImage(imagenZ)
label=tk.Label(ventana, image=tkimage, width=520, height=300,bg=fondoAux).place(x=0, y=0)
#label1=tk.Label(ventana, text="Autor").place(x=60, y=230)
#label2=tk.Label(ventana, text="Canción").place(x=260, y=230)+



textAux1.set("Canción")
#entry1=tk.Entry(ventana, textvariable=textAux1).place(x=60, y=200)



entry1=tk.Entry(ventana, textvariable=textAux1,font=("Bahnschrift"))
entry1.place(x = 60, y = 200,width=200,height=30)



textAux2.set("Autor")
entry2=tk.Entry(ventana, textvariable=textAux2,font=("Bahnschrift"))
entry2.place(x=280, y=200,width=200,height=30)




botonBusq=tk.Button(ventana, text="Buscar",font=("Bahnschrift"),fg="black", command=getInfo).place(x=230, y=240)




ventana.mainloop()



if __name__ == "__main__":
    args = sys.argv
if(args[1] =='Entrada'):
    PreguntasEntrada()
elif(args[1]=='BotFavorito'):
    BotFavorito(args[2])
elif(args[1]=='BotEmotion'):
    BotEmotion(args[2])
elif(args[1]=='MensajeWarning'):
    MensajeWarning()
elif(args[1]=='Busqueda'):
    Busqueda()