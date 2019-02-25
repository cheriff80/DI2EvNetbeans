#Instalador de la aplicacion de Netbeans de Carreras

# nombre del instalador
outfile "Avituallamiento.exe"

# Necesario para borrar el acceso directo en Windows 7
RequestExecutionLevel user

# Pantallas que hay que mostrar del instalador

Page directory
Page instfiles

#Ruta por defecto
InstallDir $PROGRAMFILES\Avituallamiento

#Cambiar el idioma
!include "MUI.nsh"
!insertmacro MUI_LANGUAGE "Spanish"
 
# siempre tiene que haber una seccion
section

	# Definimos la ruta en la que vamos a escribir el archivo
	setOutPath $INSTDIR

	# Se crea un  nuevo acceso directo en el menu de inicio. 
   	 createShortCut "$SMPROGRAMS\Avituallamiento.lnk" "$INSTDIR/Avituallamiento.exe"

	#Creamos ShortCut en el escritorio
	createShortCut "$DESKTOP\Avituallamiento.lnk" "$INSTDIR/Avituallamiento.exe"
	 
	# Escribimos el archivo en la ruta de salida
	
	File Avituallamiento.exe
	
	# definimos el desinstalador y su nombre
	writeUninstaller $INSTDIR\uninstaller.exe

	# Creamos un acceso directo apuntando al desinstalador
   	 createShortCut "$SMPROGRAMS\desinstalar.lnk" "$INSTDIR\uninstall.exe"
 
 
sectionEnd

# Creamos una seccion para definir el comportamiento del desinstalador
# siempre se va a llamar uninstall
section "Uninstall"
	#Delete Files 
  	RMDir /r "$INSTDIR\*.*"    
 
	#Remove the installation directory
  	RMDir "$INSTDIR"

	#Borramos el shortCut de desisntalacion 
	delete "$SMPROGRAMS\desinstalar.lnk"
	delete	"$DESKTOP\Avituallamiento.lnk"
	 
	# borramos el archivo que habiamos instalado
	delete "$INSTDIR\Avituallamiento.exe"
	 
	# Borramos el desinstalador
	delete "$INSTDIR\uninstaller.exe"

 
sectionEnd