package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.Sampler;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class ImageDescriptorImpl extends FeaturedObject<ImageDescriptor.Features<?>> implements ImageDescriptor {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<ImageDescriptor.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private EDescriptorType type;
  private final List<EShaderStage> shaderStages = newObservableList(IDescriptor.FeatureIDs.SHADER_STAGES, false, false);
  private final List<IVulkanImage> images = newObservableList(ImageDescriptor.FeatureIDs.IMAGES, true, false);
  private Sampler sampler;
  private EImageLayout layout;

  public ImageDescriptorImpl(final String name, final EDescriptorType type,
      final List<EShaderStage> shaderStages) {
    this.name = name;
    this.type = type;
    this.shaderStages.addAll(shaderStages);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageDescriptor.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public EDescriptorType type() {
    return type;
  }

  @Override
  public void type(final EDescriptorType type) {
    final var oldValue = this.type;
    this.type = type;
    notifier.notify(IDescriptor.FeatureIDs.TYPE, false, false, oldValue, type);
  }

  @Override
  public List<EShaderStage> shaderStages() {
    return shaderStages;
  }

  @Override
  public List<IVulkanImage> images() {
    return images;
  }

  @Override
  public Sampler sampler() {
    return sampler;
  }

  @Override
  public void sampler(final Sampler sampler) {
    final var oldValue = this.sampler;
    final var eventType = sampler == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.sampler = sampler;
    notifier.notify(ImageDescriptor.FeatureIDs.SAMPLER, false, false, eventType, oldValue, sampler);
  }

  @Override
  public EImageLayout layout() {
    return layout;
  }

  @Override
  public void layout(final EImageLayout layout) {
    final var oldValue = this.layout;
    this.layout = layout;
    notifier.notify(ImageDescriptor.FeatureIDs.LAYOUT, false, false, oldValue, layout);
  }

  @Override
  public Group<ImageDescriptor> lmGroup() {
    return VulkanResourceModelDefinition.Groups.IMAGE_DESCRIPTOR;
  }

  @Override
  protected FeatureSetter<ImageDescriptor> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageDescriptor> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ImageDescriptor.FeatureIDs.NAME -> 0;
      case ImageDescriptor.FeatureIDs.TYPE -> 1;
      case ImageDescriptor.FeatureIDs.SHADER_STAGES -> 2;
      case ImageDescriptor.FeatureIDs.IMAGES -> 3;
      case ImageDescriptor.FeatureIDs.SAMPLER -> 4;
      case ImageDescriptor.FeatureIDs.LAYOUT -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageDescriptor> GET_MAP = new FeatureGetter.Builder<ImageDescriptor>(FEATURE_COUNT, ImageDescriptorImpl::featureIndexStatic).add(ImageDescriptor.FeatureIDs.NAME, ImageDescriptor::name).add(ImageDescriptor.FeatureIDs.TYPE, ImageDescriptor::type).add(ImageDescriptor.FeatureIDs.SHADER_STAGES, ImageDescriptor::shaderStages).add(ImageDescriptor.FeatureIDs.IMAGES, ImageDescriptor::images).add(ImageDescriptor.FeatureIDs.SAMPLER, ImageDescriptor::sampler).add(ImageDescriptor.FeatureIDs.LAYOUT, ImageDescriptor::layout).build();
    private static final FeatureSetter<ImageDescriptor> SET_MAP = new FeatureSetter.Builder<ImageDescriptor>(FEATURE_COUNT, ImageDescriptorImpl::featureIndexStatic).add(ImageDescriptor.FeatureIDs.TYPE, (object, value) -> ((ImageDescriptorImpl) object).type((EDescriptorType) value)).add(ImageDescriptor.FeatureIDs.SAMPLER, (object, value) -> ((ImageDescriptorImpl) object).sampler((Sampler) value)).add(ImageDescriptor.FeatureIDs.LAYOUT, (object, value) -> ((ImageDescriptorImpl) object).layout((EImageLayout) value)).build();
  }
}
