<div class="modal fade" id="agregarTornilloModal" tabindex="-1" aria-labelledby="agregarTornilloModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Tornillo</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="codigoSku">Codigo SKU</label>
                        <input type="text" class="form-control" name="codigoSku" required="">
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripcion</label>
                        <input type="text" class="form-control" name="descripcion" required="">
                    </div>
                    <div class="form-group">
                        <label for="pesoUnidad">Peso por Unidad</label>
                        <input type="number" class="form-control" name="pesoUnidad">
                    </div>
                    <div class="form-group">
                        <label for="precio">Valor del Tornillo</label>
                        <input type="currency" class="form-control" name="precio" required="">
                    </div>
                    <div class="form-group">
                        <label for="stock">Cantidad en Stock</label>
                        <input type="number" class="form-control" name="stock" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
