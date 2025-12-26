package org.sheepy.vulkan.model.enumeration;

public enum EPipelineStage {
  TOP_OF_PIPE_BIT(1),
  DRAW_INDIRECT_BIT(2),
  VERTEX_INPUT_BIT(4),
  VERTEX_SHADER_BIT(8),
  TESSELLATION_CONTROL_SHADER_BIT(16),
  TESSELLATION_EVALUATION_SHADER_BIT(32),
  GEOMETRY_SHADER_BIT(64),
  FRAGMENT_SHADER_BIT(128),
  EARLY_FRAGMENT_TESTS_BIT(256),
  LATE_FRAGMENT_TESTS_BIT(512),
  COLOR_ATTACHMENT_OUTPUT_BIT(1024),
  COMPUTE_SHADER_BIT(2048),
  TRANSFER_BIT(4096),
  BOTTOM_OF_PIPE_BIT(8192),
  HOST_BIT(16384),
  ALL_GRAPHICS_BIT(32768),
  ALL_COMMANDS_BIT(65536);

  private final int value;

  EPipelineStage(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
