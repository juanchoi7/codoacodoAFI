<div class="modal fade" id="updateStockModal" tabindex="-1" aria-labelledby="updateStockModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Actualizaci&oacute;n de Stock</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=actualizarStock" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="codigoSku">Codigo SKU</label>
                        <input type="text" class="form-control" name="codigoSku" disabled>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripcion</label>
                        <input type="text" class="form-control" name="descripcion" disabled>
                    </div>

                    <div class="form-group">
                        <label for="stock">Cantidad en Stock</label>
                        <input type="number" class="form-control" name="stock" required="">
                        <input type="hidden" class="form-control" name="idtornillo" value="" >
                    </div>
                </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" value="actualizarStock" name="btnAccion" class="btn btn-primary">Actualizar Stock</button>
                    </div>
            </form>
        </div>
    </div>
</div>
