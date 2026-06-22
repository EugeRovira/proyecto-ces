    
Listado de funcionalidades detectadas:


    Funcionalidades en el Home de la página (sin realizar Login):

1-	Iniciar sesión.

Permite iniciar sesión con datos previamente registrados (datos de administrador).

2-	Registrarse.

Permite registrarse con datos nuevos.

3-	Reiniciar contraseña.

Permite recuperar la contraseña de un usuario previamente registrado.

    Funcionalidades dentro de Iniciar Sesión:
1-	Iniciar sesión (luego de completar los datos).

Permite iniciar sesión con datos previamente registrados.
- En este caso: Iniciar sesión como Administrador:
     email: yaniscorrea@gmail.com contraseña: 12345

2-	Olvidé mi contraseña.
     
Permite recuperar la contraseña de un usuario previamente registrado.

3-	Crear cuenta administrador.

Permite crear una cuenta con datos nuevos con un perfil de Administrador.

4-	Volver atrás.
     Vuelve a la página anterior.

    Funcionalidades dentro de Registrarse:

1- Registrarse (luego de completar los datos).
     
Permite registrarse con datos nuevos.

2-	Olvidé mi contraseña.
     
Permite recuperar la contraseña de un usuario previamente registrado.

3-	Ya tengo cuenta.
     
Permite iniciar sesión con datos previamente registrados.

4-	Volver atrás.
     
Vuelve a la página anterior.

    Funcionalidades dentro de Reiniciar contraseña:

1-	Reiniciar contraseña (luego de completar los datos).
     
Permite recuperar la contraseña de un usuario previamente registrado.

2-	Crear cuenta.
     
Permite crear una cuenta nueva con datos no registrados anteriormente.

3-	Ya tengo cuenta.
     
Permite iniciar sesión con datos previamente registrados.

4-	Volver atrás.
     
Vuelve a la página anterior.

    Home de la página (realizado el Login):

1-	Ir al perfil.

Te lleva directamente al perfil del usuario administrador logueado y habilita realizar cambios de información personal.

2-	Cerrar sesión.

Permite cerrar la sesión del usuario actualmente logueado.

3-	Crear Usuario.
Permite crear un nuevo usuario con datos no registrados anteriormente.
- En este caso: Iniciar sesión como Administrador:
     email: juanrocca222@hotmail.com contraseña: 123456

4-	Reiniciar contraseña.
     
Permite recuperar la contraseña de un usuario previamente registrado.

5-	Ver usuarios.
     
Permite visualizar a todos los usuarios existentes.
     
    Funcionalidades dentro de Crear usuario:
     
1-	Crear usuario (luego de completar los datos).
     
Permite crear nuevo usuario con datos no registrados anteriormente.

2-	Volver atrás.
     
Vuelve a la página anterior.
     
    Funcionalidades dentro de Reiniciar contraseña:

1-	Reiniciar contraseña (luego de completar los datos).
     
Permite recuperar la contraseña de un usuario previamente registrado.

2-	Crear cuenta.
     
Permite crear una cuenta nueva con datos no registrados anteriormente.
     
3-	Ya tengo cuenta.
     
Permite iniciar sesión con datos previamente registrados.
     
4-	Volver atrás.
     
Vuelve a la página anterior.
     
    Funcionalidades dentro de Ver Usuarios:
     
1-	Eliminar usuario.
     
Permite eliminar un usuario previamente registrado

                         DIAGRAMA DE CLASES UML
------------------------------------------------
Usuario
------------------------------------------------
- nombre : String
- apellido : String
- edad : int
- pais : String
- email : String
- clave : String
------------------------------------------------
+ Usuario()
+ Usuario(nombre, apellido, edad, pais, email, clave)

+ getNombre() : String
+ setNombre(nombre : String) : void

+ getApellido() : String
+ setApellido(apellido : String) : void

+ getEdad() : int
+ setEdad(edad : int) : void

+ getPais() : String
+ setPais(pais : String) : void

+ getEmail() : String
+ setEmail(email : String) : void

+ getClave() : String
+ setClave(clave : String) : void
------------------------------------------------




------------------------------------------------
Admin
------------------------------------------------
- nivelAcceso : String
------------------------------------------------
+ Admin()
+ Admin(nombre, apellido, edad, pais,
  email, clave, nivelAcceso)

+ getNivelAcceso() : String
+ setNivelAcceso(nivelAcceso : String) : void

------------------------------------------------

Admin ─────────▷ Usuario



------------------------------------------------
Tester
------------------------------------------------
- tipoPrueba : String
------------------------------------------------
+ Tester()
+ Tester(nombre, apellido, edad, pais,
  email, clave, tipoPrueba)

+ getTipoPrueba() : String
+ setTipoPrueba(tipoPrueba : String) : void
-------------------------------------------------

Tester ─────────▷ Usuario



------------------------------------------------
SistemaUsuarios
------------------------------------------------
- usuarios : Usuario[]
- cantidad : int
------------------------------------------------
+ SistemaUsuarios()

+ agregarUsuario(usuario : Usuario) : void

+ login(email : String,
  clave : String) : boolean

+ usuarioExiste(email : String) : boolean

+ existeAdministrador() : boolean

+ getUsuarios() : Usuario[]
--------------------------------------------------

SistemaUsuarios 1 ─────── 0..* Usuario


![img.png](img.png)