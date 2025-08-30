import React from "react";

export default function CampoSelect({ label, name, value, onChange, options, disabled, error }) {
  return (
    <label className="crf-field">
      <span className="crf-label">{label}</span>
      <select
        name={name}
        value={value}
        onChange={onChange}
        disabled={disabled}
        required
        className="crf-input crf-select"
      >
        <option value="" disabled>Selecciona {label.toLowerCase()}</option>
        {options.map((o) => (
          <option key={o.value} value={o.value}>
            {o.label}
          </option>
        ))}
      </select>
      {error && <span className="crf-hint-error">{error}</span>}
    </label>
  );
}
