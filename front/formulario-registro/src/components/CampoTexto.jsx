import React from "react";

export default function CampoTexto({ label, type="text", name, value, onChange, placeholder, error }) {
  return (
    <label className="crf-field">
      <span className="crf-label">{label}</span>
      <input
        type={type}
        name={name}
        value={value}
        onChange={onChange}
        placeholder={placeholder}
        required
        className="crf-input"
      />
      {error && <span className="crf-hint-error">{error}</span>}
    </label>
  );
}
