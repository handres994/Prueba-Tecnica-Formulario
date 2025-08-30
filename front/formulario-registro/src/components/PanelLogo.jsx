import React from "react";

export default function PanelLogo({ heroUrl, selectedMarcaLabel }) {
  return (
    <div className="crf-hero" aria-label={selectedMarcaLabel ? `Logo ${selectedMarcaLabel}` : "Programa de fidelización"}>
      <img src={heroUrl} alt={selectedMarcaLabel || "Fidelización"} className="crf-hero-img" />
    </div>
  );
}
