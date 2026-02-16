# Lily-vulkan

Lily-vulkan is the rendering and runtime backend layer of the Lily ecosystem.
It extends Lily-core with concrete graphics, compute, window, and audio capabilities built on Vulkan and LWJGL.

## MDE perspective
Lily-vulkan is, first and foremost, a Model-Driven Engineering (MDE) modeling of Vulkan (and more).
Core Vulkan notions like descriptors, descriptor sets, pipelines, buffers, barriers, and processes are represented as LMF model elements.
In practice, each of these notions is defined as an LMF `Group` (the LMF equivalent of an `EClass` in EMF).

This gives a structured and typed way to build Vulkan configurations as models instead of writing everything as low-level imperative code.
As a result, common Vulkan usage becomes drastically easier to express, understand, and maintain.

## Why this matters
Because Vulkan is modeled explicitly, higher-complexity rendering or compute setups can also be described at a high level.
Those high-level models are then materialized at runtime through adapters.
This keeps advanced behavior extensible without losing control over low-level execution details.

## Key LMF features used here
The two most important LMF capabilities used by Lily-vulkan are:
- modelization (explicit domain modeling of Vulkan concepts),
- adapter pattern (binding model elements to executable runtime behavior).

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
