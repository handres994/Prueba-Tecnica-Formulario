export const norm = {
  tipoIdentificacion: (row) => ({ value: row.Id_Identificacion ?? row.id, label: row.Tipo ?? row.tipo }),
  pais: (row) => ({ value: row.Id_Pais ?? row.id, label: row.Pais ?? row.pais }),
  departamento: (row) => ({ value: row.Id_Departamento ?? row.id, label: row.Departamento ?? row.departamento }),
  ciudad: (row) => ({ value: row.Id_Ciudad ?? row.id, label: row.Ciudad ?? row.ciudad }),
  marca: (row) => ({ value: row.Id_Marca ?? row.id, label: row.Marca ?? row.marca }),
};
