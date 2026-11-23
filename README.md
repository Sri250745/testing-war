# Testing War — first build

A Minecraft Java 26.3 Fabric starter for the Testing War project. It contains one custom player-shaped humanoid entity registered as `testing_war:citizen`. In a new creative test world, use `/summon testing_war:citizen` to check that the mod loads, the entity appears with a visible name, wanders, and retains its identity/name in the world save.

This is an early technical slice, not the requested full simulation. It does not yet implement resource gathering, crafting, NPC inventories, hunger, combat, population management, politics, kingdoms, Nether/End progression, voice, or modpack packaging. No voice input is captured. Do not use valuable worlds for testing.

## Build using the workflow you already used

1. Create a **new** public GitHub repository named `testing-war` (keep your Spear Mace repo unchanged).
2. Upload the contents of this folder to the new repository. Include the hidden `.github` folder and `gradle/wrapper` folder; do not upload the outer ZIP as a single file.
3. Open the new repository's **Actions** tab. The `build` workflow starts on the upload. Wait for the run to finish green.
4. Open that run, scroll to **Artifacts**, and download `testing-war-jar`. Extract the download and use `testing-war-0.1.0.jar` from it (ignore any `-sources.jar`).
5. Put the JAR in the `mods` folder for a separate SKlauncher installation set to Minecraft 26.3 + Fabric. Put the matching Fabric API JAR in that same folder. Start a brand-new creative test world and run `/summon testing_war:citizen`.

The build uses Java 25, Fabric Loader 0.20.1, Fabric Loom 1.19-SNAPSHOT and Fabric API 0.167.0+26.3. GitHub Actions installs Java and Gradle downloads the build dependencies. No paid API, extra Minecraft account, voice service, or public game server is part of this slice.

## If the workflow fails

Open the red workflow run, select the `build` job, and copy the first error block (the lines around `What went wrong`). Share that text here; it is enough to diagnose most build failures. Do not replace version numbers or copy dependency JARs into the repo.
