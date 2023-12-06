# FCEN Aulas • Endpoint Server

Acá está el código que maneja las solicitudes web hacia el servidor para la aplicación de `fcen-aulas`.
Una vez compilado, asume que existe un archivo `output/cache.txt` el cual devuelve si se le piden las aulas actuales.

> [!NOTE]
> Esta versión, aunque funcional, es una versión de prueba.
> El código está algo desprolijo, y no maneja la lectura del cache y
> las solicitudes con multithreading, por lo que está fuertemente sujeto
> a cambios.
En un futuro, debería enviar señales al servidor interno para reprocesar los datos.
