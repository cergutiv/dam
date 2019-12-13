# dam
Adivina una fecha del año actual en el menor tiempo posible, para conseguir la mayor cantidad de “RM” (Rappel Monedas ).
OPERATIVA: 
• El juego comienza solicitando al usuario su Nick (apodo o alias). Requisitos: 
 ✓ Sin espacios. ✓ Primer carácter no puede ser un nº. ✓ Signos de puntuación permitidos: punto (.), coma(,), _, @ y #. 
 
• A continuación, se generará la fecha a adivinar aleatoriamente, con el formato dia/mes/año (dd/mm/aaaa).  
 El rango de generación de la fecha será [1/1/año actual -31/12/año actual].  
 
• A partir de entonces, el usuario realizará intentos de adivinar esa fecha, realizando entradas desde el teclado con el mismo formato dia/mes/año (dd/mm/aaaa). 
 
• Si el usuario acierta la fecha: 
 ✓ Se le mostrará el tiempo que ha tardado en acertar la fecha (en horas, minutos,  segundos (hh:mm:ss) ✓ Ganará un nº de  (“Rappel Monedas”), y se le mostrará un mensaje de acuerdo al siguiente ranking: Tiempo invertido Mensaje  < 1 minuto, Rappel a tu lado no es nadie 100 Entre 1 min. y 15 min. Eres bueno... y lo sabes!! 50 Entre 15 min. y 30 min. Dedícate a otra cosa 25 Mas de 30 min. ZZZzzzzzzzzz…… 5 
 
• Si no acierta: ✓ Puede ocurrir que haya acertado sólo un parte de la fecha, en cuyo caso, se le informará con un mensaje del tipo “Has acertado el mes”. ✓ Además, se le darán las pistas: - Si la fecha a adivinar es anterior o posterior a la que él ha propuesto. - Si la fecha propuesta, está más-menos 15 días de la fecha a adivinar se le mostrará el mensaje "caliente caliente....". 
 
A TENER EN CUENTA: 
• El código estará organizado en 2 clases, una con toda la operativa del juego y otra con la interfaz del usuario.  
 Es decir, el usuario interactuará (consola) a través de una clase, que será la que llame a los métodos correspondientes de la otra clase con la operativa del juego. 
 
• Debes mostrar mensajes de error al usuario indicado todas las situaciones anómalas que se presenten.  
 
• Cualquier mensaje que se muestre al usuario estará personalizado con su Nick. 
