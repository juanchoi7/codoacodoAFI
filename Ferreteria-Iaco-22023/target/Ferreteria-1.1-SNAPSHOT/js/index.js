
const deleteModal = document.getElementById('deleteModal')
deleteModal.addEventListener('show.bs.modal', event => {
    // Button that triggered the modal
    const button = event.relatedTarget
    // Extract info from data-bs-* attributes
    const idtornillo = button.getAttribute('data-bs-idtornillo')
    const codigoSku = button.getAttribute('data-bs-codigoSku')
    const descripcion = button.getAttribute('data-bs-descripcion')
    const stock = button.getAttribute('data-bs-stock')

    const modalTitle = deleteModal.querySelector('.modal-title')
    const modalBody1 = deleteModal.querySelector(".modal-body input[name='codigoSku']")
    const modalBody2 = deleteModal.querySelector(".modal-body input[name='descripcion']")
    const modalBody3 = deleteModal.querySelector(".modal-body input[name='idtornillo']")

    modalTitle.textContent = `Borrado de producto: ${codigoSku}`
    modalBody1.value = codigoSku
    modalBody2.value = descripcion
    modalBody3.value = idtornillo

})



const updateStockModal = document.getElementById('updateStockModal')
updateStockModal.addEventListener('show.bs.modal', event => {
    // Button that triggered the modal
    const button = event.relatedTarget
    // Extract info from data-bs-* attributes
    const idtornillo = button.getAttribute('data-bs-idtornillo')
    const codigoSku = button.getAttribute('data-bs-codigoSku')
    const descripcion = button.getAttribute('data-bs-descripcion')
    const stock = button.getAttribute('data-bs-stock')

    const modalTitle = updateStockModal.querySelector('.modal-title')
    const modalBody1 = updateStockModal.querySelector(".modal-body input[name='codigoSku']")
    const modalBody2 = updateStockModal.querySelector(".modal-body input[name='descripcion']")
    const modalBody3 = updateStockModal.querySelector(".modal-body input[name='stock']")
    const modalBody4 = updateStockModal.querySelector(".modal-body input[name='idtornillo']")

    modalTitle.textContent = `Actualizaci&oacute; de stock: ${codigoSku}`
    modalBody1.value = codigoSku
    modalBody2.value = descripcion
    modalBody3.value = stock
    modalBody4.value = idtornillo

})