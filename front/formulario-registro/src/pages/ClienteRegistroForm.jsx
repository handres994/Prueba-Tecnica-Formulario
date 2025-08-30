import React, { useMemo, useState } from "react";
import "../assets/ClienteRegistroForm.css";
import CampoSelect from "../components/CampoSelect";
import CampoTexto from "../components/CampoTexto";
import PanelLogo from "../components/PanelLogo";
import { LOGOS_MARCA, normText } from "../const/logosMarcas";
import { registrarCliente } from "../api/clientes";
import { useCatalogos } from "../hooks/useCatalogos";

export default function ClienteRegistroForm() {
  const [form, setForm] = useState({
    tipoIdentificacionId: "",
    numeroIdentificacion: "",
    nombres: "",
    apellidos: "",
    fechaNacimiento: "",
    direccion: "",
    paisId: "",
    departamentoId: "",
    ciudadId: "",
    marcaId: "",
  });

  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");
  const { tipos, paises, departamentos, ciudades, marcas } = useCatalogos(form, setForm, setError);

  const errors = useMemo(() => {
    const e = {};
    if (!form.tipoIdentificacionId) e.tipoIdentificacionId = "Requerido";
    if (!form.numeroIdentificacion?.trim()) e.numeroIdentificacion = "Requerido";
    if (!form.nombres?.trim()) e.nombres = "Requerido";
    if (!form.apellidos?.trim()) e.apellidos = "Requerido";
    if (!form.fechaNacimiento) e.fechaNacimiento = "Requerido";
    if (!form.direccion?.trim()) e.direccion = "Requerido";
    if (!form.paisId) e.paisId = "Requerido";
    if (!form.departamentoId) e.departamentoId = "Requerido";
    if (!form.ciudadId) e.ciudadId = "Requerido";
    if (!form.marcaId) e.marcaId = "Requerido";
    return e;
  }, [form]);

  const isFormValid = Object.keys(errors).length === 0;

  const selectedMarcaLabel = useMemo(() => {
    const m = marcas.find((o) => String(o.value) === String(form.marcaId));
    return m?.label || "";
  }, [marcas, form.marcaId]);

  const heroUrl = useMemo(
    () => LOGOS_MARCA[normText(selectedMarcaLabel)] || "/img/Fidelizacion_Logo.png",
    [selectedMarcaLabel]
  );

  const onChange = (e) => setForm((f) => ({ ...f, [e.target.name]: e.target.value }));

  const onSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setSuccess("");
    if (!isFormValid) return;
    try {
      await registrarCliente(form);
      setSuccess("Cliente registrado correctamente");
      setForm({ tipoIdentificacionId:"", numeroIdentificacion:"", nombres:"", apellidos:"", fechaNacimiento:"", direccion:"", paisId:"", departamentoId:"", ciudadId:"", marcaId:"" });
    } catch (err) {
      setError(err.message || "No se pudo registrar el cliente");
    }
  };

  return (
    <div className="crf-wrapper">
      <div className="crf-modal">
        <PanelLogo heroUrl={heroUrl} selectedMarcaLabel={selectedMarcaLabel} />

        <div className="crf-pane">
          <div className="crf-card">
            <h1 className="crf-title">Registro de Cliente</h1>
            <p className="crf-subtitle">Los catálogos se cargan desde tu base de datos</p>

            {error && <div className="crf-msg crf-msg--error">{error}</div>}
            {success && <div className="crf-msg crf-msg--success">{success}</div>}

            <form onSubmit={onSubmit} noValidate>
              <div className="crf-grid">
                <CampoSelect label="Tipo de identificación" name="tipoIdentificacionId" value={form.tipoIdentificacionId} onChange={onChange} options={tipos} error={errors.tipoIdentificacionId} />
                <CampoTexto label="Número de identificación" name="numeroIdentificacion" value={form.numeroIdentificacion} onChange={onChange} placeholder="Ej: 1000000001" error={errors.numeroIdentificacion} />
                <CampoTexto label="Nombres" name="nombres" value={form.nombres} onChange={onChange} placeholder="Nombres" error={errors.nombres} />
                <CampoTexto label="Apellidos" name="apellidos" value={form.apellidos} onChange={onChange} placeholder="Apellidos" error={errors.apellidos} />
                <CampoTexto label="Fecha de nacimiento" type="date" name="fechaNacimiento" value={form.fechaNacimiento} onChange={onChange} error={errors.fechaNacimiento} />
                <CampoTexto label="Dirección" name="direccion" value={form.direccion} onChange={onChange} placeholder="Calle 10 # 20-30" error={errors.direccion} />
                <CampoSelect label="País" name="paisId" value={form.paisId} onChange={onChange} options={paises} error={errors.paisId} />
                <CampoSelect label="Departamento/Estado" name="departamentoId" value={form.departamentoId} onChange={onChange} options={departamentos} error={errors.departamentoId} />
                <CampoSelect label="Ciudad" name="ciudadId" value={form.ciudadId} onChange={onChange} options={ciudades} error={errors.ciudadId} />
                <CampoSelect label="Marca" name="marcaId" value={form.marcaId} onChange={onChange} options={marcas} error={errors.marcaId} />
              </div>

              <div className="crf-buttons">
                <button type="button" className="crf-btn" onClick={() => setForm({ tipoIdentificacionId:"", numeroIdentificacion:"", nombres:"", apellidos:"", fechaNacimiento:"", direccion:"", paisId:"", departamentoId:"", ciudadId:"", marcaId:"" })}>
                  Limpiar
                </button>
                <button type="submit" className="crf-btn" disabled={!isFormValid}>Registrar</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
