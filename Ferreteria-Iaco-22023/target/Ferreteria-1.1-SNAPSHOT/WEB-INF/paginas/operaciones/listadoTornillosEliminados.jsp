<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="tornillos">
    <div class="container">
        <div class="row">

            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Tornillos ELIMINADOS</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>SKU</th>
                                <th>Descripcion</th>
                                <th>Peso (grs)</th>
                                <th>Precio</th>
                                <th>Stock</th>
                                <th class="text-center">Accion</th>
                            </tr>
                        </thead>
                        <tbody>


                            <c:forEach var="tornillo" items="${tornillos}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${tornillo.codigoSku}</td>
                                    <td>${tornillo.descripcion}</td>
                                    <td class="text-center">${tornillo.pesoUnidad}</td>
                                    <td><fmt:formatNumber value="${tornillo.precio}" type="currency"/></td>
                                    <td>${tornillo.stock}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=reactivar&idtornillo=${tornillo.idtornillo}" class="btn btn-success">
                                            <i class="fa fa-refresh" aria-hidden="true"></i>
                                            Reactivar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


            <div class="col-md-4">
                <div class="card text-center  text-white mb-3">
            
                </div>

                <div class="card text-center  text-white mb-3">
                   
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarTornillo.jsp"/>
