
# Tech Stack
- Kotlin
- Compose
- Hilt
- Clean Architecture & DDD
- GraphQL
- Coroutines

# Architecture
 The app is based on Clean Architecture & DDD, with three main modules:
# Domain: Contains the business logic of the application, which is independent of the Android platform. It defines the entities, use cases, and repositories interfaces.
# Data: Implements the repository interfaces defined in the domain layer. It is responsible for retrieving the data from the remote data source (AniListApi) and mapping it into entities.
# Presentation: Contains the UI logic of the application using Compose. It interacts with the domain layer through the use cases to display the data on the screen.


# Getting Started
- Clone the repo.
- Open the project in Android Studio or your preferred IDE.
- Build and run the app on your device or emulator.
