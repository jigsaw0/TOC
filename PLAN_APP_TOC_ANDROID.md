# Plan de aplicación Android para personas con TOC

## 1) Objetivo
Crear una app móvil de apoyo para personas con Trastorno Obsesivo-Compulsivo (TOC), centrada en estrategias basadas en evidencia (principalmente TCC/ERP), seguimiento de síntomas y acceso rápido a recursos de ayuda.

> **Nota importante**: La app **no reemplaza tratamiento profesional**. Debe presentarse como herramienta de acompañamiento.

## 2) Usuario objetivo
- Personas con diagnóstico de TOC.
- Personas con síntomas compatibles en búsqueda de apoyo estructurado.
- Pacientes en tratamiento que necesitan registrar progreso entre sesiones.

## 3) Propuesta de valor
- Rutinas guiadas de Exposición con Prevención de Respuesta (ERP).
- Registro simple y útil de obsesiones, compulsiones, ansiedad y progreso.
- Contención en momentos críticos (plan de crisis + contacto rápido).
- Personalización gradual para evitar sobrecarga.

## 4) MVP (primer lanzamiento)

### 4.1 Onboarding clínicamente responsable
- Consentimiento informado y límites de uso.
- Configuración de idioma, zona horaria y recordatorios.
- Definición de objetivos iniciales semanales.

### 4.2 Registro diario
- Intensidad de ansiedad (0–10).
- Tipo de obsesión/compulsión (catálogo configurable).
- Duración estimada de rituales.
- Disparadores y contexto.

### 4.3 Módulo ERP básico
- Jerarquía de exposición (niveles de dificultad).
- Sesiones guiadas con temporizador.
- Registro de ansiedad antes/durante/después.
- Reflexión post-sesión y refuerzo positivo.

### 4.4 Dashboard de progreso
- Tendencias semanales (ansiedad media, tiempo de rituales, adherencia).
- Días consecutivos de práctica.
- Recomendaciones automáticas simples (no diagnósticas).

### 4.5 Plan de crisis y seguridad
- Botón de acceso rápido a contactos de emergencia.
- Lista personalizada de estrategias de autorregulación.
- Mensajes de contención basados en guías psicoeducativas.

## 5) Funcionalidades para versiones futuras
- Integración con terapeuta (exportar reportes PDF/CSV).
- IA conversacional para psicoeducación (con validación clínica).
- Comunidad moderada y anónima.
- Wearables para detectar estrés (HRV / pulso, según permisos).

## 6) Requisitos clínicos y éticos
- Contenido revisado por profesional de salud mental.
- Evitar lenguaje de culpa o promesas de cura.
- Señalización clara de riesgo y derivación a servicios de emergencia.
- Transparencia total sobre uso de datos.

## 7) Arquitectura técnica sugerida (Android)

### 7.1 Stack
- **Lenguaje**: Kotlin.
- **UI**: Jetpack Compose + Material 3.
- **Arquitectura**: Clean Architecture + MVVM.
- **DI**: Hilt.
- **Persistencia local**: Room + DataStore.
- **Backend** (opcional MVP+): Firebase o API propia con Ktor/Spring.
- **Analítica**: eventos mínimos, anonimizados.

### 7.2 Módulos
- `feature_onboarding`
- `feature_daily_log`
- `feature_erp`
- `feature_dashboard`
- `feature_safety`
- `core_ui`, `core_domain`, `core_data`

### 7.3 Modelo de datos inicial
- `UserProfile(id, timezone, remindersEnabled, emergencyContacts)`
- `DailyEntry(id, date, anxietyLevel, trigger, compulsionMinutes, notes)`
- `ExposurePlan(id, title, level, targetDurationMin)`
- `ExposureSession(id, planId, startAt, endAt, anxietyBefore, anxietyAfter, completed)`

## 8) Seguridad, privacidad y cumplimiento
- Cifrado en reposo para datos sensibles.
- Cifrado en tránsito (TLS).
- Bloqueo opcional con biometría/PIN.
- Política de privacidad clara (RGPD/LFPDPPP según mercado).
- Mecanismo de borrado de cuenta y exportación de datos.

## 9) Métricas de éxito (producto)
- Activación: % usuarios que completan onboarding + primer registro.
- Retención D7/D30.
- % usuarios que realizan ≥2 sesiones ERP por semana.
- Reducción autoinformada de tiempo dedicado a compulsiones.
- NPS y percepción de utilidad clínica.

## 10) Roadmap sugerido (12 semanas)
- **Semanas 1–2**: discovery clínico + prototipos UX.
- **Semanas 3–5**: onboarding, registro diario, persistencia local.
- **Semanas 6–8**: módulo ERP y dashboard básico.
- **Semanas 9–10**: plan de crisis, QA, accesibilidad.
- **Semanas 11–12**: beta cerrada, ajustes, publicación interna.

## 11) Próximos pasos accionables
1. Validar este alcance con un psicólogo/a especialista en TOC.
2. Diseñar wireframes de 5 pantallas clave (onboarding, diario, ERP, dashboard, crisis).
3. Construir un prototipo funcional local (sin backend) para pruebas de usabilidad.
4. Definir protocolo de manejo de riesgo y mensajes de emergencia por país.
5. Lanzar beta cerrada con 10–20 usuarios y medir adherencia 4 semanas.
