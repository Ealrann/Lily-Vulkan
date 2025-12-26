package org.sheepy.vulkan.model.enumeration;

public enum EImageUsage {
  TRANSFER_SRC(1),
  TRANSFER_DST(2),
  SAMPLED(4),
  STORAGE(8),
  COLOR_ATTACHMENT(16),
  DEPTH_STENCIL_ATTACHMENT(32),
  TRANSIENT_ATTACHMENT(64),
  INPUT_ATTACHEMENT(128);

  private final int value;

  EImageUsage(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
