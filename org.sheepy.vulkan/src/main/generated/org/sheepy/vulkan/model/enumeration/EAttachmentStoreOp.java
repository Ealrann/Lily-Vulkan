package org.sheepy.vulkan.model.enumeration;

public enum EAttachmentStoreOp {
  STORE(0),
  DONT_CARE(1);

  private final int value;

  EAttachmentStoreOp(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
