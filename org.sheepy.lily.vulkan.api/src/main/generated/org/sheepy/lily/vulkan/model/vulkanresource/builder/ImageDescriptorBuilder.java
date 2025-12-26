package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.Sampler;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class ImageDescriptorBuilder implements Builder {
  private String name;
  private EDescriptorType type = EDescriptorType.SAMPLER;
  private final List<EShaderStage> shaderStages = new ArrayList<>();
  private final List<Supplier<IVulkanImage>> images = new ArrayList<>();
  private Supplier<Sampler> sampler = () -> null;
  private EImageLayout layout = EImageLayout.GENERAL;

  public ImageDescriptorBuilder() {
  }

  @Override
  public ImageDescriptorBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ImageDescriptorBuilder type(EDescriptorType type) {
    this.type = type;
    return this;
  }

  @Override
  public ImageDescriptorBuilder addShaderStage(EShaderStage shaderStage) {
    this.shaderStages.add(shaderStage);
    return this;
  }

  @Override
  public ImageDescriptorBuilder addShaderStages(final List<EShaderStage> shaderStages) {
    this.shaderStages.addAll(shaderStages);
    return this;
  }

  @Override
  public ImageDescriptorBuilder addImage(Supplier<IVulkanImage> image) {
    this.images.add(image);
    return this;
  }

  @Override
  public ImageDescriptorBuilder addImages(final List<IVulkanImage> images) {
    images.forEach(value -> this.images.add(() -> value));
    return this;
  }

  @Override
  public ImageDescriptorBuilder sampler(Supplier<Sampler> sampler) {
    this.sampler = sampler;
    return this;
  }

  @Override
  public ImageDescriptorBuilder layout(EImageLayout layout) {
    this.layout = layout;
    return this;
  }

  @Override
  public ImageDescriptor build() {
    final var builtImages = BuildUtils.collectSuppliers(images);
    final var built = new ImageDescriptorImpl(name, type, shaderStages);
    built.images().addAll(builtImages);
    built.sampler(sampler.get());
    built.layout(layout);
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
    private static final FeatureInserter<ImageDescriptorBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageDescriptorBuilder>(4, Inserters::attributeIndex).add(ImageDescriptor.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ImageDescriptor.FeatureIDs.TYPE, (builder, value) -> builder.type((EDescriptorType) value)).add(ImageDescriptor.FeatureIDs.SHADER_STAGES, (builder, value) -> builder.addShaderStage((EShaderStage) value)).add(ImageDescriptor.FeatureIDs.LAYOUT, (builder, value) -> builder.layout((EImageLayout) value)).build();
    private static final RelationLazyInserter<ImageDescriptorBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageDescriptorBuilder>(2, Inserters::relationIndex).add(ImageDescriptor.FeatureIDs.IMAGES, (builder, value) -> builder.addImage((Supplier<IVulkanImage>) value)).add(ImageDescriptor.FeatureIDs.SAMPLER, (builder, value) -> builder.sampler((Supplier<Sampler>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ImageDescriptor.FeatureIDs.NAME -> 0;
        case ImageDescriptor.FeatureIDs.TYPE -> 1;
        case ImageDescriptor.FeatureIDs.SHADER_STAGES -> 2;
        case ImageDescriptor.FeatureIDs.LAYOUT -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ImageDescriptor.FeatureIDs.IMAGES -> 0;
        case ImageDescriptor.FeatureIDs.SAMPLER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
