package org.sheepy.vulkan.model.enumeration;

public enum EAttachmentLoadOp {
  LOAD(0),
  CLEAR(1),
  DONT_CARE(2);

  private final int value;

  EAttachmentLoadOp(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
