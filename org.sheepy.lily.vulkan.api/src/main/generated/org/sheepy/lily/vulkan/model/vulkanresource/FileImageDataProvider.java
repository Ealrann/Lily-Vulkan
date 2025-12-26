package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.FileImageDataProviderBuilder;

public interface FileImageDataProvider extends ImageDataProvider {
  static Builder builder() {
    return new FileImageDataProviderBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  FileImage fileImageReference();
  FileImage fileImageContainment();
  void fileImageReference(final FileImage fileImageReference);
  void fileImageContainment(final FileImage fileImageContainment);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int FILE_IMAGE_REFERENCE = -156594985;
    int FILE_IMAGE_CONTAINMENT = 60148414;
  }

  interface Features<T extends Features<T>> extends ImageDataProvider.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<FileImage, FileImage, Listener<FileImage>, Features<?>> FILE_IMAGE_REFERENCE = new RelationBuilder<FileImage, FileImage, Listener<FileImage>, Features<?>>().name("fileImageReference").id(FileImageDataProvider.FeatureIDs.FILE_IMAGE_REFERENCE).concept(() -> ResourceModelDefinition.Groups.FILE_IMAGE).build();
    Relation<FileImage, FileImage, Listener<FileImage>, Features<?>> FILE_IMAGE_CONTAINMENT = new RelationBuilder<FileImage, FileImage, Listener<FileImage>, Features<?>>().name("fileImageContainment").contains(true).id(FileImageDataProvider.FeatureIDs.FILE_IMAGE_CONTAINMENT).concept(() -> ResourceModelDefinition.Groups.FILE_IMAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, FILE_IMAGE_REFERENCE, FILE_IMAGE_CONTAINMENT);
  }

  interface Builder extends IFeaturedObject.Builder<FileImageDataProvider> {
    Builder name(String name);
    Builder fileImageReference(Supplier<FileImage> fileImageReference);
    Builder fileImageContainment(Supplier<FileImage> fileImageContainment);
  }
}
