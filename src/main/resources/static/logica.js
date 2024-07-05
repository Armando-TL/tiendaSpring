// logica.js
function updateButtonText() {
    const nombre = document.getElementById('nombre').value.trim();
    const precio = document.getElementById('precio').value.trim();
    const unidades = document.getElementById('unidades').value.trim();
    const id = document.getElementById('id').value.trim();
    const submitButton = document.getElementById('submitButton');

    if (id && (!nombre && !precio && !unidades)) {
        submitButton.textContent = 'Eliminar Producto';
        submitButton.form.action = '/eliminar';
        submitButton.style.backgroundColor = '#FF6347';
    } else if (!id && (nombre || precio || unidades)) {
        submitButton.textContent = 'Crear Producto';
        submitButton.form.action = '/crear';
        submitButton.style.backgroundColor = '#4CAF50';
    } else if (id && nombre && precio && unidades) {
        submitButton.textContent = 'Modificar Producto';
        submitButton.form.action = '/modificar';
        submitButton.style.backgroundColor = '#FFD700';
    } else {
        submitButton.textContent = 'Crear Producto';
        submitButton.form.action = '/crear';
        submitButton.style.backgroundColor = '#4CAF50';
    }
}

document.getElementById('nombre').addEventListener('input', updateButtonText);
document.getElementById('precio').addEventListener('input', updateButtonText);
document.getElementById('unidades').addEventListener('input', updateButtonText);
document.getElementById('id').addEventListener('input', updateButtonText);

window.onload = function () {
    document.getElementById('productoForm').reset();
};
