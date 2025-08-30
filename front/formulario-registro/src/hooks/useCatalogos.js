import { useEffect, useState } from "react";
import { getTiposIdentificacion, getPaises, getDepartamentos, getCiudades, getMarcas } from "../api/catalogos";
import { norm } from "../const/normalizadores";

export function useCatalogos(form, setForm, setError) {
  const [tipos, setTipos] = useState([]);
  const [paises, setPaises] = useState([]);
  const [departamentos, setDepartamentos] = useState([]);
  const [ciudades, setCiudades] = useState([]);
  const [marcas, setMarcas] = useState([]);

  useEffect(() => {
    Promise.all([getTiposIdentificacion(), getPaises(), getMarcas()])
      .then(([tiposRes, paisesRes, marcasRes]) => {
        setTipos(tiposRes.map(norm.tipoIdentificacion));
        setPaises(paisesRes.map(norm.pais));
        setMarcas(marcasRes.map(norm.marca));
      })
      .catch((err) => setError(err.message));
  }, []);

  useEffect(() => {
    if (!form.paisId) return;
    getDepartamentos(form.paisId)
      .then((res) => setDepartamentos(res.map(norm.departamento)))
      .catch((err) => setError(err.message));
  }, [form.paisId]);

  useEffect(() => {
    if (!form.departamentoId) return;
    getCiudades(form.departamentoId)
      .then((res) => setCiudades(res.map(norm.ciudad)))
      .catch((err) => setError(err.message));
  }, [form.departamentoId]);

  return { tipos, paises, departamentos, ciudades, marcas };
}
