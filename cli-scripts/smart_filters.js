// Smart filter para stream vendedores.
// Filtro 1
function filterstreamitem() {
  const item = getfilterstreamitem();
  if (item.keys.length != 1) return "Debe tener una sola clave.";
  if (item.format != "json") return "Debe ser de tipo JSON.";

  const json = item.data.json;
  if (!json.hasOwnProperty("nombre")) return "Debe tener el atributo nombre.";
  if (!json.hasOwnProperty("telefono"))
    return "Debe tener el atributo telefono.";
  if (Object.keys(json).length > 2)
    return "Solo puede incluir los atributos nombre y telefono";
}

// Smart filter para stream ganancias.
// Filtro 2
function filterstreamitem() {
  const item = getfilterstreamitem();
  if (item.keys.length != 1) return "Debe tener una sola clave.";
  if (item.format != "json") return "Debe ser de tipo JSON.";

  const json = item.data.json;
  if (!json.hasOwnProperty("valor")) return "Debe tener el atributo valor.";
  if (Object.keys(json).length > 1)
    return "Solo puede incluir el atributo valor";
}
