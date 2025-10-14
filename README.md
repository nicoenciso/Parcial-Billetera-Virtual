![image](https://img.shields.io/badge/Kotlin-B125EA?style=for-the-badge&logo=kotlin&logoColor=white)
![image](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=Jetpack%20Compose&logoColor=white)
![image](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![image](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)

# Billetera Virtual

Aplicación móvil en **Jetpack Compose** para la gestión de retiros de dinero con interfaz intuitiva, validación de montos y persistencia de saldo.

---

## 🛠 Tecnologías utilizadas

- **Kotlin**  
- **Jetpack Compose**  
- **Navigation Compose**  
- **ViewModel** para persistencia de datos entre pantallas  
- **Material3** para componentes y diseño UI  

---

## 📱 Funcionalidades principales

1. **Pantalla de retiro de dinero**
    - Selección rápida de montos mediante chips (`5000`, `10000`, `15000`, `20000`).  
    - Input editable para ingresar un monto personalizado.  
    - Validación dinámica del monto: no permite retirar más del saldo disponible.  
    - Botón de retiro que navega a la pantalla de comprobante.  

2. **Pantalla de comprobante**
    - Muestra el monto retirado y el saldo restante.  
    - Botón para volver a la pantalla de retiro.  

3. **Persistencia del saldo total**
    - Implementada con **ViewModel**, el saldo se mantiene al navegar entre pantallas.  
    - Se actualiza automáticamente cuando se realizan retiros.

4. **Formato dinámico de dinero**
    - Todos los montos se muestran con **dos decimales** y formato consistente.  
    - Compatible con chips y TextField editable.  

---

## 🎨 UI / UX

- Uso de **TopAppBar con gradiente** para títulos y navegación.  
- **OutlinedTextField** para entrada de montos con validación visual (`isError`).  
- **Chips** para selección rápida de valores.  
- **Botones centrados** y disposición en columnas y filas con spacing consistente.

- Diseño en Figma: [figma](https://www.figma.com/design/KRIMRGzi8Waa0Xns0mGGug/Parcial---Billetera-Virtual?node-id=0-1&t=9G8YR4LOQXUES72t-1)

---

## 📝 Cómo ejecutar

1. Clonar el repositorio:

```bash
git clone https://github.com/nicoenciso/Parcial-Billetera-Virtual.git
