package org.sheepy.vulkan.model.enumeration;

public enum EBufferUsage {
  TRANSFER_SRC_BIT(1),
  TRANSFER_DST_BIT(2),
  UNIFORM_TEXEL_BUFFER_BIT(4),
  STORAGE_TEXEL_BUFFER_BIT(8),
  UNIFORM_BUFFER_BIT(16),
  STORAGE_BUFFER_BIT(32),
  INDEX_BUFFER_BIT(64),
  VERTEX_BUFFER_BIT(128),
  INDIRECT_BUFFER_BIT(256);

  private final int value;

  EBufferUsage(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
