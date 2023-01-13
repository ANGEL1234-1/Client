# Client

Programa sencillo en Java que permite la comunicación con un servidor.

# Cómo usar

Abrir la consola de terminal, escribir ```java -jar Client.jar``` e introducir un nombre de usuario. Para desconectarse escribir ```\exit```

# Cómo funciona

Al lanzarse el programa crea un socket que trata de conectarse a la aplicación servidor (actualmente esto esta hardcoded para que se conecte al puerto ```54321``` de la IP ```192.168.4.8``` aunque la intención es cambiar esto en el futuro para permitir elegir a donde se quiere conectar) y pide al usuario un nombre, tras lo cual espera que el usuario escriba algo para enviar al resto de usuarios conectados. A su vez se lanza un hilo para "oir" los mensajes que se envían por el servidor.

# Special Thanks to

Mercedes por enseñarnos que se puede hacer esto y Stack Overflow por hacer el proceso de manejar los hilos más fácil.
