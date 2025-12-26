package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class FileImageDataProviderImpl extends FeaturedObject<FileImageDataProvider.Features<?>> implements FileImageDataProvider {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<FileImageDataProvider.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private FileImage fileImageReference;
  private FileImage fileImageContainment;

  public FileImageDataProviderImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FileImageDataProvider.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public FileImage fileImageReference() {
    return fileImageReference;
  }

  @Override
  public void fileImageReference(final FileImage fileImageReference) {
    final var oldValue = this.fileImageReference;
    final var eventType = fileImageReference == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.fileImageReference = fileImageReference;
    notifier.notify(FileImageDataProvider.FeatureIDs.FILE_IMAGE_REFERENCE, false, false, eventType, oldValue, fileImageReference);
  }

  @Override
  public FileImage fileImageContainment() {
    return fileImageContainment;
  }

  @Override
  public void fileImageContainment(final FileImage fileImageContainment) {
    final var oldValue = this.fileImageContainment;
    final var eventType = fileImageContainment == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.fileImageContainment = fileImageContainment;
    setContainer(fileImageContainment, FileImageDataProvider.FeatureIDs.FILE_IMAGE_CONTAINMENT);
    beforeContainmentNotify(eventType, oldValue, fileImageContainment);
    notifier.notify(FileImageDataProvider.FeatureIDs.FILE_IMAGE_CONTAINMENT, true, false, eventType, oldValue, fileImageContainment);
    afterContainmentNotify(eventType, oldValue, fileImageContainment);
  }

  @Override
  public Group<FileImageDataProvider> lmGroup() {
    return VulkanResourceModelDefinition.Groups.FILE_IMAGE_DATA_PROVIDER;
  }

  @Override
  protected FeatureSetter<FileImageDataProvider> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FileImageDataProvider> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FileImageDataProvider.FeatureIDs.NAME -> 0;
      case FileImageDataProvider.FeatureIDs.FILE_IMAGE_REFERENCE -> 1;
      case FileImageDataProvider.FeatureIDs.FILE_IMAGE_CONTAINMENT -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<FileImageDataProvider> GET_MAP = new FeatureGetter.Builder<FileImageDataProvider>(FEATURE_COUNT, FileImageDataProviderImpl::featureIndexStatic).add(FileImageDataProvider.FeatureIDs.NAME, FileImageDataProvider::name).add(FileImageDataProvider.FeatureIDs.FILE_IMAGE_REFERENCE, FileImageDataProvider::fileImageReference).add(FileImageDataProvider.FeatureIDs.FILE_IMAGE_CONTAINMENT, FileImageDataProvider::fileImageContainment).build();
    private static final FeatureSetter<FileImageDataProvider> SET_MAP = new FeatureSetter.Builder<FileImageDataProvider>(FEATURE_COUNT, FileImageDataProviderImpl::featureIndexStatic).add(FileImageDataProvider.FeatureIDs.FILE_IMAGE_REFERENCE, (object, value) -> ((FileImageDataProviderImpl) object).fileImageReference((FileImage) value)).add(FileImageDataProvider.FeatureIDs.FILE_IMAGE_CONTAINMENT, (object, value) -> ((FileImageDataProviderImpl) object).fileImageContainment((FileImage) value)).build();
  }
}
