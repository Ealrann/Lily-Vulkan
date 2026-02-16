# Lily-vulkan

Lily-vulkan is the rendering and runtime backend layer of the Lily ecosystem.
It extends Lily-core with concrete graphics, compute, window, and audio capabilities built on Vulkan and LWJGL.

## What this project does
- Provides a model-driven Vulkan engine implementation for Lily applications.
- Adds GPU process abstractions (compute and graphic pipelines, resources, descriptors, synchronization).
- Integrates input, windowing, and execution services for real-time interactive applications.
- Includes OpenAL support for audio through dedicated model and runtime modules.

## Position in the ecosystem
Lily-vulkan is not a standalone framework; it is designed to sit on top of Lily-core.
Lily-core defines shared application concepts and lifecycle contracts.
Lily-vulkan provides the platform-specific implementation of those contracts.

## Related projects
- Lily-core (foundation): https://github.com/Ealrann/Lily-core
- LMF (modeling framework used by Lily projects): https://github.com/Ealrann/lmf
- VSand (example application built with Lily-vulkan): https://github.com/Ealrann/VSand

## In practice
You can use Lily-vulkan to build model-driven real-time applications that need GPU compute + rendering.
VSand is a concrete reference showing how the stack is composed end-to-end.
This repository is the backend layer that turns Lily models into actual Vulkan/OpenAL runtime behavior.
