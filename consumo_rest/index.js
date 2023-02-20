let baseUrl = "http://localhost:8080";
let productos = [];

function ObtenerProductos() { 
    fetch(baseUrl+'/productos/all').then(res=>{
        res.json().then(json=>{
            productos = json
            ImprimirProductos()
        })
    })
 }

function ImprimirProductos() { 
    let contenedor = document.getElementById("cuerpoTabla")
    contenedor.innerHTML = "";

    productos.forEach(producto => {
        contenedor.innerHTML += MapearProductos(producto)
    })
}

function MapearProductos(producto) {
    return `<tr>
    <td><button class="btn btn-danger btn-sm " onclick="EliminarProducto(${producto.id})">Eliminar</button>
    <button class="btn btn-warning btn-sm " onclick="LLenarCampos(${producto.id})">Actualizar</button></td>
    <td>${producto.id}</td>
    <td>${producto.nombre}</td>
    <td>${producto.precio}</td>
    <td>${producto.categoria}</td>
    <td>${producto.foto}</td>
    </tr>`
}

function EliminarProducto(id) {
    fetch(baseUrl+'/producto/' + id, {method:"Delete"}).then(res=>{
        console.log(res);
        ObtenerProductos();
    })
}

function GuardarProducto(){
    let data ={
        nombre: document.getElementById("nombre").value,
        precio: document.getElementById("precio").value,
        categoria: document.getElementById("categoria").value,
        foto: document.getElementById("foto").value
    }

    fetch(baseUrl + "/producto",{
        method:"POST",
        body: JSON.stringify(data),
        headers:{
            "Content-type":'application/json; charset=UTF8'
        }
    }).then(res=>{
        console.log(res);
    })
    ObtenerProductos();
}

function LLenarCampos(pid) {
    let producto = productos.filter(p => {return p.id == pid })[0]
    document.getElementById("nombre").value = producto.nombre,
    document.getElementById("precio").value = producto.precio,
    document.getElementById("categoria").value = producto.categoria,
    document.getElementById("foto").value = producto.foto,
    document.getElementById("productoId").value = producto.id
}

function ActualizarProducto(){
    let data ={
        nombre: document.getElementById("nombre").value,
        precio: document.getElementById("precio").value,
        categoria: document.getElementById("categoria").value,
        foto: document.getElementById("foto").value,
        id: document.getElementById("productoId").value
    }
    fetch(baseUrl + "/producto",{
        method:"PUT",
        body: JSON.stringify(data),
        headers:{
            "Content-type":'application/json; charset=UTF8'
        }
    }).then(res=>{
        console.log(res);
    })
    ObtenerProductos();
}