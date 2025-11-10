****📱 ComposeAuth****

ComposeAuth is a modern Android application built with Jetpack Compose, following a clean, multi-module architecture. It demonstrates best practices for building scalable, maintainable, and responsive UI screens for login and registration.

**🚀 Features**

🔐 Authentication Screens — Login, Register

🎨 Jetpack Compose UI — Built fully using Compose; no XML layouts.

📦 Modular Architecture — Clean separation of concerns between UI, domain, and data layers.

🌓 Dark Mode Support — The app is fully theme-reactive and adapts to the system's light or dark mode setting.

🌈 Shared Theme — Centralized Material 3 theme in the `:core` module.

🧠 State Management — Using `ViewModel` and `StateFlow` for a reactive UI.

⚙️ Validation — Real-time form validation for email & password fields.

👁️ Show/Hide Password — Toggle visibility for password fields.

✈️ Offline Handling — A Lottie-powered screen for no-internet scenarios.

**✨ Recent Changes**

- **Dark Mode Implementation**: Added full support for dark mode. The app now automatically adapts to the system theme, and all UI components have been updated to be theme-aware.
- **Major Architectural Refactoring**: Migrated to a full multi-module architecture (`app`, `core`, `domain`, `data`, `feature-auth`, `feature-home`) to enforce separation of concerns and improve scalability.
- **Dependency Injection with Koin**: Integrated Koin for dependency injection across all modules, simplifying the management of dependencies like ViewModels and Repositories.
- **Firebase Integration**:
    - **Firebase Auth**: Added for handling user authentication.
    - **Crashlytics**: Integrated for crash reporting and app stability monitoring.
- **Centralized Navigation**: Implemented a `NavigationProvider` system in `:core` to allow feature modules to define their navigation routes in a decoupled way.
- **Shared UI & Theme**: Moved the Material 3 `Theme`, `Color`, and `Typography` into the `:core` module, allowing a consistent look and feel across all features.
- **Enhanced UX Features**:
    - **Show/Hide Password**: Added an icon to toggle password visibility in input fields.
    - **Progress Dialog**: Implemented a reusable, modal `ProgressDialog` to prevent user interaction during network operations.
    - **No Internet Screen**: Created a `NoInternetScreen` using a Lottie animation to gracefully handle offline states.
- **Resilient Network Observer**: Implemented and subsequently refined a `NetworkObserver` in `:core`. It now provides a reliable, real-time stream of the device's network status and is resilient to race conditions that could cause false negatives.

**🏗️ Project Structure**

ComposeAuth/
│
├── app/                 # Main application module (DI, entry point)
├── core/                # Shared utilities, navigation, and base UI components
├── data/                # Data sources and repository implementations
├── domain/              # Core data models and repository interfaces
├── feature-auth/        # Self-contained authentication feature
└── feature-home/        # Self-contained home screen feature

**💡 Tech Stack**

| Category           | Technology                                        |
|--------------------|---------------------------------------------------|
| **Language**       | Kotlin                                            |
| **UI Toolkit**     | Jetpack Compose                                   |
| **Architecture**   | MVVM + Clean Architecture (Multi-Module)          |
| **Navigation**     | Jetpack Navigation-Compose                        |
| **Dependency Injection** | Koin                                              |
| **Async / Reactive** | Kotlin Coroutines + StateFlow                     |
| **Networking**     | Firebase Auth                                     |
| **Crash Reporting**| Firebase Crashlytics                              |
| **Animations**     | Lottie                                            |

**🧩 Setup Instructions**

1️⃣ Clone the repository

```bash
git clone https://github.com/yourusername/ComposeAuth.git
cd ComposeAuth
```

2️⃣ Open in Android Studio

- Use Android Studio Hedgehog or later.
- Ensure you have a `google-services.json` file from your Firebase project placed in the `app/` directory.

3️⃣ Build the project

```bash
./gradlew assembleDebug
```

**🪪 License**

Copyright (c) 2025 Abdul Hanan Khan

Licensed under the MIT License. You may use, copy, modify, and distribute this software for any purpose, provided that the above copyright notice and this permission notice are included in all copies or substantial portions of the Software.

**💬 Contact**

Author: Abdul Hanan Khan
📧 Email: ahkhan622@gmail.com
🌐 GitHub: @Ahkh56
