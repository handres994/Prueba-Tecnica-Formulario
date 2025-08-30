import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import ClienteRegistroForm from './pages/ClienteRegistroForm.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ClienteRegistroForm />
  </StrictMode>,
)
