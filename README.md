# TOC App (Android MVP)

Base de aplicación Android (Jetpack Compose) enfocada a personas con TOC.

## Incluye
- `MainActivity` con pantalla principal Compose.
- Secciones MVP:
  - Registro diario.
  - Exposiciones ERP.
  - Plan de seguridad.
- Datos de ejemplo en un repositorio fake para prototipado rápido.

## Ejecutar
```bash
gradle wrapper
./gradlew :app:assembleDebug
```

> Requiere Android SDK configurado localmente (`ANDROID_HOME` o `ANDROID_SDK_ROOT`).
