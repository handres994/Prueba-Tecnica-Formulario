export const LOGOS_MARCA = {
  "americanino": "/img/Americanino_Logo.png",
  "american eagle": "/img/American_Eagle_Logo.png",
  "chevignon": "/img/Chevignon_Logo.png",
  "esprit": "/img/Esprit_Logo.png",
  "naf naf": "/img/Naf_Naf_Logo.png",
  "rifle": "/img/Rifle_Logo.png",
};

export const normText = (t = "") =>
  t.toString()
    .normalize("NFD")
    .replace(/[\u0300-\u036f]/g, "")
    .toLowerCase()
    .replace(/\s+/g, " ")
    .trim();
