<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<H1 style="text-align: center;">Actualizar Producto</H1>

<form name="form1" method="get" action="ControladorProductos"> <!-- aqui le decimos que lo mande a ControladorProductos -->
<input type="hidden" name="instruccion" value="actualizarBBDD"> <!-- creamos un campo oculto que también será enviado y sirve para manipular lo que enviamos(usando condicionales) -->
<input type="hidden" name="cArt" value="${ProductoActualizar.cArt}"> <!-- creamos un campo oculto para que también le envie el Codido Articulo sin que el usuario lo vea, es nuestra referencia para SQL-->

<table width="50%" border="0">
 
 <!-- Ocultamos Cósdigo Artículo porque no queremos que se pueda cambiar, es nuestro numero de referencia -->
 <!--   <tr>
   <td width="27%">Código de Artículo</td>
   <td width="73%"><label for="cArt"></label>
   <input type="text" name="cArt" id="cArt"></td>
  </tr> -->

 
  <tr>
   <td>Sección</td>
   <td><label for="seccion"></label>
   <input type="text" name="seccion" id="seccion" value="${ProductoActualizar.seccion}"></td>
  </tr>
 
  <tr>
   <td>Nombre Artículo</td>
   <td><label for="nArt"></label>
   <input type="text" name="nArt" id="nArt" value="${ProductoActualizar.nArt}"></td>
  </tr>
 
  <tr>
   <td>Precio</td>
   <td><label for="precio"></label>
   <input type="text" name="precio" id="precio" value="${ProductoActualizar.precio}"></td>
  </tr>
 
  <tr>
   <td>Fecha</td>
   <td><label for="fecha"></label>
   <input type="text" name="fecha" id="fecha" value="${ProductoActualizar.fecha}"></td>
  </tr>
 
  <tr>
   <td>Importado</td>
   <td><label for="importado"></label>
   <input type="text" name="importado" id="importado" value="${ProductoActualizar.importado}"></td>
  </tr>
 
  <tr>
   <td>País de Origen</td>
   <td><label for="pOrig"></label>
   <input type="text" name="pOrig" id="pOrig" value="${ProductoActualizar.pOrig}"></td>
  </tr>
 
  <tr>
   <td><input type="submit" name="envio" id="envio" value="Actualizar"/></td>
   <td><input type="reset" name="borrar" id="borrar" value="Restablecer" /></td>
  </tr>
  
 
</table>

</form>
</body>
</html>