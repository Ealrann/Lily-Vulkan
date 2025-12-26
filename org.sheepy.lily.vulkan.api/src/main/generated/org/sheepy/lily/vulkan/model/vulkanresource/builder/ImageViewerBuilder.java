package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageViewerImpl;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

public final class ImageViewerBuilder implements Builder {
  private EFormat format = EFormat.R8G8B8A8_UNORM;
  private final List<EImageUsage> usages = new ArrayList<>();
  private int tiling = 0;
  private int mipLevels = 1;
  private EImageLayout initialLayout = EImageLayout.SHADER_READ_ONLY_OPTIMAL;
  private String name;
  private Supplier<ImageDataProvider> dataProvider;
  private boolean mipmapEnabled = false;

  public ImageViewerBuilder() {
  }

  @Override
  public ImageViewerBuilder format(EFormat format) {
    this.format = format;
    return this;
  }

  @Override
  public ImageViewerBuilder addUsage(EImageUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public ImageViewerBuilder addUsages(final List<EImageUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public ImageViewerBuilder tiling(int tiling) {
    this.tiling = tiling;
    return this;
  }

  @Override
  public ImageViewerBuilder mipLevels(int mipLevels) {
    this.mipLevels = mipLevels;
    return this;
  }

  @Override
  public ImageViewerBuilder initialLayout(EImageLayout initialLayout) {
    this.initialLayout = initialLayout;
    return this;
  }

  @Override
  public ImageViewerBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ImageViewerBuilder dataProvider(Supplier<ImageDataProvider> dataProvider) {
    this.dataProvider = dataProvider;
    return this;
  }

  @Override
  public ImageViewerBuilder mipmapEnabled(boolean mipmapEnabled) {
    this.mipmapEnabled = mipmapEnabled;
    return this;
  }

  @Override
  public ImageViewer build() {
    final var built = new ImageViewerImpl(format, usages, tiling, mipLevels, name, dataProvider.get(), mipmapEnabled);
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
    private static final FeatureInserter<ImageViewerBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageViewerBuilder>(7, Inserters::attributeIndex).add(ImageViewer.FeatureIDs.FORMAT, (builder, value) -> builder.format((EFormat) value)).add(ImageViewer.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EImageUsage) value)).add(ImageViewer.FeatureIDs.TILING, (builder, value) -> builder.tiling((int) value)).add(ImageViewer.FeatureIDs.MIP_LEVELS, (builder, value) -> builder.mipLevels((int) value)).add(ImageViewer.FeatureIDs.INITIAL_LAYOUT, (builder, value) -> builder.initialLayout((EImageLayout) value)).add(ImageViewer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ImageViewer.FeatureIDs.MIPMAP_ENABLED, (builder, value) -> builder.mipmapEnabled((boolean) value)).build();
    private static final RelationLazyInserter<ImageViewerBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageViewerBuilder>(1, Inserters::relationIndex).add(ImageViewer.FeatureIDs.DATA_PROVIDER, (builder, value) -> builder.dataProvider((Supplier<ImageDataProvider>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ImageViewer.FeatureIDs.FORMAT -> 0;
        case ImageViewer.FeatureIDs.USAGES -> 1;
        case ImageViewer.FeatureIDs.TILING -> 2;
        case ImageViewer.FeatureIDs.MIP_LEVELS -> 3;
        case ImageViewer.FeatureIDs.INITIAL_LAYOUT -> 4;
        case ImageViewer.FeatureIDs.NAME -> 5;
        case ImageViewer.FeatureIDs.MIPMAP_ENABLED -> 6;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ImageViewer.FeatureIDs.DATA_PROVIDER -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
