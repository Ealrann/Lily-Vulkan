package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class GraphicConfigurationImpl extends FeaturedObject<GraphicConfiguration.Features<?>> implements GraphicConfiguration {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<GraphicConfiguration.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private SwapchainConfiguration swapchainConfiguration;
  private FramebufferConfiguration framebufferConfiguration;
  private EPipelineStage acquireWaitStage;
  private PhysicalSurface surface;
  private RenderPass renderPass;
  private ImageViews imageViews;

  public GraphicConfigurationImpl(final SwapchainConfiguration swapchainConfiguration,
      final FramebufferConfiguration framebufferConfiguration, final PhysicalSurface surface,
      final RenderPass renderPass) {
    this.swapchainConfiguration = swapchainConfiguration;
    this.framebufferConfiguration = framebufferConfiguration;
    this.surface = surface;
    this.renderPass = renderPass;
    setContainer(swapchainConfiguration, GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION);
    setContainer(framebufferConfiguration, GraphicConfiguration.FeatureIDs.FRAMEBUFFER_CONFIGURATION);
    setContainer(surface, GraphicConfiguration.FeatureIDs.SURFACE);
    setContainer(renderPass, GraphicConfiguration.FeatureIDs.RENDER_PASS);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GraphicConfiguration.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public SwapchainConfiguration swapchainConfiguration() {
    return swapchainConfiguration;
  }

  @Override
  public void swapchainConfiguration(final SwapchainConfiguration swapchainConfiguration) {
    final var oldValue = this.swapchainConfiguration;
    final var eventType = swapchainConfiguration == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.swapchainConfiguration = swapchainConfiguration;
    setContainer(swapchainConfiguration, GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION);
    beforeContainmentNotify(eventType, oldValue, swapchainConfiguration);
    notifier.notify(GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION, true, false, eventType, oldValue, swapchainConfiguration);
    afterContainmentNotify(eventType, oldValue, swapchainConfiguration);
  }

  @Override
  public FramebufferConfiguration framebufferConfiguration() {
    return framebufferConfiguration;
  }

  @Override
  public void framebufferConfiguration(final FramebufferConfiguration framebufferConfiguration) {
    final var oldValue = this.framebufferConfiguration;
    final var eventType = framebufferConfiguration == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.framebufferConfiguration = framebufferConfiguration;
    setContainer(framebufferConfiguration, GraphicConfiguration.FeatureIDs.FRAMEBUFFER_CONFIGURATION);
    beforeContainmentNotify(eventType, oldValue, framebufferConfiguration);
    notifier.notify(GraphicConfiguration.FeatureIDs.FRAMEBUFFER_CONFIGURATION, true, false, eventType, oldValue, framebufferConfiguration);
    afterContainmentNotify(eventType, oldValue, framebufferConfiguration);
  }

  @Override
  public EPipelineStage acquireWaitStage() {
    return acquireWaitStage;
  }

  @Override
  public void acquireWaitStage(final EPipelineStage acquireWaitStage) {
    final var oldValue = this.acquireWaitStage;
    this.acquireWaitStage = acquireWaitStage;
    notifier.notify(GraphicConfiguration.FeatureIDs.ACQUIRE_WAIT_STAGE, false, false, oldValue, acquireWaitStage);
  }

  @Override
  public PhysicalSurface surface() {
    return surface;
  }

  @Override
  public void surface(final PhysicalSurface surface) {
    final var oldValue = this.surface;
    final var eventType = surface == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.surface = surface;
    setContainer(surface, GraphicConfiguration.FeatureIDs.SURFACE);
    beforeContainmentNotify(eventType, oldValue, surface);
    notifier.notify(GraphicConfiguration.FeatureIDs.SURFACE, true, false, eventType, oldValue, surface);
    afterContainmentNotify(eventType, oldValue, surface);
  }

  @Override
  public RenderPass renderPass() {
    return renderPass;
  }

  @Override
  public void renderPass(final RenderPass renderPass) {
    final var oldValue = this.renderPass;
    final var eventType = renderPass == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.renderPass = renderPass;
    setContainer(renderPass, GraphicConfiguration.FeatureIDs.RENDER_PASS);
    beforeContainmentNotify(eventType, oldValue, renderPass);
    notifier.notify(GraphicConfiguration.FeatureIDs.RENDER_PASS, true, false, eventType, oldValue, renderPass);
    afterContainmentNotify(eventType, oldValue, renderPass);
  }

  @Override
  public ImageViews imageViews() {
    return imageViews;
  }

  @Override
  public void imageViews(final ImageViews imageViews) {
    final var oldValue = this.imageViews;
    final var eventType = imageViews == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.imageViews = imageViews;
    setContainer(imageViews, GraphicConfiguration.FeatureIDs.IMAGE_VIEWS);
    beforeContainmentNotify(eventType, oldValue, imageViews);
    notifier.notify(GraphicConfiguration.FeatureIDs.IMAGE_VIEWS, true, false, eventType, oldValue, imageViews);
    afterContainmentNotify(eventType, oldValue, imageViews);
  }

  @Override
  public Group<GraphicConfiguration> lmGroup() {
    return GraphicModelDefinition.Groups.GRAPHIC_CONFIGURATION;
  }

  @Override
  protected FeatureSetter<GraphicConfiguration> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GraphicConfiguration> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION -> 0;
      case GraphicConfiguration.FeatureIDs.FRAMEBUFFER_CONFIGURATION -> 1;
      case GraphicConfiguration.FeatureIDs.ACQUIRE_WAIT_STAGE -> 2;
      case GraphicConfiguration.FeatureIDs.SURFACE -> 3;
      case GraphicConfiguration.FeatureIDs.RENDER_PASS -> 4;
      case GraphicConfiguration.FeatureIDs.IMAGE_VIEWS -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GraphicConfiguration> GET_MAP = new FeatureGetter.Builder<GraphicConfiguration>(FEATURE_COUNT, GraphicConfigurationImpl::featureIndexStatic).add(GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION, GraphicConfiguration::swapchainConfiguration).add(GraphicConfiguration.FeatureIDs.FRAMEBUFFER_CONFIGURATION, GraphicConfiguration::framebufferConfiguration).add(GraphicConfiguration.FeatureIDs.ACQUIRE_WAIT_STAGE, GraphicConfiguration::acquireWaitStage).add(GraphicConfiguration.FeatureIDs.SURFACE, GraphicConfiguration::surface).add(GraphicConfiguration.FeatureIDs.RENDER_PASS, GraphicConfiguration::renderPass).add(GraphicConfiguration.FeatureIDs.IMAGE_VIEWS, GraphicConfiguration::imageViews).build();
    private static final FeatureSetter<GraphicConfiguration> SET_MAP = new FeatureSetter.Builder<GraphicConfiguration>(FEATURE_COUNT, GraphicConfigurationImpl::featureIndexStatic).add(GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION, (object, value) -> ((GraphicConfigurationImpl) object).swapchainConfiguration((SwapchainConfiguration) value)).add(GraphicConfiguration.FeatureIDs.FRAMEBUFFER_CONFIGURATION, (object, value) -> ((GraphicConfigurationImpl) object).framebufferConfiguration((FramebufferConfiguration) value)).add(GraphicConfiguration.FeatureIDs.ACQUIRE_WAIT_STAGE, (object, value) -> ((GraphicConfigurationImpl) object).acquireWaitStage((EPipelineStage) value)).add(GraphicConfiguration.FeatureIDs.SURFACE, (object, value) -> ((GraphicConfigurationImpl) object).surface((PhysicalSurface) value)).add(GraphicConfiguration.FeatureIDs.RENDER_PASS, (object, value) -> ((GraphicConfigurationImpl) object).renderPass((RenderPass) value)).add(GraphicConfiguration.FeatureIDs.IMAGE_VIEWS, (object, value) -> ((GraphicConfigurationImpl) object).imageViews((ImageViews) value)).build();
  }
}
