package org.sheepy.vulkan.model.image.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImageInfo.Builder;
import org.sheepy.vulkan.model.image.impl.ImageInfoImpl;

public final class ImageInfoBuilder implements Builder {
  private EFormat format = EFormat.R8G8B8A8_UNORM;
  private final List<EImageUsage> usages = new ArrayList<>();
  private int tiling = 0;
  private int mipLevels = 1;
  private EImageLayout initialLayout = EImageLayout.SHADER_READ_ONLY_OPTIMAL;

  public ImageInfoBuilder() {
  }

  @Override
  public ImageInfoBuilder format(EFormat format) {
    this.format = format;
    return this;
  }

  @Override
  public ImageInfoBuilder addUsage(EImageUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public ImageInfoBuilder addUsages(final List<EImageUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public ImageInfoBuilder tiling(int tiling) {
    this.tiling = tiling;
    return this;
  }

  @Override
  public ImageInfoBuilder mipLevels(int mipLevels) {
    this.mipLevels = mipLevels;
    return this;
  }

  @Override
  public ImageInfoBuilder initialLayout(EImageLayout initialLayout) {
    this.initialLayout = initialLayout;
    return this;
  }

  @Override
  public ImageInfo build() {
    final var built = new ImageInfoImpl(format, usages, tiling, mipLevels);
    built.initialLayout(initialLayout);
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
    private static final FeatureInserter<ImageInfoBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageInfoBuilder>(5, Inserters::attributeIndex).add(ImageInfo.FeatureIDs.FORMAT, (builder, value) -> builder.format((EFormat) value)).add(ImageInfo.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EImageUsage) value)).add(ImageInfo.FeatureIDs.TILING, (builder, value) -> builder.tiling((int) value)).add(ImageInfo.FeatureIDs.MIP_LEVELS, (builder, value) -> builder.mipLevels((int) value)).add(ImageInfo.FeatureIDs.INITIAL_LAYOUT, (builder, value) -> builder.initialLayout((EImageLayout) value)).build();
    private static final RelationLazyInserter<ImageInfoBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageInfoBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ImageInfo.FeatureIDs.FORMAT -> 0;
        case ImageInfo.FeatureIDs.USAGES -> 1;
        case ImageInfo.FeatureIDs.TILING -> 2;
        case ImageInfo.FeatureIDs.MIP_LEVELS -> 3;
        case ImageInfo.FeatureIDs.INITIAL_LAYOUT -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
