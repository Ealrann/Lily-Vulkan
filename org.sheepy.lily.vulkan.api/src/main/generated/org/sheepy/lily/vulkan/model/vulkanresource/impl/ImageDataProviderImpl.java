package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class ImageDataProviderImpl extends FeaturedObject<ImageDataProvider.Features<?>> implements ImageDataProvider {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<ImageDataProvider.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;

  public ImageDataProviderImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageDataProvider.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Group<ImageDataProvider> lmGroup() {
    return VulkanResourceModelDefinition.Groups.IMAGE_DATA_PROVIDER;
  }

  @Override
  protected FeatureSetter<ImageDataProvider> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageDataProvider> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ImageDataProvider.FeatureIDs.NAME -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageDataProvider> GET_MAP = new FeatureGetter.Builder<ImageDataProvider>(FEATURE_COUNT, ImageDataProviderImpl::featureIndexStatic).add(ImageDataProvider.FeatureIDs.NAME, ImageDataProvider::name).build();
    private static final FeatureSetter<ImageDataProvider> SET_MAP = new FeatureSetter.Builder<ImageDataProvider>(FEATURE_COUNT, ImageDataProviderImpl::featureIndexStatic).build();
  }
}
