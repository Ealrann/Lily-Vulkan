package org.sheepy.lily.vulkan.model.process.graphic;

public enum EAttachmentType {
  Color(0),
  Depth(1),
  Input(2);

  private final int value;

  EAttachmentType(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
