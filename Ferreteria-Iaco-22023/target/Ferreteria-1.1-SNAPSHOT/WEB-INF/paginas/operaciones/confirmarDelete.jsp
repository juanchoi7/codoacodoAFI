<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-warning text-white">
                <h5 class="modal-title" id="deleteModalLabel">New message</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar" method="POST" class="was-validated">

                    <div class="mb-3">
                        <label for="codigoSku">Codigo SKU</label>
                        <input type="text" class="form-control" name="codigoSku" disabled>                        
                    </div>
                    <div class="mb-3">
                        <label for="codigoSku">Descripci&oacute;n</label>
                        <input type="text" class="form-control" name="descripcion" disabled>                        
                        <input type="hidden" class="form-control" name="idtornillo" value="" >  
                    </div>                 

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" value="Eliminar" name="btnAccion" class="btn btn-danger">Borrar Producto</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
