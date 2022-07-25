# Backend tabla maestra Brillantemente


Proyecto APi REST de brillantemente, aquí encontraras varios de los enpoints del aplicativo con su funcionamiento  .

## Tecnologias

- [JSP] - JSP
- [Java] - Java

## Instalacion

Clonar del repositorio
```sh
git clone https://github.com/cgrisales04/info_usuarios.git
```

## Servicios (Endpoints)

POST - Agregar usuarios
```sh
http://localhost:8383/employees/SrvlUsuarios
https://infousuarios.herokuapp.com/SrvlUsuarios
```

Body - Parametros
```sh
{
    "nombre": "",
    "apellido": "",
    "edad": "",
    "identificacion": "",
    "id_tipo_usuario_fk": ,
    "id_genero_fk": ,
    "id_tipo_identificacion_fk": 
}
```

PUT - Editar usuarios
```sh
http://localhost:8383/employees/SrvlUsuarios?id_usuario=1
https://infousuarios.herokuapp.com/SrvlUsuarios?id_usuario=1
```

Body - Parametros
```sh
{
    "nombre": "",
    "apellido": "",
    "edad": "",
    "identificacion": "",
    "id_tipo_usuario_fk": ,
    "id_genero_fk": ,
    "id_tipo_identificacion_fk": 
}
```

GET - Obtener un solo usuario
```sh
http://localhost:8383/employees/SrvlUsuarios?id_usuario=1
https://infousuarios.herokuapp.com/SrvlUsuarios?id_usuario=1
```

GET - Obtener todos los usuarios
```sh
http://localhost:8383/employees/SrvlUsuarios
https://infousuarios.herokuapp.com/SrvlUsuarios
```

DELETE - Eliminar usuarios
```sh
http://localhost:8383/employees/SrvlUsuarios?id_usuario=1
https://infousuarios.herokuapp.com/SrvlUsuarios?id_usuario=1
```


## Devs

Cristian Grisales Venitez - 
Yaider Cordoba Cordoba

[Java]: <https://www.java.com/es/>
[JSP]: <https://www.ibm.com/docs/es/i/7.3?topic=java-jsp-servlet-programming>