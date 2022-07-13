<section id="actions" class="py-2 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <button type="button" class="btn btn-primary btn-block" 
                        data-bs-toggle="modal" 
                        data-bs-target="#agregarTornilloModal">
                    <i class="fas fa-plus"></i> Agregar Tornillo
                </button>

                <a href="${pageContext.request.contextPath}/servletControlador?accion=visualizar" 
                   class="btn btn-success btn-block">
                    Visualizar Activos
                </a>
                <a href="${pageContext.request.contextPath}/servletControlador?accion=visualizarEliminados" 
                   class="btn btn-secondary btn-block">
                    Visualizar Eliminados
                </a>
            </div>
        </div>
    </div>
</section>
