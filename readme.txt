*******************************************************
Readme de la Tarea Nº1 realizada para la asignatura ELO329.

Tarea 1: Bolas, Resortes y Puntos de Apoyo como Objetos de Software.

Integrantes: Oscar Tapia; Camilo Barra; Roberto Cifuentes. 
*******************************************************
Archivos que contiene:
Etapa1:
	Ball.java
	MyWorld.java
	PhysicsElement.java
	PhysicsLab.java
	Makefile

Etapa 2: 
	Ball.java
	Spring.java
	MyWorld.java
	PhysicsElement.java
	PhysicsLab.java
	Makefile

Etapa 3:
	SpringAttachable.java
	Ball.java
	Spring.java
	MyWorld.java
	PhysicsElement.java
	PhysicsLab.java
	Makefile

Etapa 4:
	SpringAttachable.java
	Ball.java
	Spring.java
	MyWorld.java
	PhysicsElement.java
	PhysicsLab.java
	Makefile

Etapa n+1:
	SpringAttachable.java
	Ball.java
	Spring.java
	MyWorld.java
	PhysicsElement.java
	PhysicsLab.java
	Makefile

*******************************************************
Instrucciones: Dentro del archivo el programa se encuentra separada en las Etapas correspondientes a la tarea, y dentro de cada Etapa se encuentran los archivos .java que poseen los códigos, y el Makefile que puede servir para la compilación y ejecución de la Etapa.
Dentro de cada Makefile estan descritos los parámetros de simulacion por defecto:

	<delta tiempo> = 0.1
	<tiempo total a simular> = 20
	<periodo de muestreo> = 0.2

Para la compilacion y ejecucion del programa dentro de cada etapa correspondiente, se puede realizar de dos formas

1- Desde terminal, ejecutar el Makefile con el comando
	
	$make run

La compilación y ejecuciónlos datos se realizarán de forma automática y se almacenarán en un archivo llamado "EtapaX.csv" siendo X la etapa correspondiente. Los parámetros de simulación serán los que están por defecto.

2- Realizar la compilación manualmente, desde terminal, dirigirse a la carpeta donde se encuentra la etapa correspondiente e ingresar los siguentes codigos:

	$javac PhysicsElement.java
	$java PhysicsElement <delta tiempo> <tiempo total a simular> <periodo de muestreo> > EtapaX.csv

El primer código corresponde a la compilación de la Etapa.
El segundo código corresponde a la ejecucion de la Etapa y almacenamiento de los resultados en el archivo "EtapaX.csv". Aquí los parámetros pueden ser ingresados al gusto de quien desea ejecutar el programa.

Una vez ejecutado el código y creado el archivo.csv, dentro se encuentra una tabla de datos en donde se apresia la posicion de cada objeto dentro del mundo creado en funcion del tiempo. 
