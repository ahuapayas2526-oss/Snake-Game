

# 🐍 Snake Game – Full Stack Java Project

---

## 📌 Descripció del projecte

Snake Game és una aplicació interactiva desenvolupada en Java que implementa el clàssic joc de la serp, ampliant-lo amb un sistema complet de persistència de dades.

A diferència dels jocs tradicionals, aquest projecte permet:

* Gestionar usuaris
* Registrar partides
* Guardar estadístiques de rendiment

Simula una aplicació **full-stack**, integrant interfície gràfica, lògica de negoci i base de dades.

---

## 🖼️ Captures de la pantalla de Login i la del joc




<img width="324" height="357" alt="Pantalla login" src="https://github.com/user-attachments/assets/31ad2f9a-7006-486e-a184-83fc4e90d3e0" />
<img width="324" height="357" alt="Pantalla joc" src="https://github.com/user-attachments/assets/edc0053f-57e7-4dec-818d-68020705c3ff" />




## 🎯 Funcionalitats principals

* 🎮 Joc Snake complet amb control per teclat
* 👤 Sistema d’usuaris amb identificació única
* 💾 Persistència de partides en MySQL
* 📊 Registre de puntuació i temps
* 🔁 Reinici de partida
* 🧱 Detecció de col·lisions

---

## 🛠️ Stack tecnològic

| Tecnologia  | Ús                            |
| ----------- | ----------------------------- |
| **Java SE** | Lògica del joc i estructura   |
| **Swing**   | Interfície gràfica            |
| **AWT**     | Renderització gràfica         |
| **MySQL**   | Base de dades                 |
| **JDBC**    | Connexió amb la base de dades |

---

## 🧠 Arquitectura del sistema

El projecte segueix una estructura modular basada en separació de responsabilitats:

* `GameArea` → Lògica del joc i renderització
* `SnakeGame` → Control general del joc
* `GameStats` → Gestió de dades de partida
* `GuardarPartides` → Connexió amb base de dades

Aquesta separació permet escalabilitat i manteniment del codi.

---

## 👨‍💻 Contribució personal

He desenvolupat el projecte de forma integral assumint múltiples rols:

### 🏗️ Arquitectura

* Disseny de classes i estructura modular
* Separació entre UI i lògica

### ⚙️ Backend

* Implementació del motor del joc
* Control del moviment i col·lisions
* Gestió del loop amb `Timer`

### 🗄️ Base de dades

* Disseny de l’esquema SQL
* Implementació de JDBC
* Persistència segura de partides

---

## ⚠️ Problemes i solucions

### 🎯 Gestió del focus del teclat

* Problema: el joc no detectava inputs
* Solució: `requestFocusInWindow()`

### 💾 Pèrdua de dades

* Problema: risc en tancaments inesperats
* Solució: guardar dades en esdeveniments crítics

### ⏱️ Sincronització del joc

* Problema: control del temps
* Solució: ús de `javax.swing.Timer`

---

## 📚 Aprenentatges tècnics

Aquest projecte m’ha permès consolidar coneixements clau:

* Programació orientada a objectes aplicada a projectes reals
* Integració de Java amb bases de dades (JDBC)
* Gestió d’esdeveniments i interfícies gràfiques
* Disseny d’arquitectures modulars
* Pensament full-stack

També he après a:

* Escriure codi mantenible
* Separar responsabilitats
* Pensar en escalabilitat des del disseny

---

## 🚀 Possibles millores

* 🏆 Sistema de rànquing global
* 🎚️ Nivells de dificultat
* 🎨 Millora visual (JavaFX o frontend web)
* 🌐 Migració a arquitectura web

---


## 💡 Reflexió final

Aquest projecte representa molt més que un joc: és una demostració pràctica de com integrar diferents capes del desenvolupament de software en una sola aplicació.

Mostra la meva capacitat per dissenyar, implementar i connectar sistemes complets, seguint una mentalitat de desenvolupador professional.

---
