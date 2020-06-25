$(document).ready(function() {
	listarProducto();
	listarCat(0)
	limpiar();
	$("#cant").numeric();
});

$("#boton").click(
		function() {
			alert(3);
			var idescuela = $("#escuela").val();
			var apellnombres = $("#apellnombres").val();
			var correo = $("#correo").val();
			var telefono = $("#telefono").val();
			var id = $("#id").val();
			alert(" EL id=   " + id);
			if (id == 0) {
				$.post("PruebaController", {
					idescuela : idescuela,
					correo : correo,
					apellnombres : apellnombres,
					telefono : telefono,
					opc : 3
				}).done(function(data) {
					limpiar();
					listarCat(0)
					listarProducto();
				});
				alert("se acaba de listar o no?  ?");
			} else {
				bootbox.confirm("Desea Modificar?", function(result) {
					if (result) {
						bootbox.alert("Registro Modificado Correctamente...!",
								function() {
							$.post("PruebaController", {
								idAl : id,
								idEs : idescuela,
								correo : correo,
								apellnombres : apellnombres,
								telefono : telefono,
								
								opc : 6
							}).done(function(data) {
								$("#id").val(0);
								limpiar();
								listarCat(0)
								listarProducto();
							});
						});
					} else {

						bootbox.alert("El registro no se Modifico...!");
						limpiar();
						listarCat(0)
						listarProducto();
					}
				});
			}
		});

function listarCat(x) {
	alert(1);
	var i, c = 1;
	$("#escuela")
			.empty()
			.append(
					'<option selected="selected" value="test">Seleccionar Escuela</option>')
	$.get("PruebaController", {
		opc : "1"
	}, function(data) {
		alert(data);
		var d = JSON.parse(data);
		for (i = 0; i < d.length; i++) {
			if (x == d[i].idescuela) {
				$("#escuela").append(
						"<option selected='selected' value='" + d[i].idescuela
								+ "'>" + d[i].nombrecat + "</option>");
			} else {
				$("#escuela").append(
						"<option value='" + d[i].idescuela + "'>"
								+ d[i].nombrecat + "</option>");
			}
		}
	});
}

function listarProducto() {
	var i, c = 1;
	$
			.get(
					"PruebaController",
					{
						opc : "2"
					},
					function(data) {
						alert(data);
						var d = JSON.parse(data);
						$('#tablita tbody').empty();
						for (i = 0; i < d.length; i++) {
							$("#tablita tbody")
									.append(
											"<tr><td style='color:blue; border: 1px solid #000000;'>"
													+ c
													+ "</td><td style=' border: 1px solid #000000;'>"
													+ d[i].nombrecat
													+ "</td><td style=' border: 1px solid #000000;'>"
													+ d[i].apellnombres
													+ "</td><td style=' border: 1px solid #000000;'>"
													+ d[i].correo
													+ "</td><td style=' border: 1px solid #000000; width: 140px'>"
													+ d[i].telefono
													+ "</td><td style=' border: 1px solid #000000;'><a href='#' style='color:green' onclick='modificar("
													+ d[i].idalumno
													+ ")'><i class='far fa-edit'></i></a></td><td style=' border: 1px solid #000000;'><a href='#' style='color:red' onclick='eliminar("
													+ d[i].idalumno
													+ ")'><i class='far fa-trash-alt'></i></a></td></tr>")
							c++;
						}
					});
}

function eliminar(id) {
	bootbox.confirm("Desea Eliminar?", function(result) {
		if (result) {
			bootbox.alert("Registro Eliminado Correctamente...!", function() {
				$.get("PruebaController", {
					id : id,
					opc : 5
				}, function(data) {
					limpiar();
					listarCat(0);
					listarProducto();
				});
			});

		} else {
			bootbox.alert("El registro no se Elimino...!")
		}
	});
}
function modificar(id) {
	alert("id:  " + id);
	$.post("PruebaController", {
		id : id,
		opc : 4
	}, function(data) {
		var x = JSON.parse(data);
		$("#apellnombres").val(x[0].apellnombres);
		$("#correo").val(x[0].correo);
		$("#telefono").val(x[0].telefono);
		$("#id").val(x[0].idalumno);
		listarCat(x[0].idescuela);
	});
}
function limpiar() {
	$("#apellnombres").val("");
	$("#correo").val("");
	$("#telefono").val("");
	$("#apellnombres").focus();
}
