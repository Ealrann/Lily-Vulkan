package org.sheepy.vulkan.model.enumeration;

public enum EInstanceCount {
  ONE(0),
  TWO(1),
  FIT_TO_SWAP_IMAGE_COUNT(2);

  private final int value;

  EInstanceCount(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
