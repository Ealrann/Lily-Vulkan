package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

public final class SwapchainConfigurationImpl extends FeaturedObject<SwapchainConfiguration.Features<?>> implements SwapchainConfiguration {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<SwapchainConfiguration.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int requiredSwapImageCount;
  private final List<EImageUsage> swapImageUsages = newObservableList(SwapchainConfiguration.FeatureIDs.SWAP_IMAGE_USAGES, false, false);
  private boolean presentWhenVBlank;
  private boolean acquireWaitForVBlank;
  private boolean allowingAccessFromCompute;
  private SwapImageAttachment colorAttachment;

  public SwapchainConfigurationImpl(final boolean presentWhenVBlank,
      final boolean acquireWaitForVBlank, final boolean allowingAccessFromCompute,
      final SwapImageAttachment colorAttachment) {
    this.presentWhenVBlank = presentWhenVBlank;
    this.acquireWaitForVBlank = acquireWaitForVBlank;
    this.allowingAccessFromCompute = allowingAccessFromCompute;
    this.colorAttachment = colorAttachment;
    setContainer(colorAttachment, SwapchainConfiguration.FeatureIDs.COLOR_ATTACHMENT);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SwapchainConfiguration.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int requiredSwapImageCount() {
    return requiredSwapImageCount;
  }

  @Override
  public void requiredSwapImageCount(final int requiredSwapImageCount) {
    final var oldValue = this.requiredSwapImageCount;
    this.requiredSwapImageCount = requiredSwapImageCount;
    notifier.notifyInt(SwapchainConfiguration.FeatureIDs.REQUIRED_SWAP_IMAGE_COUNT, false, false, oldValue, requiredSwapImageCount);
  }

  @Override
  public List<EImageUsage> swapImageUsages() {
    return swapImageUsages;
  }

  @Override
  public boolean presentWhenVBlank() {
    return presentWhenVBlank;
  }

  @Override
  public void presentWhenVBlank(final boolean presentWhenVBlank) {
    final var oldValue = this.presentWhenVBlank;
    this.presentWhenVBlank = presentWhenVBlank;
    notifier.notifyBoolean(SwapchainConfiguration.FeatureIDs.PRESENT_WHENV_BLANK, false, false, oldValue, presentWhenVBlank);
  }

  @Override
  public boolean acquireWaitForVBlank() {
    return acquireWaitForVBlank;
  }

  @Override
  public void acquireWaitForVBlank(final boolean acquireWaitForVBlank) {
    final var oldValue = this.acquireWaitForVBlank;
    this.acquireWaitForVBlank = acquireWaitForVBlank;
    notifier.notifyBoolean(SwapchainConfiguration.FeatureIDs.ACQUIRE_WAIT_FORV_BLANK, false, false, oldValue, acquireWaitForVBlank);
  }

  @Override
  public boolean allowingAccessFromCompute() {
    return allowingAccessFromCompute;
  }

  @Override
  public void allowingAccessFromCompute(final boolean allowingAccessFromCompute) {
    final var oldValue = this.allowingAccessFromCompute;
    this.allowingAccessFromCompute = allowingAccessFromCompute;
    notifier.notifyBoolean(SwapchainConfiguration.FeatureIDs.ALLOWING_ACCESS_FROM_COMPUTE, false, false, oldValue, allowingAccessFromCompute);
  }

  @Override
  public SwapImageAttachment colorAttachment() {
    return colorAttachment;
  }

  @Override
  public void colorAttachment(final SwapImageAttachment colorAttachment) {
    final var oldValue = this.colorAttachment;
    final var eventType = colorAttachment == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.colorAttachment = colorAttachment;
    setContainer(colorAttachment, SwapchainConfiguration.FeatureIDs.COLOR_ATTACHMENT);
    beforeContainmentNotify(eventType, oldValue, colorAttachment);
    notifier.notify(SwapchainConfiguration.FeatureIDs.COLOR_ATTACHMENT, true, false, eventType, oldValue, colorAttachment);
    afterContainmentNotify(eventType, oldValue, colorAttachment);
  }

  @Override
  public Group<SwapchainConfiguration> lmGroup() {
    return GraphicModelDefinition.Groups.SWAPCHAIN_CONFIGURATION;
  }

  @Override
  protected FeatureSetter<SwapchainConfiguration> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SwapchainConfiguration> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SwapchainConfiguration.FeatureIDs.REQUIRED_SWAP_IMAGE_COUNT -> 0;
      case SwapchainConfiguration.FeatureIDs.SWAP_IMAGE_USAGES -> 1;
      case SwapchainConfiguration.FeatureIDs.PRESENT_WHENV_BLANK -> 2;
      case SwapchainConfiguration.FeatureIDs.ACQUIRE_WAIT_FORV_BLANK -> 3;
      case SwapchainConfiguration.FeatureIDs.ALLOWING_ACCESS_FROM_COMPUTE -> 4;
      case SwapchainConfiguration.FeatureIDs.COLOR_ATTACHMENT -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SwapchainConfiguration> GET_MAP = new FeatureGetter.Builder<SwapchainConfiguration>(FEATURE_COUNT, SwapchainConfigurationImpl::featureIndexStatic).add(SwapchainConfiguration.FeatureIDs.REQUIRED_SWAP_IMAGE_COUNT, SwapchainConfiguration::requiredSwapImageCount).add(SwapchainConfiguration.FeatureIDs.SWAP_IMAGE_USAGES, SwapchainConfiguration::swapImageUsages).add(SwapchainConfiguration.FeatureIDs.PRESENT_WHENV_BLANK, SwapchainConfiguration::presentWhenVBlank).add(SwapchainConfiguration.FeatureIDs.ACQUIRE_WAIT_FORV_BLANK, SwapchainConfiguration::acquireWaitForVBlank).add(SwapchainConfiguration.FeatureIDs.ALLOWING_ACCESS_FROM_COMPUTE, SwapchainConfiguration::allowingAccessFromCompute).add(SwapchainConfiguration.FeatureIDs.COLOR_ATTACHMENT, SwapchainConfiguration::colorAttachment).build();
    private static final FeatureSetter<SwapchainConfiguration> SET_MAP = new FeatureSetter.Builder<SwapchainConfiguration>(FEATURE_COUNT, SwapchainConfigurationImpl::featureIndexStatic).add(SwapchainConfiguration.FeatureIDs.REQUIRED_SWAP_IMAGE_COUNT, (object, value) -> ((SwapchainConfigurationImpl) object).requiredSwapImageCount((int) value)).add(SwapchainConfiguration.FeatureIDs.PRESENT_WHENV_BLANK, (object, value) -> ((SwapchainConfigurationImpl) object).presentWhenVBlank((boolean) value)).add(SwapchainConfiguration.FeatureIDs.ACQUIRE_WAIT_FORV_BLANK, (object, value) -> ((SwapchainConfigurationImpl) object).acquireWaitForVBlank((boolean) value)).add(SwapchainConfiguration.FeatureIDs.ALLOWING_ACCESS_FROM_COMPUTE, (object, value) -> ((SwapchainConfigurationImpl) object).allowingAccessFromCompute((boolean) value)).add(SwapchainConfiguration.FeatureIDs.COLOR_ATTACHMENT, (object, value) -> ((SwapchainConfigurationImpl) object).colorAttachment((SwapImageAttachment) value)).build();
  }
}
