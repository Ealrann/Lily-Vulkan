package org.sheepy.vulkan.model.enumeration;

public enum EShaderStage {
  VERTEX_BIT(1),
  TESSELLATION_CONTROL_BIT(2),
  TESSELLATION_EVALUATION_BIT(4),
  GEOMETRY_BIT(8),
  FRAGMENT_BIT(16),
  COMPUTE_BIT(32),
  ALL_GRAPHICS(31),
  ALL(2147483647);

  private final int value;

  EShaderStage(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
