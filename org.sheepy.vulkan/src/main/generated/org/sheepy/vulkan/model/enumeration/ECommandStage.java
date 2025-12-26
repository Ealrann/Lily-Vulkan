package org.sheepy.vulkan.model.enumeration;

public enum ECommandStage {
  MAIN(0),
  PRE_RENDER(1),
  POST_RENDER(2);

  private final int value;

  ECommandStage(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
