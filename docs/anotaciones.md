Puede ocurrir que Selenium quiera acceder a un elemento que todavia no se ha cargado, entonces el test falla.

Se pueden manejar las esperas. Hay explicitas e implicitas.

Selenium recomienda un tipo de espera. No combinados.

#Implicit waits: 
si el elemento no se encuentra de forma inmediata, le decimos que espere un cierto tiempo. Al terminar este tiempo, WebDriver hace una segunda consulta. Si este aun no ha cargado se lanza un "NoSuchElementException".
El tiempo por default es 0. No es la mas recomendada.

#Explicit waits: 
Un ejemplo es Thread.sleep(2000), pero no se recomienda usarlo.
Se usan las WebDriverWait y las ExpectedConditions. Estas realizan consultas cada 500mS. 

Fluent Waits: Permite establecer tiempo de espera.

*******Page Object Model (POM)************
Se refactorizara la clase MercuryTours_AutomatedTest

Cual es el inconveniente que tiene ?

Que cuando el sistema tenga cambios que afecte el codigo html, esto afecta a todos los tests que tienen que ver con esos campos. 
Con el POM se crea una capa donde se concentra en las clase Page los locators y los metodos que se ejecutan. De esta forma, ante cualquier cambio solo se actualiza la clase Page y los test cases siguen funcionando exitosamente.

******Base Page Object********
Tambien conocida como *SeleniumWrapper* o *UtilityClass*.

Nos permite aislar las clases Page de los comandos de Selenium, de forma tal que si se actualizan los comandos de Selenium, entonces solo modificariamos la clase Base. 

En resumen:
- La clase *Base Page Object* aisla el resto del codigo de los comandos de Selenium WD (Wrapper)
- Las clases *Page Objects* heredan de la clase Base y centralizan los localizadores y acciones de una pagina.
- Los tests usan las clases Page Objects.
********************************************