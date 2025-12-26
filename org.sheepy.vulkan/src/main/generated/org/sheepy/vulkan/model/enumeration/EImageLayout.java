package org.sheepy.vulkan.model.enumeration;

public enum EImageLayout {
  UNDEFINED(0),
  GENERAL(1),
  COLOR_ATTACHMENT_OPTIMAL(2),
  DEPTH_STENCIL_ATTACHMENT_OPTIMAL(3),
  DEPTH_STENCIL_READ_ONLY_OPTIMAL(4),
  SHADER_READ_ONLY_OPTIMAL(5),
  TRANSFER_SRC_OPTIMAL(6),
  TRANSFER_DST_OPTIMAL(7),
  PREINITIALIZED(8),
  PRESENT_SRC_KHR(1000001002);

  private final int value;

  EImageLayout(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
