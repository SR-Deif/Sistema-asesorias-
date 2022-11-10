const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
	nomCliente:/^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	apeCliente:/^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	direccion:/^[a-zA-ZÀ-ÿ0-9_.+-\s+#]{1,100}$/, // Letras, numeros, guion y guion_bajo
	detalle:/^[a-zA-ZÀ-ÿ0-9_.+-\s+#]{1,100}$/, // Letras, numeros, guion y guion_bajo
	correoCliente:/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	numCliente:/^\d{7,10}$/ // 7 a 14 numeros.
	// descripcion: /^[a-zA-ZÀ-ÿ\s]{1,100}$/
}

const campos = {
	nomCliente: false,
	apeCliente: false,
	direccion: false,
	detalle: false,
	correoCliente: false,
	numCliente: false
	// descripcion: false
}

const validarFormuario = (e)  =>{
	console.log('se ejecuto');
	 switch (e.target.name){
		case "nomCliente":
			validarCampo(expresiones.nomCliente, e.target, 'nomCliente');
			console.log('funciona')
		break;
		case "apeCliente":
			validarCampo(expresiones.apeCliente, e.target, 'apeCliente');
			console.log('funciona2')
		break;
		case "direccion":
			validarCampo(expresiones.direccion, e.target, 'direccion');
			console.log('funciona3')
		break;
		case "detalle":
			validarCampo(expresiones.detalle, e.target, 'detalle');
			console.log('funciona4')
		break;
		case "correoCliente":
			validarCampo(expresiones.correoCliente, e.target, 'correoCliente');
			console.log('funciona5')
		break;
		case "numCliente":
			validarCampo(expresiones.numCliente, e.target, 'numCliente');
			console.log('funciona6')
		break;
		// case "descripcion":
		// 	validarCampo(expresiones.descripcion, e.target, 'descripcion');
		// break;

	 }
}

//Validación por valores
const validarCampo =(expresiones, input, campo) => {
if(expresiones.test(input.value)){
	document.getElementById(`${campo}`).classList.remove('incorrecto');
	document.getElementById(`${campo}`).classList.add('correcto');
	document.querySelector(`#${campo} i`).classList.add('fa-circle-check');
	document.querySelector(`#${campo} i`).classList.remove('fa-circle-xmark');
	document.querySelector(`#${campo} .formulario-input-error`).classList.remove('formulario-input-error-activo');
	campos[campo] = true;
}else{
	document.getElementById(`${campo}`).classList.add('incorrecto');
	document.getElementById(`${campo}`).classList.remove('correcto');
	document.querySelector(`#${campo} i`).classList.add('fa-circle-xmark');
	document.querySelector(`#${campo} i`).classList.remove('fa-circle-check');
	document.querySelector(`#${campo} .formulario-input-error`).classList.add('formulario-input-error-activo');
	campos[campo] = false;
}
}
//validación inputs
inputs.forEach((input) =>{
    input.addEventListener('keyup', validarFormuario);
	input.addEventListener('blur', validarFormuario);
});

//Validación de enviar
formulario.addEventListener('submit', (e) => {
    e.preventDefault();

	//validar terminos y condiciones
	const terminos = document.getElementById('terminos');

	//validar que todos los campos sean verdaderos
	if(campos.nomCliente && campos.apeCliente && campos.direccion && campos.detalle && campos.numDoc && campos.correoCliente  &&  terminos){
		formulario.reset();

		document.getElementById('formulario-mensaje-correcto').classList.add('formulario-mensaje-correcto-activo');
		setTimeout(() =>{
			document.getElementById('formulario-mensaje-correcto').classList.remove('formulario-mensaje-correcto-activo');
		}, 5000 );

		document.querySelectorAll('correcto').forEach((icono)=>{
			icono.classList.remove('correcto');
		});
	} else{
		document.getElementById('formulario-mensaje').classList.add('formulario-mensaje-activo');
	}
});