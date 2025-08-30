import { fetchJSON } from "./clientes";

const API_BASE = import.meta.env.VITE_API_BASE || "http://localhost:8080/api";
const CATALOGS_BASE = `${API_BASE}/catalogos`;

export const getTiposIdentificacion = () =>
  fetchJSON(`${CATALOGS_BASE}/tipos-identificacion`);

export const getPaises = () =>
  fetchJSON(`${CATALOGS_BASE}/paises`);

export const getDepartamentos = (paisId) =>
  fetchJSON(`${CATALOGS_BASE}/departamentos?paisId=${encodeURIComponent(paisId)}`);

export const getCiudades = (departamentoId) =>
  fetchJSON(`${CATALOGS_BASE}/ciudades?departamentoId=${encodeURIComponent(departamentoId)}`);

export const getMarcas = () =>
  fetchJSON(`${CATALOGS_BASE}/marcas`);
