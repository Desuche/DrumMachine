<p align="center">
  <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" width="100" alt="project-logo">
</p>
<p align="center">
    <h1 align="center">DRUMMACHINE</h1>
</p>
<p align="center">
    <em>Drumming up beats, making music interactive.</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/Desuche/DrumMachine?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/Desuche/DrumMachine?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/Desuche/DrumMachine?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/Desuche/DrumMachine?style=default&color=0080ff" alt="repo-language-count">
<p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>

<br><!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary><br>

- [ Overview](#-overview)
- [ Features](#-features)
- [ Repository Structure](#-repository-structure)
- [ Modules](#-modules)
- [ Getting Started](#-getting-started)
  - [ Installation](#-installation)
  - [ Usage](#-usage)
  - [ Tests](#-tests)
- [ Project Roadmap](#-project-roadmap)
- [ Contributing](#-contributing)
- [ License](#-license)
- [ Acknowledgments](#-acknowledgments)
</details>
<hr>

##  Overview

DrumMachine is an interactive drum machine software project that enables users to create, visualize, and play drum sequences with a sleek JavaFX GUI. It offers features such as MIDI playback, recording, BPM control, dynamic beat visualization, undo functionality, and instrument selection. Users can interact with the grid interface to compose beats, manage track history, and control playback. The projects value lies in providing a user-friendly music creation tool with responsive controls and engaging visual feedback.

---

##  Features

|    |   Feature         | Description |
|----|-------------------|---------------------------------------------------------------|
| ⚙️  | **Architecture**  | The project is a Java application built using Gradle for managing dependencies and builds. It utilizes JavaFX for the GUI and follows a modular structure with classes for player functionality, beat visualization, controls, and grid management. |
| 🔩 | **Code Quality**  | The codebase maintains a high quality with clear organization, consistent naming conventions, and well-structured classes. It adheres to Java best practices, making it readable and maintainable for contributors. |
| 📄 | **Documentation** | The project provides inline documentation within the codebase for classes and methods, aiding developers in understanding the functionality. However, there could be further improvements in terms of external documentation for setup and usage. |
| 🔌 | **Integrations**  | Key integrations include Java and JavaFX for application development, Gradle for build automation, and external dependencies for MIDI playback and GUI rendering. The project leverages these tools effectively to enhance functionality. |
| 🧩 | **Modularity**    | The codebase exhibits good modularity with separate classes for different functionalities like player control, visualization, beat generation, and GUI components. This modular design promotes code reusability and maintainability. |
| 🧪 | **Testing**       | Testing frameworks and tools used in the project are not explicitly mentioned in the details provided. Incorporating testing frameworks like JUnit or Mockito could be beneficial for ensuring code reliability and functionality. |
| ⚡️  | **Performance**   | The project's efficiency is commendable in terms of GUI rendering, MIDI playback, and real-time interaction with the drum machine interface. However, potential optimizations in resource usage could further enhance performance under heavy load. |
| 🛡️ | **Security**      | Protective measures for data security and access control are not explicitly discussed in the details provided. Implementing secure coding practices, data encryption, and access controls can bolster security in the application. |
| 📦 | **Dependencies**  | Key external libraries and dependencies include Java, Gradle, and JavaFX, essential for Java application development and building GUI interfaces. These dependencies are crucial for enabling the project's features and functionalities. |

---

##  Repository Structure

```sh
└── DrumMachine/
    ├── LICENSE
    ├── README.md
    ├── build.gradle
    ├── gradlew
    ├── gradlew.bat
    ├── settings.gradle
    └── src
        └── main
```

---

##  Modules

<details closed><summary>.</summary>

| File                                                                                  | Summary                                                                                                                                                                                                                                                             |
| ---                                                                                   | ---                                                                                                                                                                                                                                                                 |
| [settings.gradle](https://github.com/Desuche/DrumMachine/blob/master/settings.gradle) | Defines the project name within the DrumMachine repository.                                                                                                                                                                                                         |
| [build.gradle](https://github.com/Desuche/DrumMachine/blob/master/build.gradle)       | Manages Java and JavaFX dependencies, configurations, and artifact generation for the DrumMachine app in the repository. Sets up necessary plugins, versions, modules, dependencies, and defines tasks for packaging a runnable JAR file with specified attributes. |
| [gradlew.bat](https://github.com/Desuche/DrumMachine/blob/master/gradlew.bat)         | Defines Windows Gradle startup script; sets variables, resolves paths, finds Java, and executes Gradle with specified options and classpath. Ensures proper Java installation and handles errors gracefully.                                                        |

</details>

<details closed><summary>src.main.java.nl.vu.cs.softwaredesign</summary>

| File                                                                                                            | Summary                                                                                                                         |
| ---                                                                                                             | ---                                                                                                                             |
| [Main.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/Main.java) | Initiates the Drum Machine application by calling the main method of the App class. Displays the version number upon execution. |

</details>

<details closed><summary>src.main.java.nl.vu.cs.softwaredesign.player</summary>

| File                                                                                                                                           | Summary                                                                                                                                                                                                     |
| ---                                                                                                                                            | ---                                                                                                                                                                                                         |
| [SequenceRecorder.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/player/SequenceRecorder.java) | Records MIDI sequences during playback, saving the last recorded sequence. Tracks time intervals and note events, calculating ticks based on tempo. Facilitates sequence retrieval.                         |
| [Player.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/player/Player.java)                     | Manages MIDI playback and recording for a drum machine. Includes methods for playing sequences, looping, instrument sounds, BPM control, and manual recording. Centralizes synthesizer and sequencer setup. |

</details>

<details closed><summary>src.main.java.nl.vu.cs.softwaredesign.beat</summary>

| File                                                                                                                                             | Summary                                                                                                                                                                                                                                                                                                              |
| ---                                                                                                                                              | ---                                                                                                                                                                                                                                                                                                                  |
| [BeatFactory.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/beat/BeatFactory.java)               | Generates random beats with shapes and colors for a music visualization feature. Supports creating MIDI events and rendering dynamic visual elements based on specified parameters.                                                                                                                                  |
| [Beat.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/beat/Beat.java)                             | Defines a Beat class for visualizing MIDI events in DrumMachine. Manages the noteEvent and corresponding shape properties to display colored shapes on the grid.                                                                                                                                                     |
| [BeatCommand.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/beat/BeatCommand.java)               | Implements BeatCommand to add, remove beats in TrackVisual. Manages beat history for undo functionality in DrumMachine architecture.                                                                                                                                                                                 |
| [BeatCommandHistory.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/beat/BeatCommandHistory.java) | Manages a history of beat commands in the BeatCommandHistory class, providing functionalities to push, pop, remove, and check for emptiness. Key component in the DrumMachine repository for tracking and maintaining command history.                                                                               |
| [Instrument.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/beat/Instrument.java)                 | Defines musical instruments with associated visual and auditory elements. Enables instrument selection by key press or button click, triggering animations and sound playback. Instrument mappings are stored for efficient lookup. Contributing to the interactive drum machine interface in the parent repository. |

</details>

<details closed><summary>src.main.java.nl.vu.cs.softwaredesign.app</summary>

| File                                                                                                                        | Summary                                                                                                                                                                                                                                                                                                   |
| ---                                                                                                                         | ---                                                                                                                                                                                                                                                                                                       |
| [Controls.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/app/Controls.java) | Implements interactive controls for playing, stopping, recording, and playback in the DrumMachine app. Manages BPM settings, triggers instrument playback, and displays status information. Encapsulates the user interface components for seamless interaction with the Grid and Player functionalities. |
| [App.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/app/App.java)           | Generates a Drum Machine GUI with interactive controls and grid for creating beats. Allows undoing the last beat and playing sounds. Presented in a sleek layout using JavaFX.                                                                                                                            |

</details>

<details closed><summary>src.main.java.nl.vu.cs.softwaredesign.grid</summary>

| File                                                                                                                               | Summary                                                                                                                                                                                                                       |
| ---                                                                                                                                | ---                                                                                                                                                                                                                           |
| [TrackVisual.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/grid/TrackVisual.java) | Visualizes musical tracks with interactive features, manages beat history, and supports adding/removing beats dynamically.Uses JavaFX for GUI rendering within the DrumMachine repository architecture.                       |
| [Grid.java](https://github.com/Desuche/DrumMachine/blob/master/src/main/java/nl/vu/cs/softwaredesign/grid/Grid.java)               | Creates a visual grid with instrument tracks, allowing users to interact with and play musical sequences. Offers options to undo the last inputted beat. Facilitates seamless integration with Player for real-time playback. |

</details>

---

##  Getting Started

**System Requirements:**

* **Java**: `version x.y.z`

###  Installation

<h4>From <code>source</code></h4>

> 1. Clone the DrumMachine repository:
>
> ```console
> $ git clone https://github.com/Desuche/DrumMachine
> ```
>
> 2. Change to the project directory:
> ```console
> $ cd DrumMachine
> ```
>
> 3. Install the dependencies:
> ```console
> $ mvn clean install
> ```

###  Usage

<h4>From <code>source</code></h4>

> Run DrumMachine using the command below:
> ```console
> $ java -jar target/myapp.jar
> ```

###  Tests

> Run the test suite using the command below:
> ```console
> $ mvn test
> ```

---

##  Project Roadmap

- [X] `► INSERT-TASK-1`
- [ ] `► INSERT-TASK-2`
- [ ] `► ...`

---

##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Report Issues](https://github.com/Desuche/DrumMachine/issues)**: Submit bugs found or log feature requests for the `DrumMachine` project.
- **[Submit Pull Requests](https://github.com/Desuche/DrumMachine/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/Desuche/DrumMachine/discussions)**: Share your insights, provide feedback, or ask questions.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/Desuche/DrumMachine
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="center">
   <a href="https://github.com{/Desuche/DrumMachine/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=Desuche/DrumMachine">
   </a>
</p>
</details>

---

##  License

This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

[**Return**](#-overview)

---
