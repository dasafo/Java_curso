<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<H1 style="text-align: center;">Insertar Registros</H1>

<form name="form1" method="get" action="ControladorProductos"> <!-- aqui le decimos que lo mande a ControladorProductos -->
<input type="hidden" name="instruccion" value="insertarBBDD"> <!-- creamos un campo oculto que también será enviado y sirve para manipular lo que enviamos(usando condicionales) -->

<table width="50%" border="0">
 
  <tr>
   <td width="27%">Código de Artículo</td>
   <td width="73%"><label for="cArt"></label>
   <input type="text" name="cArt" id="cArt"></td>
  </tr>
 
  <tr>
   <td>Sección</td>
   <td><label for="seccion"></label>
   <input type="text" name="seccion" id="seccion"></td>
  </tr>
 
  <tr>
   <td>Nombre Artículo</td>
   <td><label for="nArt"></label>
   <input type="text" name="nArt" id="nArt"></td>
  </tr>
 
  <tr>
   <td>Precio</td>
   <td><label for="precio"></label>
   <input type="text" name="precio" id="precio"></td>
  </tr>
 
  <tr>
   <td>Fecha</td>
   <td><label for="fecha"></label>
   <input type="text" name="fecha" id="fecha"></td>
  </tr>
 
  <tr>
   <td>Importado</td>
   <td><label for="importado"></label>
   <input type="text" name="importado" id="importado"></td>
  </tr>
 
  <tr>
   <td>País de Origen</td>
   <td><label for="pOrig"></label>
   <input type="text" name="pOrig" id="pOrig"></td>
  </tr>
 
  <tr>
   <td><input type="submit" name="envio" id="envio" value="Enviar"/></td>
   <td><input type="reset" name="borrar" id="borrar" value="Restablecer" /></td>
  </tr>
  
 
</table>

</form>
</body>
</html>