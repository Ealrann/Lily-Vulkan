package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.FileImageDataProviderImpl;

public final class FileImageDataProviderBuilder implements Builder {
  private String name;
  private Supplier<FileImage> fileImageReference = () -> null;
  private Supplier<FileImage> fileImageContainment = () -> null;

  public FileImageDataProviderBuilder() {
  }

  @Override
  public FileImageDataProviderBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public FileImageDataProviderBuilder fileImageReference(Supplier<FileImage> fileImageReference) {
    this.fileImageReference = fileImageReference;
    return this;
  }

  @Override
  public FileImageDataProviderBuilder fileImageContainment(
      Supplier<FileImage> fileImageContainment) {
    this.fileImageContainment = fileImageContainment;
    return this;
  }

  @Override
  public FileImageDataProvider build() {
    final var built = new FileImageDataProviderImpl(name);
    built.fileImageReference(fileImageReference.get());
    built.fileImageContainment(fileImageContainment.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<FileImageDataProviderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FileImageDataProviderBuilder>(1, Inserters::attributeIndex).add(FileImageDataProvider.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<FileImageDataProviderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FileImageDataProviderBuilder>(2, Inserters::relationIndex).add(FileImageDataProvider.FeatureIDs.FILE_IMAGE_REFERENCE, (builder, value) -> builder.fileImageReference((Supplier<FileImage>) value)).add(FileImageDataProvider.FeatureIDs.FILE_IMAGE_CONTAINMENT, (builder, value) -> builder.fileImageContainment((Supplier<FileImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case FileImageDataProvider.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case FileImageDataProvider.FeatureIDs.FILE_IMAGE_REFERENCE -> 0;
        case FileImageDataProvider.FeatureIDs.FILE_IMAGE_CONTAINMENT -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
