<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ferreteria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>

        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar" method="POST" class="was-validated">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="codigoSku">Codigo SKU</label>
                            <input type="text" class="form-control" name="codigoSku" required="" value="${tornillo.codigoSku}">
                        </div>
                        <div class="form-group">
                            <label for="descripcion">Descripcion</label>
                            <input type="text" class="form-control" name="descripcion" required="" value="${tornillo.descripcion}">
                        </div>
                        <div class="form-group">
                            <label for="pesoUnidad">Peso por Unidad</label>
                            <input type="number" class="form-control" name="pesoUnidad"  value="${tornillo.pesoUnidad}">
                        </div>
                        <div class="form-group">
                            <label for="precio">Valor del Tornillo</label>
                            <input type="currency" class="form-control" name="precio" required="" value="${tornillo.precio}">
                        </div>
                        <div class="form-group">
                            <label for="stock">Cantidad en Stock</label>
                            <input type="number" class="form-control" name="stock" required="" value="${tornillo.stock}">
                            <input type="hidden" class="form-control" name="idtornillo" value="${tornillo.idtornillo}">
                        </div>
                    </div>

                        
                    <div class="modal-footer">
                        <table>
                            <tr>
                                <td>
                                    <button class="btn btn-primary" type="submit" value="Modificar" name="btnAccion">Guardar</button>
                                </td>
                                <td>
                                    <button class="btn btn-secondary" type="submit" value="Cancelar" name="btnAccion">Cancelar</button>
                                </td>
                                <td>
                                    <button class="btn btn-danger" type="submit" value="Eliminar" name="btnAccion">Eliminar</button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </form>
            </div>
        </div>

        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
