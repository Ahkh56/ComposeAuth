****📱 ComposeAuth****

ComposeAuth is a modern Android authentication module built with Jetpack Compose, following a clean
modular architecture. It demonstrates best practices for building scalable, maintainable, and
responsive UI screens for login and registration.

**🚀 Features**

🔐 Authentication Screens — Login, Register, Forgot Password

🎨 Jetpack Compose UI — Built fully using Compose; no XML layouts

📦 Modular Architecture — Separation of concerns via app, core, and feature-auth modules

🌈 Material 3 Design — Modern components with theming support

🧠 State Management — Using ViewModel and StateFlow for reactive UI

⚙️ Validation — Real-time form validation for email & password fields

📱 Responsive Layouts — Adaptive design for all screen sizes

🧩 Custom Typography — Integrated with Google Fonts (DM Sans & Inter)

**🏗️ Project Structure**

ComposeAuth/
│
├── app/                 # Main application module (entry point, navigation, theme)
│   ├── ui/theme/        # Global typography, colors, and shapes
│   └── MainActivity.kt
│
├── core/                # Shared utilities and base components
│   ├── utils/           # Common validation logic, constants, extensions
│   └── ui/              # Reusable composables (buttons, text fields, etc.)
│
└── feature-auth/        # Authentication feature module
├── ui/login/        # Login screen, state handling, validation
├── ui/register/     # Registration screen
└── viewmodel/       # Auth ViewModels & use cases

**💡 Tech Stack**

Category	           Technology
Language               Kotlin
UI Toolkit       	   Jetpack Compose
Architecture	       MVVM + Clean Architecture
Navigation	           Jetpack Navigation-Compose
Dependency             Injection	Hilt (optional / coming soon)
Async / Reactive	   Kotlin Coroutines + StateFlow
Fonts	Google Fonts   (DM Sans, Inter)

**🧩 Setup Instructions**

1️⃣ Clone the repository

git clone https://github.com/yourusername/ComposeAuth.git
cd ComposeAuth


2️⃣ Open in Android Studio

Use Android Studio Hedgehog or later

Ensure Kotlin ≥ 1.9 and Compose Compiler ≥ 1.6.0

3️⃣ Build the project

./gradlew assembleDebug

4️⃣ Run on Emulator or Physical Device

Use Android Studio’s Run configuration or CLI:
./gradlew installDebug

Key Implementation Details


**🧠 Form Validation:**
Email and password fields are validated using mutableStateOf<String?> to track errors.
Error messages appear dynamically under input fields when invalid.

UI Responsiveness:
The layout adapts automatically to screen size and orientation changes.
Scrollable content is enabled using Column(Modifier.verticalScroll()).

Typography:
Custom Google Fonts are used — DM Sans for headings, Inter for body text.
Fonts are defined in the app module theme and shared across modules.

**🧭 Roadmap**

Add Register & Forgot Password Screens

Integrate Firebase Authentication

Add Unit Tests

Add Dark Mode support

Local & Remote Validation Layers

**🪪 License**

Copyright (c) 2025 Abdul Hanan Khan

Licensed under the MIT License.  
You may use, copy, modify, and distribute this software for any purpose,  
provided that the above copyright notice and this permission notice are included.

**💬 Contact**

Author: Abdul Hanan Khan
📧 Email: ahkhan622@gmail.com
🌐 GitHub: @Ahkh56
