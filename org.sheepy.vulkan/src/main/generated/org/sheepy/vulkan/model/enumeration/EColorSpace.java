package org.sheepy.vulkan.model.enumeration;

public enum EColorSpace {
  SRGB_NONLINEAR_KHR(0);

  private final int value;

  EColorSpace(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
