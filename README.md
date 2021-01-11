# productor_consumidor_sin_monitor

Trabajo Practico de la materia Programacion Concurrente

ENUNCIADO
En un buffer cuya capacidad son 10 lugares, acceden múltiples productores y dos 
consumidores. Este buffer tiene pura pérdida, es decir que si está lleno, el productor 
descarta los datos.
Cada consumidor puede extraer solo de a un dato y demora un tiempo aleatorio entre alfa y 
beta milisegundos para procesar el dato.
Extra: Se requiere realizar un log cada 2 segundos, con el objetivo de realizar una 
estadística del uso del buffer y de los estados de los consumidores.
El log debe registrar: 
- Cantidad de lugares ocupados del buffer.
- Estado de cada consumidor (ocupado consumiendo, o disponible).



En el trabajo se IMPLEMENTO:

a) primitivas de concurrencia, haciendo uso del metodo synchronize() sobre los metodos del  objeto buffer, gestionando asi el acceso unitario sobre el recurso compartido, evitando asi incongruencia en los registros.

b) uso de inferfaz Runnable para implementacion de los hilos que modelan el comportamiento de los productores y los consumidores, metodos start() y run().

c) primitiva de sincronizacion de hilos, metodo join()


Se adjunta immagen de DIAGRAMAS de Clase y de Secuencia (muestre la interacción de solo dos 
productores que quieran acceder al buffer, suponiendo que los dos consumidores 
están disponibles y quieren consumir)
